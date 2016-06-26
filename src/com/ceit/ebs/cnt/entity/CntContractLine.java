package com.ceit.ebs.cnt.entity;


/**
 * CntContractLine entity. @author MyEclipse Persistence Tools
 */

public class CntContractLine implements java.io.Serializable {

	// Fields

	private Integer id;                       //主键
	private Integer lineSeq;                  //合同行项目号
	private Integer supplierId;                //供应商ID
	private String supplierName;              //供应商名称
	private Integer materielId;                //物料编码
	private String materialName;              //物料名称
	private String deliveryAddress;           //送货地点
	private Integer planDeliveryDate;         //约定到货时间
	private String bidPlanCode;               //招标计划编号
	private String demandPlanCode;            //需求计划编号
	private String reqDemandName;             //需求部门
	private String matModel;                  //型号
	private String matSpec;                   //规格
	private String matQuality;                //材质
	private String matStandard;               //标准
	private String dzUnit;                    //单重单位
	private String coefficient;               //系数
	private String conversionFormula;         //转换公式
	private String matUnit;                   //单位
	private Integer matAmount;                //数量
	private Integer taxUnitPrice;             //价格（单价）
	private Integer taxTotalPrice;            //总价
	private Integer createdDate;              //合同创建日期
	private String opTime;                   //最后操作时间
	private String partitionColumn;           //分区列
	private Integer customCompanyId;          //公司ID
	private String isValid;                   //是否可用  是否枚举  中有Y和N两种值 不然会报错
	private Integer bidResultId;              //中标结果记录ID
	private Integer dispIndex;                //排序索引

	// Constructors

	/** default constructor */
	public CntContractLine() {
	}

	/** minimal constructor */
	public CntContractLine(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public CntContractLine(Integer id, Integer lineSeq, Integer supplierId,
			String supplierName, Integer materielId, String materialName,
			String deliveryAddress, Integer planDeliveryDate,
			String bidPlanCode, String demandPlanCode, String reqDemandName,
			String matModel, String matSpec, String matQuality,
			String matStandard, String dzUnit, String coefficient,
			String conversionFormula, String matUnit, Integer matAmount,
			Integer taxUnitPrice, Integer taxTotalPrice, Integer createdDate,
			String opTime, String partitionColumn, Integer customCompanyId,
			String isValid, Integer bidResultId, Integer dispIndex) {
		this.id = id;
		this.lineSeq = lineSeq;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.materielId = materielId;
		this.materialName = materialName;
		this.deliveryAddress = deliveryAddress;
		this.planDeliveryDate = planDeliveryDate;
		this.bidPlanCode = bidPlanCode;
		this.demandPlanCode = demandPlanCode;
		this.reqDemandName = reqDemandName;
		this.matModel = matModel;
		this.matSpec = matSpec;
		this.matQuality = matQuality;
		this.matStandard = matStandard;
		this.dzUnit = dzUnit;
		this.coefficient = coefficient;
		this.conversionFormula = conversionFormula;
		this.matUnit = matUnit;
		this.matAmount = matAmount;
		this.taxUnitPrice = taxUnitPrice;
		this.taxTotalPrice = taxTotalPrice;
		this.createdDate = createdDate;
		this.opTime = opTime;
		this.partitionColumn = partitionColumn;
		this.customCompanyId = customCompanyId;
		this.isValid = isValid;
		this.bidResultId = bidResultId;
		this.dispIndex = dispIndex;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLineSeq() {
		return this.lineSeq;
	}

	public void setLineSeq(Integer lineSeq) {
		this.lineSeq = lineSeq;
	}

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Integer getMaterielId() {
		return this.materielId;
	}

	public void setMaterielId(Integer materielId) {
		this.materielId = materielId;
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getPlanDeliveryDate() {
		return this.planDeliveryDate;
	}

	public void setPlanDeliveryDate(Integer planDeliveryDate) {
		this.planDeliveryDate = planDeliveryDate;
	}

	public String getBidPlanCode() {
		return this.bidPlanCode;
	}

	public void setBidPlanCode(String bidPlanCode) {
		this.bidPlanCode = bidPlanCode;
	}

	public String getDemandPlanCode() {
		return this.demandPlanCode;
	}

	public void setDemandPlanCode(String demandPlanCode) {
		this.demandPlanCode = demandPlanCode;
	}

	public String getReqDemandName() {
		return this.reqDemandName;
	}

	public void setReqDemandName(String reqDemandName) {
		this.reqDemandName = reqDemandName;
	}

	public String getMatModel() {
		return this.matModel;
	}

	public void setMatModel(String matModel) {
		this.matModel = matModel;
	}

	public String getMatSpec() {
		return this.matSpec;
	}

	public void setMatSpec(String matSpec) {
		this.matSpec = matSpec;
	}

	public String getMatQuality() {
		return this.matQuality;
	}

	public void setMatQuality(String matQuality) {
		this.matQuality = matQuality;
	}

	public String getMatStandard() {
		return this.matStandard;
	}

	public void setMatStandard(String matStandard) {
		this.matStandard = matStandard;
	}

	public String getDzUnit() {
		return this.dzUnit;
	}

	public void setDzUnit(String dzUnit) {
		this.dzUnit = dzUnit;
	}

	public String getCoefficient() {
		return this.coefficient;
	}

	public void setCoefficient(String coefficient) {
		this.coefficient = coefficient;
	}

	public String getConversionFormula() {
		return this.conversionFormula;
	}

	public void setConversionFormula(String conversionFormula) {
		this.conversionFormula = conversionFormula;
	}

	public String getMatUnit() {
		return this.matUnit;
	}

	public void setMatUnit(String matUnit) {
		this.matUnit = matUnit;
	}

	public Integer getMatAmount() {
		return this.matAmount;
	}

	public void setMatAmount(Integer matAmount) {
		this.matAmount = matAmount;
	}

	public Integer getTaxUnitPrice() {
		return this.taxUnitPrice;
	}

	public void setTaxUnitPrice(Integer taxUnitPrice) {
		this.taxUnitPrice = taxUnitPrice;
	}

	public Integer getTaxTotalPrice() {
		return this.taxTotalPrice;
	}

	public void setTaxTotalPrice(Integer taxTotalPrice) {
		this.taxTotalPrice = taxTotalPrice;
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

	public String getPartitionColumn() {
		return this.partitionColumn;
	}

	public void setPartitionColumn(String partitionColumn) {
		this.partitionColumn = partitionColumn;
	}

	public Integer getCustomCompanyId() {
		return this.customCompanyId;
	}

	public void setCustomCompanyId(Integer customCompanyId) {
		this.customCompanyId = customCompanyId;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Integer getBidResultId() {
		return this.bidResultId;
	}

	public void setBidResultId(Integer bidResultId) {
		this.bidResultId = bidResultId;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}