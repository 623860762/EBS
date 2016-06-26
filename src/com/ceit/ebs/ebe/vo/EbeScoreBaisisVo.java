package com.ceit.ebs.ebe.vo;

import com.ceit.ebs.ebe.entity.EbeScoreBaisis;


/**
 * EbeScoreBaisisVo 系统的打分依据构件的VO
 * @author czg
 * date 2014-8-8
 */

public class EbeScoreBaisisVo{

	// Fields

	private Integer id;             //主键
	private Integer packageId;      //包ID
	private Integer groupId;        //组标识
	private Integer projectId;      //项目ID
	private String content;        //依据内容
	private String createUser;     //创建人
	private String createDate;     //创建日期
	private Integer providerId;     //供应商ID
	private String opTime;        //操作时间
	private String isValid;        //是否有效
	private Integer businessId;     //备用字段
	private Integer objectId;       //标ID
	private Integer dispIndex;      //排序索引

	// Constructors

	/** default constructor */
	public EbeScoreBaisisVo() {
	}

	/** minimal constructor */
	public EbeScoreBaisisVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EbeScoreBaisisVo(Integer id, Integer groupId, Integer projectId,
			String content, String createUser, String createDate,
			Integer packageId, Integer providerId, String opTime, String isValid,
			Integer businessId, Integer objectId, Integer dispIndex) {
		this.id = id;
		this.groupId = groupId;
		this.projectId = projectId;
		this.content = content;
		this.createUser = createUser;
		this.createDate = createDate;
		this.packageId = packageId;
		this.providerId = providerId;
		this.opTime = opTime;
		this.isValid = isValid;
		this.businessId = businessId;
		this.objectId = objectId;
		this.dispIndex = dispIndex;
	}
	
	public EbeScoreBaisisVo(EbeScoreBaisis e){
		this.setId(e.getId());
		this.setPackageId(e.getPackageId());
		this.setGroupId(e.getGroupId());
		this.setProjectId(e.getProjectId());
		this.setContent(e.getContent());
		this.setCreateUser(e.getCreateUser());
		this.setCreateDate(e.getCreateDate());
		this.setProviderId(e.getProviderId());
		this.setOpTime(e.getOpTime());
		this.setIsValid(e.getIsValid());
		this.setBusinessId(e.getBusinessId());
		this.setObjectId(e.getObjectId());
		this.setDispIndex(e.getDispIndex());
	}
	
	//此方法将vo转为po
	public EbeScoreBaisis adapterToEbeScoreBaisis(){
		EbeScoreBaisis e = new EbeScoreBaisis();
		e.setId(this.getId());
		e.setPackageId(this.getPackageId());
		e.setGroupId(this.getGroupId());
		e.setProjectId(this.getProjectId());
		e.setContent(this.getContent());
		e.setCreateUser(this.getCreateUser());
		e.setCreateDate(this.getCreateDate());
		e.setProviderId(this.getProviderId());
		e.setOpTime(this.getOpTime());
		e.setIsValid(this.getIsValid());
		e.setBusinessId(this.getBusinessId());
		e.setObjectId(this.getObjectId());		
		return e;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getPackageId() {
		return this.packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Integer getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}
}