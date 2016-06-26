package com.ceit.ebs.sup.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sup.entity.SupSupplier;
import com.ceit.ebs.sup.vo.SupSupplierVo;

/**
 * ISupSupplierService 是为系统的供应商基本信息提供服务的接口
 * @author czg
 * date 2014-8-15
 */
public interface ISupSupplierService {
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<SupSupplierVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public SupSupplierVo getSupSupplierbyId(Integer supSupplierId);
	
	//通过Vo修改数据库
	public boolean modifySupSupplier(SupSupplierVo supSupplierVo);
	
	//通过ID删除一条数据
	public boolean deleteSupSupplierbyId(Integer supSupplierId);
	
	//以Vo作为参数插入一条数据
	public Integer insertSupSupplier(SupSupplierVo supSupplierVo);
	
	//审核不通过
	public Boolean failAudit(Integer supId);
	
	//审核通过
	public Boolean passAudit(Integer supId);
	
	public void setSupSupplier(SupSupplier supSupplier);
	
	public void setTableDao(ITableDao tableDao);
}
