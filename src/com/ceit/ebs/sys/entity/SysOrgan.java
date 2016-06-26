package com.ceit.ebs.sys.entity;


/**
 *@author gr
 *@date 2014-8-9 下午08:36:20
 */

public class SysOrgan {

	// Fields

	private Integer id;         //组织机构编号
	private String organCode;       //组织机构编码
	private String organName;       //组织机构名称
	private String shortName;       //组织机构简称
	private Integer parentId;        //该组织机构父节点
	private Integer dispIndex;      //索引，主要在组织机构的上移、下移中使用
	private String path;            //组织机构层级路线
	private Integer organState;     //组织机构状态：0为锁定，1为启用
	private Integer createTime;     //组织机构创建时间
	private String organIcon;        //组织机构图标


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getOrganState() {
		return this.organState;
	}

	public void setOrganState(Integer organState) {
		this.organState = organState;
	}

	public Integer getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public String getOrganIcon() {
		return organIcon;
	}

	public void setOrganIcon(String organIcon) {
		this.organIcon = organIcon;
	}

}