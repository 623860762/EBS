package com.ceit.ebs.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.entity.SysRoleResource;
import com.ceit.ebs.sys.service.ISysRoleResourceService;
import com.ceit.ebs.sys.vo.SysRoleResourceVo;

/**
 *@author gr
 *@date 2014-8-7 下午03:22:55
 */

public class SysRoleResourceService implements ISysRoleResourceService{

	// Fields

	private SysRoleResource sysRoleResource;
	private ITableDao tableDao;

	// Constructors

	
	
	public SysRoleResourceVo getSysRoleResourcebyId(int id){
		SysRoleResourceVo sysRoleResourceVo = null;
		try {
			sysRoleResource = (SysRoleResource)(tableDao.getEntitybyId(id, SysRoleResource.class));
			sysRoleResourceVo = new SysRoleResourceVo(sysRoleResource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysRoleResourceVo;
	}
	
	public boolean modifySysRoleResource(SysRoleResourceVo so){
		try {
			SysRoleResource s = so.adapterToSysRoleResource();
			tableDao.update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteSysRoleResourcebyId(Integer id){
		try{
			tableDao.delete(id,SysRoleResource.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertSysRoleResource(SysRoleResourceVo sysRoleResourceVo){
		try {
			SysRoleResource sr = sysRoleResourceVo.adapterToSysRoleResource();
			Integer sysRoleResourceId = tableDao.insert(sr);
			//sr.setId(sysRoleResourceId);
			//sr.setDispindex(sysRoleResourceId);
			tableDao.update(sr);
			return sysRoleResourceId;
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
		sql = "SELECT  COUNT(d.id) FROM  SysRoleResource d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<SysRoleResource> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SysRoleResourceVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SysRoleResourceVo> querydata(int pageindex, int pagesize) {
		List<SysRoleResourceVo> sysRoleResourceVoList = new ArrayList<SysRoleResourceVo>(); //VO集合
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  SysRoleResource d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		int count = 0;
		try {
			//PO集合
			List<SysRoleResource> sysRoleResourceList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(sysRoleResourceList != null && sysRoleResourceList.size() > 0){
				for(int i = 0 ; i < sysRoleResourceList.size() ; i++){
					SysRoleResourceVo srv = new SysRoleResourceVo(sysRoleResourceList.get(i));//PO -> VO
					sysRoleResourceVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<SysRoleResourceVo>(sysRoleResourceVoList,count,pageindex,pagesize);
	}
	
	public void setSysRoleResource(SysRoleResource sysRoleResource) {
		this.sysRoleResource = sysRoleResource;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

}