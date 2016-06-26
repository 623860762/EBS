package com.ceit.ebs.bsdata.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.bsdata.entity.BsdataDict;
import com.ceit.ebs.bsdata.vo.BsdataDictVo;

/**
 * IBsdataDictService 是为系统的基础数据数据字典构件提供服务的接口
 * @author czg
 * date 2014-8-10
 */

public interface IBsdataDictService {
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<BsdataDictVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public BsdataDictVo getBsdataDictbyId(Integer BsdataDictId);
	
	//通过Vo修改数据库
	public boolean modifyBsdataDict(BsdataDictVo bsdataDictVo);
	
	//通过ID删除一条数据
	public boolean deleteBsdataDictbyId(Integer BsdataDictId);
	
	//以Vo作为参数插入一条数据
	public Integer insertBsdataDict(BsdataDictVo bsdataDictVo);
	
	public void setBsdataDict(BsdataDict bsdataDict);
	
	public void setTableDao(ITableDao iTableDao);
}
