package com.ceit.ebs.cnt.vo;

import com.ceit.ebs.cnt.entity.CntContract;

/**
 * CntContract entity. @author MyEclipse Persistence Tools
 */

public class CntContractVo implements java.io.Serializable {

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
	public CntContractVo(CntContract p) {
		this.setActualAmount(p.getActualAmount());
		this.setActualAmountUnit(p.getAdvanceAmountUnit());
		this.setAdvanceAmount(p.getAdvanceAmount());
		this.setAdvanceAmountUnit(p.getAdvanceAmountUnit());
		this.setBidPlanCode(p.getBidPlanCode());
		this.setBidResultId(p.getBidResultId());
		this.setContractAmount(p.getContractAmount());
		this.setContractAmountUnit(p.getContractAmountUnit());
		this.setContractCode(p.getContractCode());
		this.setId(p.getId());
		this.setContractName(p.getContractName());
		this.setContractSource(p.getContractSource());
		this.setContractStatus(p.getContractStatus());
		this.setContractType(p.getContractType());
		this.setCreatedDate(p.getCreatedDate());
		this.setIsUsedTemplate(p.getIsUsedTemplate());
		this.setIsValid(p.getIsValid());
		this.setNeedDepartment(p.getNeedDepartment());
		this.setOpTime(p.getOpTime());
		this.setPayWay(p.getPayWay());
		this.setProjectId(p.getProjectId());
		this.setProjectName(p.getProjectName());
		this.setProvinceCode(p.getProvinceCode());
		this.setProvinceName(p.getProvinceName());
		this.setRemark(p.getRemark());
		this.setSignatureDate(p.getSignatureDate());
		this.setSignaturePlace(p.getSignaturePlace());
		this.setTemplateId(p.getTemplateId());
		this.setUsedCurrency(p.getUsedCurrency());
		this.setValidateEnd(p.getValidateEnd());
		this.setValidateStart(p.getValidateStart());
		this.setWarrAmount(p.getWarrAmount());
		this.setWarrAmountUnit(p.getWarrAmountUnit());
		this.setWarrdataEnd(p.getWarrdataEnd());
		this.setWarrdataStart(p.getWarrdataStart());
		this.setDispIndex(p.getDispIndex());
	}
	
	public CntContract adapterToCntContract(){
		CntContract p = new CntContract();
		p.setActualAmount(this.getActualAmount());
		p.setActualAmountUnit(this.getAdvanceAmountUnit());
		p.setAdvanceAmount(this.getAdvanceAmount());
		p.setAdvanceAmountUnit(this.getAdvanceAmountUnit());
		p.setBidPlanCode(this.getBidPlanCode());
		p.setBidResultId(this.getBidResultId());
		p.setContractAmount(this.getContractAmount());
		p.setContractAmountUnit(this.getContractAmountUnit());
		p.setContractCode(this.getContractCode());
		p.setId(this.getId());
		p.setContractName(this.getContractName());
		p.setContractSource(this.getContractSource());
		p.setContractStatus(this.getContractStatus());
		p.setContractType(this.getContractType());
		p.setCreatedDate(this.getCreatedDate());
		p.setIsUsedTemplate(this.getIsUsedTemplate());
		p.setIsValid(this.getIsValid());
		p.setNeedDepartment(this.getNeedDepartment());
		p.setOpTime(this.getOpTime());
		p.setPayWay(this.getPayWay());
		p.setProjectId(this.getProjectId());
		p.setProjectName(this.getProjectName());
		p.setProvinceCode(this.getProvinceCode());
		p.setProvinceName(this.getProvinceName());
		p.setRemark(this.getRemark());
		p.setSignatureDate(this.getSignatureDate());
		p.setSignaturePlace(this.getSignaturePlace());
		p.setTemplateId(this.getTemplateId());
		p.setUsedCurrency(this.getUsedCurrency());
		p.setValidateEnd(this.getValidateEnd());
		p.setValidateStart(this.getValidateStart());
		p.setWarrAmount(this.getWarrAmount());
		p.setWarrAmountUnit(this.getWarrAmountUnit());
		p.setWarrdataEnd(this.getWarrdataEnd());
		p.setWarrdataStart(this.getWarrdataStart());
		p.setId(this.getId());
		return p;
		
	}
	
	

	/** default constructor */
	public CntContractVo() {
	}

	/** minimal constructor */
	public CntContractVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public CntContractVo(Integer id, String contractType, String contractSource,
			String contractName, String bidPlanCode, String provinceCode,
			String provinceName, Integer bidResultId, Integer templateId,
			String isUsedTemplate, String contractStatus,
			Integer signatureDate, String signaturePlace,
			String usedCurrency, Integer contractAmount, Integer actualAmount,
			Integer advanceAmount, Integer warrAmount, String payWay,
			Integer validateEnd, Integer validateStart,
			Integer warrdataStart, Integer warrdataEnd, Integer projectId,
			String projectName, String remark, Integer createdDate,
			String opTime, String isValid, String contractCode,
			String needDepartment, String contractAmountUnit,
			String actualAmountUnit, String advanceAmountUnit,
			String warrAmountUnit, Integer dispIndex) {
		this.id = id;
		this.contractType = contractType;
		this.contractSource = contractSource;
		this.contractName = contractName;
		this.bidPlanCode = bidPlanCode;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
		this.bidResultId = bidResultId;
		this.templateId = templateId;
		this.isUsedTemplate = isUsedTemplate;
		this.contractStatus = contractStatus;
		this.signatureDate = signatureDate;
		this.signaturePlace = signaturePlace;
		this.usedCurrency = usedCurrency;
		this.contractAmount = contractAmount;
		this.actualAmount = actualAmount;
		this.advanceAmount = advanceAmount;
		this.warrAmount = warrAmount;
		this.payWay = payWay;
		this.validateEnd = validateEnd;
		this.validateStart = validateStart;
		this.warrdataStart = warrdataStart;
		this.warrdataEnd = warrdataEnd;
		this.projectId = projectId;
		this.projectName = projectName;
		this.remark = remark;
		this.createdDate = createdDate;
		this.opTime = opTime;
		this.isValid = isValid;
		this.contractCode = contractCode;
		this.needDepartment = needDepartment;
		this.contractAmountUnit = contractAmountUnit;
		this.actualAmountUnit = actualAmountUnit;
		this.advanceAmountUnit = advanceAmountUnit;
		this.warrAmountUnit = warrAmountUnit;
		this.dispIndex = dispIndex;
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