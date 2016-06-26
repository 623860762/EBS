package com.ceit.ebs.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.entity.SysUser;
import com.ceit.ebs.sys.service.ISysUserService;
import com.ceit.ebs.sys.vo.SysUserVo;


/**
 *@author gr
 *@date 2014-8-7 下午03:35:59
 */

public class SysUserService implements ISysUserService {
	static Log log=LogFactory.getLog(SysUserService.class);
	private SysUser sysUser;
	private ITableDao tableDao;
	
	public SysUserVo getSysUserbyId(int id){
		SysUserVo sysUserVo = null;
		try {
			sysUser = (SysUser)(tableDao.getEntitybyId(id, SysUser.class));
			sysUserVo = new SysUserVo(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysUserVo;
	}
	
	public boolean modifySysUser(SysUserVo s){
		try {
			tableDao.update(s.adapterToSysUser());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteSysUserbyId(Integer id){
		try{
			tableDao.delete(id,SysUser.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertSysUser(SysUserVo sysUserVo){
		try {
			SysUser sr = sysUserVo.adapterToSysUser();
			Integer sysUserId = tableDao.insert(sr);
			sr.setId(sysUserId);
			sr.setDispIndex(sysUserId);
			this.tableDao.update(sr);
			tableDao.update(sr);
			return sysUserId;
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
		sql = "SELECT  COUNT(d.sys_user_id) FROM  SYS_USER d " +
		"where '1' = '1' ";
		try {
			List<SysUser> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SysUserVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SysUserVo> querydata(int pageindex, int pagesize) {
		List<SysUserVo> sysUserVoList = new ArrayList<SysUserVo>(); //VO集合
		String sql = " FROM  SYS_USER d where '1' = '1'  ";
		int count = 0;
		try {
			//PO集合
			List<SysUser> sysUserList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(sysUserList != null && sysUserList.size() > 0){
				for(int i = 0 ; i < sysUserList.size() ; i++){
					SysUserVo srv = new SysUserVo(sysUserList.get(i));//PO -> VO
					sysUserVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<SysUserVo>(sysUserVoList,count,pageindex,pagesize);
	}
	
	/**
	 * 通过organId(组织机构id，在用户表中为corporationId)获取下属用户
	 * @author wujinshui
	 */
	@SuppressWarnings("unchecked")
	public List<SysUserVo> getUserListByOrganId(int parentId) {
		List<SysUserVo> sysUserVoList = new ArrayList<SysUserVo>();
		String hql = "FROM SysUser t where t.parentId=:parentId order by t.dispIndex";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		try {
			List<SysUser> sysUserList = this.tableDao.otherQuery(hql, true, true, map);
			if(sysUserList != null && sysUserList.size() > 0){
				for(int i = 0 ; i < sysUserList.size() ; i++){
					SysUserVo srv = new SysUserVo(sysUserList.get(i));//PO -> VO
					sysUserVoList.add(srv);
				}
			}
			return sysUserVoList;
		} catch (Exception e) {
			log.info("通过组织机构id获取所有下属用户出现异常!");
		}
		return null;
	}
	

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}
	
	/**
	 * 上移下移菜单
	 */
	public void moveUser(int id, int flag) {
		try {
			if(flag == 0){
				this.tableDao.up(id, SysUser.class);
			}else{
				this.tableDao.down(id, SysUser.class);
			}
		} catch (Exception e) {
			log.info("上移下移菜单出现异常");
		}
	}
}