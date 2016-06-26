package com.ceit.ebs.md.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.md.vo.MdUnitVo;

/**
 * MdUnit entity. @author MyEclipse Persistence Tools
 * @author hgl
 * @version 2014.8.11
 */
public interface IMdUnitService {
	//获得数据的条数
		public Integer getCount();
		
		//通过页数和页面大小获得vo
		public PageInfo<MdUnitVo> querydata(int pageindex, int pagesize);
		
		//通过id获得实体
		public MdUnitVo getMdUnitbyId(Integer id);
		
		//通过实体修改数据库
		public boolean modifyMdUnit(MdUnitVo s);
		
		//通过id删除一条数据
		public boolean deleteMdUnitbyId(Integer id);
		
		//以Vo作为参数插入一条数据
		public Integer insertMdUnit(MdUnitVo role);
}
