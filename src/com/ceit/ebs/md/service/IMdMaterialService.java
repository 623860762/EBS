package com.ceit.ebs.md.service;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.md.vo.MdCategoryVo;
import com.ceit.ebs.md.vo.MdMaterialVo;

/**
 * MdMaterial entity. @author MyEclipse Persistence Tools
 * @author hgl
 * @version 2014.8.11
 */
public interface IMdMaterialService {
	//获得数据的条数
		public Integer getCount();
		
		//通过页数和页面大小获得vo
		public PageInfo<MdMaterialVo> querydata(int pageindex, int pagesize);
		
		//通过id获得实体
		public MdMaterialVo getMdMaterialbyId(Integer id);
		
		//通过实体修改数据库
		public boolean modifyMdMaterial(MdMaterialVo s);
		
		//通过id删除一条数据
		public boolean deleteMdMaterialbyId(Integer id);
		
		//以Vo作为参数插入一条数据
		public Integer insertMdMaterial(MdMaterialVo role);
		
		//根据分类Id(CategoryId)查看物料
		public PageInfo<MdMaterialVo> getMdMaterialbyCategoryId(int pageindex, int pagesize,Integer mdCategoryId);

		public Integer getListSizeByCategoryId(Integer categoryId);
		
		//根据父节点id分页显示其子节点
		public PageInfo<MdMaterialVo> getObjList(int pageindex, int pagesize, Integer parentId);
		
		//根据父节点id查询其子节点的数量
		public Integer getListSizeByParentId(Integer parentId);
		
		//根据多个id删除对应数据
		public boolean delObjsByIds(String ids);
}
