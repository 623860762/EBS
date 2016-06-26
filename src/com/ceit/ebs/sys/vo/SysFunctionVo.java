package com.ceit.ebs.sys.vo;

import com.ceit.ebs.sys.entity.SysFunction;

/**
 *@author gr
 *@date 2014-8-7 下午03:38:40
 */

public class SysFunctionVo{

	// Fields

	private Integer id;         //功能编号
	private String name;       //功能名称
	private Integer parentId;           //功能所在的模块id，对应sys_module表下的module_id
	private Integer dispIndex;         //排序索引

	// Constructors

	/** default constructor */
	public SysFunctionVo() {
	}

	/** minimal constructor */
	public SysFunctionVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SysFunctionVo(Integer id, String name, Integer parentId,
			Integer dispIndex) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.dispIndex = dispIndex;
	}
	
	public SysFunctionVo(SysFunction p){
		this.setDispIndex(p.getDispIndex());
		this.setId(p.getId());
		this.setName(p.getName());
		this.setParentId(p.getParentId());
	}
	
	public SysFunction adapterToSysFunction(){
		SysFunction p = new SysFunction();
		p.setDispIndex(this.getDispIndex());
		p.setId(this.getId());
		p.setName(this.getName());
		p.setParentId(this.getParentId());
		return p;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}


}