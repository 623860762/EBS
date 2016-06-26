package com.ceit.ebs.ebe.vo;


import com.ceit.ebs.ebe.entity.EbePackageInfo;

/**
 * EbePackageInfoVo 系统的评审产品构件的VO
 * @author czg
 * date 2014-8-8
 */
public class EbePackageInfoVo {

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
	public EbePackageInfoVo() {
	}

	/** minimal constructor */
	public EbePackageInfoVo(Integer id, Integer packageId, String packageName,
			Integer projectId) {
		this.id = id;
		this.packageId = packageId;
		this.packageName = packageName;
		this.projectId = projectId;
	}

	/** full constructor */
	public EbePackageInfoVo(Integer id, Integer packageId, String packageName,
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

	public EbePackageInfoVo(EbePackageInfo e){
		this.setId(e.getId());
		this.setPackageId(e.getPackageId());
		this.setPackageName(e.getPackageName());
		this.setProjectId(e.getProjectId());
		this.setProjectName(e.getProjectName());
		this.setObjectId(e.getObjectId());
		this.setObjectName(e.getObjectName());
		this.setAmout(e.getAmout());
		this.setUnit(e.getUnit());
		this.setIsFlowobject(e.getIsFlowobject());
		this.setRate(e.getRate());
		this.setOperUser(e.getOperUser());
		this.setOpTime(e.getOpTime());
		this.setTechWeight(e.getTechWeight());
		this.setBusiWeight(e.getBusiWeight());
		this.setPriceWeight(e.getPriceWeight());
		this.setHitcount(e.getHitcount());
		this.setIsValid(e.getIsValid());
		this.setAssessWeight(e.getAssessWeight());
		this.setBusinessId(e.getBusinessId());
		this.setDispIndex(e.getDispIndex());
	}
	
	//此方法将vo转为po
	public EbePackageInfo adapterToEbePackageInfo(){
		EbePackageInfo e = new EbePackageInfo();
		
		e.setId(this.getId());
		e.setPackageId(this.getPackageId());
		e.setPackageName(this.getPackageName());
		e.setProjectId(this.getProjectId());
		e.setProjectName(this.getProjectName());
		e.setObjectId(this.getObjectId());
		e.setObjectName(this.getObjectName());
		e.setAmout(this.getAmout());
		e.setUnit(this.getUnit());
		e.setIsFlowobject(this.getIsFlowobject());
		e.setRate(this.getRate());
		e.setOperUser(this.getOperUser());
		e.setOpTime(this.getOpTime());
		e.setTechWeight(this.getTechWeight());
		e.setBusiWeight(this.getBusiWeight());
		e.setPriceWeight(this.getPriceWeight());
		e.setHitcount(this.getHitcount());
		e.setIsValid(this.getIsValid());
		e.setAssessWeight(this.getAssessWeight());
		e.setBusinessId(this.getBusinessId());
		e.setDispIndex(this.getDispIndex());		
		return e;
	}	
	
	// Property accessors
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getAmout() {
		return amout;
	}

	public void setAmout(String amout) {
		this.amout = amout;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Boolean getIsFlowobject() {
		return isFlowobject;
	}

	public void setIsFlowobject(Boolean isFlowobject) {
		this.isFlowobject = isFlowobject;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getOperUser() {
		return operUser;
	}

	public void setOperUser(String operUser) {
		this.operUser = operUser;
	}

	public String getOpTime() {
		return opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public Integer getTechWeight() {
		return techWeight;
	}

	public void setTechWeight(Integer techWeight) {
		this.techWeight = techWeight;
	}

	public Integer getBusiWeight() {
		return busiWeight;
	}

	public void setBusiWeight(Integer busiWeight) {
		this.busiWeight = busiWeight;
	}

	public Integer getPriceWeight() {
		return priceWeight;
	}

	public void setPriceWeight(Integer priceWeight) {
		this.priceWeight = priceWeight;
	}

	public Integer getHitcount() {
		return hitcount;
	}

	public void setHitcount(Integer hitcount) {
		this.hitcount = hitcount;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Integer getAssessWeight() {
		return assessWeight;
	}

	public void setAssessWeight(Integer assessWeight) {
		this.assessWeight = assessWeight;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}
}