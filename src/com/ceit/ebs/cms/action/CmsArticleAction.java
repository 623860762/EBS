package com.ceit.ebs.cms.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.util.PageInfo;
import com.ceit.common.util.StringUtil;
import com.ceit.ebs.cms.service.ICmsArticleService;
import com.ceit.ebs.cms.vo.CmsArticleVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * MdMaterial entity. @author MyEclipse Persistence Tools
 */

public class CmsArticleAction extends ActionSupport implements ModelDriven {

	private static final long serialVersionUID = 3492389124540118101L;
	static Log log=LogFactory.getLog(CmsArticleAction.class);
	private JSONArray ebsJsonArray;
	private JSONObject ebsJsonObj;
	private CmsArticleVo cmsArticleVo;
	private ICmsArticleService cmsArticleService;
	
	/*
	 * featId数组[1,2,3]
	 */
	private String articleIds;

	

	public JSONArray getEbsJsonArray() {
		return ebsJsonArray;
	}
	public void setEbsJsonArray(JSONArray ebsJsonArray) {
		this.ebsJsonArray = ebsJsonArray;
	}
	public JSONObject getEbsJsonObj() {
		return ebsJsonObj;
	}
	public void setEbsJsonObj(JSONObject ebsJsonObj) {
		this.ebsJsonObj = ebsJsonObj;
	}
	public CmsArticleVo getCmsArticleVo() {
		return cmsArticleVo;
	}
	public void setCmsArticleVo(CmsArticleVo cmsArticleVo) {
		this.cmsArticleVo = cmsArticleVo;
	}
	public ICmsArticleService getCmsArticleService() {
		return cmsArticleService;
	}
	public void setCmsArticleService(ICmsArticleService cmsArticleService) {
		this.cmsArticleService = cmsArticleService;
	}


public String getArticleIds() {
		return articleIds;
	}
	public void setArticleIds(String articleIds) {
		this.articleIds = articleIds;
	}
	/*
 * 通过projectId项目id获取公告列表
 */
	public String getArticleList(){
		try {
			cmsArticleVo.setProjectId(321);
			if(cmsArticleVo.getProjectId() != null && !("".equals(cmsArticleVo.getProjectId()))){
				PageInfo<CmsArticleVo> pageInfo = cmsArticleService.getCmsArticlebyProjectId(Integer.parseInt(cmsArticleVo.getPage()),Integer.parseInt(cmsArticleVo.getRows()),cmsArticleVo.getProjectId());
				ebsJsonObj = JSONObject.fromObject(pageInfo.getContentJSon());
			}else{
				log.info("项目ID传入异常!");
			}
		} catch (Exception e) {
			log.info("获取公告列表失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
/*
 * 通过分类ID新增属性	
 */
	public String persistArticle(){
		try {
			cmsArticleVo.setRemark(StringUtil.strFilterHttptoNull(cmsArticleVo.getRemark()));
			Integer reid = cmsArticleService.insertCmsArticle(cmsArticleVo);
			if (reid > 0) {
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			} else {
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}
		} catch (Exception e) {
			log.info("新增公告失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
/*
 * 通过多个id删除公告
 */
	public String delArticlesByIds(){
		try {
			if (cmsArticleService.delObjsByIds(articleIds)) {
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			} else {
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}
		} catch (Exception e) {
			log.info("删除公告失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/*
	 * 通过属性ID修改属性内容
	 */
	public String mergeArticle(){
		try {
			cmsArticleVo.setRemark(StringUtil.strFilterHttptoNull(cmsArticleVo.getRemark()));
			if (cmsArticleService.modifyCmsArticle(cmsArticleVo)) {
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			} else {
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}
		} catch (Exception e) {
			log.info("修改公告失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/*
	 * 跳转到修改公告页面
	 */
	public String editArticlePage(){
		try {
			if(cmsArticleVo.getId() != null && !("".equals(cmsArticleVo.getId()))){
				cmsArticleVo = cmsArticleService.getCmsArticlebyId(cmsArticleVo.getId());
			}
		} catch (Exception e) {
			log.info("获取公告VO异常!");
		}
		return "editArticlePage";
	}
	
	public Object getModel() {
		if(cmsArticleVo == null){
	    	   cmsArticleVo = new CmsArticleVo();
	       }
	       return cmsArticleVo;
	}
	
	/*
	 * 跳转到查询公告页面
	 */
	public String viewArticlePage(){
		try {
			if(cmsArticleVo.getId() != null && !("".equals(cmsArticleVo.getId()))){
				cmsArticleVo = cmsArticleService.getCmsArticlebyId(cmsArticleVo.getId());
			}
		} catch (Exception e) {
			log.info("获取公告VO异常!");
		}
		return "viewArticlePage";
	}

}