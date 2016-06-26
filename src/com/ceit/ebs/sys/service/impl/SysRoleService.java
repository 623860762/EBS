package com.ceit.ebs.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.entity.SysRole;
import com.ceit.ebs.sys.service.ISysRoleService;
import com.ceit.ebs.sys.vo.SysRoleVo;

/**
 *@author gr
 *@date 2014-8-7 下午03:27:28
 */

public class SysRoleService implements ISysRoleService {

	static Log log=LogFactory.getLog(SysRoleService.class);
	private SysRole sysRole;
	private ITableDao tableDao;
	
	
	
	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	public SysRoleVo getSysRolebyId(int id){
		SysRoleVo sysRoleVo = null;
		try {
			sysRole = (SysRole)(tableDao.getEntitybyId(id, SysRole.class));
			sysRoleVo = new SysRoleVo(sysRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysRoleVo;
	}
	
	public boolean modifySysRole(SysRoleVo s){
		try {
			tableDao.update(s.adapterToSysRole());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteSysRolebyId(Integer id){
		try{
			tableDao.delete(id,SysRole.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Integer insertSysRole(SysRoleVo sysRoleVo){
		try {
			SysRole sr = sysRoleVo.adapterToSysRole();
			Integer sysRoleId = tableDao.insert(sr);
			sr.setId(sysRoleId);
			sr.setDispIndex(sysRoleId);
			tableDao.update(sr);
			return sysRoleId;
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
		sql = "SELECT COUNT(id) FROM SysRole";
		try {
			List<SysRole> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SysRoleVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SysRoleVo> querydata(int pageindex, int pagesize) {
		List<SysRoleVo> sysRoleVoList = new ArrayList<SysRoleVo>(); //VO集合
		String sql = " FROM  SysRole d where '1' = '1'  ";
		int count = 0;
		try {
			//PO集合
			List<SysRole> sysRoleList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(sysRoleList != null && sysRoleList.size() > 0){
				for(int i = 0 ; i < sysRoleList.size() ; i++){
					SysRoleVo srv = new SysRoleVo(sysRoleList.get(i));//PO -> VO
					sysRoleVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<SysRoleVo>(sysRoleVoList,count,pageindex,pagesize);
	}
	
	
	/**
	 * 通过organId(组织机构id，在角色表中为corporationId)获取下属用户
	 * @author wujinshui
	 */
	@SuppressWarnings("unchecked")
	public List<SysRoleVo> getRoleListByOrganId(int parentId) {
		List<SysRoleVo> sysRoleVoList = new ArrayList<SysRoleVo>();
		String hql = "FROM SysRole t where t.parentId=:parentId order by t.dispIndex";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		try {
			List<SysRole> sysRoleList = this.tableDao.otherQuery(hql, true, true, map);
			if(sysRoleList != null && sysRoleList.size() > 0){
				for(int i = 0 ; i < sysRoleList.size() ; i++){
					SysRoleVo srv = new SysRoleVo(sysRoleList.get(i));//PO -> VO
					sysRoleVoList.add(srv);
				}
			}
			return sysRoleVoList;
		} catch (Exception e) {
			log.info("通过组织机构id获取所有下属角色出现异常!");
		}
		return null;
	}
	

	/**
	 * 上移下移菜单
	 */
	public void moveRole(int id, int flag) {
		try {
			if(flag == 0){
				this.tableDao.up(id, SysRole.class);
			}else{
				this.tableDao.down(id, SysRole.class);
			}
		} catch (Exception e) {
			log.info("上移下移菜单出现异常");
		}
	}

}