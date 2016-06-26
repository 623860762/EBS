package com.ceit.ebs.ebp.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.vo.EbpProjectVo;

public interface IEbpProjectService{
	/**
	 * 获得项目的总数目
	 * @return
	 */
	public Integer getCount();
	/**
	 * 根据页数和每页显示数目查询数据
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	public PageInfo<EbpProjectVo> querydata(int pageindex, int pagesize);
	/**
	 * 根据id获取项目vo
	 * @param id
	 * @return
	 */
	public EbpProjectVo getEbpProjectbyId(int id);
	/**
	 * 修改项目
	 * @param s
	 * @return
	 */
	public boolean modifyEbpProject(EbpProjectVo s);
	/**
	 * 根据id删除一条项目记录
	 * @param id
	 * @return
	 */
	public boolean deleteEbpProjectbyId(Integer id);
	
	//手动截标
	public Boolean closeBidByHand(Integer projectId);
	
	//开标
	public Boolean openProBid(Integer projectId);
	
	//唱标
	public Boolean singBid(Integer projectId);
	/**
	 * 进行状态跳转操作
	 * @param projectId
	 * @param bigStatus
	 * @param smallStatus
	 * @return
	 */
	public boolean statusTransformed(Integer projectId, String bigStatus, String smallStatus);
	/**
	 * 插入一条项目
	 * @param role
	 * @return
	 */
	public Integer insertEbpProject(EbpProjectVo role);
	/**
	 * 通过是否分标过滤项目
	 * @param isObject
	 * @param currentPageNumber
	 * @param perPageCount
	 * @return
	 */
	public PageInfo<EbpProjectVo> getEbpProjectVobyIsObject(String isObject, Integer currentPageNumber, Integer perPageCount);
	/**
	 * 通过状态过滤项目
	 * @param bigstatus
	 * @param smallstatus
	 * @param currentPageNumber
	 * @param perPageCount
	 * @return
	 */
	public PageInfo<EbpProjectVo> getEbpProjectVobyStatus(String bigstatus, String smallstatus, Integer currentPageNumber, Integer perPageCount);
	/**
	 *获取审核状态下的所有数据
	 * @param currentPageNumber
	 * @param perPageCount
	 * @return
	 */
	public PageInfo<EbpProjectVo> getSHEbpProjectVo(Integer currentPageNumber, Integer perPageCount);
	/**
	 * 重立项操作
	 */
	public boolean returnToLXProject(Integer projectid);
}