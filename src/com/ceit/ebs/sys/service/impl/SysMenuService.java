package com.ceit.ebs.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.entity.SysMenu;
import com.ceit.ebs.sys.service.ISysMenuService;
import com.ceit.ebs.sys.vo.SysMenuVo;

/**
 *@author gr
 *@date 2014-8-7 下午03:00:59
 */

public class SysMenuService implements ISysMenuService{

	static Log log=LogFactory.getLog(SysMenuService.class);
	private SysMenu sysMenu;
	private ITableDao tableDao;
	
	public SysMenuVo getSysMenubyId(int id){
		SysMenuVo sysMenuVo = null;
		try {
			sysMenu = (SysMenu)(tableDao.getEntitybyId(id, SysMenu.class));
			sysMenuVo = new SysMenuVo(sysMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysMenuVo;
	}
	
	public boolean modifySysMenu(SysMenuVo so){
		try {
			SysMenu s = so.adapterToSysMenu();
			tableDao.update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteSysMenubyId(Integer id){
		try{
			tableDao.delete(id,SysMenu.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertSysMenu(SysMenuVo sysMenuVo){
		try {
			SysMenu sr = sysMenuVo.adapterToSysMenu();
			Integer sysMenuId = tableDao.insert(sr);
			sr.setId(sysMenuId);
			sr.setDispIndex(sysMenuId);
			tableDao.update(sr);
			return sysMenuId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
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
		sql = "SELECT  COUNT(d.id) FROM  SysMenu d " +
		"where '1' = '1' ";
		try {
			List<SysMenu> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SysMenuVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SysMenuVo> querydata(int pageindex, int pagesize) {
		List<SysMenuVo> sysMenuVoList = new ArrayList<SysMenuVo>(); //VO集合
		String sql = " FROM  SysMenu d where '1' = '1'  ";
		int count = 0;
		try {
			//PO集合
			List<SysMenu> sysMenuList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(sysMenuList != null && sysMenuList.size() > 0){
				for(int i = 0 ; i < sysMenuList.size() ; i++){
					SysMenuVo srv = new SysMenuVo(sysMenuList.get(i));//PO -> VO
					sysMenuVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<SysMenuVo>(sysMenuVoList,count,pageindex,pagesize);
	}

	/**
	 * 通过parentId获取所有子节点
	 * @author wujinshui
	 */
	@SuppressWarnings("unchecked")
	public List<SysMenuVo> getMenuListByParentId(int parentId) {
		List<SysMenuVo> sysMenuVoList = new ArrayList<SysMenuVo>();
		String hql = "FROM SysMenu t where t.parentId=:parentId order by t.dispIndex";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		try {
			List<SysMenu> sysMenuList = this.tableDao.otherQuery(hql, true, true, map);
			if(sysMenuList != null && sysMenuList.size() > 0){
				for(int i = 0 ; i < sysMenuList.size() ; i++){
					SysMenuVo srv = new SysMenuVo(sysMenuList.get(i));//PO -> VO
					sysMenuVoList.add(srv);
				}
			}
			return sysMenuVoList;
		} catch (Exception e) {
			log.info("通过父节点获取所有菜单出现异常!");
		}
		return null;
	}

	/**
	 * 上移下移菜单
	 */
	public void moveMenu(int id, int flag) {
		try {
			if(flag == 0){
				this.tableDao.up(id, SysMenu.class);
			}else{
				this.tableDao.down(id, SysMenu.class);
			}
		} catch (Exception e) {
			log.info("上移下移菜单出现异常");
		}
	}
}