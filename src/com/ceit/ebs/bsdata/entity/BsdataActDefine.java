package com.ceit.ebs.bsdata.entity;

/**
 * BsdataActDefineVo 
 * @author czg
 * date 2014-8-10
 */

public class BsdataActDefine implements java.io.Serializable {

	// Fields

	private Integer id;           //主键ID
	private Integer parentId;     //父类节点
	private Integer dispIndex;    //排序索引
	private String name;          //名称
	private Integer flowId;       //工作流ID
	private Integer roleId;       //角色ID
	private Integer deptId;       //部门ID
	private String actName;       //
	private String opTime;       //操作时间

	// Constructors

	/** default constructor */
	public BsdataActDefine() {
	}

	/** minimal constructor */
	public BsdataActDefine(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public BsdataActDefine(Integer id, Integer parentId, Integer dispIndex, String name,
			Integer flowId, Integer roleId, Integer deptId, String actName, String opTime) {
		this.id = id;
		this.parentId = parentId;
		this.dispIndex = dispIndex;
		this.name = name;
		this.flowId = flowId;
		this.roleId = roleId;
		this.deptId = deptId;
		this.actName = actName;
		this.opTime = opTime;
	}

	
	
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getdispIndex() {
		return this.dispIndex;
	}

	public void setdispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFlowId() {
		return this.flowId;
	}

	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getActName() {
		return this.actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

}