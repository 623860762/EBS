package com.ceit.ebs.ept.vo;

import com.ceit.ebs.ept.entity.EptMessageSupplier;

/**
 *@author gr
 *@date 2014-8-10 上午11:05:40
 */

public class EptMessageSupplierVo {

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
	public EptMessageSupplierVo() {
	}

	public EptMessageSupplierVo(EptMessageSupplier p) {
		this.setTemplateId(p.getTemplateId());
		this.setIsUseTemplate(p.getIsUseTemplate());
		this.setIsValid(p.getIsValid());
		this.setMessageContent(p.getMessageContent());
		this.setId(p.getId());
		this.setMessageName(p.getMessageName());
		this.setMessageType(p.getMessageType());
		this.setOpTime(p.getOpTime());
		this.setOpUser(p.getOpUser());
		this.setPackageId(p.getPackageId());
		this.setSupplierId(p.getSupplierId());
		this.setDispIndex(p.getDispIndex());
	}
	
	public EptMessageSupplier adapterToEptMessageSupplier(){
		EptMessageSupplier p = new EptMessageSupplier();
		p.setTemplateId(this.getTemplateId());
		p.setIsUseTemplate(this.getIsUseTemplate());
		p.setIsValid(this.getIsValid());
		p.setMessageContent(this.getMessageContent());
		p.setId(this.getId());
		p.setMessageName(this.getMessageName());
		p.setMessageType(this.getMessageType());
		p.setOpTime(this.getOpTime());
		p.setOpUser(this.getOpUser());
		p.setPackageId(this.getPackageId());
		p.setSupplierId(this.getSupplierId());
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

//	public EptMessageTemplate getEptMessageTemplate() {
//		return this.eptMessageTemplate;
//	}
//
//	public void setEptMessageTemplate(EptMessageTemplate eptMessageTemplate) {
//		this.eptMessageTemplate = eptMessageTemplate;
//	}

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
		return templateId;
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