package com.ceit.ebs.md.vo;

import com.ceit.ebs.md.entity.MdFeatVal;


/**
 * MdFeatVal entity. @author MyEclipse Persistence Tools
 */

public class MdFeatValVo{

	// Fields

	private Integer id;//id
	private Integer parentId;
	private Integer dispIndex;
	private String name;
	private Integer featId;//属性项标识
	private String code;//属性值编码
	private String desc;//属性值描述
	private String remark;//属性值备注
	private String aliasName;//属性项别名
	private String opTime;//操作时间
	private String userId;//用户ID
	private String userName;//用户名
	private Integer materialId;//物料id
	// Constructors

	/** default constructor */
	public MdFeatValVo() {
	}

	public MdFeatValVo(MdFeatVal p) {
		this.setAliasName(p.getAliasName());
		this.setCode(p.getCode());
		this.setDesc(p.getDesc());
		this.setDispIndex(p.getDispIndex());
		this.setFeatId(p.getFeatId());
		this.setId(p.getId());
		this.setName(p.getName());
		this.setOpTime(p.getOpTime());
		this.setParentId(p.getParentId());
		this.setRemark(p.getRemark());
		this.setUserId(p.getUserId());
		this.setUserName(p.getUserName());
		this.setMaterialId(p.getMaterialId());
	}
	
	public MdFeatVal adapterToMdFeatVal(){
		MdFeatVal p = new MdFeatVal();
		p.setAliasName(this.getAliasName());
		p.setCode(this.getCode());
		p.setDesc(this.getDesc());
		p.setDispIndex(this.getDispIndex());
		p.setFeatId(this.getFeatId());
		p.setId(this.getId());
		p.setName(this.getName());
		p.setOpTime(this.getOpTime());
		p.setParentId(this.getParentId());
		p.setRemark(this.getRemark());
		p.setUserId(this.getUserId());
		p.setUserName(this.getUserName());
		p.setMaterialId(this.getMaterialId());
		return p;
	}
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFeatId() {
		return this.featId;
	}

	public void setFeatId(Integer featId) {
		this.featId = featId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

}