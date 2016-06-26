package com.ceit.ebs.ept.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptMessageTemplate;
import com.ceit.ebs.ept.vo.EptMessageTemplateVo;

/**
 * EptMessageTemplate entity. @author MyEclipse Persistence Tools
 */

public interface IEptMessageTemplateService  {

	public Integer getCount();
	public PageInfo<EptMessageTemplateVo> querydata(int pageindex, int pagesize);
	
	public EptMessageTemplate getEptMessageTemplatebyId(int id);
	
	public boolean modifyEptMessageTemplate(EptMessageTemplateVo sv);
	
	public boolean deleteEptMessageTemplatebyId(Integer id);
	
	public Integer insertEptMessageTemplate(EptMessageTemplateVo role);

}