package com.ceit.ebs.sys.entity;

/**
 *@author gr
 *@date 2014-8-9 下午10:00:11
 */

public class SysUserRole{

	// Fields

	private Integer id;          //主键id
	private Integer userId;      //用户id
	private Integer roleId;      //角色id


	// Constructors

	/** default constructor */
	public SysUserRole() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}