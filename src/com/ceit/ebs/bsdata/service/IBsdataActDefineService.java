package com.ceit.ebs.bsdata.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.bsdata.entity.BsdataActDefine;
import com.ceit.ebs.bsdata.vo.BsdataActDefineVo;
/**
 * IEbeWinService
 * @author czg
 * date 2014-8-10
 */
public interface IBsdataActDefineService {
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<BsdataActDefineVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public BsdataActDefineVo getBsdataActDefinebyId(Integer bsdataActDefineId);
	
	//通过Vo修改数据库
	public boolean modifyBsdataActDefine(BsdataActDefineVo bsdataActDefineVo);
	
	//通过ID删除一条数据
	public boolean deleteBsdataActDefinebyId(Integer bsdataActDefineId);
	
	//以Vo作为参数插入一条数据
	public Integer insertBsdataActDefine(BsdataActDefineVo bsdataActDefineVo);
	
	public void setBsdataActDefine(BsdataActDefine bsdataActDefine);
	
	public void setTableDao(ITableDao iTableDao);
}
