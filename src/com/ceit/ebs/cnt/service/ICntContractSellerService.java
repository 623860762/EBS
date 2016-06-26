package com.ceit.ebs.cnt.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.vo.CntContractSellerVo;

/*
 * @author lcy date : 2014.8.7
 */

public interface ICntContractSellerService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo	
	public PageInfo<CntContractSellerVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public CntContractSellerVo getCntContractSellerbyId(int id);
	
	//通过id获得实体
	public boolean modifyCntContractSeller(CntContractSellerVo s);
	
	//通过id删除一条数据
	public boolean deleteCntContractSellerbyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertCntContractSeller(CntContractSellerVo role);

}