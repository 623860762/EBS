package com.ceit.ebs.md.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.md.vo.MdFeatVo;

/**
 * MdFeat entity. @author MyEclipse Persistence Tools
 * @author hgl
 * @version 2014.8.11
 */
public interface IMdFeatService {
		//获得数据的条数
		public Integer getCount();
		
		//通过页数和页面大小获得vo
		public PageInfo<MdFeatVo> querydata(int pageindex, int pagesize);
		
		//通过id获得实体
		public MdFeatVo getMdFeatbyId(Integer id);
		
		//通过实体修改数据库
		public boolean modifyMdFeat(MdFeatVo s);
		
		//通过id删除一条数据
		public boolean deleteMdFeatbyId(Integer id);
		
		//以Vo作为参数插入一条数据
		public Integer insertMdFeat(MdFeatVo role);
		
		//根据分类Id(CategoryId)查看属性列表
		public PageInfo<MdFeatVo> getMdFeatbyCategoryId(int pageindex, int pagesize,Integer mdCategoryId);
		
		public Integer getListSizeByCategoryId(Integer categoryId);
		
		//根据多个id删除对应数据
		public boolean delObjsByIds(String mdFeatIds);
		
		//获取所有属性列表
		public List<MdFeatVo> getListByCategoryId(Integer categoryId);
}
