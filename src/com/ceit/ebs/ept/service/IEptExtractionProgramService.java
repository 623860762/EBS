package com.ceit.ebs.ept.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptExtractionProgram;
import com.ceit.ebs.ept.vo.EptExtractionProgramVo;


public interface IEptExtractionProgramService{

	public Integer getCount();
	public PageInfo<EptExtractionProgramVo> querydata(int pageindex, int pagesize);
	
	public EptExtractionProgram getEptExtractionProgrambyId(int id);
	
	public boolean modifyEptExtractionProgram(EptExtractionProgramVo s);
	
	public boolean deleteEptExtractionProgrambyId(Integer id);
	
	public Integer insertEptExtractionProgram(EptExtractionProgramVo role);
	
	/**
	 * 
	 * @Title: getProgramByProjectId
	 * @Description: 项目下抽取方案分页
	 * @param @param projectId
	 * @param @param currentPageNumber
	 * @param @param perPageCount
	 * @param @return    
	 * @return PageInfo<EptExtractionProgramVo> 
	 * @author ly
	 * @date 2014-8-22 下午04:14:35
	 * @throws
	 */
	public PageInfo<EptExtractionProgramVo>  getProgramByProjectId(Integer projectId, Integer currentPageNumber, Integer perPageCount);
	/**
	 * 
	 * @Title: countProgramByProjectId
	 * @Description: 项目下抽取方案的数目
	 * @param @param projectId
	 * @param @return    
	 * @return Integer 
	 * @author ly
	 * @date 2014-8-22 下午03:36:12
	 * @throws
	 */
	public Integer countProgramByProjectId(Integer projectId);
	/**
	 * 
	 * @Title: autoExtractExpert
	 * @Description: 自动抽取专家
	 * @param extractionProgramId    
	 * @return void    
	 * @throws
	 */
	public boolean autoExtractExpert(Integer extractionProgramId);

}