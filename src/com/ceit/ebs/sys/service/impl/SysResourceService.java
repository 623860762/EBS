package com.ceit.ebs.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.entity.SysResource;
import com.ceit.ebs.sys.service.ISysResourceService;
import com.ceit.ebs.sys.vo.SysResourceVo;

/**
 * SysResource entity. @author MyEclipse Persistence Tools
 */

public class SysResourceService implements ISysResourceService{
	static Log log=LogFactory.getLog(SysResourceService.class);
	private SysResource sysResource;
	private ITableDao tableDao;

	public SysResourceVo getSysResourcebyId(int id){
		SysResourceVo sysResourceVo = null;
		try {
			sysResource = (SysResource)(tableDao.getEntitybyId(id, SysResource.class));
			sysResourceVo = new SysResourceVo(sysResource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysResourceVo;
	}
	
	public boolean modifySysResource(SysResourceVo so){
		try {
			SysResource s = so.adapterToSysResource();
			tableDao.update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteSysResourcebyId(Integer id){
		try{
			tableDao.delete(id,SysResource.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertSysResource(SysResourceVo sysResourceVo){
		try {
			SysResource sr = sysResourceVo.adapterToSysResource();
			Integer sysResourceId = tableDao.insert(sr);
			sr.setId(sysResourceId);
			sr.setDispIndex(sysResourceId);
			tableDao.update(sr);
			return sysResourceId;
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
		sql = "SELECT  COUNT(d.id) FROM  SysResource d " +
		"where '1' = '1' ";
		try {
			List<SysResource> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SysResourceVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SysResourceVo> querydata(int pageindex, int pagesize) {
		List<SysResourceVo> sysResourceVoList = new ArrayList<SysResourceVo>(); //VO集合
		String sql = " FROM  SysResource d where '1' = '1'  ";
		int count = 0;
		try {
			//PO集合
			List<SysResource> sysResourceList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(sysResourceList != null && sysResourceList.size() > 0){
				for(int i = 0 ; i < sysResourceList.size() ; i++){
					SysResourceVo srv = new SysResourceVo(sysResourceList.get(i));//PO -> VO
					sysResourceVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<SysResourceVo>(sysResourceVoList,count,pageindex,pagesize);
	}
	
	public void setSysResource(SysResource sysResource) {
		this.sysResource = sysResource;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	
	/**
	 * 通过parentId获取下属资源
	 * @author wujinshui
	 */
	@SuppressWarnings("unchecked")
	public List<SysResourceVo> getResourceListByParentId(int parentId) {
		List<SysResourceVo> sysResourceVoList = new ArrayList<SysResourceVo>();
		String hql = "FROM SysResource t where t.parentId=:parentId order by t.dispIndex";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		try {
			List<SysResource> sysResourceList = this.tableDao.otherQuery(hql, true, true, map);
			if(sysResourceList != null && sysResourceList.size() > 0){
				for(int i = 0 ; i < sysResourceList.size() ; i++){
					SysResourceVo srv = new SysResourceVo(sysResourceList.get(i));//PO -> VO
					sysResourceVoList.add(srv);
				}
			}
			return sysResourceVoList;
		} catch (Exception e) {
			log.info("通过ParentId获取所有下属资源出现异常!");
		}
		return null;
	}

	/**
	 * 上移下移资源
	 */
	public void moveResource(int id, int flag) {
		try {
			if(flag == 0){
				this.tableDao.up(id, SysResource.class);
			}else{
				this.tableDao.down(id, SysResource.class);
			}
		} catch (Exception e) {
			log.info("上移下移模块出现异常");
		}
	}
}