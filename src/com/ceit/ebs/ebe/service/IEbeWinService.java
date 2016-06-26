package com.ceit.ebs.ebe.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.entity.EbeWin;
import com.ceit.ebs.ebe.vo.EbeWinVo;
/**
 * IEbeWinService 是为系统的定标构件提供服务的接口
 * @author czg
 * date 2014-8-7
 */
public interface IEbeWinService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<EbeWinVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public EbeWinVo getEbeWinbyId(Integer ebeWinId);
	
	//通过Vo修改数据库
	public boolean modifyEbeWin(EbeWinVo ebeWinVo);
	
	//通过ID删除一条数据
	public boolean deleteEbeWinbyId(Integer ebeWinId);
	
	//以Vo作为参数插入一条数据
	public Integer insertEbeWin(EbeWinVo ebeWinVo);
	
	public void setEbeWin(EbeWin ebeWin);
	
	public void setTableDao(ITableDao tableDao);
}
