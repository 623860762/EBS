package com.ceit.ebs.sys.vo;

import com.ceit.ebs.sys.entity.SysRoleMenu;

/**
 *@author gr
 *@date 2014-8-7 下午03:44:41
 */
public class SysRoleMenuVo {

	// Fields

	private Integer id;          //主键
	private Integer roleId;      //角色id
	private Integer menuId;      //菜单id
	
	// Constructors
	
	public SysRoleMenuVo(SysRoleMenu p){
		this.setId(p.getId());
		this.setMenuId(p.getMenuId());
		this.setRoleId(p.getRoleId());
	}
	
	public SysRoleMenu adapterToSysRoleMenu(){
		
		SysRoleMenu p = new SysRoleMenu();
		p.setId(this.getId());
		p.setMenuId(this.getMenuId());
		p.setRoleId(this.getRoleId());
		return p;
	}

	/** default constructor */
	public SysRoleMenuVo() {
	}

	/** minimal constructor */
	public SysRoleMenuVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SysRoleMenuVo(Integer id, Integer roleId, Integer menuId) {
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