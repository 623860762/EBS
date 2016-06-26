package com.ceit.ebs.sys.vo;

import com.ceit.ebs.sys.entity.SysUserRole;

/**
 * SysUserRole entity. @author MyEclipse Persistence Tools
 */

public class SysUserRoleVo {

	// Fields

	private Integer id;          //主键id
	private Integer userId;      //用户id
	private Integer roleId;      //角色id

	// Constructors
	public SysUserRoleVo(SysUserRole p) {
		this.setId(p.getId());
		this.setRoleId(p.getRoleId());
		this.setUserId(p.getUserId());
	}
	
	public SysUserRole adapterToSysUserRole(){
		
		SysUserRole p =new SysUserRole();
		p.setId(this.getId());
		p.setRoleId(this.getRoleId());
		p.setUserId(this.getUserId());
		return p;
	}

	/** default constructor */
	public SysUserRoleVo() {
	}

	/** minimal constructor */
	public SysUserRoleVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SysUserRoleVo(Integer id, Integer userId, Integer roleId) {
		this.id = id;
		this.userId = userId;
		this.roleId = roleId;
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