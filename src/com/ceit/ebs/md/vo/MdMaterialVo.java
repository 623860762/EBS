package com.ceit.ebs.md.vo;

import com.ceit.ebs.md.entity.MdMaterial;


/**
 * MdMaterial entity. @author MyEclipse Persistence Tools
 */

public class MdMaterialVo{

	// Fields

	private Integer id;
	private Integer parentId;
	private Integer dispIndex;
	private String name;
	private Integer categoryId;//类型id
	private String unitId;//单元id
	private String purchaseLevel;//购买水平
	private String code;
	private String type;
	private String remark;
	private String useCount;//账户
	private String userId;//用户id
	private String userName;
	private String opStatus;//操作状态
	private String opTime;

	private String page;//页数
	private String rows;//行数
	
	/** default constructor */
	public MdMaterialVo() {
	}
	
	public MdMaterialVo(MdMaterial p) {
		this.setCategoryId(p.getCategoryId());
		this.setCode(p.getCode());
		this.setDispIndex(p.getDispIndex());
		this.setId(p.getId());
		this.setName(p.getName());
		this.setOpStatus(p.getOpStatus());
		this.setOpTime(p.getOpTime());
		this.setParentId(p.getParentId());
		this.setPurchaseLevel(p.getPurchaseLevel());
		this.setRemark(p.getRemark());
		this.setType(p.getType());
		this.setUnitId(p.getUnitId());
		this.setUseCount(p.getUseCount());
		this.setUserId(p.getUserId());
		this.setUserName(p.getUserName());
	}
	
	public MdMaterial adapterToMdMaterial(){
		MdMaterial p = new MdMaterial();
		p.setCategoryId(this.getCategoryId());
		p.setCode(this.getCode());
		p.setDispIndex(this.getDispIndex());
		p.setId(this.getId());
		p.setName(this.getName());
		p.setOpStatus(this.getOpStatus());
		p.setOpTime(this.getOpTime());
		p.setParentId(this.getParentId());
		p.setPurchaseLevel(this.getPurchaseLevel());
		p.setRemark(this.getRemark());
		p.setType(this.getType());
		p.setUnitId(this.getUnitId());
		p.setUseCount(this.getUseCount());
		p.setUserId(this.getUserId());
		p.setUserName(this.getUserName());
		return p;
	}


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

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getUnitId() {
		return this.unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getPurchaseLevel() {
		return this.purchaseLevel;
	}

	public void setPurchaseLevel(String purchaseLevel) {
		this.purchaseLevel = purchaseLevel;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUseCount() {
		return this.useCount;
	}

	public void setUseCount(String useCount) {
		this.useCount = useCount;
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

	public String getOpStatus() {
		return this.opStatus;
	}

	public void setOpStatus(String opStatus) {
		this.opStatus = opStatus;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

}