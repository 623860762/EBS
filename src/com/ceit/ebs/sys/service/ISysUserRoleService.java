package com.ceit.ebs.sys.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.vo.SysUserRoleVo;

/**
 *@author gr
 *@date 2014-8-7 下午03:32:43
 *
 */

public interface ISysUserRoleService{
	
	//通过页数和页面大小获得vo
	public PageInfo<SysUserRoleVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public SysUserRoleVo getSysUserRolebyId(int id);
	
//	public boolean insertSysUserRole(SysUserRole s);
	
	//通过id删除一条数据
	public boolean deleteSysUserRolebyId(int id);
	
	//通过实体修改数据库
	public boolean modifySysUserRole(SysUserRoleVo s);
	
	//获得数据的条数
	public Integer getCount();
	
	//以Vo作为参数插入一条数据
	public Integer insertSysUserRole(SysUserRoleVo s);
	

}