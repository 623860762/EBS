package com.ceit.ebs.md.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.md.entity.MdCategory;
import com.ceit.ebs.md.vo.MdCategoryVo;

/**
 * MdCategory entity. @author MyEclipse Persistence Tools
 * @author lcy
 * @version 2014.8.16
 */
public interface IMdCategoryService {

	//获得数据的条数
		public Integer getCount();
		
		//通过页数和页面大小获得vo
		public PageInfo<MdCategoryVo> querydata(int pageindex, int pagesize);
		
		//通过id获得实体
		public MdCategoryVo getMdCategorybyId(Integer id);
		
		//通过实体修改数据库
		public boolean modifyMdCategory(MdCategoryVo s);
		
		//通过id删除一条数据
		public boolean deleteMdCategorybyId(Integer id);
		
		//以Vo作为参数插入一条数据
		public Integer insertMdCategory(MdCategoryVo mdCategoryVo);
		
		//根据父节点id查询其子节点的数量
		public Integer getListSizeByParentId(Integer parentId);
		
		//根据父节点id查询其子节点数据
		public List getListByParentId(Integer parentId);
		
		//根据父节点id分页显示其子节点
		public PageInfo<MdCategoryVo> getObjList(int pageindex, int pagesize, Integer parentId);
		
		//根据多个id删除对应数据
		public boolean delObjsByIds(String mdCategoryIds);
		
		//增加同级分类
		public Integer insertByParentId(Integer CategoryId,MdCategoryVo mdCategoryVo);
		
		//增加子级分类
		public Integer insertChildById(Integer CategoryId,MdCategoryVo mdCategoryVo);
		
		//根据id获取父节点
		public Integer getParentIdbyId(Integer id);
		
		//根据code获得分类
		public List<MdCategoryVo> getMdCategorybyCode(String mdCategoryCode);


}
