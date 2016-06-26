package com.ceit.ebs.ebe.vo;

import com.ceit.ebs.ebe.entity.EbeFileClrfy;
import com.ceit.ebs.ebp.entity.EbpPackage;

/*
 * @author lcy date : 2014.8.7
 */

public class EbeFileClrfyVo implements java.io.Serializable {

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
	private Integer providerId;            //供应商ID
	private String opTime;
	private String isValid;
	private Integer businessId;
	private Integer objectId;
	private Integer dispIndex;
	
	private String providerName;	//供应商名称
	private String packageName;		//包名

	// Constructors
	public EbeFileClrfyVo(EbeFileClrfy p) {
		this.setApprovalId(p.getApprovalId());
		this.setApprovalTime(p.getApprovalTime());
		this.setAuditStatus(p.getAuditStatus());
		this.setBusinessId(p.getBusinessId());
		this.setClarifyName(p.getClarifyName());
		this.setContent(p.getContent());
		this.setCreateDate(p.getCreateDate());
		this.setCreateUser(p.getCreateUser());
		this.setPackageId(p.getPackageId());
		this.setId(p.getId());
		this.setGroupId(p.getGroupId());
		this.setIsValid(p.getIsValid());
		this.setObjectId(p.getObjectId());
		this.setOpTime(p.getOpTime());
		this.setProjectId(p.getProjectId());
		this.setProviderId(p.getProviderId());
		this.setDispIndex(p.getDispIndex());
		//修改此构造函数
		this.setPackageName("");
		this.setProviderName("");
	}
	
	public EbeFileClrfy adapterToEbeFileClrfy(){
		EbeFileClrfy p = new EbeFileClrfy();
		p.setApprovalId(this.getApprovalId());
		p.setApprovalTime(this.getApprovalTime());
		p.setAuditStatus(this.getAuditStatus());
		p.setBusinessId(this.getBusinessId());
		p.setClarifyName(this.getClarifyName());
		p.setContent(this.getContent());
		p.setCreateDate(this.getCreateDate());
		p.setCreateUser(this.getCreateUser());
		p.setPackageId(this.getPackageId());
		p.setId(this.getId());
		p.setGroupId(this.getGroupId());
		p.setIsValid(this.getIsValid());
		p.setObjectId(this.getObjectId());
		p.setOpTime(this.getOpTime());
		p.setProjectId(this.getProjectId());
		p.setProviderId(this.getProviderId());
		p.setDispIndex(this.getDispIndex());
		return p;
		
	}
	
	

	/** default constructor */
    public EbeFileClrfyVo() {
    }

	/** minimal constructor */
    public EbeFileClrfyVo(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public EbeFileClrfyVo(Integer id, Integer groupId, String clarifyName, Integer projectId, String content, String createUser, String createDate, Integer auditStatus, Integer approvalTime, Integer approvalId, Integer packageId, Integer providerId, String opTime, String isValid, Integer businessId, Integer objectId, Integer dispIndex) {
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

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}