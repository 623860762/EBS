package com.ceit.ebs.sys.entity;


/**
 *@author gr
 *@date 2014-8-9 下午08:37:18
 */

public class SysRole {

	private Integer id;           //角色编号
	private String roleName;         //角色名称
	private String roleAlias;        //角色别名
	private Integer parentId;    //组织机构编号
	private Integer roleState;       //角色状态：0为锁定，1为启用
	private String createTime;      //角色创建时间
	private String comments;          //备注
	private Integer dispIndex;		//排序索引

	public SysRole() {
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
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

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}