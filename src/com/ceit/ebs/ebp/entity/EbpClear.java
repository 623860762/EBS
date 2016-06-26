package com.ceit.ebs.ebp.entity;


/**
 * EbpClear entity. @author MyEclipse Persistence Tools
 */

public class EbpClear implements java.io.Serializable {

	// Fields

	private Integer id;
	private String projectId;
	private String packageId;
	private String projectName;
	private String supplyId;
	private String packageName;
	private String remark;
	private String approvalMan;
	private String approvalStatus;
	private String approvalContent;
	private Integer approvalTime;
	private String isSubmit;
	private Integer publishTime;
	private String attachmentId;
	private String isSee;
	private String opTime;
	private Integer dispIndex;

	// Constructors

	/** default constructor */
	public EbpClear() {
	}

	/** minimal constructor */
	public EbpClear(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EbpClear(Integer id, String projectId, String packageId,
			String projectName, String supplyId, String packageName,
			String remark, String approvalMan, String approvalStatus,
			String approvalContent, Integer approvalTime, String isSubmit,
			Integer publishTime, String attachmentId, String isSee,
			String opTime, Integer dispIndex) {
		this.id = id;
		this.projectId = projectId;
		this.packageId = packageId;
		this.projectName = projectName;
		this.supplyId = supplyId;
		this.packageName = packageName;
		this.remark = remark;
		this.approvalMan = approvalMan;
		this.approvalStatus = approvalStatus;
		this.approvalContent = approvalContent;
		this.approvalTime = approvalTime;
		this.isSubmit = isSubmit;
		this.publishTime = publishTime;
		this.attachmentId = attachmentId;
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

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getPackageId() {
		return this.packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSupplyId() {
		return this.supplyId;
	}

	public void setSupplyId(String supplyId) {
		this.supplyId = supplyId;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApprovalMan() {
		return this.approvalMan;
	}

	public void setApprovalMan(String approvalMan) {
		this.approvalMan = approvalMan;
	}

	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalContent() {
		return this.approvalContent;
	}

	public void setApprovalContent(String approvalContent) {
		this.approvalContent = approvalContent;
	}

	public Integer getApprovalTime() {
		return this.approvalTime;
	}

	public void setApprovalTime(Integer approvalTime) {
		this.approvalTime = approvalTime;
	}

	public String getIsSubmit() {
		return this.isSubmit;
	}

	public void setIsSubmit(String isSubmit) {
		this.isSubmit = isSubmit;
	}

	public Integer getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Integer publishTime) {
		this.publishTime = publishTime;
	}

	public String getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
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