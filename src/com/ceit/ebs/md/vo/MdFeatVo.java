package com.ceit.ebs.md.vo;

import com.ceit.ebs.md.entity.MdFeat;


/**
 * MdFeat entity. @author MyEclipse Persistence Tools
 */

public class MdFeatVo{

	// Fields

	private Integer id;//id
	private Integer parentId;
	private String name;//属性项名称
	private Integer dispIndex;
	private Integer categoryId;//分类标识id
	private String code;//属性项编码
	private String freezeStatus;//冻结状态
	private String type;//属性项类型
	private String remark;//属性项备注
	private String aliasName;//属性项别名
	private String opTime;//操作时间
	private String userId;//用户ID
	private String userName;//用户名

	private String page;
	private String rows;
	// Constructors

	/** default constructor */
	public MdFeatVo() {
	}
	
	public MdFeatVo(MdFeat p) {
		this.setAliasName(p.getAliasName());
		this.setCategoryId(p.getCategoryId());
		this.setCode(p.getCode());
		this.setDispIndex(p.getDispIndex());
		this.setFreezeStatus(p.getFreezeStatus());
		this.setId(p.getId());
		this.setName(p.getName());
		this.setOpTime(p.getOpTime());
		this.setParentId(p.getParentId());
		this.setRemark(p.getRemark());
		this.setType(p.getType());
		this.setUserId(p.getUserId());
		this.setUserName(p.getUserName());
	}
	
	public MdFeat adapterToMdFeat(){
		MdFeat p = new MdFeat();
		p.setAliasName(this.getAliasName());
		p.setCategoryId(this.getCategoryId());
		p.setCode(this.getCode());
		p.setDispIndex(this.getDispIndex());
		p.setFreezeStatus(this.getFreezeStatus());
		p.setId(this.getId());
		p.setName(this.getName());
		p.setOpTime(this.getOpTime());
		p.setParentId(this.getParentId());
		p.setRemark(this.getRemark());
		p.setType(this.getType());
		p.setUserId(this.getUserId());
		p.setUserName(this.getUserName());
		return p;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}





	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFreezeStatus() {
		return freezeStatus;
	}

	public void setFreezeStatus(String freezeStatus) {
		this.freezeStatus = freezeStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getOpTime() {
		return opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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