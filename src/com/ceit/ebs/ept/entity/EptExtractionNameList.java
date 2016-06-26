package com.ceit.ebs.ept.entity;


/**
 *@author gr
 *@date 2014-8-10 上午10:32:35
 */

public class EptExtractionNameList{

	// Fields

//	private Integer extractionNameListId;
//	private Integer extractionProgramId;
//	private Integer expertId;
//	private Integer projectId;
//	private Integer lockBeginDate;
//	private Integer lockEndDate;
//	private String toAttend;
//	private String notAttendReason;
//	private String optionUser;
//	private Integer opTime;
//	private String isValid;
//	private String expertUnit;
//	private String extractionTimes;
//	private String expertNotify;
//	private String isToNotify;
//	private Integer toNotifyTime;
//	private String isToConfirm;
//	private Integer toConfirmTime;
//	private String otherNoAttendReason;

	private Integer id;
	private Integer extractionNameListId;//专家抽取名单id
	private Integer extractionProgramId;//抽取方案编号
	private Integer expertId;//专家编号
	private Integer projectId;//项目id
	private Integer lockBeginDate;//锁定开始时间
	private Integer lockEndDate;//锁定结束时间
	private String toAttend;//出席情况 
	private String notAttendReason;//不参加原因
	private String optionUser;//操作人 
	private String opTime;//数据操作时间
	private String isValid;//数据是否有效可用
	private String expertUnit;//申报单位
	private String extractionTimes;//第几次抽取
	private String expertNotify;//通知情况
	private String isToNotify;//是否提交通知名单
	private Integer toNotifyTime;//提交通知名单时间
	private String isToConfirm;//是否提交名单确认
	private Integer toConfirmTime;//提交名单确认时间
	private String otherNoAttendReason;//其他项目不出席原因
	private Integer dispIndex;     //排序索引
	// Constructors

	/** default constructor */
	public EptExtractionNameList() {
	}

	// Property accessors

	public Integer getExtractionNameListId() {
		return this.extractionNameListId;
	}

	public void setExtractionNameListId(Integer extractionNameListId) {
		this.extractionNameListId = extractionNameListId;
	}

	public Integer getExtractionProgramId() {
		return this.extractionProgramId;
	}

	public void setExtractionProgramId(Integer extractionProgramId) {
		this.extractionProgramId = extractionProgramId;
	}

	public Integer getExpertId() {
		return this.expertId;
	}

	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getLockBeginDate() {
		return this.lockBeginDate;
	}

	public void setLockBeginDate(Integer lockBeginDate) {
		this.lockBeginDate = lockBeginDate;
	}

	public Integer getLockEndDate() {
		return this.lockEndDate;
	}

	public void setLockEndDate(Integer lockEndDate) {
		this.lockEndDate = lockEndDate;
	}

	public String getToAttend() {
		return this.toAttend;
	}

	public void setToAttend(String toAttend) {
		this.toAttend = toAttend;
	}

	public String getNotAttendReason() {
		return this.notAttendReason;
	}

	public void setNotAttendReason(String notAttendReason) {
		this.notAttendReason = notAttendReason;
	}

	public String getOptionUser() {
		return this.optionUser;
	}

	public void setOptionUser(String optionUser) {
		this.optionUser = optionUser;
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

	public String getExpertUnit() {
		return this.expertUnit;
	}

	public void setExpertUnit(String expertUnit) {
		this.expertUnit = expertUnit;
	}

	public String getExtractionTimes() {
		return this.extractionTimes;
	}

	public void setExtractionTimes(String extractionTimes) {
		this.extractionTimes = extractionTimes;
	}

	public String getExpertNotify() {
		return this.expertNotify;
	}

	public void setExpertNotify(String expertNotify) {
		this.expertNotify = expertNotify;
	}

	public String getIsToNotify() {
		return this.isToNotify;
	}

	public void setIsToNotify(String isToNotify) {
		this.isToNotify = isToNotify;
	}

	public Integer getToNotifyTime() {
		return this.toNotifyTime;
	}

	public void setToNotifyTime(Integer toNotifyTime) {
		this.toNotifyTime = toNotifyTime;
	}

	public String getIsToConfirm() {
		return this.isToConfirm;
	}

	public void setIsToConfirm(String isToConfirm) {
		this.isToConfirm = isToConfirm;
	}

	public Integer getToConfirmTime() {
		return this.toConfirmTime;
	}

	public void setToConfirmTime(Integer toConfirmTime) {
		this.toConfirmTime = toConfirmTime;
	}

	public String getOtherNoAttendReason() {
		return this.otherNoAttendReason;
	}

	public void setOtherNoAttendReason(String otherNoAttendReason) {
		this.otherNoAttendReason = otherNoAttendReason;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	
}