package com.ceit.ebs.ept.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptMessageSupplier;
import com.ceit.ebs.ept.vo.EptMessageSupplierVo;

/**
 * EptMessageSupplier entity. @author MyEclipse Persistence Tools
 */

public interface IEptMessageSupplierService {

	public Integer getCount();
	public PageInfo<EptMessageSupplierVo> querydata(int pageindex, int pagesize);
	
	public EptMessageSupplier getEptMessageSupplierbyId(int id);
	
	public boolean modifyEptMessageSupplier(EptMessageSupplierVo sv);
	
	public boolean deleteEptMessageSupplierbyId(Integer id);
	
	public Integer insertEptMessageSupplier(EptMessageSupplierVo role);
}