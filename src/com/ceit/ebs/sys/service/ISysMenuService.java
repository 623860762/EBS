package com.ceit.ebs.sys.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.vo.SysMenuVo;

/**
 *@author gr
 *@date 2014-8-7 下午02:59:51
 */

public interface ISysMenuService {

	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo
	public PageInfo<SysMenuVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public SysMenuVo getSysMenubyId(int id);
	
	//通过实体修改数据库
	public boolean modifySysMenu(SysMenuVo s);
	
	//通过id删除一条数据
	public boolean deleteSysMenubyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertSysMenu(SysMenuVo role);
	
	public List<SysMenuVo> getMenuListByParentId(int parentId);
	
	public void moveMenu(int id, int flag);

}
