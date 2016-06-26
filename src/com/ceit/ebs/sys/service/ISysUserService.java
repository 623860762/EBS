package com.ceit.ebs.sys.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.vo.SysUserVo;


/**
 *@author gr
 *@date 2014-8-7 下午03:35:32
 */

public interface ISysUserService {

	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo
	public PageInfo<SysUserVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public SysUserVo getSysUserbyId(int id);
	
	//通过实体修改数据库
	public boolean modifySysUser(SysUserVo s);
	
	//通过id删除一条数据
	public boolean deleteSysUserbyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertSysUser(SysUserVo role);
	
	public List<SysUserVo> getUserListByOrganId(int parentId);
	
	public void moveUser(int id, int flag);

}