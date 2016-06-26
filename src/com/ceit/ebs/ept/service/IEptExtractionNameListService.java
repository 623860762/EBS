package com.ceit.ebs.ept.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptExtractionNameList;
import com.ceit.ebs.ept.vo.EptExpertBaseinfoVo;
import com.ceit.ebs.ept.vo.EptExtractionNameListVo;

/**
 * EptExtractionNameList entity. @author MyEclipse Persistence Tools
 */

public interface IEptExtractionNameListService{

	public Integer getCount();
	public PageInfo<EptExtractionNameListVo> querydata(int pageindex, int pagesize);
	
	public EptExtractionNameList getEptExtractionNameListbyId(int id);
	
	public boolean modifyEptExtractionNameList(EptExtractionNameListVo s);
	
	public boolean deleteEptExtractionNameListbyId(Integer id);
	
	public Integer insertEptExtractionNameList(EptExtractionNameListVo role);
	/**
	 * 
	 * @Title: getExpertIdsByProjectId
	 * @Description: 项目抽取的专家
	 * @param @param projectId
	 * @param @param currentPageNumber
	 * @param @param perPageCount
	 * @param @return    
	 * @return PageInfo<EptExpertBaseinfoVo> 
	 * @author ly
	 * @date 2014-8-18 下午09:17:02
	 * @throws
	 */
	public PageInfo<EptExpertBaseinfoVo>  getExpertIdsByProjectId(Integer projectId, Integer currentPageNumber, Integer perPageCount);
	/**
	 * 
	 * @Title: countExpertIdsByProjectId
	 * @Description: 项目抽取的专家的数目
	 * @param @param projectId
	 * @param @return    
	 * @return Integer    
	 * @throws
	 */
	public Integer countExpertIdsByProjectId(Integer projectId);
}