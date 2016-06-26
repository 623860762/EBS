package com.ceit.ebs.ebe.vo;

import com.ceit.ebs.ebe.entity.EbeGroupPackage;

/**
 * EbeGroupPackageVo 系统的评标小组与包关系构件的VO
 * @author czg
 * date 2014-8-8
 */

public class EbeGroupPackageVo{

	// Fields

	private Integer id;//评标小组与包关系ID
	private Integer groupId;//组ID
	private Integer packageId;//包ID
	private String operUser;//操作人
	private String opTime;//最后修改时间
	private Integer projectId;//项目ID
	private String isValid;//是否有效
	private Integer businessId;//业务ID
	private Integer techGroupId;//技术组ID
	private Integer busiGroupId;//商务组ID
	private Integer priceGroupId;//价格组ID
	private Integer dispIndex;//排序索引
	
	
	private String packageName;//包名称
	// Constructors

	/** default constructor */
	/** default constructor */
	public EbeGroupPackageVo() {
	}

	/** minimal constructor */
	public EbeGroupPackageVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EbeGroupPackageVo(Integer id, Integer groupId, Integer packageId,
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
	
	public EbeGroupPackageVo(EbeGroupPackage e){
		this.setId(e.getId());
		this.setGroupId(e.getGroupId());
		this.setPackageId(e.getPackageId());
		this.setOperUser(e.getOperUser());
		this.setOpTime(e.getOpTime());
		this.setProjectId(e.getProjectId());
		this.setIsValid(e.getIsValid());
		this.setBusinessId(e.getBusinessId());
		this.setDispIndex(e.getDispIndex());
		this.setPriceGroupId(e.getPriceGroupId());
		this.setBusiGroupId(e.getBusiGroupId());
		this.setTechGroupId(e.getTechGroupId());
		this.setPackageName("");
	}
	
	//此方法将vo转为po
	public EbeGroupPackage adapterToEbeGroupPackage(){
		EbeGroupPackage e = new EbeGroupPackage();
		e.setId(this.getId());
		e.setGroupId(this.getGroupId());
		e.setPackageId(this.getPackageId());
		e.setOperUser(this.getOperUser());
		e.setOpTime(this.getOpTime());
		e.setProjectId(this.getProjectId());
		e.setIsValid(this.getIsValid());
		e.setBusinessId(this.getBusinessId());
		e.setDispIndex(this.getDispIndex());
		e.setBusiGroupId(this.getBusiGroupId());
		e.setPriceGroupId(this.getPriceGroupId());
		e.setTechGroupId(this.getTechGroupId());
		return e;
	}
	
	
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
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

	public Integer getTechGroupId() {
		return techGroupId;
	}

	public void setTechGroupId(Integer techGroupId) {
		this.techGroupId = techGroupId;
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