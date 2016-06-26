package com.ceit.ebs.ebe.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.entity.EbePackageInfo;
import com.ceit.ebs.ebe.vo.EbePackageInfoVo;
/**
 * IEbePackageInfoService 是为系统的评审产品构件提供服务的接口
 * @author czg
 * date 2014-8-7
 */

public interface IEbePackageInfoService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<EbePackageInfoVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public EbePackageInfoVo getEbePackageInfobyId(Integer ebePackageInfoId);
	
	//通过Vo修改数据库
	public boolean modifyEbePackageInfo(EbePackageInfoVo ebePackageInfoVo);
	
	//通过ID删除一条数据
	public boolean deleteEbePackageInfobyId(Integer ebePackageInfoId);
	
	//以Vo作为参数插入一条数据
	public Integer insertEbePackageInfo(EbePackageInfoVo ebePackageInfoVo);
	
	public void setEbePackageInfo(EbePackageInfo ebePackageInfo);
	
	public void setTableDao(ITableDao tableDao);

}
