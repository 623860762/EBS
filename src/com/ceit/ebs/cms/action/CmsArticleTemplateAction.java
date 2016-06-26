package com.ceit.ebs.cms.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.util.PageInfo;
import com.ceit.common.util.StringUtil;
import com.ceit.ebs.cms.service.ICmsArticleService;
import com.ceit.ebs.cms.service.ICmsArticleTemplateService;
import com.ceit.ebs.cms.vo.CmsArticleTemplateVo;
import com.ceit.ebs.cms.vo.CmsArticleVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * MdMaterial entity. @author MyEclipse Persistence Tools
 */

public class CmsArticleTemplateAction extends ActionSupport implements ModelDriven {

	private static final long serialVersionUID = 3492389124540118101L;
	static Log log=LogFactory.getLog(CmsArticleTemplateAction.class);
	private JSONArray ebsJsonArray;
	private JSONObject ebsJsonObj;
	private CmsArticleTemplateVo cmsArticleTemplateVo;
	private ICmsArticleTemplateService cmsArticleTemplateService;
	
	/*
	 * cmsArticleTemplateIds数组[1,2,3]
	 */
	private String cmsArticleTemplateIds;

	

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
	

	public CmsArticleTemplateVo getCmsArticleTemplateVo() {
		return cmsArticleTemplateVo;
	}
	public void setCmsArticleTemplateVo(CmsArticleTemplateVo cmsArticleTemplateVo) {
		this.cmsArticleTemplateVo = cmsArticleTemplateVo;
	}
	public ICmsArticleTemplateService getCmsArticleTemplateService() {
		return cmsArticleTemplateService;
	}
	public void setCmsArticleTemplateService(
			ICmsArticleTemplateService cmsArticleTemplateService) {
		this.cmsArticleTemplateService = cmsArticleTemplateService;
	}
	
	public String getCmsArticleTemplateIds() {
		return cmsArticleTemplateIds;
	}
	public void setCmsArticleTemplateIds(String cmsArticleTemplateIds) {
		this.cmsArticleTemplateIds = cmsArticleTemplateIds;
	}
	/*
 * 通过templateType项目id获取公告列表
 */
	public String getArticleTemplateList(){
		try {
//			cmsArticleTemplateVo.setTemplateType("澄清公告");
			if(cmsArticleTemplateVo.getTemplateType() != null && !("".equals(cmsArticleTemplateVo.getTemplateType()))){
				PageInfo<CmsArticleTemplateVo> pageInfo = cmsArticleTemplateService.getCmsArticleTemplatebyTemplateType(Integer.parseInt(cmsArticleTemplateVo.getPage()),Integer.parseInt(cmsArticleTemplateVo.getRows()),cmsArticleTemplateVo.getTemplateType());
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
	public String persistArticleTemplate(){
		try {
			cmsArticleTemplateVo.setTemplateData(StringUtil.strFilterHttptoNull(cmsArticleTemplateVo.getTemplateData()));
			Integer reid = cmsArticleTemplateService.insertCmsArticleTemplate(cmsArticleTemplateVo);
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
	public String delArticleTemplatesByIds(){
		try {
			if (cmsArticleTemplateService.delObjsByIds(cmsArticleTemplateIds)) {
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
	public String mergeArticleTemplate(){
		try {
			cmsArticleTemplateVo.setTemplateData(StringUtil.strFilterHttptoNull(cmsArticleTemplateVo.getTemplateData()));
			if (cmsArticleTemplateService.modifyCmsArticleTemplate(cmsArticleTemplateVo)) {
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
	public String editArticleTemplatePage(){
		try {
			if(cmsArticleTemplateVo.getId() != null && !("".equals(cmsArticleTemplateVo.getId()))){
				cmsArticleTemplateVo = cmsArticleTemplateService.getCmsArticleTemplatebyId(cmsArticleTemplateVo.getId());
			}
		} catch (Exception e) {
			log.info("获取公告VO异常!");
		}
		return "editArticleTemplatePage";
	}
	
	public Object getModel() {
		if(cmsArticleTemplateVo == null){
	    	   cmsArticleTemplateVo = new CmsArticleTemplateVo();
	       }
	       return cmsArticleTemplateVo;
	}
	
	/*
	 * 跳转到查询公告页面
	 */
	public String viewArticleTemplatePage(){
		try {
			if(cmsArticleTemplateVo.getId() != null && !("".equals(cmsArticleTemplateVo.getId()))){
				cmsArticleTemplateVo = cmsArticleTemplateService.getCmsArticleTemplatebyId(cmsArticleTemplateVo.getId());
			}
		} catch (Exception e) {
			log.info("获取公告VO异常!");
		}
		return "viewArticleTemplatePage";
	}

}