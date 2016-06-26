package com.ceit.ebs.ept.vo;

import com.ceit.ebs.ept.entity.EptSpecialty;

/**
 *@author gr
 *@date 2014-8-10 下午02:47:57
 */
public class EptSpecialtyVo {

	// Fields

	private Integer id;//专业id
	private String specialtyCode;//编码
	private String specialtyName;//名称
	private String parentCode;//父级专业编码
	private String opTime;
	private String isValid;
	private Integer opUser;
	private String specialtyRemark;//专业备注
	private Integer dispIndex;     //排序索引
	private Integer parentId;
//	private Set eptExpertBaseinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public EptSpecialtyVo() {
	}

	public EptSpecialtyVo(EptSpecialty p) {
//		this.setEptExpertBaseinfos(p.getEptExpertBaseinfos());
		this.setIsValid(p.getIsValid());
		this.setOpTime(p.getOpTime());
		this.setOpUser(p.getOpUser());
		this.setParentCode(p.getParentCode());
		this.setSpecialtyCode(p.getSpecialtyCode());
		this.setId(p.getId());
		this.setSpecialtyName(p.getSpecialtyName());
		this.setSpecialtyRemark(p.getSpecialtyRemark());
		this.setDispIndex(p.getDispIndex());
		this.setParentId(p.getParentId());
	}
	
	public EptSpecialty adapterToEptSpecialty(){
		EptSpecialty p = new EptSpecialty();
//		p.setEptExpertBaseinfos(this.getEptExpertBaseinfos());
		p.setIsValid(this.getIsValid());
		p.setOpTime(this.getOpTime());
		p.setOpUser(this.getOpUser());
		p.setParentCode(this.getParentCode());
		p.setSpecialtyCode(this.getSpecialtyCode());
		p.setId(this.getId());
		p.setSpecialtyName(this.getSpecialtyName());
		p.setSpecialtyRemark(this.getSpecialtyRemark());
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

	public String getSpecialtyCode() {
		return this.specialtyCode;
	}

	public void setSpecialtyCode(String specialtyCode) {
		this.specialtyCode = specialtyCode;
	}

	public String getSpecialtyName() {
		return this.specialtyName;
	}

	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
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

	public Integer getOpUser() {
		return this.opUser;
	}

	public void setOpUser(Integer opUser) {
		this.opUser = opUser;
	}

	public String getSpecialtyRemark() {
		return this.specialtyRemark;
	}

	public void setSpecialtyRemark(String specialtyRemark) {
		this.specialtyRemark = specialtyRemark;
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