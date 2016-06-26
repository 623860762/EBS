package com.ceit.ebs.ebe.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.entity.EbeExpertGroup;
import com.ceit.ebs.ebe.service.IEbeExpertGroupService;
import com.ceit.ebs.ebe.vo.EbeExpertGroupVo;
import com.ceit.ebs.ept.entity.EptExpertBaseinfo;
import com.ceit.ebs.ept.vo.EptExpertBaseinfoVo;

public class EbeExpertGroupService implements IEbeExpertGroupService {

	private EbeExpertGroup ebeExpertGroup;
	private ITableDao tableDao;

	// Constructors

	public EbeExpertGroupService(){
	}
	
	public EbeExpertGroupVo getEbeExpertGroupbyId(int id){
		EbeExpertGroupVo ebeExpertGroupVo = null;
		try {
			ebeExpertGroup = (EbeExpertGroup)(tableDao.getEntitybyId(id, EbeExpertGroup.class));
			ebeExpertGroupVo = new EbeExpertGroupVo(ebeExpertGroup);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ebeExpertGroupVo;
	}
	
	public boolean modifyEbeExpertGroup(EbeExpertGroupVo s){
		try {
			tableDao.update(s.adapterToEbeExpertGroup());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEbeExpertGroupbyId(Integer id){
		try{
			tableDao.delete(id,EbeExpertGroup.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEbeExpertGroup(EbeExpertGroupVo ebeExpertGroupVo){
		try {
			EbeExpertGroup sr = ebeExpertGroupVo.adapterToEbeExpertGroup();
			Integer ebeExpertGroupId = tableDao.insert(sr);
			sr.setId(ebeExpertGroupId);
			sr.setDispIndex(ebeExpertGroupId);
			tableDao.update(sr);
			return ebeExpertGroupId;
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
		sql = "SELECT  COUNT(d.id) FROM  EbeExpertGroup d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EbeExpertGroup> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbeExpertGroupVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbeExpertGroupVo> querydata(int pageindex, int pagesize) {
		List<EbeExpertGroupVo> ebeExpertGroupVoList = new ArrayList<EbeExpertGroupVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbeExpertGroup d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbeExpertGroup> ebeExpertGroupList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebeExpertGroupList != null && ebeExpertGroupList.size() > 0){
				for(int i = 0 ; i < ebeExpertGroupList.size() ; i++){
					EbeExpertGroupVo srv = new EbeExpertGroupVo(ebeExpertGroupList.get(i));//PO -> VO
					ebeExpertGroupVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EbeExpertGroupVo>(ebeExpertGroupVoList,count,pageindex,pagesize);
	}
	
	public void setEbeExpertGroup(EbeExpertGroup ebeExpertGroup) {
		this.ebeExpertGroup = ebeExpertGroup;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}
	
	//查询小组内的专家
	public PageInfo<EbeExpertGroupVo> showExpertInGroup(int groupId, int pageindex, int pagesize) {
		List<EbeExpertGroupVo> ebeExpertGroupVoList = new ArrayList<EbeExpertGroupVo>(); //VO集合
		int count =0;
		try{
		Map<String, Object> params = new HashMap<String, Object>();
		//0.查出所有的在组内的 专家-小组记录
		String sql0 ="from EbeExpertGroup d where d.groupId =:groupId";
		params.put("groupId", groupId);
		List<EbeExpertGroup> ebeExpertGroup = tableDao.otherQuery(sql0, true, true, params);
		count = ebeExpertGroup.size();
		ebeExpertGroup = tableDao.querydata(sql0, true,pageindex,pagesize, params);
			//1.遍历记录，通过extractionNameListId字段联查获取expertId
			for(int i=0;i<ebeExpertGroup.size();i++){
				//1.1 po->vo
				EbeExpertGroupVo egv = new EbeExpertGroupVo(ebeExpertGroup.get(i));
				//1.2查询每一条记录的expertId
				String sql1 = "select b.expertId FROM  EptExtractionNameList b , EbeExpertGroup c where b.id = c.extractionNameListId " +
						"and c.id=:expertGroupId";
				params = new HashMap<String, Object>();
				params.put("expertGroupId", egv.getId());
				List<Integer> expertId = tableDao.otherQuery(sql1, true, true, params);
				//1.3通过expertId获得expertBaseInfo
				String sql2 = "from EptExpertBaseinfo a where a.id =:expertId";
				params = new HashMap<String, Object>();
				params.put("expertId", expertId.get(0));
				List<EptExpertBaseinfo> eptExpertBaseinfo = tableDao.otherQuery(sql2, true, true, params);
				//1.4给vo赋值
				egv.setExpertAccount(eptExpertBaseinfo.get(0).getIdNumber());
				egv.setExpertName(eptExpertBaseinfo.get(0).getExpertName());
				egv.setExpertRate(eptExpertBaseinfo.get(0).getExpertRate());
				ebeExpertGroupVoList.add(egv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EbeExpertGroupVo>(ebeExpertGroupVoList,count,pageindex,pagesize);
	}

/**
 * 
 * @Title: expertIntoGroup
 * @Description: TODO(专家入组,不能重复入组)
 * @param @param extractionNameListIds
 * @param @param groupId
 * @param @return    
 * @return Boolean 
 * @author hgl
 * @date 2014-8-20 下午09:46:15
 * @throws
 */
	public Boolean expertIntoGroup(String myExpertGroupIds,Integer groupId) {
		String[] expertGroupIds = myExpertGroupIds.split(",");
		for (int i = 0; i < expertGroupIds.length; i++) {
			EbeExpertGroupVo egv=this.getEbeExpertGroupbyId(Integer.parseInt(expertGroupIds[i]));
			egv.setGroupId(groupId);
			this.modifyEbeExpertGroup(egv);
		}
		return true;
	}
	
	/**
	 * 设置组长
	 * @author hgl
	 * @param Id 记录的ID号
	 * @return 成功返回true，失败返回false
	 * date 2014-8-14 已测试
	 * 展示的时候可以在界面上隐藏显示ID（不是抽取ID）
	 */
	public Boolean setHeadMan(Integer Id)
	{
		setTableDao(new TableDao());
		EbeExpertGroupVo ebeExpertGroupVo = getEbeExpertGroupbyId(Id);
		ebeExpertGroupVo.setIsHeader(1);
		ebeExpertGroupVo.setOpTime(getTime());
		modifyEbeExpertGroup(ebeExpertGroupVo);
		return true;
	}
	
	
	//查询可以入组的专家
	public PageInfo<EbeExpertGroupVo> getExpertCouldIntoGroup(String groupType, int pageindex, int pagesize){
		//groupId=-1表示没有入组，isTechScore，isBusiScore，isPriceSocre判断专家类型
		String sql=" FROM  EbeExpertGroup d where d.groupId = -1";
		List<EbeExpertGroupVo> ebeExpertGroupVoList = new ArrayList<EbeExpertGroupVo>(); //VO集合
		int count =0;
		try {
			//丧心病狂的只是为了计数……
			List<EbeExpertGroup> list = tableDao.otherQuery(sql, true, true, null);
			for(int i = 0;i<list.size(); i++){
				EbeExpertGroupVo egv = new EbeExpertGroupVo(list.get(i));
				if((egv.getIsBusiScore() == 1 && "BUSI".equals(groupType)) || (egv.getIsTechScore() == 1 && "TECH".equals(groupType))
						|| (egv.getIsPriceScore() == 1 && "PRICE".equals(groupType))){
					count++;
				}
			}
			//查询数据	
			list = tableDao.querydata(sql, true, pageindex,pagesize, null);
			for(int i = 0;i<list.size(); i++){
				EbeExpertGroupVo egv = new EbeExpertGroupVo(list.get(i));
				//如果此条未分组专家的类型和当前专家组的类型相同，获取详细信息
				if((egv.getIsBusiScore() == 1 && "BUSI".equals(groupType)) || (egv.getIsTechScore() == 1 && "TECH".equals(groupType))
						|| (egv.getIsPriceScore() == 1 && "PRICE".equals(groupType))){
					String sql1 = "select b.expertId FROM  EptExtractionNameList b , EbeExpertGroup c where b.id = c.extractionNameListId " +
					"and c.id=:expertGroupId";
					HashMap<String, Object> params = new HashMap<String, Object>();
					params.put("expertGroupId", egv.getId());
					List<Integer> expertId = tableDao.otherQuery(sql1, true, true, params);
					//1.3通过expertId获得expertBaseInfo
					String sql2 = "from EptExpertBaseinfo a where a.id =:expertId";
					params = new HashMap<String, Object>();
					params.put("expertId", expertId.get(0));
					List<EptExpertBaseinfo> eptExpertBaseinfo = tableDao.otherQuery(sql2, true, true, params);
					//1.4给vo赋值
					egv.setExpertAccount(eptExpertBaseinfo.get(0).getIdNumber());
					egv.setExpertName(eptExpertBaseinfo.get(0).getExpertName());
					egv.setExpertRate(eptExpertBaseinfo.get(0).getExpertRate());
					ebeExpertGroupVoList.add(egv);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new PageInfo<EbeExpertGroupVo>(ebeExpertGroupVoList,count,pageindex,pagesize);
	}
	/**
	 * 获取系统时间
	 * @author hgl
	 * @return 返回时间字符串
	 * date 2014-8-14 已测试
	 */
	public String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}

}
