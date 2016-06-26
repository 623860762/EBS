package com.ceit.ebs.sys.entity;


/**
 *@author gr
 *@date 2014-8-9 下午08:34:43
 */

public class SysMenu {

	// Fields

	private Integer id;
	private String name;
	private Integer parentId;
	private Integer dispIndex;
	private String path;
	private String icon;
	private String linkValue;
	private String isLeaf;
	private String state;
	private String comments;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getDispIndex() {
		return dispIndex;
	}
	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getLinkValue() {
		return linkValue;
	}
	public void setLinkValue(String linkValue) {
		this.linkValue = linkValue;
	}
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	

}