package com.ceit.ebs.ept.vo;

import com.ceit.ebs.ept.entity.EptOrg;


public class EptOrgVo {

	// Fields

	private Integer id;//机构id
	private String orgCode;//机构编码方式 
	private String orgName;//机构名称
	private String parentCode;//父机构编码
	private String opTime;//更新时间
	private String isValid;//是否有效
	private Integer dispIndex;     //排序索引
	private Integer parentId;
//	private Set eptExpertBaseinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public EptOrgVo() {
	}
	
	public EptOrgVo(EptOrg p) {
//		this.setEptExpertBaseinfos(p.getEptExpertBaseinfos());
		this.setIsValid(p.getIsValid());
		this.setOpTime(p.getOpTime());
		this.setOrgCode(p.getOrgCode());
		this.setId(p.getId());
		this.setOrgName(p.getOrgName());
		this.setParentCode(p.getParentCode());
		this.setDispIndex(p.getDispIndex());
		this.setParentId(p.getParentId());
	}
	
	public EptOrg adapterToEptOrg(){
		EptOrg p = new EptOrg();
//		p.setEptExpertBaseinfos(this.getEptExpertBaseinfos());
		p.setIsValid(this.getIsValid());
		p.setOpTime(this.getOpTime());
		p.setOrgCode(this.getOrgCode());
		p.setId(this.getId());
		p.setOrgName(this.getOrgName());
		p.setParentCode(this.getParentCode());
		p.setDispIndex(this.getDispIndex());
		p.setParentId(this.getParentId());
		return p;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
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
	
	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	

//	public Set getEptExpertBaseinfos() {
//		return this.eptExpertBaseinfos;
//	}
//
//	public void setEptExpertBaseinfos(Set eptExpertBaseinfos) {
//		this.eptExpertBaseinfos = eptExpertBaseinfos;
//	}

}