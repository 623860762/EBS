package com.ceit.ebs.ept.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptRepealTemplate;
import com.ceit.ebs.ept.vo.EptRepealTemplateVo;


public interface IEptRepealTemplateService {

	
	public Integer getCount();
	public PageInfo<EptRepealTemplateVo> querydata(int pageindex, int pagesize);
	
	public EptRepealTemplate getEptRepealTemplatebyId(int id);
	
	public boolean modifyEptRepealTemplate(EptRepealTemplateVo sv);
	
	public boolean deleteEptRepealTemplatebyId(Integer id);
	
	public Integer insertEptRepealTemplate(EptRepealTemplateVo role);
}