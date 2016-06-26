package com.ceit.ebs.sys.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.vo.SysRoleVo;

/**
 *@author gr
 *@date 2014-8-7 下午03:25:30
 */

public interface ISysRoleService{

	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo
	public PageInfo<SysRoleVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public SysRoleVo getSysRolebyId(int id);
	
	//通过实体修改数据库
	public boolean modifySysRole(SysRoleVo s);
	
	//通过id删除一条数据
	public boolean deleteSysRolebyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertSysRole(SysRoleVo role);
	
	public List<SysRoleVo> getRoleListByOrganId(int parentId);
	
	public void moveRole(int id, int flag);

}