package com.ceit.ebs.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.entity.SysUserRole;
import com.ceit.ebs.sys.service.ISysUserRoleService;
import com.ceit.ebs.sys.vo.SysUserRoleVo;

/**
 *@author gr
 *@date 2014-8-7 下午03:33:34
 */

public class SysUserRoleService implements ISysUserRoleService {

	private SysUserRole sysUserRole;
	private ITableDao tableDao;

	public SysUserRoleService(){
		
	}
	
	public SysUserRoleVo getSysUserRolebyId(int id){
		SysUserRoleVo sysUserRoleVo = null;
		try {
			sysUserRole = (SysUserRole)(tableDao.getEntitybyId(id, SysUserRole.class));
			sysUserRoleVo = new SysUserRoleVo(sysUserRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysUserRoleVo;
	}
	
	public boolean modifySysUserRole(SysUserRoleVo s){
		try {
			tableDao.update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteSysUserRolebyId(int id){
		try{
			tableDao.delete(id,SysUserRole.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertSysUserRole(SysUserRoleVo sysUserRoleVo){
		try {
			SysUserRole sr = sysUserRoleVo.adapterToSysUserRole();
			Integer sysUserRoleId = tableDao.insert(sr);
			//sr.setId(sysUserRoleId);
			//sr.setDispindex(sysUserRoleId);
			tableDao.update(sr);
			return sysUserRoleId;
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
		sql = "SELECT  COUNT(d.sys_user_role_id) FROM  SYS_USER_ROLE d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<SysUserRole> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SysUserRoleVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SysUserRoleVo> querydata(int pageindex, int pagesize) {
		List<SysUserRoleVo> sysUserRoleVoList = new ArrayList<SysUserRoleVo>(); //VO集合
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  SYS_USER_ROLE d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		int count = 0;
		try {
			//PO集合
			List<SysUserRole> sysUserRoleList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(sysUserRoleList != null && sysUserRoleList.size() > 0){
				for(int i = 0 ; i < sysUserRoleList.size() ; i++){
					SysUserRoleVo srv = new SysUserRoleVo(sysUserRoleList.get(i));//PO -> VO
					sysUserRoleVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<SysUserRoleVo>(sysUserRoleVoList,count,pageindex,pagesize);
	}
	
	public void setSysUserRole(SysUserRole sysUserRole) {
		this.sysUserRole = sysUserRole;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}
}