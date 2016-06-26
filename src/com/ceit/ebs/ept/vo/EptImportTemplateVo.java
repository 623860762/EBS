package com.ceit.ebs.ept.vo;

import com.ceit.ebs.ept.entity.EptImportTemplate;


/**
 *@author gr
 *@date 2014-8-10 上午11:03:34
 */

public class EptImportTemplateVo{

	// Fields

	private Integer id;//id
	private String templateName;//名字
	private String templateType;//类型
	private Integer fileId;//关联文件主键
	private String createUser;//创建人
	private Integer createTime;//创建时间
	private String opUser;//更新人
	private String opTime;//更新时间
	private String isValid;//是否有效
	private Integer dispIndex;     //排序索引

	// Constructors

	/** default constructor */
	public EptImportTemplateVo() {
	}

	
	public EptImportTemplateVo(EptImportTemplate p) {
		this.setCreateTime(p.getCreateTime());
		this.setCreateUser(p.getCreateUser());
		this.setFileId(p.getFileId());
		this.setIsValid(p.getIsValid());
		this.setOpTime(p.getOpTime());
		this.setOpUser(p.getOpUser());
		this.setId(p.getId());
		this.setTemplateName(p.getTemplateName());
		this.setTemplateType(p.getTemplateType());
		this.setDispIndex(p.getDispIndex());
	}
	
	public EptImportTemplate adapterToEptImportTemplate(){
		EptImportTemplate p = new EptImportTemplate();
		p.setCreateTime(this.getCreateTime());
		p.setCreateUser(this.getCreateUser());
		p.setFileId(this.getFileId());
		p.setIsValid(this.getIsValid());
		p.setOpTime(this.getOpTime());
		p.setOpUser(this.getOpUser());
		p.setId(this.getId());
		p.setTemplateName(this.getTemplateName());
		p.setTemplateType(this.getTemplateType());
		p.setDispIndex(this.getDispIndex());
		return p;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateType() {
		return this.templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public Integer getFileId() {
		return this.fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public String getOpUser() {
		return this.opUser;
	}

	public void setOpUser(String opUser) {
		this.opUser = opUser;
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
	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}