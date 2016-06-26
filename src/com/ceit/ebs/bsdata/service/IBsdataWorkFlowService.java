package com.ceit.ebs.bsdata.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.bsdata.entity.BsdataWorkFlow;
import com.ceit.ebs.bsdata.vo.BsdataWorkFlowVo;

/**
 * IBsdataDictService 是为系统的基础数据数据字典构件提供服务的接口
 * @author czg
 * date 2014-8-10
 */

public interface IBsdataWorkFlowService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<BsdataWorkFlowVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public BsdataWorkFlowVo getBsdataWorkFlowbyId(Integer bsdataSerialNumberId);
	
	//通过Vo修改数据库
	public boolean modifyBsdataWorkFlow(BsdataWorkFlowVo bsdataSerialNumberVo);
	
	//通过ID删除一条数据
	public boolean deleteBsdataWorkFlowbyId(Integer bsdataSerialNumberVoId);
	
	//以Vo作为参数插入一条数据
	public Integer insertBsdataWorkFlow(BsdataWorkFlowVo sdataSerialNumberVo);
	
	public void setBsdataWorkFlow(BsdataWorkFlow bsdataSerialNumber);
	
	public void setTableDao(ITableDao iTableDao);

}
