package com.ceit.ebs.ept.entity;


/**
 *@author gr
 *@date 2014-8-10 上午10:34:31
 */

public class EptMessageTemplate{

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
	// Constructors

	/** default constructor */
	public EptMessageTemplate() {
	}

	/** minimal constructor */
	public EptMessageTemplate(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EptMessageTemplate(Integer id,
			String messageTemplateName, String messageTemplateType,
			String messageTemplateContent, String opUser, String opTime,
			String isValid, Integer fileId, String createUser,
			Integer createTime) {
		this.id = id;
		this.messageTemplateName = messageTemplateName;
		this.messageTemplateType = messageTemplateType;
		this.messageTemplateContent = messageTemplateContent;
		this.opUser = opUser;
		this.opTime = opTime;
		this.isValid = isValid;
		this.fileId = fileId;
		this.createUser = createUser;
		this.createTime = createTime;
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
}