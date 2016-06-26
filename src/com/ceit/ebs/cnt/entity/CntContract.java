package com.ceit.ebs.cnt.entity;


/**
 * CntContract entity. @author MyEclipse Persistence Tools
 */

public class CntContract{

	// Fields

	private Integer id;                          //合同标识符
	private String contractType;                 //合同类型
	private String contractSource;               //合同来源，0--手工录入，1--招标流转
	private String contractName;                 //合同名称
	private String bidPlanCode;                  //招标计划编号
	private String provinceCode;                 //需求省编码
	private String provinceName;                 //需求省名称
	private Integer bidResultId;                  //中标结果记录ID
	private Integer templateId;                   //合同模板编号
	private String isUsedTemplate;               //是否使用合同模板，Y/N
	private String contractStatus;               //合同状态
	private Integer signatureDate;               //合同签订日期
	private String signaturePlace;               //签订地点
	private String usedCurrency;                 //币种
	private Integer contractAmount;              //合同金额
	private Integer actualAmount;                //实际金额
	private Integer advanceAmount;               //预付款金额
	private Integer warrAmount;                  //质保金额
	private String payWay;                       //付款方式
	private Integer validateEnd;                 //合同期限截止日期
	private Integer validateStart;               //合同期限开始日期
	private Integer warrdataStart;               //质保金期限开始时间
	private Integer warrdataEnd;                 //质保金期限结束时间
	private Integer projectId;                    //项目ID
	private String projectName;                  //项目名称
	private String remark;                       //备注
	private Integer createdDate;                 //合同创建日期
	private String opTime;                      //最后操作时间
	private String isValid;                      //是否可用  是否枚举  中有Y和N两种值 不然会报错
	private String contractCode;                 //合同编号
	private String needDepartment;               //需求部门(ect_cn_project)
	private String contractAmountUnit;           //合同金额单位
	private String actualAmountUnit;             //实际金额单位
	private String advanceAmountUnit;            //预付款金额单位
	private String warrAmountUnit;               //质保金额单位
	private Integer dispIndex;                   //排序索引

	// Constructors

	/** default constructor */
	public CntContract() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContractType() {
		return this.contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getContractSource() {
		return this.contractSource;
	}

	public void setContractSource(String contractSource) {
		this.contractSource = contractSource;
	}

	public String getContractName() {
		return this.contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getBidPlanCode() {
		return this.bidPlanCode;
	}

	public void setBidPlanCode(String bidPlanCode) {
		this.bidPlanCode = bidPlanCode;
	}

	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Integer getBidResultId() {
		return this.bidResultId;
	}

	public void setBidResultId(Integer bidResultId) {
		this.bidResultId = bidResultId;
	}

	public Integer getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public String getIsUsedTemplate() {
		return this.isUsedTemplate;
	}

	public void setIsUsedTemplate(String isUsedTemplate) {
		this.isUsedTemplate = isUsedTemplate;
	}

	public String getContractStatus() {
		return this.contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public Integer getSignatureDate() {
		return this.signatureDate;
	}

	public void setSignatureDate(Integer signatureDate) {
		this.signatureDate = signatureDate;
	}

	public String getSignaturePlace() {
		return this.signaturePlace;
	}

	public void setSignaturePlace(String signaturePlace) {
		this.signaturePlace = signaturePlace;
	}

	public String getUsedCurrency() {
		return this.usedCurrency;
	}

	public void setUsedCurrency(String usedCurrency) {
		this.usedCurrency = usedCurrency;
	}

	public Integer getContractAmount() {
		return this.contractAmount;
	}

	public void setContractAmount(Integer contractAmount) {
		this.contractAmount = contractAmount;
	}

	public Integer getActualAmount() {
		return this.actualAmount;
	}

	public void setActualAmount(Integer actualAmount) {
		this.actualAmount = actualAmount;
	}

	public Integer getAdvanceAmount() {
		return this.advanceAmount;
	}

	public void setAdvanceAmount(Integer advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public Integer getWarrAmount() {
		return this.warrAmount;
	}

	public void setWarrAmount(Integer warrAmount) {
		this.warrAmount = warrAmount;
	}

	public String getPayWay() {
		return this.payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public Integer getValidateEnd() {
		return this.validateEnd;
	}

	public void setValidateEnd(Integer validateEnd) {
		this.validateEnd = validateEnd;
	}

	public Integer getValidateStart() {
		return this.validateStart;
	}

	public void setValidateStart(Integer validateStart) {
		this.validateStart = validateStart;
	}

	public Integer getWarrdataStart() {
		return this.warrdataStart;
	}

	public void setWarrdataStart(Integer warrdataStart) {
		this.warrdataStart = warrdataStart;
	}

	public Integer getWarrdataEnd() {
		return this.warrdataEnd;
	}

	public void setWarrdataEnd(Integer warrdataEnd) {
		this.warrdataEnd = warrdataEnd;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Integer createdDate) {
		this.createdDate = createdDate;
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

	public String getContractCode() {
		return this.contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getNeedDepartment() {
		return this.needDepartment;
	}

	public void setNeedDepartment(String needDepartment) {
		this.needDepartment = needDepartment;
	}

	public String getContractAmountUnit() {
		return this.contractAmountUnit;
	}

	public void setContractAmountUnit(String contractAmountUnit) {
		this.contractAmountUnit = contractAmountUnit;
	}

	public String getActualAmountUnit() {
		return this.actualAmountUnit;
	}

	public void setActualAmountUnit(String actualAmountUnit) {
		this.actualAmountUnit = actualAmountUnit;
	}

	public String getAdvanceAmountUnit() {
		return this.advanceAmountUnit;
	}

	public void setAdvanceAmountUnit(String advanceAmountUnit) {
		this.advanceAmountUnit = advanceAmountUnit;
	}

	public String getWarrAmountUnit() {
		return this.warrAmountUnit;
	}

	public void setWarrAmountUnit(String warrAmountUnit) {
		this.warrAmountUnit = warrAmountUnit;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}