package com.ceit.ebs.sup.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sup.entity.SupSingBid;
import com.ceit.ebs.sup.vo.SupSingBidVo;
/**
 * ISupSingBidService 是为系统的供应商唱标明细提供服务的接口
 * @author czg
 * date 2014-8-15
 */
public interface ISupSingBidService {
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<SupSingBidVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public SupSingBidVo getSupSingBidbyId(Integer supSingBidId);
	
	//通过Vo修改数据库
	public boolean modifySupSingBid(SupSingBidVo supSingBidVo);
	
	//通过ID删除一条数据
	public boolean deleteSupSingBidbyId(Integer supSingBidId);
	
	//以Vo作为参数插入一条数据
	public Integer insertSupSingBid(SupSingBidVo supSingBidVo);
	
	public void setSupSingBid(SupSingBid supSingBid);
	
	public void setTableDao(ITableDao tableDao);
}
