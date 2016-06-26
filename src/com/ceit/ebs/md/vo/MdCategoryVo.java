package com.ceit.ebs.md.vo;

import com.ceit.ebs.md.entity.MdCategory;




public class MdCategoryVo{

	// Fields

	private Integer id;//id
	private Integer parentId;//
	private String name;
	private Integer dispIndex;
	private String code;//分类编码
	private String groupCode;//分类全编码
	private String type;//分类类型
	private String remark;//分类描述
	private String aliasName;//分类别名
	private String freezeStatus;//是否冻结
	private String userId;//用户ID
	private String userName;//用户名
	private String opTime;//操作时间

	// Constructors

	/** default constructor */
	public MdCategoryVo() {
	}
	
	public MdCategoryVo(MdCategory p) {
		this.setAliasName(p.getAliasName());
		this.setCode(p.getCode());
		this.setDispIndex(p.getDispIndex());
		this.setFreezeStatus(p.getFreezeStatus());
		this.setGroupCode(p.getGroupCode());
		this.setId(p.getId());
		this.setName(p.getName());
		this.setOpTime(p.getOpTime());
		this.setParentId(p.getParentId());
		this.setRemark(p.getRemark());
		this.setType(p.getType());
		this.setUserId(p.getUserId());
		this.setUserName(p.getUserName());
	}
	
	public MdCategory adapterToMdCategory(){
		MdCategory p = new MdCategory();
		p.setAliasName(this.getAliasName());
		p.setCode(this.getCode());
		p.setDispIndex(this.getDispIndex());
		p.setFreezeStatus(this.getFreezeStatus());
		p.setGroupCode(this.getGroupCode());
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