package com.ceit.ebs.sys.vo;

import com.ceit.ebs.sys.entity.SysResource;

/**
 *@author gr
 *@date 2014-8-7 下午03:42:44
 */

public class SysResourceVo{

	private Integer id;     //资源编号
	private String resourceName;   //资源名称
	private String resourceAlias;  //资源描述
	private String resourceUrl;    //资源请求路径
	private Integer parentId;     //资源所属功能id，对应sys_function下的function_id
	private Integer dispIndex;     //排序索引，主要用于资源的上移下移
	private String isAudit;        //是否需要审计：y为需要，n为不需要

	// Constructors
	public SysResourceVo(SysResource p){
		this.setDispIndex(p.getDispIndex());
		this.setParentId(p.getParentId());
		this.setIsAudit(p.getIsAudit());
		this.setResourceAlias(p.getResourceAlias());
		this.setId(p.getId());
		this.setResourceName(p.getResourceName());
		this.setResourceUrl(p.getResourceUrl());
	}
	
	public SysResource adapterToSysResource(){
		SysResource p = new SysResource();
		p.setDispIndex(this.getDispIndex());
		p.setParentId(this.getParentId());
		p.setIsAudit(this.getIsAudit());
		p.setResourceAlias(this.getResourceAlias());
		p.setId(this.getId());
		p.setResourceName(this.getResourceName());
		p.setResourceUrl(this.getResourceUrl());
		return p;
	}

	/** default constructor */
	public SysResourceVo() {
	}

	/** minimal constructor */
	public SysResourceVo(Integer resourceId) {
		this.id = resourceId;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceAlias() {
		return this.resourceAlias;
	}

	public void setResourceAlias(String resourceAlias) {
		this.resourceAlias = resourceAlias;
	}

	public String getResourceUrl() {
		return this.resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
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

	public String getIsAudit() {
		return this.isAudit;
	}

	public void setIsAudit(String isAudit) {
		this.isAudit = isAudit;
	}

}