package com.ceit.ebs.md.entity;


/**
 * MdCategory entity. @author MyEclipse Persistence Tools
 */

public class MdCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer parentId;
	private String name;
	private Integer dispIndex;
	private String code;
	private String groupCode;
	private String type;
	private String remark;
	private String aliasName;
	private String freezeStatus;
	private String userId;
	private String userName;
	private String opTime;

	// Constructors

	/** default constructor */
	public MdCategory() {
	}

	/** minimal constructor */
	public MdCategory(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public MdCategory(Integer id, Integer parentId, String name,
			Integer dispIndex, String code, String groupCode, String type,
			String remark, String aliasName, String freezeStatus,
			String userId, String userName, String opTime) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.dispIndex = dispIndex;
		this.code = code;
		this.groupCode = groupCode;
		this.type = type;
		this.remark = remark;
		this.aliasName = aliasName;
		this.freezeStatus = freezeStatus;
		this.userId = userId;
		this.userName = userName;
		this.opTime = opTime;
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

	public String getGroupCode() {
		return this.groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
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

	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getFreezeStatus() {
		return this.freezeStatus;
	}

	public void setFreezeStatus(String freezeStatus) {
		this.freezeStatus = freezeStatus;
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

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

}