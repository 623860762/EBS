package com.ceit.ebs.sys.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sys.vo.SysOrganVo;



/**
 *@author gr
 *@date 2014-8-7 下午03:10:27
 */

public interface ISysOrganService {

	//通过页数和页面大小获得vo
	public PageInfo<SysOrganVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public SysOrganVo getSysOrganbyId(int id);
	
	//通过id删除一条数据
	public boolean deleteSysOrganbyId(int id);
	
	//通过实体修改数据库
	public boolean modifySysOrgan(SysOrganVo so);
	
	//获得数据的条数
	public Integer getCount();
	
	//以Vo作为参数插入一条数据
	public Integer insertSysOrgan(SysOrganVo sysOrganVo);
	
	public List<SysOrganVo> getOrganListByParentId(int parentId);
	
	public void moveOrgan(int id, int flag);
	
}