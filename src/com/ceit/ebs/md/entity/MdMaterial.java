package com.ceit.ebs.md.entity;


/**
 * MdMaterial entity. @author MyEclipse Persistence Tools
 */

public class MdMaterial implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer parentId;
	private Integer dispIndex;
	private String name;
	private Integer categoryId;
	private String unitId;
	private String purchaseLevel;
	private String code;
	private String type;
	private String remark;
	private String useCount;
	private String userId;
	private String userName;
	private String opStatus;
	private String opTime;

	// Constructors

	/** default constructor */
	public MdMaterial() {
	}

	/** minimal constructor */
	public MdMaterial(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public MdMaterial(Integer id, Integer parentId, Integer dispIndex,
			String name, Integer categoryId, String unitId,
			String purchaseLevel, String code, String type, String remark,
			String useCount, String userId, String userName, String opStatus,
			String opTime) {
		this.id = id;
		this.parentId = parentId;
		this.dispIndex = dispIndex;
		this.name = name;
		this.categoryId = categoryId;
		this.unitId = unitId;
		this.purchaseLevel = purchaseLevel;
		this.code = code;
		this.type = type;
		this.remark = remark;
		this.useCount = useCount;
		this.userId = userId;
		this.userName = userName;
		this.opStatus = opStatus;
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

}