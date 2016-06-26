package com.ceit.ebs.ebe.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.HibernateUtils;
import com.ceit.ebs.cnt.vo.CntContractPurchaserVo;
import com.ceit.ebs.ebe.entity.EbeExpertReply;
import com.ceit.ebs.ebe.entity.EbeProviderPackage;
import com.ceit.ebs.ebe.service.IEbeExpertReplySerivce;
import com.ceit.ebs.ebe.vo.EbeExpertReplyVo;

public class EbeExpertReplySerivce implements IEbeExpertReplySerivce {

	private EbeExpertReply ebeExpertReply;
	private ITableDao tableDao;

	// Constructors


	public EbeExpertReplySerivce(){
		
	}
	
	public EbeExpertReplyVo getEbeExpertReplybyId(int id){
		EbeExpertReplyVo ebeExpertReplyVo = null;
		try {
			ebeExpertReply = (EbeExpertReply)(tableDao.getEntitybyId(id, EbeExpertReply.class));
			ebeExpertReplyVo = new EbeExpertReplyVo(ebeExpertReply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ebeExpertReplyVo;
	}
	
	public boolean modifyEbeExpertReply(EbeExpertReplyVo s){
		try {
			tableDao.update(s.adapterToEbeExpertReply());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEbeExpertReplybyId(Integer id){
		try{
			tableDao.delete(id,EbeExpertReply.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEbeExpertReply(EbeExpertReplyVo ebeExpertReplyVo){
		try {
			EbeExpertReply sr = ebeExpertReplyVo.adapterToEbeExpertReply();
			Integer ebeExpertReplyId = tableDao.insert(sr);
			sr.setId(ebeExpertReplyId);
			sr.setDiapIndex(ebeExpertReplyId);
			if(sr.getBusinessScore() == null) sr.setBusinessScore(-1);
			if(sr.getPriceScore() == null) sr.setPriceScore(-1);
			if(sr.getTechnicalScore() == null) sr.setTechnicalScore(-1);
			tableDao.update(sr);
			return ebeExpertReplyId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	/**
	 * 根据ID,获得数据总数
	 * @param id 
	 * @return 查询到的数据总数，若失败，返回-1
	 */
	@SuppressWarnings("unchecked")
	public Integer getCount(){
		Integer count = 0;  //记录总数
		String sql = null;
		//Map<String,Object> map = new HashMap<String,Object>();
		sql = "SELECT  COUNT(d.id) FROM  EbeExpertReply d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EbeExpertReply> list = tableDao.otherQuery(sql, true, true, null);
			if(list != null && list.size() > 0){
				count = Integer.parseInt((list.get(0)+""));
			}
		}catch(Exception e) {
			count = -1;
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 分页显示数据
	 * @param pageindex 当前页码
	 * @param pagesize 每页显示条数
	 * @return 包含查询到的所有EbeExpertReplyVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbeExpertReplyVo> querydata(int pageindex, int pagesize) {
		List<EbeExpertReplyVo> ebeExpertReplyVoList = new ArrayList<EbeExpertReplyVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbeExpertReply d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbeExpertReply> ebeExpertReplyList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebeExpertReplyList != null && ebeExpertReplyList.size() > 0){
				for(int i = 0 ; i < ebeExpertReplyList.size() ; i++){
					EbeExpertReplyVo srv = new EbeExpertReplyVo(ebeExpertReplyList.get(i));//PO -> VO
					ebeExpertReplyVoList.add(srv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<EbeExpertReplyVo>(ebeExpertReplyVoList,count,pageindex,pagesize);
	}
	
	public void setEbeExpertReply(EbeExpertReply ebeExpertReply) {
		this.ebeExpertReply = ebeExpertReply;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	/**
	 * 查看对于某个包的组内成员打分
	 * @param packageId 包的主键编号
	 * @param groupId 组的主键编号
	 * @return EbeExpertReply对象列表
	 * @author hgl
	 * date 2014/08/16
	 */
	public List<EbeExpertReply> groupReplyForPackage(Integer packageId, Integer groupId){
		setTableDao(new TableDao());
		//本函数用到了hql语句的in查询
		String sql="select e.expertId FROM  EbeExpertGroup d ,EptExtractionNameList e where d.groupId = :groupId and d.extractionNameListId = e.id";
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("groupId", groupId);
			List<Integer> list = tableDao.otherQuery(sql, true, true, params);
			if(list.size() > 0 && list != null){//专家号联查成功则执行下面sql
				String sql2 = "From EbeExpertReply where expertId in (:list)";
//				Session session = HibernateUtils.getSession();
//				session.beginTransaction();
//				Query query = session.createQuery(sql2);
//				query.setParameterList("list", list); 
//				List<EbeExpertReply> list2 = query.list();
//				session.close();
				params = new HashMap<String, Object>();
				params.put("list", list);
				List<EbeExpertReply> list2=tableDao.otherQuery(sql2, true, true, params);
				return list2;
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	/**
	 * 查看对于某个包的所有成员打分
	 * @param packageId 包的主键编号
	 * @return EbeExpertReply对象列表
	 * @author hgl
	 * date 2014/08/16
	 */
	public List<EbeExpertReply> replyForPackage(Integer packageId){
		setTableDao(new TableDao());
		//判断是否已经加入过其他评审小组
		String sql=" FROM  EbeExpertReply d where d.packageId = :packageId";
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("packageId", packageId);
			List<EbeExpertReply> list = tableDao.otherQuery(sql, true, true, params);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
}
