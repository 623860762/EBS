package com.ceit.ebs.ebp.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.vo.EbpClearVo;

public interface IEbpClearService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<EbpClearVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public EbpClearVo getEbpClearbyId(Integer EbpClearId);
	
	//通过Vo修改数据库
	public boolean modifyEbpClear(EbpClearVo EbpClearVo);
	
	//通过ID删除一条数据
	public boolean deleteEbpClearbyId(Integer EbpClearId);
	
	//以Vo作为参数插入一条数据
	public Integer insertEbpClear(EbpClearVo EbpClearVo);

}
