package com.ceit.ebs.ept.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptExpertBaseinfo;
import com.ceit.ebs.ept.vo.EptExpertBaseinfoVo;

/**
 * EptExpertBaseinfo entity. @author MyEclipse Persistence Tools
 */

public interface IEptExpertBaseinfoService {

	public Integer getCount();
	public PageInfo<EptExpertBaseinfoVo> querydata(int pageindex, int pagesize);
	
	public EptExpertBaseinfo getEptExpertBaseinfobyId(int id);
	
	public boolean modifyEptExpertBaseinfo(EptExpertBaseinfoVo s);
	
	public boolean deleteEptExpertBaseinfobyId(Integer id);
	
	public Integer insertEptExpertBaseinfo(EptExpertBaseinfoVo role);
}