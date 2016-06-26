package com.ceit.ebs.bsdata.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.bsdata.entity.BsdataSerialNumber;
import com.ceit.ebs.bsdata.vo.BsdataSerialNumberVo;
/**
 * IBsdataSerialNumberService 是为系统的流水号构件提供服务的接口
 * @author czg
 * date 2014-8-10
 */
public interface IBsdataSerialNumberService {
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<BsdataSerialNumberVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public BsdataSerialNumberVo getBsdataSerialNumberbyId(Integer bsdataSerialNumberId);
	
	//通过Vo修改数据库
	public boolean modifyBsdataSerialNumber(BsdataSerialNumberVo bsdataSerialNumberVo);
	
	//通过ID删除一条数据
	public boolean deleteBsdataSerialNumberbyId(Integer bsdataSerialNumberVoId);
	
	//以Vo作为参数插入一条数据
	public Integer insertBsdataSerialNumber(BsdataSerialNumberVo sdataSerialNumberVo);
	
	public void setBsdataSerialNumber(BsdataSerialNumber bsdataSerialNumber);
	
	public void setTableDao(ITableDao iTableDao);
}
