package com.ceit.ebs.md.vo;

import com.ceit.ebs.md.entity.MdUnit;


/**
 * MdUnit entity. @author MyEclipse Persistence Tools
 */

public class MdUnitVo{

	// Fields

	private Integer id;//id
	private String parentId;//父节点
	private String name;
	private Integer dispIndex;
	private String code;
	private String remark;
	private String opTime;

	// Constructors

	/** default constructor */
	public MdUnitVo() {
	}
	
	public MdUnitVo(MdUnit p) {
		this.setCode(p.getCode());
		this.setDispIndex(p.getDispIndex());
		this.setId(p.getId());
		this.setName(p.getName());
		this.setOpTime(p.getOpTime());
		this.setParentId(p.getParentId());
		this.setRemark(p.getRemark());
	}
	
	public MdUnit adapterToMdUnit(){
		MdUnit p = new MdUnit();
		p.setCode(this.getCode());
		p.setDispIndex(this.getDispIndex());
		p.setId(this.getId());
		p.setName(this.getName());
		p.setOpTime(this.getOpTime());
		p.setParentId(this.getParentId());
		p.setRemark(this.getRemark());
		return p;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

}