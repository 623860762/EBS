package com.ceit.ebs.ebp.entity;


/**
 * EbpClearReply entity. @author MyEclipse Persistence Tools
 */

public class EbpClearReply implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer clearId;
	private Integer parentId;
	private Integer supplyId;
	private String name;
	private String remark;
	private Integer publishTime;
	private Integer attachmentId;
	private String isSubmit;
	private String isSee;
	private String opTime;
	private Integer dispIndex;

	// Constructors

	/** default constructor */
	public EbpClearReply() {
	}

	/** minimal constructor */
	public EbpClearReply(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EbpClearReply(Integer id, Integer clearId,
			Integer parentId, Integer supplyId, String name,
			String remark, Integer publishTime,
			Integer attachmentId, String isSubmit, String isSee,
			String opTime, Integer dispIndex) {
		this.id = id;
		this.clearId = clearId;
		this.parentId = parentId;
		this.supplyId = supplyId;
		this.name = name;
		this.remark = remark;
		this.publishTime = publishTime;
		this.attachmentId = attachmentId;
		this.isSubmit = isSubmit;
		this.isSee = isSee;
		this.opTime = opTime;
		this.dispIndex = dispIndex;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClearId() {
		return this.clearId;
	}

	public void setClearId(Integer clearId) {
		this.clearId = clearId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSupplyId() {
		return this.supplyId;
	}

	public void setSupplyId(Integer supplyId) {
		this.supplyId = supplyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Integer publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getIsSubmit() {
		return this.isSubmit;
	}

	public void setIsSubmit(String isSubmit) {
		this.isSubmit = isSubmit;
	}

	public String getIsSee() {
		return this.isSee;
	}

	public void setIsSee(String isSee) {
		this.isSee = isSee;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}