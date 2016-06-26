package com.ceit.ebs.sys.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.vo.SysFunctionVo;

/**
 * SysFunction entity. @author MyEclipse Persistence Tools
 * @author gr
 * @version 2014.8.7
 */

public interface ISysFunctionService {

	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo
	public PageInfo<SysFunctionVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public SysFunctionVo getSysFunctionbyId(int id);
	
	//通过实体修改数据库
	public boolean modifySysFunction(SysFunctionVo s);
	
	//通过id删除一条数据
	public boolean deleteSysFunctionbyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertSysFunction(SysFunctionVo role);
	
	public List<SysFunctionVo> getFunctionListByParentId(int parentId);

	public void moveFunction(int id, int flag);
}
