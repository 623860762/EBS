package com.ceit.ebs.sup.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sup.entity.SupSingBid;
import com.ceit.ebs.sup.service.ISupSingBidService;
import com.ceit.ebs.sup.vo.SupSingBidVo;

/**
 * SupSingBidService 是为系统的供应商唱标明细提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-15
 */
public class SupSingBidService implements ISupSingBidService {

	private SupSingBid supSingBid;
	private ITableDao tableDao;
	
	
	public SupSingBidService(){
		
	}
	
	/**
	 * 根据主键ID,获得数据总数
	 * @return 查询到的数据总数，若失败，返回-1
	 */
	@SuppressWarnings("unchecked")
	public Integer getCount() {
		// TODO Auto-generated method stub
		Integer count = 0;//记录总数
		String sql = null;
		//Map<String,Object> map = new HashMap<String,Object>();
		sql="SELECT COUNT(d.id) FROM SupSingBid d "+"where '1'='1'";
		try {
			List<SupSingBid> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SupSingBidVo实例的PageInfo，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SupSingBidVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<SupSingBidVo> supSingBidVoList = new ArrayList<SupSingBidVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  SupSingBid d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<SupSingBid> supSingBidList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(supSingBidList != null && supSingBidList.size() > 0){
				for(int i = 0 ; i < supSingBidList.size() ; i++){
					SupSingBidVo efuv = new SupSingBidVo(supSingBidList.get(i));//PO -> VO
					supSingBidVoList.add(efuv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<SupSingBidVo>(supSingBidVoList,count,pageindex,pagesize);
		
	}
	/**
	 * 根据定标的ID查找定标
	 * @param  supSingBidId 要查询的上传文件ID值
	 * @return 查询到的SupSingBid实例
	 */
	public SupSingBidVo getSupSingBidbyId(Integer supSingBidId) {
		// TODO Auto-generated method stub
		SupSingBidVo supSingBidVo=null;
		try {
			supSingBid = (SupSingBid)tableDao.getEntitybyId(supSingBidId, SupSingBid.class);
			supSingBidVo=new SupSingBidVo(supSingBid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return supSingBidVo;	
	}
	/**
	 * 修改定标实例
	 * @param  supSingBidVo 要修改的定标Vo
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifySupSingBid(SupSingBidVo supSingBidVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(supSingBidVo.adapterToSupSingBid());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据定标的ID删除定标
	 * @param  supSingBidId 要删除的定标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteSupSingBidbyId(Integer supSingBidId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(supSingBidId, SupSingBid.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个定标
	 * @param supSingBidVo 要添加的SupSingBidVo实例
	 * @return 添加的定标在数据库中的ID值，若失败返回-1
	 */
	public Integer insertSupSingBid(SupSingBidVo supSingBidVo) {
		// TODO Auto-generated method stub
		try {
			SupSingBid ew = supSingBidVo.adapterToSupSingBid();
			Integer supSingBidId = tableDao.insert(ew);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(ew);
			return supSingBidId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setSupSingBid(SupSingBid supSingBid) {
		// TODO Auto-generated method stub
		this.supSingBid=supSingBid;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}

}
