package com.ceit.ebs.ept.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptImportTemplate;
import com.ceit.ebs.ept.vo.EptImportTemplateVo;


/**
 * EptImportTemplate entity. @author MyEclipse Persistence Tools
 */

public interface IEptImportTemplateService{

	public Integer getCount();
	public PageInfo<EptImportTemplateVo> querydata(int pageindex, int pagesize);
	
	public EptImportTemplate getEptImportTemplatebyId(int id);
	
	public boolean modifyEptImportTemplate(EptImportTemplateVo sv);
	
	public boolean deleteEptImportTemplatebyId(Integer id);
	
	public Integer insertEptImportTemplate(EptImportTemplateVo role);
}