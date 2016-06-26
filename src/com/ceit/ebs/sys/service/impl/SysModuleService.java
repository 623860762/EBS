package com.ceit.ebs.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.entity.SysModule;
import com.ceit.ebs.sys.service.ISysModuleService;
import com.ceit.ebs.sys.vo.SysModuleVo;

/**
 * SysModule entity. @author MyEclipse Persistence Tools
 */

public class SysModuleService implements ISysModuleService{
	static Log log=LogFactory.getLog(SysModuleService.class);
	private SysModule sysModule;
	private ITableDao tableDao;

	public SysModuleService(){
	}
	
	public SysModuleVo getSysModulebyId(int id){
		SysModuleVo sysModuleVo = null;
		try {
			sysModule = (SysModule)(tableDao.getEntitybyId(id, SysModule.class));
			sysModuleVo =new SysModuleVo(sysModule);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysModuleVo;
	}
	
	public boolean modifySysModule(SysModuleVo so){
		try {
			SysModule s = so.adapterToSysModule();
			tableDao.update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSysModulebyId(Integer id){
		try{
			tableDao.delete(id,SysModule.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertSysModule(SysModuleVo sysModuleVo){
		try {
			SysModule sr = sysModuleVo.adapterToSysModule();
			Integer sysModuleId = tableDao.insert(sr);
			sr.setId(sysModuleId);
			sr.setDispIndex(sysModuleId);
			tableDao.update(sr);
			return sysModuleId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setSysModule(SysModule sysModule) {
		this.sysModule = sysModule;
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
		sql = "SELECT  COUNT(d.id) FROM  SysModule d " +
		"where '1' = '1' ";
		try {
			List<SysModule> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SysModuleVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SysModuleVo> querydata(int pageindex, int pagesize) {
		List<SysModuleVo> sysModuleVoList = new ArrayList<SysModuleVo>(); //VO集合
		String sql = " FROM  SysModule d where '1' = '1'  ";
		int count = 0;
		try {
			//PO集合
			List<SysModule> sysModuleList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(sysModuleList != null && sysModuleList.size() > 0){
				for(int i = 0 ; i < sysModuleList.size() ; i++){
					SysModuleVo srv = new SysModuleVo(sysModuleList.get(i));//PO -> VO
					sysModuleVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<SysModuleVo>(sysModuleVoList,count,pageindex,pagesize);
	}

	/**
	 * 通过parentId获取下属模块
	 * @author wujinshui
	 */
	@SuppressWarnings("unchecked")
	public List<SysModuleVo> getModuleListByParentId(int parentId) {
		List<SysModuleVo> sysModuleVoList = new ArrayList<SysModuleVo>();
		String hql = "FROM SysModule t where t.parentId=:parentId order by t.dispIndex";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		try {
			List<SysModule> sysModuleList = this.tableDao.otherQuery(hql, true, true, map);
			if(sysModuleList != null && sysModuleList.size() > 0){
				for(int i = 0 ; i < sysModuleList.size() ; i++){
					SysModuleVo srv = new SysModuleVo(sysModuleList.get(i));//PO -> VO
					sysModuleVoList.add(srv);
				}
			}
			return sysModuleVoList;
		} catch (Exception e) {
			log.info("通过ParentId获取所有下属模块出现异常!");
		}
		return null;
	}
	

	/**
	 * 上移下移模块
	 */
	public void moveModule(int id, int flag) {
		try {
			if(flag == 0){
				this.tableDao.up(id, SysModule.class);
			}else{
				this.tableDao.down(id, SysModule.class);
			}
		} catch (Exception e) {
			log.info("上移下移模块出现异常");
		}
	}

}