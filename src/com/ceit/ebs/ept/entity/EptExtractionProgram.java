package com.ceit.ebs.ept.entity;


/**
 *@author gr
 *@date 2014-8-10 上午10:32:54
 */

public class EptExtractionProgram{

	// Fields

//	private Integer extractionProgramId;
//	private Integer projectId;
//	private String extractionUnit;
//	private String extractionArea;
//	private String judgeMajor;
//	private String produceMethod;
//	private Integer totalUserNumber;
//	private String expertRate;
//	private String orgAvoid;
//	private String selectProportion;
//	private String programStatus;
//	private String monitorName;
//	private String isMonitor;
//	private String actualExtractionNum;
//	private String isExtraction;
//	private String isSetagainExtractionProgram;
//	private String optionUser;
//	private Integer opTime;
//	private String isValid;
//	private String purchaseNo;
//	private String techName;
//	private String checkName;
//	private String provideExtractionNum;
//	private String maxExtractionNum;
//	private String extractionTimes;
//	private String expertArea;
//	private String expertAvoidArea;

	
	private Integer id;//抽取方案编号
	private Integer projectId;//项目id
	private String extractionUnit;//抽取单位
	private String extractionArea;//抽取区域
	private String judgeMajor;//评审专业
	private String produceMethod;//产生方式
	private Integer totalUserNumber;//需求人数
	private String expertRate;//专家等级
	private String orgAvoid;//组织机构回避
	private String selectProportion;//正备选比例
	private String programStatus;//方案状态
	private String monitorName;//监察人员姓名
	private String isMonitor;//监察人员是否在线
	private String actualExtractionNum;//实际抽取人数
	private String isExtraction;//是否已抽取
	private String isSetagainExtractionProgram;//是否已设置再次抽取方案
	private String optionUser;//操作人
	private String opTime;//数据操作时间
	private String isValid;//数据是否有效可用
	private String purchaseNo;//采购编号
	private String techName;//专业技术资格职称
	private String checkName;//方案审阅人
	private String provideExtractionNum;//可供抽取人数
	private String maxExtractionNum;//最大抽取人数
	private String extractionTimes;//抽取次数
	private String expertArea;//专家所在区域
	private String expertAvoidArea;//专家回避区域
	private Integer dispIndex;     //排序索引
	// Constructors

	/** default constructor */
	public EptExtractionProgram() {
	}

	/** minimal constructor */
	public EptExtractionProgram(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EptExtractionProgram(Integer id, Integer projectId,
			String extractionUnit, String extractionArea, String judgeMajor,
			String produceMethod, Integer totalUserNumber,
			String expertRate, String orgAvoid, String selectProportion,
			String programStatus, String monitorName, String isMonitor,
			String actualExtractionNum, String isExtraction,
			String isSetagainExtractionProgram, String optionUser,
			String opTime, String isValid, String purchaseNo,
			String techName, String checkName, String provideExtractionNum,
			String maxExtractionNum, String extractionTimes, String expertArea,
			String expertAvoidArea) {
		this.id = id;
		this.projectId = projectId;
		this.extractionUnit = extractionUnit;
		this.extractionArea = extractionArea;
		this.judgeMajor = judgeMajor;
		this.produceMethod = produceMethod;
		this.totalUserNumber = totalUserNumber;
		this.expertRate = expertRate;
		this.orgAvoid = orgAvoid;
		this.selectProportion = selectProportion;
		this.programStatus = programStatus;
		this.monitorName = monitorName;
		this.isMonitor = isMonitor;
		this.actualExtractionNum = actualExtractionNum;
		this.isExtraction = isExtraction;
		this.isSetagainExtractionProgram = isSetagainExtractionProgram;
		this.optionUser = optionUser;
		this.opTime = opTime;
		this.isValid = isValid;
		this.purchaseNo = purchaseNo;
		this.techName = techName;
		this.checkName = checkName;
		this.provideExtractionNum = provideExtractionNum;
		this.maxExtractionNum = maxExtractionNum;
		this.extractionTimes = extractionTimes;
		this.expertArea = expertArea;
		this.expertAvoidArea = expertAvoidArea;
	}

	// Property accessors

	

	public Integer getProjectId() {
		return this.projectId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getExtractionUnit() {
		return this.extractionUnit;
	}

	public void setExtractionUnit(String extractionUnit) {
		this.extractionUnit = extractionUnit;
	}

	public String getExtractionArea() {
		return this.extractionArea;
	}

	public void setExtractionArea(String extractionArea) {
		this.extractionArea = extractionArea;
	}

	public String getJudgeMajor() {
		return this.judgeMajor;
	}

	public void setJudgeMajor(String judgeMajor) {
		this.judgeMajor = judgeMajor;
	}

	public String getProduceMethod() {
		return this.produceMethod;
	}

	public void setProduceMethod(String produceMethod) {
		this.produceMethod = produceMethod;
	}

	public Integer getTotalUserNumber() {
		return this.totalUserNumber;
	}

	public void setTotalUserNumber(Integer totalUserNumber) {
		this.totalUserNumber = totalUserNumber;
	}

	public String getExpertRate() {
		return this.expertRate;
	}

	public void setExpertRate(String expertRate) {
		this.expertRate = expertRate;
	}

	public String getOrgAvoid() {
		return this.orgAvoid;
	}

	public void setOrgAvoid(String orgAvoid) {
		this.orgAvoid = orgAvoid;
	}

	public String getSelectProportion() {
		return this.selectProportion;
	}

	public void setSelectProportion(String selectProportion) {
		this.selectProportion = selectProportion;
	}

	public String getProgramStatus() {
		return this.programStatus;
	}

	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}

	public String getMonitorName() {
		return this.monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getIsMonitor() {
		return this.isMonitor;
	}

	public void setIsMonitor(String isMonitor) {
		this.isMonitor = isMonitor;
	}

	public String getActualExtractionNum() {
		return this.actualExtractionNum;
	}

	public void setActualExtractionNum(String actualExtractionNum) {
		this.actualExtractionNum = actualExtractionNum;
	}

	public String getIsExtraction() {
		return this.isExtraction;
	}

	public void setIsExtraction(String isExtraction) {
		this.isExtraction = isExtraction;
	}

	public String getIsSetagainExtractionProgram() {
		return this.isSetagainExtractionProgram;
	}

	public void setIsSetagainExtractionProgram(
			String isSetagainExtractionProgram) {
		this.isSetagainExtractionProgram = isSetagainExtractionProgram;
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

	public String getPurchaseNo() {
		return this.purchaseNo;
	}

	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public String getTechName() {
		return this.techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getCheckName() {
		return this.checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getProvideExtractionNum() {
		return this.provideExtractionNum;
	}

	public void setProvideExtractionNum(String provideExtractionNum) {
		this.provideExtractionNum = provideExtractionNum;
	}

	public String getMaxExtractionNum() {
		return this.maxExtractionNum;
	}

	public void setMaxExtractionNum(String maxExtractionNum) {
		this.maxExtractionNum = maxExtractionNum;
	}

	public String getExtractionTimes() {
		return this.extractionTimes;
	}

	public void setExtractionTimes(String extractionTimes) {
		this.extractionTimes = extractionTimes;
	}

	public String getExpertArea() {
		return this.expertArea;
	}

	public void setExpertArea(String expertArea) {
		this.expertArea = expertArea;
	}

	public String getExpertAvoidArea() {
		return this.expertAvoidArea;
	}

	public void setExpertAvoidArea(String expertAvoidArea) {
		this.expertAvoidArea = expertAvoidArea;
	}
	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}