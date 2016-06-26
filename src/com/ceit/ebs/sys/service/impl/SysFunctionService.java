package com.ceit.ebs.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.entity.SysFunction;
import com.ceit.ebs.sys.service.ISysFunctionService;
import com.ceit.ebs.sys.vo.SysFunctionVo;

/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 * @author gr
 * @version 2014.8.7
 */

public class SysFunctionService implements ISysFunctionService{
	static Log log=LogFactory.getLog(SysFunctionService.class);
	private SysFunction sysFunction;
	private ITableDao tableDao;

	public SysFunctionService(){
	}
	
	public SysFunctionVo getSysFunctionbyId(int id){
		SysFunctionVo sysFunctionVo = null;
		try {
			sysFunction = (SysFunction)(tableDao.getEntitybyId(id, SysFunction.class));
			sysFunctionVo =  new SysFunctionVo(sysFunction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysFunctionVo;
	}
	
	public boolean modifySysFunction(SysFunctionVo so){
		try {
			SysFunction s = so.adapterToSysFunction();
			tableDao.update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteSysFunctionbyId(Integer id){
		try{
			tableDao.delete(id,SysFunction.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertSysFunction(SysFunctionVo sysFunctionVo){
		try {
			SysFunction sr = sysFunctionVo.adapterToSysFunction();
			Integer sysFunctionId = tableDao.insert(sr);
			sr.setId(sysFunctionId);
			sr.setDispIndex(sysFunctionId);
			tableDao.update(sr);
			return sysFunctionId;
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
		sql = "SELECT  COUNT(d.id) FROM  SysFunction d " +
		"where '1' = '1' ";
		try {
			List<SysFunction> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有SysFunctionVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<SysFunctionVo> querydata(int pageindex, int pagesize) {
		List<SysFunctionVo> sysFunctionVoList = new ArrayList<SysFunctionVo>(); //VO集合
		String sql = " FROM  SysFunction d where '1' = '1'  ";
		int count = 0;
		try {
			//PO集合
			List<SysFunction> sysFunctionList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(sysFunctionList != null && sysFunctionList.size() > 0){
				for(int i = 0 ; i < sysFunctionList.size() ; i++){
					SysFunctionVo srv = new SysFunctionVo(sysFunctionList.get(i));//PO -> VO
					sysFunctionVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<SysFunctionVo>(sysFunctionVoList,count,pageindex,pagesize);
	}

	public SysFunction getSysFunction() {
		return sysFunction;
	}

	public void setSysFunction(SysFunction sysFunction) {
		this.sysFunction = sysFunction;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}
	
	/**
	 * 通过moduleId获取下属功能
	 * @author wujinshui
	 */
	@SuppressWarnings("unchecked")
	public List<SysFunctionVo> getFunctionListByParentId(int parentId) {
		List<SysFunctionVo> sysFunctionVoList = new ArrayList<SysFunctionVo>();
		String hql = "FROM SysFunction t where t.parentId=:parentId order by t.dispIndex";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", parentId);
		try {
			List<SysFunction> sysFunctionList = this.tableDao.otherQuery(hql, true, true, map);
			if(sysFunctionList != null && sysFunctionList.size() > 0){
				for(int i = 0 ; i < sysFunctionList.size() ; i++){
					SysFunctionVo srv = new SysFunctionVo(sysFunctionList.get(i));//PO -> VO
					sysFunctionVoList.add(srv);
				}
			}
			return sysFunctionVoList;
		} catch (Exception e) {
			log.info("通过ParentId获取所有下属功能出现异常!");
		}
		return null;
	}
	

	/**
	 * 上移下移模块
	 */
	public void moveFunction(int id, int flag) {
		try {
			if(flag == 0){
				this.tableDao.up(id, SysFunction.class);
			}else{
				this.tableDao.down(id, SysFunction.class);
			}
		} catch (Exception e) {
			log.info("上移下移功能出现异常");
		}
	}
	
	
	
}

