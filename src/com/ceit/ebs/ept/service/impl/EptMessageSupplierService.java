package com.ceit.ebs.ept.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptMessageSupplier;
import com.ceit.ebs.ept.service.IEptMessageSupplierService;
import com.ceit.ebs.ept.vo.EptMessageSupplierVo;

/**
 * EptMessageSupplier entity. @author MyEclipse Persistence Tools
 */

public class EptMessageSupplierService implements IEptMessageSupplierService {

	// Fields

	private EptMessageSupplier eptMessageSupplier;
	private ITableDao tableDao;
	
	public EptMessageSupplierService(){
	}

	// Constructors

	
	
	public EptMessageSupplier getEptMessageSupplierbyId(int id){
		
		try {
			eptMessageSupplier = (EptMessageSupplier)(tableDao.getEntitybyId(id, EptMessageSupplier.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eptMessageSupplier;
	}
	
	public boolean modifyEptMessageSupplier(EptMessageSupplierVo sv){
		try {
			tableDao.update(sv.adapterToEptMessageSupplier());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEptMessageSupplierbyId(Integer id){
		try{
			tableDao.delete(id,EptMessageSupplier.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEptMessageSupplier(EptMessageSupplierVo eptMessageSupplierVo){
		try {
			EptMessageSupplier sr = eptMessageSupplierVo.adapterToEptMessageSupplier();
			Integer eptMessageSupplierId = tableDao.insert(sr);
			//sr.setId(eptMessageSupplierId);
			//sr.setDispindex(eptMessageSupplierId);
			tableDao.update(sr);
			return eptMessageSupplierId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setEptMessageSupplier(EptMessageSupplier eptMessageSupplier) {
		this.eptMessageSupplier = eptMessageSupplier;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
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
		sql = "SELECT  COUNT(d.id) FROM  EptMessageSupplier d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EptMessageSupplier> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EptMessageSupplierVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EptMessageSupplierVo> querydata(int pageindex, int pagesize) {
		List<EptMessageSupplierVo> eptMessageSupplierVoList = new ArrayList<EptMessageSupplierVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EptMessageSupplier d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EptMessageSupplier> eptMessageSupplierList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(eptMessageSupplierList != null && eptMessageSupplierList.size() > 0){
				for(int i = 0 ; i < eptMessageSupplierList.size() ; i++){
					EptMessageSupplierVo srv = new EptMessageSupplierVo(eptMessageSupplierList.get(i));//PO -> VO
					eptMessageSupplierVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EptMessageSupplierVo>(eptMessageSupplierVoList,count,pageindex,pagesize);
	}

}