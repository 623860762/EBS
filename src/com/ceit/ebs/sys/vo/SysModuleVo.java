package com.ceit.ebs.sys.vo;

import com.ceit.ebs.sys.entity.SysModule;

/**
 *@author gr
 *@date 2014-8-7 下午03:40:39
 */

public class SysModuleVo  {

	private Integer id;            //模块编号
	private String moduleName;          //模块名称
	private Integer parentId;      //模块父节点编号
	private String isLeaf;              //是否为叶子节点
	private Integer dispIndex;          //排序索引，一般用于模块的上移下移
	private String path;                //父子层级路径

	// Constructors
	public SysModuleVo(SysModule p){
		this.setDispIndex(p.getDispIndex());
		this.setIsLeaf(p.getIsLeaf());
		this.setId(p.getId());
		this.setModuleName(p.getName());
		this.setParentId(p.getParentId());
		this.setPath(p.getPath());
	}
	
	public SysModule adapterToSysModule(){
		
		SysModule p = new SysModule();
		p.setDispIndex(this.getDispIndex());
		p.setIsLeaf(this.getIsLeaf());
		p.setId(this.getId());
		p.setName(this.getModuleName());
		p.setParentId(this.getParentId());
		p.setPath(this.getPath());
		return p;
	}

	/** default constructor */
	public SysModuleVo() {
	}

	/** minimal constructor */
	public SysModuleVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SysModuleVo(Integer id, String moduleName, Integer parentd,
			String isLeaf, Integer dispIndex, String path) {
		this.id = id;
		this.moduleName = moduleName;
		this.parentId = parentd;
		this.isLeaf = isLeaf;
		this.dispIndex = dispIndex;
		this.path = path;
	}

	// Property accessors


	public String getModuleName() {
		return this.moduleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}


	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getIsLeaf() {
		return this.isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}