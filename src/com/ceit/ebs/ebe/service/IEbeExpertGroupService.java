package com.ceit.ebs.ebe.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.entity.EbeExpertGroup;
import com.ceit.ebs.ebe.vo.EbeExpertGroupVo;
import com.ceit.ebs.ebe.vo.EbeGroupPackageVo;
import com.ceit.ebs.ept.vo.EptExpertBaseinfoVo;

/*
 * @author lcy date : 2014.8.7
 */

public interface IEbeExpertGroupService {

	//获得数据的条数
	public Integer getCount();

	//通过页数和页面大小获得vo
	public PageInfo<EbeExpertGroupVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public EbeExpertGroupVo getEbeExpertGroupbyId(int id);

	//通过实体修改数据库
	public boolean modifyEbeExpertGroup(EbeExpertGroupVo s);
	
	//通过id删除一条数据
	public boolean deleteEbeExpertGroupbyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertEbeExpertGroup(EbeExpertGroupVo role);

	//查询小组内的专家的详细信息
	public PageInfo<EbeExpertGroupVo> showExpertInGroup(int groupId, int pageindex, int pagesize);
	
	//查询可以加入某类小组的专家详细信息
	public PageInfo<EbeExpertGroupVo> getExpertCouldIntoGroup(String groupType, int pageindex, int pagesize);
	
	//组下关联一批包
	public Boolean expertIntoGroup(String myExpertGroupIds,Integer groupId);
}
