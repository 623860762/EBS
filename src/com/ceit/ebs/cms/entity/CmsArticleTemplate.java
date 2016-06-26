package com.ceit.ebs.cms.entity;

/**
 * CmsArticleTemplate entity. @author lcy 2014/8/19
 */

public class CmsArticleTemplate implements java.io.Serializable {

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

	// Constructors

	/** default constructor */
	public CmsArticleTemplate() {
	}

	/** minimal constructor */
	public CmsArticleTemplate(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public CmsArticleTemplate(Integer id, String name, String templateData,
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

}