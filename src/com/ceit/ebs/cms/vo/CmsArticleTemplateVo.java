package com.ceit.ebs.cms.vo;

import com.ceit.ebs.cms.entity.CmsArticleTemplate;

/**
 * CmsArticleTemplate entity. @author MyEclipse Persistence Tools
 */

public class CmsArticleTemplateVo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String templateData;
	private String creUser;
	private String opTime;
	private String isValid;
	private String templateType;
	private String code;
	private Integer parentId;
	private Integer dispIndex;
	
	private String page;
	private String rows;

	// Constructors
	public CmsArticleTemplateVo(CmsArticleTemplate p) {
		this.setId(p.getId());
		this.setName(p.getName());
		this.setTemplateData(p.getTemplateData());
		this.setCreUser(p.getCreUser());
		this.setOpTime(p.getOpTime());
		this.setIsValid(p.getIsValid());
		this.setTemplateType(p.getTemplateType());
		this.setCode(p.getCode());
		this.setParentId(p.getParentId());
		this.setDispIndex(p.getDispIndex());
	}
	
	public CmsArticleTemplate adapterToCmsArticleTemplate(){
		CmsArticleTemplate p = new CmsArticleTemplate();
		p.setId(this.getId());
		p.setName(this.getName());
		p.setTemplateData(this.getTemplateData());
		p.setCreUser(this.getCreUser());
		p.setOpTime(this.getOpTime());
		p.setIsValid(this.getIsValid());
		p.setTemplateType(this.getTemplateType());
		p.setCode(this.getCode());
		p.setParentId(this.getParentId());
		p.setDispIndex(this.getDispIndex());
		return p;
	}
	

	/** default constructor */
	public CmsArticleTemplateVo() {
	}

	/** minimal constructor */
	public CmsArticleTemplateVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public CmsArticleTemplateVo(Integer id, String name, String templateData,
			String creUser, String opTime, String isValid, String templateType,
			String code, Integer parentId, Integer dispIndex) {
		this.id = id;
		this.name = name;
		this.templateData = templateData;
		this.creUser = creUser;
		this.opTime = opTime;
		this.isValid = isValid;
		this.templateType = templateType;
		this.code = code;
		this.parentId = parentId;
		this.dispIndex = dispIndex;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplateData() {
		return this.templateData;
	}

	public void setTemplateData(String templateData) {
		this.templateData = templateData;
	}

	public String getCreUser() {
		return this.creUser;
	}

	public void setCreUser(String creUser) {
		this.creUser = creUser;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getTemplateType() {
		return this.templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
	

}