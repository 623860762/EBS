package com.ceit.ebs.ept.entity;


/**
 *@author gr
 *@date 2014-8-10 上午10:33:58
 */

public class EptMessageSupplier{

	// Fields

	
	private Integer id;//短信id
	private Integer templateId;//模板
	private String messageName;//名字
	private String messageType;//类型
	private String messageContent;//内容
	private String opUser;//更新者
	private String opTime;//更新时间
	private String isValid;//是否有效
	private Integer packageId;//包id
	private Integer supplierId;//供应商id
	private String isUseTemplate;//是否为模板
	private Integer dispIndex;     //排序索引

	// Constructors

	/** default constructor */
	public EptMessageSupplier() {
	}

	/** minimal constructor */
	public EptMessageSupplier(Integer id, Integer packageId) {
		this.id = id;
		this.packageId = packageId;
	}

	/** full constructor */
	public EptMessageSupplier(Integer id, String messageName,
			String messageType, String messageContent, String opUser,
			String opTime, String isValid, Integer packageId, Integer supplierId,
			String isUseTemplate, Integer templateId) {
		this.id = id;
		this.messageName = messageName;
		this.messageType = messageType;
		this.messageContent = messageContent;
		this.opUser = opUser;
		this.opTime = opTime;
		this.isValid = isValid;
		this.packageId = packageId;
		this.supplierId = supplierId;
		this.isUseTemplate = isUseTemplate;
		this.templateId = templateId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessageName() {
		return this.messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageContent() {
		return this.messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
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

	public Integer getPackageId() {
		return this.packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getIsUseTemplate() {
		return this.isUseTemplate;
	}

	public void setIsUseTemplate(String isUseTemplate) {
		this.isUseTemplate = isUseTemplate;
	}

	public Integer getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	
	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}