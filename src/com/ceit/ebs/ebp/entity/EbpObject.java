package com.ceit.ebs.ebp.entity;


/**
 * EbpObject 系统的项目下分标构件
 * @author czg
 * date 2014-8-9
 */

public class EbpObject{

	// Fields

	private Integer id;            //标ID
	private Integer projectId;     //项目ID
	private String objectName;     //标名称
	private Integer creatorId;      //创建人编号
	private String updateTime;    //最新更新时间
	private Integer dispIndex;     //排序索引
	private String isValid;        //是否有效

	// Constructors

	/** default constructor */
	public EbpObject() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getObjectName() {
		return this.objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

}