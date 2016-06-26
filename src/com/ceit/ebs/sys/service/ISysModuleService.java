package com.ceit.ebs.sys.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.vo.SysModuleVo;

/**
 *@author gr
 *@date 2014-8-7 下午03:06:50
 */

public interface ISysModuleService {

	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo
	public PageInfo<SysModuleVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public SysModuleVo getSysModulebyId(int id);
	
	//通过实体修改数据库
	public boolean modifySysModule(SysModuleVo s);
	
	//通过id删除一条数据
	public boolean deleteSysModulebyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertSysModule(SysModuleVo role);
	
	public List<SysModuleVo> getModuleListByParentId(int parentId);
	
	public void moveModule(int id, int flag);

}
