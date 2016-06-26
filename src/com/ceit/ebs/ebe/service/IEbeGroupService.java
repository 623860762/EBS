package com.ceit.ebs.ebe.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.vo.EbeExpertGroupVo;
import com.ceit.ebs.ebe.vo.EbeGroupVo;

/*
 * @author lcy date : 2014.8.7
 */

public interface IEbeGroupService {

	//获得数据的条数
	public Integer getCount();

	//通过页数和页面大小获得vo
	public PageInfo<EbeGroupVo> querydata(int pageindex, int pagesize);

	//通过页数、页面大小、项目id获得Vo
	public PageInfo<EbeGroupVo> queryGroupInProject(int pageindex, int pagesize, int projectId);
	
	//通过id获得实体
	public EbeGroupVo getEbeGroupbyId(int id);

	//通过实体修改数据库
	public boolean modifyEbeGroup(EbeGroupVo s);

	//通过id删除一条数据
	public boolean deleteEbeGroupbyId(Integer id);

	//以Vo作为参数插入一条数据
	public Integer insertEbeGroup(EbeGroupVo role);

}
