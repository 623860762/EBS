package com.ceit.ebs.ebe.service;

import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.entity.EbeGroupPackage;
import com.ceit.ebs.ebe.vo.EbeGroupPackageVo;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
/**
 * IEbeGroupPackageService 是为系统的评标小组与包关系构件提供服务的接口
 * @author czg
 * date 2014-8-7
 */
public interface IEbeGroupPackageService {
	
	//获得数据的条数
	public Integer getCount(String sql,Map<String, Object> params);

	//通过页数和页面大小获得Vo
	public PageInfo<EbeGroupPackageVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public EbeGroupPackageVo getEbeGroupPackagebyId(Integer ebeGroupPackageId);
	
	//通过Vo修改数据库
	public boolean modifyEbeGroupPackage(EbeGroupPackageVo ebeGroupPackageVo);
	
	//通过ID删除一条数据
	public boolean deleteEbeGroupPackagebyId(Integer ebeGroupPackageId);
	
	//以Vo作为参数插入一条数据
	public Integer insertEbeGroupPackage(EbeGroupPackageVo ebeGroupPackageVo);
	
	public void setEbeGroupPackage(EbeGroupPackage ebeGroupPackage);
	
	public void setTableDao(ITableDao tableDao);
	
	//查询组内关联的包
	public PageInfo<EbeGroupPackageVo> showGroupPackageList(int groupId, String type, int pageindex, int pagesize);
	
	//查询组内可以关联的包
	public PageInfo<EbeGroupPackageVo> showPackageNotInGroupList(String type, int pageindex, int pagesize);
	
	//初始化组包关系
	public Boolean initGroupPackage(EbpPackageVo epv);
	
	//组下关联包
	public Boolean groupAttachPackage(Integer groupId, String type, String myPackageIds);
	
	//组下取消关联包
	public Boolean removePackageFromGroup(Integer groupId, String type, String myPackageIds);
}

