package com.ceit.ebs.ebe.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.vo.EbeFileClrfyVo;

/*
 * @author lcy date : 2014.8.7
 */

public interface IEbeFileClrfyService {

	//获得数据的条数
	public Integer getCount();

	//通过页数和页面大小获得vo
	public PageInfo<EbeFileClrfyVo> querydata(int pageindex, int pagesize);

	//通过id获得实体
	public EbeFileClrfyVo getEbeFileClrfybyId(int id);

	//通过实体修改数据库
	public boolean modifyEbeFileClrfy(EbeFileClrfyVo s);

	//通过id删除一条数据
	public boolean deleteEbeFileClrfybyId(Integer id);

	//以Vo作为参数插入一条数据
	public Integer insertEbeFileClrfy(EbeFileClrfyVo role);

}
