package com.ceit.ebs.ebe.entity;


/**
 * EbePackageInfo 系统的评审产品构件
 * @author czg
 * date 2014-8-8
 */

public class EbePackageInfo implements java.io.Serializable {

	// Fields

	private Integer id;   //评审产品ID
	private Integer packageId;       //包ID
	private String packageName;     //包名称
	private Integer projectId;       //项目ID
	private String projectName;     //项目名称
	private Integer objectId;        //标ID
	private String objectName;      //标名称
	private String amout;           //数量
	private String unit;            //单位
	private Boolean isFlowobject;   //是否流标
	private String rate;            //中选比例
	private String operUser;        //操作人
	private String opTime;         //操作时间
	private Integer techWeight;     //技术权重
	private Integer busiWeight;     //商务权重
	private Integer priceWeight;    //价格权重
	private Integer hitcount;       
	private String isValid;         //是否有效
	private Integer assessWeight;   //后评估权重
	private Integer businessId;     //业务ID
	private Integer dispIndex;      //排序索引 

	// Constructors

	/** default constructor */
	public EbePackageInfo() {
	}

	/** minimal constructor */
	public EbePackageInfo(Integer id, Integer packageId, String packageName,
			Integer projectId) {
		this.id = id;
		this.packageId = packageId;
		this.packageName = packageName;
		this.projectId = projectId;
	}

	/** full constructor */
	public EbePackageInfo(Integer id, Integer packageId, String packageName,
			Integer projectId, String projectName, Integer objectId,
			String objectName, String amout, String unit, Boolean isFlowobject,
			String rate, String operUser, String opTime, Integer techWeight,
			Integer busiWeight, Integer priceWeight, Integer hitcount,
			String isValid, Integer assessWeight, Integer businessId, Integer dispIndex) {
		this.id = id;
		this.packageId = packageId;
		this.packageName = packageName;
		this.projectId = projectId;
		this.projectName = projectName;
		this.objectId = objectId;
		this.objectName = objectName;
		this.amout = amout;
		this.unit = unit;
		this.isFlowobject = isFlowobject;
		this.rate = rate;
		this.operUser = operUser;
		this.opTime = opTime;
		this.techWeight = techWeight;
		this.busiWeight = busiWeight;
		this.priceWeight = priceWeight;
		this.hitcount = hitcount;
		this.isValid = isValid;
		this.assessWeight = assessWeight;
		this.businessId = businessId;
		this.dispIndex = dispIndex;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPackageId() {
		return this.packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
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

	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public String getObjectName() {
		return this.objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getAmout() {
		return this.amout;
	}

	public void setAmout(String amout) {
		this.amout = amout;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Boolean getIsFlowobject() {
		return this.isFlowobject;
	}

	public void setIsFlowobject(Boolean isFlowobject) {
		this.isFlowobject = isFlowobject;
	}

	public String getRate() {
		return this.rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getOperUser() {
		return this.operUser;
	}

	public void setOperUser(String operUser) {
		this.operUser = operUser;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public Integer getTechWeight() {
		return this.techWeight;
	}

	public void setTechWeight(Integer techWeight) {
		this.techWeight = techWeight;
	}

	public Integer getBusiWeight() {
		return this.busiWeight;
	}

	public void setBusiWeight(Integer busiWeight) {
		this.busiWeight = busiWeight;
	}

	public Integer getPriceWeight() {
		return this.priceWeight;
	}

	public void setPriceWeight(Integer priceWeight) {
		this.priceWeight = priceWeight;
	}

	public Integer getHitcount() {
		return this.hitcount;
	}

	public void setHitcount(Integer hitcount) {
		this.hitcount = hitcount;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Integer getAssessWeight() {
		return this.assessWeight;
	}

	public void setAssessWeight(Integer assessWeight) {
		this.assessWeight = assessWeight;
	}

	public Integer getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}