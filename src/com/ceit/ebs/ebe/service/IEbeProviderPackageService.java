package com.ceit.ebs.ebe.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.entity.EbeProviderPackage;
import com.ceit.ebs.ebe.vo.EbeProviderPackageVo;

/**
 * IEbeProviderPackageService 是为系统的评标中包与供应商关系构件提供服务的接口
 * @author czg
 * date 2014-8-7
 */
public interface IEbeProviderPackageService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<EbeProviderPackageVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public EbeProviderPackageVo getEbeProviderPackagebyId(Integer ebeProviderPackageId);
	
	//通过Vo修改数据库
	public boolean modifyEbeProviderPackage(EbeProviderPackageVo ebeProviderPackageVo);
	
	//通过ID删除一条数据
	public boolean deleteEbeProviderPackagebyId(Integer ebeProviderPackageId);
	
	//以Vo作为参数插入一条数据
	public Integer insertEbeProviderPackage(EbeProviderPackageVo ebeProviderPackageVo);
	
	public void setEbeProviderPackage(EbeProviderPackage ebeProviderPackage);
	
	public void setTableDao(ITableDao tableDao);
}
