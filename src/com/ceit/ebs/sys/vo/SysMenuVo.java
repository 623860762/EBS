package com.ceit.ebs.sys.vo;

import com.ceit.ebs.sys.entity.SysMenu;

/**
 *@author gr
 *@date 2014-8-7 下午03:39:48
 */

public class SysMenuVo{

	// Fields

	private String id;         //菜单编号
	private String name;       //菜单名称
	private Integer parentId;       //父节点编号
	private Integer dispIndex;     //排序索引，用于菜单排序及上移、下移功能
	private String path;           //菜单层级路径
	private String icon;           //需要的图标名称
	private String linkValue;      //改菜单索引的功能url
	private String isLeaf;         //是否为叶子节点
//	private String menuState;      //菜单状态：0为锁定，1为启用
	private String comment;        //备注
	private String state;

	// Constructors

	/** default constructor */
	public SysMenuVo() {
	}

	public SysMenuVo(SysMenu p){
		this.setComment(p.getComments());
		this.setDispIndex(p.getDispIndex());
		this.setIcon(p.getIcon());
		this.setIsLeaf(p.getIsLeaf());
		this.setLinkValue(p.getLinkValue());
		this.setId(p.getId().toString());
		this.setName(p.getName());
		this.setState(p.getState());
		this.setParentId(p.getParentId());
		this.setPath(p.getPath());
	}
	
	public SysMenu adapterToSysMenu(){
		
		SysMenu p = new SysMenu();
		p.setComments(this.getComment());
		p.setDispIndex(this.getDispIndex());
		p.setIcon(this.getIcon());
		p.setIsLeaf(this.getIsLeaf());
		p.setLinkValue(this.getLinkValue());
		p.setId(Integer.parseInt(this.getId()));
		p.setName(this.getName());
		p.setState(this.getState());
		p.setParentId(this.getParentId());
		p.setPath(this.getPath());
		return p;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLinkValue() {
		return this.linkValue;
	}

	public void setLinkValue(String linkValue) {
		this.linkValue = linkValue;
	}

	public String getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String State) {
		this.state = State;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}