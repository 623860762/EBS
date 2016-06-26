package com.ceit.ebs.ept.vo;

import com.ceit.ebs.ept.entity.EptMessageTemplate;

/**
 *@author gr
 *@date 2014-8-10 下午02:39:35
 */

public class EptMessageTemplateVo  {

	// Fields

	private Integer id;//短信模板id
	private String messageTemplateName;//短信模板名称
	private String messageTemplateType;//短信模板类型
	private String messageTemplateContent;//短信模板内容
	private String opUser;//更新者
	private String opTime;//更新时间
	private String isValid;//是否有效
	private Integer fileId;//关联文件主键
	private String createUser;//创建者
	private Integer createTime;//创建时间
	private Integer dispIndex;     //排序索引
//	private Set eptMessageSuppliers = new HashSet(0);

	// Constructors

	/** default constructor */
	public EptMessageTemplateVo() {
	}

		public EptMessageTemplateVo(EptMessageTemplate p) {
		this.setCreateTime(p.getCreateTime());
		this.setCreateUser(p.getCreateUser());
//		this.setEptMessageSuppliers(p.getEptMessageSuppliers());
		this.setFileId(p.getFileId());
		this.setIsValid(p.getIsValid());
		this.setMessageTemplateContent(p.getMessageTemplateContent());
		this.setId(p.getId());
		this.setMessageTemplateName(p.getMessageTemplateName());
		this.setMessageTemplateType(p.getMessageTemplateType());
		this.setOpTime(p.getOpTime());
		this.setOpUser(p.getOpUser());
		this.setDispIndex(p.getDispIndex());
	}
	
	public EptMessageTemplate adapterToEptMessageTemplate(){
		EptMessageTemplate p = new EptMessageTemplate();
		p.setCreateTime(this.getCreateTime());
		p.setCreateUser(this.getCreateUser());
//		p.setEptMessageSuppliers(this.getEptMessageSuppliers());
		p.setFileId(this.getFileId());
		p.setIsValid(this.getIsValid());
		p.setMessageTemplateContent(this.getMessageTemplateContent());
		p.setId(this.getId());
		p.setMessageTemplateName(this.getMessageTemplateName());
		p.setMessageTemplateType(this.getMessageTemplateType());
		p.setOpTime(this.getOpTime());
		p.setOpUser(this.getOpUser());
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

	public String getMessageTemplateName() {
		return this.messageTemplateName;
	}

	public void setMessageTemplateName(String messageTemplateName) {
		this.messageTemplateName = messageTemplateName;
	}

	public String getMessageTemplateType() {
		return this.messageTemplateType;
	}

	public void setMessageTemplateType(String messageTemplateType) {
		this.messageTemplateType = messageTemplateType;
	}

	public String getMessageTemplateContent() {
		return this.messageTemplateContent;
	}

	public void setMessageTemplateContent(String messageTemplateContent) {
		this.messageTemplateContent = messageTemplateContent;
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

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}
//	public Set getEptMessageSuppliers() {
//		return this.eptMessageSuppliers;
//	}
//
//	public void setEptMessageSuppliers(Set eptMessageSuppliers) {
//		this.eptMessageSuppliers = eptMessageSuppliers;
//	}

}