package com.ceit.ebs.ebe.entity;



/**
 * EbeFileClrfy entity. @author MyEclipse Persistence Tools
 */

public class EbeFileClrfy  implements java.io.Serializable {


    // Fields    

	private Integer id;
	private Integer packageId;
	private Integer groupId;               //组标识
	private String clarifyName;           //澄清名称
	private Integer projectId;             //项目ID
	private String content;               //澄清内容
	private String createUser;            //创建人
	private String createDate;
	private Integer auditStatus;             //废标状态:已提交,审核通过,驳回
	private Integer approvalTime;         //审批时间
	private Integer approvalId;            //审批人ID
	private Integer providerId;            //包ID
	private String opTime;               //供应商ID
	private String isValid;
	private Integer businessId;            //备用字段
	private Integer objectId;
	private Integer dispIndex;


    // Constructors

    /** default constructor */
    public EbeFileClrfy() {
    }

	/** minimal constructor */
    public EbeFileClrfy(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public EbeFileClrfy(Integer id, Integer groupId, String clarifyName, Integer projectId, String content, String createUser, String createDate, Integer auditStatus, Integer approvalTime, Integer approvalId, Integer packageId, Integer providerId, String opTime, String isValid, Integer businessId, Integer objectId, Integer dispIndex) {
        this.id = id;
        this.groupId = groupId;
        this.clarifyName = clarifyName;
        this.projectId = projectId;
        this.content = content;
        this.createUser = createUser;
        this.createDate = createDate;
        this.auditStatus = auditStatus;
        this.approvalTime = approvalTime;
        this.approvalId = approvalId;
        this.packageId = packageId;
        this.providerId = providerId;
        this.opTime = opTime;
        this.isValid = isValid;
        this.businessId = businessId;
        this.objectId = objectId;
        this.dispIndex = dispIndex;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getClarifyName() {
        return this.clarifyName;
    }
    
    public void setClarifyName(String clarifyName) {
        this.clarifyName = clarifyName;
    }

    public Integer getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getAuditStatus() {
        return this.auditStatus;
    }
    
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getApprovalTime() {
        return this.approvalTime;
    }
    
    public void setApprovalTime(Integer approvalTime) {
        this.approvalTime = approvalTime;
    }

    public Integer getApprovalId() {
        return this.approvalId;
    }
    
    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public Integer getPackageId() {
        return this.packageId;
    }
    
    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getProviderId() {
        return this.providerId;
    }
    
    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
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

    public Integer getObjectId() {
        return this.objectId;
    }
    
    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getDispIndex() {
        return this.dispIndex;
    }
    
    public void setDispIndex(Integer dispIndex) {
        this.dispIndex = dispIndex;
    }
}