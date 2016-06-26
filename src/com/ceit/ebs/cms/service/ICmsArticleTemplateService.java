package com.ceit.ebs.cms.service;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cms.vo.CmsArticleTemplateVo;
import com.ceit.ebs.cms.vo.CmsArticleVo;

/**
 * MdUnit entity. @author MyEclipse Persistence Tools
 * @author lcy
 * @version 2014.8.19
 */
public interface ICmsArticleTemplateService {
		//获得数据的条数
		public Integer getCount();
		
		//通过页数和页面大小获得vo
		public PageInfo<CmsArticleTemplateVo> querydata(int pageindex, int pagesize);
		
		//通过id获得实体
		public CmsArticleTemplateVo getCmsArticleTemplatebyId(Integer id);
		
		//通过实体修改数据库
		public boolean modifyCmsArticleTemplate(CmsArticleTemplateVo s);
		
		//通过id删除一条数据
		public boolean deleteCmsArticleTemplatebyId(Integer id);
		
		//以Vo作为参数插入一条数据
		public Integer insertCmsArticleTemplate(CmsArticleTemplateVo role);
		
		//根据项目id(projectId)查看属性列表
		public PageInfo<CmsArticleTemplateVo> getCmsArticleTemplatebyTemplateType(int pageindex, int pagesize,String templateType);
		
		//根据多个id删除对应数据
		public boolean delObjsByIds(String ids);
}
