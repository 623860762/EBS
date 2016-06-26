package com.ceit.ebs.sys.entity;


/**
 *@author gr
 *@date 2014-8-9 下午08:35:40
 */

public class SysModule {

	private Integer id;            //模块编号
	private String name;          //模块名称
	private Integer parentId;      //模块父节点编号
	private String isLeaf;              //是否为叶子节点
	private Integer dispIndex;          //排序索引，一般用于模块的上移下移
	private String path;                //父子层级路径

	// Constructors

	/** default constructor */
	public SysModule() {
	}

	/** minimal constructor */
	public SysModule(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public SysModule(Integer id, Integer parentId, String isLeaf,
			Integer dispIndex, String path, String name) {
		this.id = id;
		this.parentId = parentId;
		this.isLeaf = isLeaf;
		this.dispIndex = dispIndex;
		this.path = path;
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}