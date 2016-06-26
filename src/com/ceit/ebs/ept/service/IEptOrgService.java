package com.ceit.ebs.ept.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptOrg;
import com.ceit.ebs.ept.vo.EptOrgVo;


public interface IEptOrgService {

	public Integer getCount();
	public PageInfo<EptOrgVo> querydata(int pageindex, int pagesize);
	
	public EptOrgVo getEptOrgbyId(int id);
	
	public List<EptOrg> getEptOrgbyParentId(int id);
	
	public boolean modifyEptOrg(EptOrgVo sv);
	
	public boolean deleteEptOrgbyId(Integer id);
	
	public Integer insertEptOrg(EptOrgVo role);
	/**
	 * 
	 * @Title: moveMenu
	 * @Description: 根据flag移动节点
	 * @param @param id
	 * @param @param flag    
	 * @return void 
	 * @author ly
	 * @date 2014-8-21 下午03:50:00
	 * @throws
	 */
	public void moveMenu(int id, int flag) ;
	/**
	 * 
	 * @Title: getOrgListByParentId
	 * @Description: 获取以此ID为ParentId的字节点
	 * @param @param parentId
	 * @param @return    
	 * @return List<EptOrgVo> 
	 * @author ly
	 * @date 2014-8-21 下午03:50:20
	 * @throws
	 */
	public List<EptOrgVo> getOrgListByParentId(int parentId);

}