package com.ceit.ebs.cnt.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.vo.CntContractPurchaserVo;

/*
 * @author lcy date : 2014.8.7
 */

public interface ICntContractPurchaserService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo
	public PageInfo<CntContractPurchaserVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public CntContractPurchaserVo getCntContractPurchaserbyId(int id);
	
	//通过实体修改数据库
	public boolean modifyCntContractPurchaser(CntContractPurchaserVo s);
	
	//通过id删除一条数据
	public boolean deleteCntContractPurchaserbyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertCntContractPurchaser(CntContractPurchaserVo role);

}