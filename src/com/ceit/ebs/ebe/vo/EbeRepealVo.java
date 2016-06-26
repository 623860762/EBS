package com.ceit.ebs.ebe.vo;

import com.ceit.ebs.ebe.entity.EbeRepeal;

/**
 * EbeRepealVo 系统的评标废标构件的VO
 * @author czg
 * date 2014-8-8
 */

public class EbeRepealVo{

	// Fields

	private Integer id;                          //主键
	private Integer templateId;                  //模板ID
	private Integer packageId;                   //包ID
	private String repealResoun;                 //废标原因
	private Integer projectId;                    //项目ID
	private Integer objectId;                     //标ID
	private Integer supplierId;                   //供应商ID
	private String fileRequire;                  //招标文件规定
	private String fileRelpy;                    //投标文件响应
	private Integer createUserId;                 //创建人
	private Integer groupId;                      //小组ID
	private String repealStatus;                 //废标状态:已提交,审核通过,驳回
	private String blankOutStatus;               //作废状态
	private String blankOutReason;               //作废原因
	private String repealType;                   //废标类型
	private String opTime;                      //操作时间
	private String isValid;                      //是否有效
	private Integer businessId;                   //业务ID
	private Integer approvalId;                   //审批人ID
	private String isUseTemplate;                //是否使用模版
	private Integer dispIndex;                   //排序索引
	
	//未在数据库表中的数据
	private String packageName;                 //包名
	private String supplierName;				//供应商名
	private String projectName;					//项目名

	// Constructors

	/** default constructor */
	public EbeRepealVo() {
	}

	/** minimal constructor */
	public EbeRepealVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EbeRepealVo(Integer id, String repealResoun, Integer projectId,
			Integer objectId, Integer packageId, Integer supplierId, String fileRequire,
			String fileRelpy, Integer createUserId, Integer groupId,
			String repealStatus, String blankOutStatus, String blankOutReason,
			String repealType, String opTime, String isValid, Integer businessId,
			Integer approvalId, String isUseTemplate, Integer templateId,
			Integer dispIndex,String packageName) {
		this.id = id;
		this.repealResoun = repealResoun;
		this.projectId = projectId;
		this.objectId = objectId;
		this.packageId = packageId;
		this.supplierId = supplierId;
		this.fileRequire = fileRequire;
		this.fileRelpy = fileRelpy;
		this.createUserId = createUserId;
		this.groupId = groupId;
		this.repealStatus = repealStatus;
		this.blankOutStatus = blankOutStatus;
		this.blankOutReason = blankOutReason;
		this.repealType = repealType;
		this.opTime = opTime;
		this.isValid = isValid;
		this.businessId = businessId;
		this.approvalId = approvalId;
		this.isUseTemplate = isUseTemplate;
		this.templateId = templateId;
		this.dispIndex = dispIndex;
		this.packageName = packageName;
	}
	//po->vo
	public EbeRepealVo(EbeRepeal e){
		this.setPackageId(e.getPackageId());
		this.setId(e.getId());
		this.setTemplateId(e.getTemplateId());
		this.setPackageId(e.getPackageId());
		this.setRepealResoun(e.getRepealResoun());
		this.setProjectId(e.getProjectId());
		this.setObjectId(e.getObjectId());
		this.setSupplierId(e.getSupplierId());
		this.setFileRequire(e.getFileRequire());
		this.setFileRelpy(e.getFileRelpy());
		this.setCreateUserId(e.getCreateUserId());
		this.setGroupId(e.getGroupId());
		this.setRepealStatus(e.getRepealStatus());
		this.setBlankOutStatus(e.getBlankOutStatus());
		this.setBlankOutReason(e.getBlankOutReason());
		this.setRepealType(e.getRepealType());
		this.setOpTime(e.getOpTime());
		this.setIsValid(e.getIsValid());
		this.setBusinessId(e.getBusinessId());
		this.setApprovalId(e.getApprovalId());
		this.setIsUseTemplate(e.getIsUseTemplate());
		this.setDispIndex(e.getDispIndex());
		this.setPackageName("");
	}
	
	//此方法将vo转为po
	public EbeRepeal adapterToEbeRepeal(){
		EbeRepeal e = new EbeRepeal();
		e.setPackageId(this.getPackageId());
		e.setId(this.getId());
		e.setTemplateId(this.getTemplateId());
		e.setPackageId(this.getPackageId());
		e.setRepealResoun(this.getRepealResoun());
		e.setProjectId(this.getProjectId());
		e.setObjectId(this.getObjectId());
		e.setSupplierId(this.getSupplierId());
		e.setFileRequire(this.getFileRequire());
		e.setFileRelpy(this.getFileRelpy());
		e.setCreateUserId(this.getCreateUserId());
		e.setGroupId(this.getGroupId());
		e.setRepealStatus(this.getRepealStatus());
		e.setBlankOutStatus(this.getBlankOutStatus());
		e.setBlankOutReason(this.getBlankOutReason());
		e.setRepealType(this.getRepealType());
		e.setOpTime(this.getOpTime());
		e.setIsValid(this.getIsValid());
		e.setBusinessId(this.getBusinessId());
		e.setApprovalId(this.getApprovalId());
		e.setIsUseTemplate(this.getIsUseTemplate());
		e.setDispIndex(this.getDispIndex());
		return e;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRepealResoun() {
		return this.repealResoun;
	}

	public void setRepealResoun(String repealResoun) {
		this.repealResoun = repealResoun;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
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

	public String getFileRequire() {
		return this.fileRequire;
	}

	public void setFileRequire(String fileRequire) {
		this.fileRequire = fileRequire;
	}

	public String getFileRelpy() {
		return this.fileRelpy;
	}

	public void setFileRelpy(String fileRelpy) {
		this.fileRelpy = fileRelpy;
	}

	public Integer getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getRepealStatus() {
		return this.repealStatus;
	}

	public void setRepealStatus(String repealStatus) {
		this.repealStatus = repealStatus;
	}

	public String getBlankOutStatus() {
		return this.blankOutStatus;
	}

	public void setBlankOutStatus(String blankOutStatus) {
		this.blankOutStatus = blankOutStatus;
	}

	public String getBlankOutReason() {
		return this.blankOutReason;
	}

	public void setBlankOutReason(String blankOutReason) {
		this.blankOutReason = blankOutReason;
	}

	public String getRepealType() {
		return this.repealType;
	}

	public void setRepealType(String repealType) {
		this.repealType = repealType;
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

	public Integer getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public Integer getApprovalId() {
		return this.approvalId;
	}

	public void setApprovalId(Integer approvalId) {
		this.approvalId = approvalId;
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
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}