package com.ceit.ebs.ept.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptSpecialty;
import com.ceit.ebs.ept.vo.EptSpecialtyVo;

/**
 * EptSpecialty entity. @author MyEclipse Persistence Tools
 */

public interface IEptSpecialtyService {

	public Integer getCount();
	public PageInfo<EptSpecialtyVo> querydata(int pageindex, int pagesize);
	
	public EptSpecialtyVo getEptSpecialtybyId(int id);
	
	public List<EptSpecialty> getEptSpecialtybyParentId(int id);
	
	public boolean modifyEptSpecialty(EptSpecialtyVo sv);
	
	public boolean deleteEptSpecialtybyId(Integer id);
	
	public Integer insertEptSpecialty(EptSpecialtyVo role);
	
	/**
	 * 
	 * @Title: getSpecialtyListByParentId
	 * @Description: 获取以此ID为ParentId的字节点
	 * @param @param parentId
	 * @param @return    
	 * @return List<EptSpecialtyVo> 
	 * @author ly
	 * @date 2014-8-19 下午08:42:53
	 * @throws
	 */
	public List<EptSpecialtyVo> getSpecialtyListByParentId(int parentId);
	/**
	 * 
	 * @Title: moveMenu
	 * @Description: 根据flag移动节点
	 * @param @param id
	 * @param @param flag    
	 * @return void 
	 * @author ly
	 * @date 2014-8-21 上午11:28:44
	 * @throws
	 */
	public void moveMenu(int id, int flag) ;
}