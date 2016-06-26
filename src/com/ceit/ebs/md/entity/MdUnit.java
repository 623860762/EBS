package com.ceit.ebs.md.entity;


/**
 * MdUnit entity. @author MyEclipse Persistence Tools
 */

public class MdUnit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String parentId;
	private String name;
	private Integer dispIndex;
	private String code;
	private String remark;
	private String opTime;

	// Constructors

	/** default constructor */
	public MdUnit() {
	}

	/** minimal constructor */
	public MdUnit(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public MdUnit(Integer id, String parentId, String name,
			Integer despIndex, String code, String remark, String opTime) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.dispIndex = dispIndex;
		this.code = code;
		this.remark = remark;
		this.opTime = opTime;
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