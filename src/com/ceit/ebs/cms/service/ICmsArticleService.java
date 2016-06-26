package com.ceit.ebs.cms.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cms.vo.CmsArticleVo;
import com.ceit.ebs.md.vo.MdFeatVo;
import com.ceit.ebs.md.vo.MdUnitVo;

/**
 * MdUnit entity. @author MyEclipse Persistence Tools
 * @author lcy
 * @version 2014.8.19
 */
public interface ICmsArticleService {
		//获得数据的条数
		public Integer getCount();
		
		//通过页数和页面大小获得vo
		public PageInfo<CmsArticleVo> querydata(int pageindex, int pagesize);
		
		//通过id获得实体
		public CmsArticleVo getCmsArticlebyId(Integer id);
		
		//通过实体修改数据库
		public boolean modifyCmsArticle(CmsArticleVo s);
		
		//通过id删除一条数据
		public boolean deleteCmsArticlebyId(Integer id);
		
		//以Vo作为参数插入一条数据
		public Integer insertCmsArticle(CmsArticleVo role);
		
		//根据项目id(projectId)查看属性列表
		public PageInfo<CmsArticleVo> getCmsArticlebyProjectId(int pageindex, int pagesize,Integer projectId);
		
		//根据多个id删除对应数据
		public boolean delObjsByIds(String ids);
}
