package com.ceit.ebs.sys.entity;

/**
 *@author gr
 *@date 2014-8-9 下午08:38:17
 */

public class SysRoleResource {

	// Fields

	private Integer id;              //主键
	private Integer roleId;          //角色id
	private Integer resourceId;      //资源id

	// Constructors

	/** default constructor */
	public SysRoleResource() {
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

	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

}