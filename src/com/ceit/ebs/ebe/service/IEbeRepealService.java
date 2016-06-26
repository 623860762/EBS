package com.ceit.ebs.ebe.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.entity.EbeRepeal;
import com.ceit.ebs.ebe.vo.EbeRepealVo;
/**
 * IEbeRepealService 是为系统的评标废标构件提供服务的接口
 * @author czg
 * date 2014-8-7
 */
public interface IEbeRepealService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<EbeRepealVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public EbeRepealVo getEbeRepealbyId(Integer ebeRepealId);
	
	//通过Vo修改数据库
	public boolean modifyEbeRepeal(EbeRepealVo ebeRepealVo);
	
	//通过ID删除一条数据
	public boolean deleteEbeRepealbyId(Integer ebeRepealId);
		
	//以Vo作为参数插入一条数据
	public Integer insertEbeRepeal(EbeRepealVo ebeRepealVo);
	
	public void setEbeRepeal(EbeRepeal ebeRepeal);
	
	public void setTableDao(ITableDao tableDao);
}
