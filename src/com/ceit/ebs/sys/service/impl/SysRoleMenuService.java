package com.ceit.ebs.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.entity.SysRoleMenu;
import com.ceit.ebs.sys.service.ISysRoleMenuService;
import com.ceit.ebs.sys.vo.SysRoleMenuVo;

/**
 *@author gr
 *@date 2014-8-7 下午03:19:25
 */

public class SysRoleMenuService implements ISysRoleMenuService{

	// Fields

	private SysRoleMenu sysRoleMenu;
	private ITableDao tableDao;

	// Constructors

	
	
	public SysRoleMenuVo getSysRoleMenubyId(int id){
		SysRoleMenuVo sysRoleMenuVo = null;
		try {
			sysRoleMenu = (SysRoleMenu)(tableDao.getEntitybyId(id, SysRoleMenu.class));
			sysRoleMenuVo = new SysRoleMenuVo(sysRoleMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysRoleMenuVo;
	}
	
	public boolean modifySysRoleMenu(SysRoleMenuVo so){
		try {
			SysRoleMenu s = so.adapterToSysRoleMenu();
			tableDao.update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteSysRoleMenubyId(Integer id){
		try{
			tableDao.delete(id,SysRoleMenu.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertSysRoleMenu(SysRoleMenuVo sysRoleMenuVo){
		try {
			SysRoleMenu sr = sysRoleMenuVo.adapterToSysRoleMenu();
			Integer sysRoleMenuId = tableDao.insert(sr);
			//sr.setId(sysRoleMenuId);
			//sr.setDispindex(sysRoleMenuId);
			tableDao.update(sr);
			return sysRoleMenuId;
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
		sql = "SELECT  COUNT(d.sys_role_menu_id) FROM  SYS_ROLE_MENU d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<SysRoleMenu> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SysRoleMenuVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SysRoleMenuVo> querydata(int pageindex, int pagesize) {
		List<SysRoleMenuVo> sysRoleMenuVoList = new ArrayList<SysRoleMenuVo>(); //VO集合
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  SYS_ROLE_MENU d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		int count = 0;
		try {
			//PO集合
			List<SysRoleMenu> sysRoleMenuList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(sysRoleMenuList != null && sysRoleMenuList.size() > 0){
				for(int i = 0 ; i < sysRoleMenuList.size() ; i++){
					SysRoleMenuVo srv = new SysRoleMenuVo(sysRoleMenuList.get(i));//PO -> VO
					sysRoleMenuVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<SysRoleMenuVo>(sysRoleMenuVoList,count,pageindex,pagesize);
	}
	
	public void setSysRoleMenu(SysRoleMenu sysRoleMenu) {
		this.sysRoleMenu = sysRoleMenu;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

}