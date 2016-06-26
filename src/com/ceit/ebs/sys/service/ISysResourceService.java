package com.ceit.ebs.sys.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.vo.SysResourceVo;

/**
 *@author gr
 *@date 2014-8-7 下午03:14:21
 */

public interface ISysResourceService {

	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo
	public PageInfo<SysResourceVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public SysResourceVo getSysResourcebyId(int id);
	
	//通过实体修改数据库
	public boolean modifySysResource(SysResourceVo s);
	
	//通过id删除一条数据
	public boolean deleteSysResourcebyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertSysResource(SysResourceVo role);
	
	public List<SysResourceVo> getResourceListByParentId(int parentId);
	
	public void moveResource(int id, int flag);
}