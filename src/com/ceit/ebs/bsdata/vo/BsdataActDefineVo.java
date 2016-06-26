package com.ceit.ebs.bsdata.vo;

import com.ceit.ebs.bsdata.entity.BsdataActDefine;

/**
 * BsdataActDefineVo 
 * @author czg
 * date 2014-8-10
 */

public class BsdataActDefineVo{

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
	public BsdataActDefineVo() {
	}

	/** minimal constructor */
	public BsdataActDefineVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public BsdataActDefineVo(Integer id, Integer parentId, Integer dispIndex, String name,
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

	//po-->vo
	public BsdataActDefineVo(BsdataActDefine b){
		this.setId(b.getId());
		this.setParentId(b.getParentId());
		this.setdispIndex(b.getdispIndex());
		this.setName(b.getName());
		this.setFlowId(b.getFlowId());
		this.setRoleId(b.getRoleId());
		this.setDeptId(b.getDeptId());
		this.setActName(b.getActName());
		this.setOpTime(b.getOpTime());
	}
	
	//vo-->po
	public BsdataActDefine adapterToBsdataActDefine(){
		BsdataActDefine b=new BsdataActDefine();
		b.setId(this.getId());
		b.setParentId(this.getParentId());
		b.setdispIndex(this.getdispIndex());
		b.setName(this.getName());
		b.setFlowId(this.getFlowId());
		b.setRoleId(this.getRoleId());
		b.setDeptId(this.getDeptId());
		b.setActName(this.getActName());
		b.setOpTime(this.getOpTime());
		return b;
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