package com.ceit.ebs.ept.vo;

import com.ceit.ebs.ept.entity.EptExpertBaseinfo;

/**
 *@author gr
 *@date 2014-8-10 上午10:45:57
 */

public class EptExpertBaseinfoVo{

	// Fields

	private Integer id;
	private String specialtyCode;	//专家来源 
//	private Integer eptOrg;				//专家级别（公共）
	private String expertSource;		//
	private String expertRate;			//
	private String expertName;			//姓名（公共）
	private String pinyinName;			//拼音姓名
	private String genderCode;			//性别（公共）
	private String birthDay;			//出生日期（公共）
	private String expertPhoto;			//照片
	private String expertCountry;		//国籍
	private String expertNationlity;	//民族
	private String expertOrigin;		//籍贯
	private String politicalStatus;		//政治面貌
	private String idType;				//证件类型 
	private String idNumber;			//证件号码
	private String cellPhone;			//手机号码
	private String communicationCity;	//居住地
	private String communicationAdd;	//通讯地址
	private String postalCode;			//邮政编码
	private String expertEmail;			//邮箱
	private String faxNumber;			//传真
	private String workUnits;
	private String workDept;			//工作部门
	private String workPhone;			//工作电话
	private String workDate;			//参加工作时间
	private Integer optionPerson;		//操作人
	private String opTime;				//数据操作时间
	private String isValid;				//是否有效：Y为有效，N为无效
	private String expertStatus;		//是否审核通过
	private String expStatus;			//专家状态 0 正常 1 冻结 2 注销
	private Integer expertLockPerson;	//冻结人
	private Integer expertLockTime;		//动结时间
	private Integer expertUnlockTime;	//解冻时间
	private Integer dispIndex;     //排序索引

	// Constructors

	/** default constructor */
	public EptExpertBaseinfoVo() {
	}
	
	public EptExpertBaseinfoVo(EptExpertBaseinfo p) {
		this.setId(p.getId());
		this.setSpecialtyCode(p.getSpecialtyCode());
//		this.setEptOrg(p.get);
		this.setExpertSource(p.getExpertSource());
		this.setExpertRate(p.getExpertRate());
		this.setExpertName(p.getExpertName());
		this.setPinyinName(p.getPinyinName());
		this.setGenderCode(p.getGenderCode());
		this.setBirthDay(p.getBirthDay());
		this.setExpertPhoto(p.getExpertPhoto());
		this.setExpertCountry(p.getExpertCountry());
		this.setExpertNationlity(p.getExpertNationlity());
		this.setExpertOrigin(p.getExpertOrigin());
		this.setPoliticalStatus(p.getPoliticalStatus());
		this.setIdType(p.getIdType());
		this.setIdNumber(p.getIdNumber());
		this.setCellPhone(p.getCellPhone());
		this.setCommunicationCity(p.getCommunicationCity());
		this.setCommunicationAdd(p.getCommunicationAdd());
		this.setPostalCode(p.getPostalCode());
		this.setExpertEmail(p.getExpertEmail());
		this.setFaxNumber(p.getFaxNumber());
		this.setWorkDept(p.getWorkDept());
		this.setWorkPhone(p.getWorkPhone());
		this.setWorkDate(p.getWorkDate());
		this.setOptionPerson(p.getOptionPersonId());
		this.setOpTime(p.getOpTime());
		this.setIsValid(p.getIsValid());
		this.setExpertStatus(p.getExpertStatus());
		this.setExpStatus(p.getExpStatus());
		this.setExpertLockPerson(p.getExpertLockPersonId());
		this.setExpertLockTime(p.getExpertLockTime());
		this.setExpertUnlockTime(p.getExpertUnlockTime());
//		this.setEptExtractionNameLists(p.getEptExtractionNameLists());
		this.setDispIndex(p.getDispIndex());
		this.setWorkUnits(p.getWorkUnits());
	}
	
	public EptExpertBaseinfo adapterToEptExpertBaseinfo(){
		EptExpertBaseinfo p = new EptExpertBaseinfo();
		p.setId(this.getId());
		p.setSpecialtyCode(this.getSpecialtyCode());
//		p.setEptOrg(this.getEptOrg());
		p.setExpertSource(this.getExpertSource());
		p.setExpertRate(this.getExpertRate());
		p.setExpertName(this.getExpertName());
		p.setPinyinName(this.getPinyinName());
		p.setGenderCode(this.getGenderCode());
		p.setBirthDay(this.getBirthDay());
		p.setExpertPhoto(this.getExpertPhoto());
		p.setExpertCountry(this.getExpertCountry());
		p.setExpertNationlity(this.getExpertNationlity());
		p.setExpertOrigin(this.getExpertOrigin());
		p.setPoliticalStatus(this.getPoliticalStatus());
		p.setIdType(this.getIdType());
		p.setIdNumber(this.getIdNumber());
		p.setCellPhone(this.getCellPhone());
		p.setCommunicationCity(this.getCommunicationCity());
		p.setCommunicationAdd(this.getCommunicationAdd());
		p.setPostalCode(this.getPostalCode());
		p.setExpertEmail(this.getExpertEmail());
		p.setFaxNumber(this.getFaxNumber());
		p.setWorkDept(this.getWorkDept());
		p.setWorkPhone(this.getWorkPhone());
		p.setWorkDate(this.getWorkDate());
		p.setOptionPersonId(this.getOptionPerson());
		p.setOpTime(this.getOpTime());
		p.setIsValid(this.getIsValid());
		p.setExpertStatus(this.getExpertStatus());
		p.setExpStatus(this.getExpStatus());
		p.setExpertLockPersonId(this.getExpertLockPerson());
		p.setExpertLockTime(this.getExpertLockTime());
		p.setExpertUnlockTime(this.getExpertUnlockTime());
//		p.setEptExtractionNameLists(this.getEptExtractionNameLists());
		p.setDispIndex(this.getDispIndex());
		p.setWorkUnits(this.getWorkUnits());
		return p;
	}

	// Property accessors

	public String getExpertSource() {
		return this.expertSource;
	}

	public void setExpertSource(String expertSource) {
		this.expertSource = expertSource;
	}

	public String getExpertRate() {
		return this.expertRate;
	}

	public void setExpertRate(String expertRate) {
		this.expertRate = expertRate;
	}

	public String getExpertName() {
		return this.expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public String getPinyinName() {
		return this.pinyinName;
	}

	public void setPinyinName(String pinyinName) {
		this.pinyinName = pinyinName;
	}

	public String getGenderCode() {
		return this.genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getExpertPhoto() {
		return this.expertPhoto;
	}

	public void setExpertPhoto(String expertPhoto) {
		this.expertPhoto = expertPhoto;
	}

	public String getExpertCountry() {
		return this.expertCountry;
	}

	public void setExpertCountry(String expertCountry) {
		this.expertCountry = expertCountry;
	}

	public String getExpertNationlity() {
		return this.expertNationlity;
	}

	public void setExpertNationlity(String expertNationlity) {
		this.expertNationlity = expertNationlity;
	}

	public String getExpertOrigin() {
		return this.expertOrigin;
	}

	public void setExpertOrigin(String expertOrigin) {
		this.expertOrigin = expertOrigin;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getCommunicationCity() {
		return this.communicationCity;
	}

	public void setCommunicationCity(String communicationCity) {
		this.communicationCity = communicationCity;
	}

	public String getCommunicationAdd() {
		return this.communicationAdd;
	}

	public void setCommunicationAdd(String communicationAdd) {
		this.communicationAdd = communicationAdd;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getExpertEmail() {
		return this.expertEmail;
	}

	public void setExpertEmail(String expertEmail) {
		this.expertEmail = expertEmail;
	}

	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	

	public String getWorkUnits() {
		return workUnits;
	}

	public void setWorkUnits(String workUnits) {
		this.workUnits = workUnits;
	}

	public String getWorkDept() {
		return this.workDept;
	}

	public void setWorkDept(String workDept) {
		this.workDept = workDept;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getWorkDate() {
		return this.workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public Integer getOptionPerson() {
		return this.optionPerson;
	}

	public void setOptionPerson(Integer optionPerson) {
		this.optionPerson = optionPerson;
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

	public String getExpertStatus() {
		return this.expertStatus;
	}

	public void setExpertStatus(String expertStatus) {
		this.expertStatus = expertStatus;
	}

	public String getExpStatus() {
		return this.expStatus;
	}

	public void setExpStatus(String expStatus) {
		this.expStatus = expStatus;
	}

	public Integer getExpertLockPerson() {
		return this.expertLockPerson;
	}

	public void setExpertLockPerson(Integer expertLockPerson) {
		this.expertLockPerson = expertLockPerson;
	}

	public Integer getExpertLockTime() {
		return this.expertLockTime;
	}

	public void setExpertLockTime(Integer expertLockTime) {
		this.expertLockTime = expertLockTime;
	}

	public Integer getExpertUnlockTime() {
		return this.expertUnlockTime;
	}

	public void setExpertUnlockTime(Integer expertUnlockTime) {
		this.expertUnlockTime = expertUnlockTime;
	}

	

	/**
	 * @return the specialtyCode
	 */
	public String getSpecialtyCode() {
		return specialtyCode;
	}

	/**
	 * @param specialtyCode the specialtyCode to set
	 */
	public void setSpecialtyCode(String specialtyCode) {
		this.specialtyCode = specialtyCode;
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
	

//	public void setEptOrg(Integer eptOrg) {
//		this.eptOrg = eptOrg;
//	}
	
	
}