package com.ceit.ebs.sys.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.vo.SysRoleResourceVo;

/**
 *@author gr
 *@date 2014-8-7 下午03:22:10
 */

public interface ISysRoleResourceService {

	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo
	public PageInfo<SysRoleResourceVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public SysRoleResourceVo getSysRoleResourcebyId(int id);
	
	//通过实体修改数据库
	public boolean modifySysRoleResource(SysRoleResourceVo s);
	
	//通过id删除一条数据
	public boolean deleteSysRoleResourcebyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertSysRoleResource(SysRoleResourceVo role);

}