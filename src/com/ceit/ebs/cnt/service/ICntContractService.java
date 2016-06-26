package com.ceit.ebs.cnt.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.vo.CntContractVo;

/*
 * @author lcy date : 2014.8.7
 */

public interface ICntContractService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得vo
	public PageInfo<CntContractVo> querydata(int pageindex, int pagesize);
	
	//通过id获得实体
	public CntContractVo getCntContractbyId(int id);
	
	//通过实体修改数据库
	public boolean modifyCntContract(CntContractVo s);
	
	//通过id删除一条数据
	public boolean deleteCntContractbyId(Integer id);
	
	//以Vo作为参数插入一条数据
	public Integer insertCntContract(CntContractVo role);

}
