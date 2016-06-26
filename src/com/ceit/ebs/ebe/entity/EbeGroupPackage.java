package com.ceit.ebs.ebe.entity;

/**
 * EbeGroupPackage 系统的评标小组与包关系构件
 * @author czg
 * date 2014-8-8
 */

public class EbeGroupPackage implements java.io.Serializable {

	// Fields

	private Integer id;//评标小组与包关系ID
	private Integer groupId;//组ID
	private Integer packageId;//包ID
	private String operUser;//操作人
	private String opTime;//最后修改时间
	private Integer projectId;//项目ID
	private String isValid;//是否有效
	private Integer businessId;//业务ID
	private Integer dispIndex;//排序索引
	private Integer techGroupId;//技术组ID
	private Integer busiGroupId;//商务组ID
	private Integer priceGroupId;//价格组ID
	


	// Constructors

	/** default constructor */
	public EbeGroupPackage() {
	}

	/** minimal constructor */
	public EbeGroupPackage(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EbeGroupPackage(Integer id, Integer groupId, Integer packageId,
			String operUser, String opTime, Integer projectId, String isValid,
			Integer businessId, Integer dispIndex) {
		this.id = id;
		this.groupId = groupId;
		this.packageId = packageId;
		this.operUser = operUser;
		this.opTime = opTime;
		this.projectId = projectId;
		this.isValid = isValid;
		this.businessId = businessId;
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

	public Integer getPackageId() {
		return this.packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getOperUser() {
		return this.operUser;
	}

	public void setOperUser(String operUser) {
		this.operUser = operUser;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
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

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public void setTechGroupId(Integer techGroupId) {
		this.techGroupId = techGroupId;
	}
	
	public Integer getTechGroupId() {
		return techGroupId;
	}

	public Integer getBusiGroupId() {
		return busiGroupId;
	}

	public void setBusiGroupId(Integer busiGroupId) {
		this.busiGroupId = busiGroupId;
	}

	public Integer getPriceGroupId() {
		return priceGroupId;
	}

	public void setPriceGroupId(Integer priceGroupId) {
		this.priceGroupId = priceGroupId;
	}

}