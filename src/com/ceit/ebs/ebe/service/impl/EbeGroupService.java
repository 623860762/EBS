package com.ceit.ebs.ebe.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.vo.CntContractPurchaserVo;
import com.ceit.ebs.ebe.entity.EbeGroup;
import com.ceit.ebs.ebe.service.IEbeGroupService;
import com.ceit.ebs.ebe.vo.EbeGroupVo;

public class EbeGroupService implements IEbeGroupService {

	private EbeGroup ebeGroup;
	private ITableDao tableDao;

	// Constructors

	
	public EbeGroupService(){
		
	}
	
	public EbeGroupVo getEbeGroupbyId(int id){
		EbeGroupVo ebeGroupVo = null;
		try {
			ebeGroup = (EbeGroup)(tableDao.getEntitybyId(id, EbeGroup.class));
			ebeGroupVo = new EbeGroupVo(ebeGroup);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ebeGroupVo;
	}
	
	public boolean modifyEbeGroup(EbeGroupVo s){
		try {
			tableDao.update(s.adapterToEbeGroup());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEbeGroupbyId(Integer id){
		try{
			tableDao.delete(id,EbeGroup.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEbeGroup(EbeGroupVo ebeGroupVo){
		try {
			EbeGroup sr = ebeGroupVo.adapterToEbeGroup();
			Integer ebeGroupId = tableDao.insert(sr);
			//sr.setId(ebeGroupId);
			//sr.setDispindex(ebeGroupId);
			tableDao.update(sr);
			return ebeGroupId;
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
		sql = "SELECT  COUNT(d.id) FROM  EbeGroup d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EbeGroup> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbeGroupVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbeGroupVo> querydata(int pageindex, int pagesize) {
		List<EbeGroupVo> ebeGroupVoList = new ArrayList<EbeGroupVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbeGroup d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbeGroup> ebeGroupList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebeGroupList != null && ebeGroupList.size() > 0){
				for(int i = 0 ; i < ebeGroupList.size() ; i++){
					EbeGroupVo srv = new EbeGroupVo(ebeGroupList.get(i));//PO -> VO
					ebeGroupVoList.add(srv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<EbeGroupVo>(ebeGroupVoList,count,pageindex,pagesize);
	}
	

	public void setEbeGroup(EbeGroup ebeGroup) {
		this.ebeGroup = ebeGroup;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}
	
	@SuppressWarnings("unchecked")
	public PageInfo<EbeGroupVo> queryGroupInProject(int pageindex, int pagesize, int projectId) {
		List<EbeGroupVo> ebeGroupVoList = new ArrayList<EbeGroupVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbeGroup d where d.projectId=:projectId ";
		//sql += " order by d.dispindex desc "; 
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("projectId", projectId);
			//PO集合
			List<EbeGroup> ebeGroupList = tableDao.querydata(sql, true, pageindex, pagesize, params);
			if(ebeGroupList != null && ebeGroupList.size() > 0){
				for(int i = 0 ; i < ebeGroupList.size() ; i++){
					EbeGroupVo srv = new EbeGroupVo(ebeGroupList.get(i));//PO -> VO
					ebeGroupVoList.add(srv);
					count++;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<EbeGroupVo>(ebeGroupVoList,count,pageindex,pagesize);
	}

}
