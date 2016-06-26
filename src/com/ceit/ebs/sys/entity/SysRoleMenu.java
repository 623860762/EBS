package com.ceit.ebs.sys.entity;

/**
 *@author gr
 *@date 2014-8-9 下午08:38:01
 */

public class SysRoleMenu {

	// Fields

	private Integer id;          //主键
	private Integer roleId;      //角色id
	private Integer menuId;      //菜单id

	// Constructors

	/** default constructor */
	public SysRoleMenu() {
	}

	/** minimal constructor */
	public SysRoleMenu(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SysRoleMenu(Integer id, Integer roleId, Integer menuId) {
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

}