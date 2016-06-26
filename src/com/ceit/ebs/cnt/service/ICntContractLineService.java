package com.ceit.ebs.cnt.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.vo.CntContractLineVo;

/*
 * @author lcy @date : 2014.8.7
 */

public interface ICntContractLineService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo
	public PageInfo<CntContractLineVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public CntContractLineVo getCntContractLinebyId(int id);
	
	//通过实体修改数据库
	public boolean modifyCntContractLine(CntContractLineVo s);
	
	//通过id删除一条数据
	public boolean deleteCntContractLinebyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertCntContractLine(CntContractLineVo role);

}