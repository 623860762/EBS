package com.ceit.ebs.ebe.service;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.entity.EbeScoreBaisis;
import com.ceit.ebs.ebe.vo.EbeScoreBaisisVo;
/**
 * IEbeScoreBaisisService 是为系统的打分依据构件提供服务的接口
 * @author czg
 * date 2014-8-7
 */
public interface IEbeScoreBaisisService {
	
	//获得数据的条数
	public Integer getCount();
	
	//通过页数和页面大小获得Vo
	public PageInfo<EbeScoreBaisisVo> querydata(int pageindex, int pagesize);
	
	//通过ID获得Vo
	public EbeScoreBaisisVo getEbeScoreBaisisbyId(Integer ebeScoreBaisisId);
	
	//通过Vo修改数据库
	public boolean modifyEbeScoreBaisis(EbeScoreBaisisVo ebeScoreBaisisVo);
	
	//通过ID删除一条数据
	public boolean deleteEbeScoreBaisisbyId(Integer ebeScoreBaisisId);
	
	//以Vo作为参数插入一条数据
	public Integer insertEbeScoreBaisis(EbeScoreBaisisVo ebeScoreBaisisVo);
	
	public void setEbeScoreBaisis(EbeScoreBaisis ebeScoreBaisis);
	
	public void setTableDao(ITableDao tableDao);
}
