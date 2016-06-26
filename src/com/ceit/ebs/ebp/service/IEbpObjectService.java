package com.ceit.ebs.ebp.service;

import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.entity.EbpObject;
import com.ceit.ebs.ebp.vo.EbpObjectVo;
/**
 *@author gr
 *@date 2014-8-14 上午09:36:15
 */

public interface IEbpObjectService {
	
	/*
	 * @param projectId 项目id
	 * @param num 分标的个数
	 * divideObject: 根据项目号，把项目分成相应数目的标
	 */
	public boolean divideObject(Integer projectId, Integer num);
	
	//获得数据的条数
	public Integer getCount();
	
	//批量删除分标记录
	public boolean deleteEbpObjectBatch(String objectId);
	
	//通过页数和页面大小获得Vo
	public PageInfo<EbpObjectVo> queryData(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public EbpObjectVo getEbpObjectbyId(Integer ebpObjectId);
	
	//通过Vo修改数据库
	public boolean modifyEbpObject(EbpObjectVo ebpObjectVo);
	
	//通过ID删除一条数据
	public boolean deleteEbpObjectbyId(Integer ebpObjectId);
	
	//以Vo作为参数插入一条数据
	public Integer insertEbpObject(EbpObjectVo ebpObjectVo);
	
	public void setEbpObject(EbpObject ebpObject);
	
	public void setTableDao(ITableDao tableDao);
	/**
	 * 根据项目id获取分标信息
	 * @param ebpProjectId
	 * @param currentPageNumber
	 * @param perPageCount
	 * @return
	 */
	public PageInfo<EbpObjectVo> getEbpObjectbyProjectId(Integer ebpProjectId, Integer currentPageNumber, Integer perPageCount);
	/**
	 * 用于树结构，查找项目id下的所有分标，供树形结构展示
	 * @param ebpProjectId
	 * @return
	 */
	public List<EbpObjectVo> getEbpObjectListbyProjectId(Integer ebpProjectId);
}
