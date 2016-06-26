package com.ceit.ebs.sys.entity;

/**
 *@author gr
 *@date 2014-8-9 下午08:21:00
 */

public class SysFunction{

	private Integer id;
	private String name;
	private Integer parentId;
	private Integer dispIndex;

	/** default constructor */
	public SysFunction() {
	}

	/** minimal constructor */
	public SysFunction(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SysFunction(Integer id, String name, Integer parentId, Integer dispIndex) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.dispIndex = dispIndex;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
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
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}