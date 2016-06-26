package com.ceit.ebs.sys.vo;

import com.ceit.ebs.sys.entity.SysRole;

/**
 *@author gr
 *@date 2014-8-7 下午03:43:56
 */

public class SysRoleVo {

	private Integer id;           //角色编号
	private String roleName;         //角色名称
	private String roleAlias;        //角色别名
	private Integer parentId;    //组织机构编号
	private Integer roleState;       //角色状态：0为锁定，1为启用
	private String createTime;      //角色创建时间
	private String comment;          //备注
	private Integer dispIndex;		//排序索引

	

	public SysRoleVo(SysRole p) {
		this.setComment(p.getComments());
		this.setParentId(p.getParentId());
		this.setCreateTime(p.getCreateTime());
		this.setRoleAlias(p.getRoleAlias());
		this.setId(p.getId());
		this.setRoleName(p.getRoleName());
		this.setRoleState(p.getRoleState());
	}
	
	public SysRole adapterToSysRole(){
		SysRole p = new SysRole();
		p.setComments(this.getComment());
		p.setParentId(this.getParentId());
		p.setCreateTime(this.getCreateTime());
		p.setRoleAlias(this.getRoleAlias());
		p.setId(this.getId());
		p.setRoleName(this.getRoleName());
		p.setRoleState(this.getRoleState());
		return p;
		
	}

	/** default constructor */
	public SysRoleVo() {
	}

	// Property accessors


	public String getRoleName() {
		return this.roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleAlias() {
		return this.roleAlias;
	}

	public void setRoleAlias(String roleAlias) {
		this.roleAlias = roleAlias;
	}

	

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getRoleState() {
		return this.roleState;
	}

	public void setRoleState(Integer roleState) {
		this.roleState = roleState;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}