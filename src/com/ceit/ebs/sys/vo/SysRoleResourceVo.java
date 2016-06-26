package com.ceit.ebs.sys.vo;

import com.ceit.ebs.sys.entity.SysRoleResource;

/**
 *@author gr
 *@date 2014-8-7 下午03:45:32
 */

public class SysRoleResourceVo {

	// Fields

	private Integer id;              //主键
	private Integer roleId;          //角色id
	private Integer resourceId;      //资源id
	
	// Constructors
	
	public SysRoleResourceVo(SysRoleResource p){
		
		this.setId(p.getId());
		this.setResourceId(p.getResourceId());
		this.setRoleId(p.getRoleId());
	}
	
	public SysRoleResource adapterToSysRoleResource(){
		SysRoleResource p = new SysRoleResource();
		p.setId(this.getId());
		p.setResourceId(this.getResourceId());
		p.setRoleId(this.getRoleId());
		return p;
	}

	/** default constructor */
	public SysRoleResourceVo() {
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