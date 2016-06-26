package com.ceit.ebs.ebe.vo;


import com.ceit.ebs.ebe.entity.EbeProviderPackage;

/**
 * EbeProviderPackageVo 系统的包与供应商关系构件的VO
 * @author czg
 * date 2014-8-8
 */

public class EbeProviderPackageVo{

	// Fields

	private Integer id;  //主键
	private Integer projectId;         //项目ID 
	private String projectName;        //项目名称
	private Integer packageId;          //包ID
	private String packageName;        //包名称
	private Integer supplierId;         //供应商ID
	private String supplierName;       //供应商名称
	private Integer objectId;           //标ID
	private String objectName;         //标名称
	private Integer price;             //开标价格
	private Integer finishScore;       //供应商加权后的最终得分
	private Integer isGetbid;             //是否中标
	private Integer repealStatus;         //是否废标 1废标0不废标
	private Integer repealType;           //废标类型
	private Integer bePrice;           //评标总价
	private Integer sumSeq;            //总分排序值
	private Integer basePrice;         //基准价
	private Integer isModify;             //是否更改过中标人
	private String operUser;           //操作人
	private String opTime;            //操作时间
	private Integer techAvgScore;      //技术平均分
	private Integer busiAvgScore;      //商务平均分
	private Integer priceAvgScore;     //价格平均分
	private String isValid;            
	private Integer assessScore;       //后评估得分
	private Integer businessId;         //保留字段
	private Integer techJqScore;       //技术加权分
	private Integer busiJqScore;       //商务加权分 
	private Integer priceJqScore;      //价格加权分
	private Integer assessJqScore;     //后评估得分
	private Integer dispIndex;         //排序索引

	// Constructors

	public EbeProviderPackageVo() {
	}

	/** minimal constructor */
	public EbeProviderPackageVo(Integer id, Integer packageId) {
		this.id = id;
		this.packageId = packageId;
	}

	/** full constructor */
	public EbeProviderPackageVo(Integer id, Integer packageId, String packageName,
			Integer supplierId, String supplierName, Integer projectId,
			String projectName, Integer objectId, String objectName, Integer price,
			Integer finishScore, Integer isGetbid, Integer repealStatus,
			Integer repealType, Integer bePrice, Integer sumSeq, Integer basePrice,
			Integer isModify, String operUser, String opTime, Integer techAvgScore,
			Integer busiAvgScore, Integer priceAvgScore, String isValid,
			Integer assessScore, Integer businessId, Integer techJqScore,
			Integer busiJqScore, Integer priceJqScore, Integer assessJqScore,
			Integer dispIndex) {
		this.id = id;
		this.packageId = packageId;
		this.packageName = packageName;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.projectId = projectId;
		this.projectName = projectName;
		this.objectId = objectId;
		this.objectName = objectName;
		this.price = price;
		this.finishScore = finishScore;
		this.isGetbid = isGetbid;
		this.repealStatus = repealStatus;
		this.repealType = repealType;
		this.bePrice = bePrice;
		this.sumSeq = sumSeq;
		this.basePrice = basePrice;
		this.isModify = isModify;
		this.operUser = operUser;
		this.opTime = opTime;
		this.techAvgScore = techAvgScore;
		this.busiAvgScore = busiAvgScore;
		this.priceAvgScore = priceAvgScore;
		this.isValid = isValid;
		this.assessScore = assessScore;
		this.businessId = businessId;
		this.techJqScore = techJqScore;
		this.busiJqScore = busiJqScore;
		this.priceJqScore = priceJqScore;
		this.assessJqScore = assessJqScore;
		this.dispIndex = dispIndex;
	}
	
	//po->vo
	public EbeProviderPackageVo(EbeProviderPackage e){
		this.setId(e.getId());
		this.setPackageId(e.getPackageId());
		this.setPackageName(e.getPackageName());
		this.setSupplierId(e.getSupplierId());
		this.setSupplierName(e.getSupplierName());
		this.setProjectId(e.getProjectId());
		this.setProjectName(e.getProjectName());
		this.setObjectId(e.getObjectId());
		this.setObjectName(e.getObjectName());
		this.setPrice(e.getPrice());
		this.setFinishScore(e.getFinishScore());
		this.setIsGetbid(e.getIsGetbid());
		this.setRepealStatus(e.getRepealStatus());
		this.setRepealType(e.getRepealType());
		this.setBePrice(e.getBePrice());
		this.setSumSeq(e.getSumSeq());
		this.setBasePrice(e.getBasePrice());
		this.setIsModify(e.getIsModify());
		this.setOperUser(e.getOperUser());
		this.setOpTime(e.getOpTime());
		this.setTechAvgScore(e.getTechAvgScore());
		this.setBusiAvgScore(e.getBusiAvgScore());
		this.setPriceAvgScore(e.getPriceAvgScore());
		this.setIsValid(e.getIsValid());
		this.setAssessScore(e.getAssessScore());
		this.setBusinessId(e.getBusinessId());
		this.setTechJqScore(e.getTechJqScore());
		this.setBusiJqScore(e.getBusiJqScore());
		this.setPriceJqScore(e.getPriceJqScore());
		this.setAssessJqScore(e.getAssessJqScore());
		this.setDispIndex(e.getDispIndex());
	}
	
	//此方法将vo转为po
	public  EbeProviderPackage adapterToEbeProviderPackage(){
		EbeProviderPackage e = new EbeProviderPackage();
		e.setId(this.getId());
		e.setPackageId(this.getPackageId());
		e.setPackageName(this.getPackageName());
		e.setSupplierId(this.getSupplierId());
		e.setSupplierName(this.getSupplierName());
		e.setProjectId(this.getProjectId());
		e.setProjectName(this.getProjectName());
		e.setObjectId(this.getObjectId());
		e.setObjectName(this.getObjectName());
		e.setPrice(this.getPrice());
		e.setFinishScore(this.getFinishScore());
		e.setIsGetbid(this.getIsGetbid());
		e.setRepealStatus(this.getRepealStatus());
		e.setRepealType(this.getRepealType());
		e.setBePrice(this.getBePrice());
		e.setSumSeq(this.getSumSeq());
		e.setBasePrice(this.getBasePrice());
		e.setIsModify(this.getIsModify());
		e.setOperUser(this.getOperUser());
		e.setOpTime(this.getOpTime());
		e.setTechAvgScore(this.getTechAvgScore());
		e.setBusiAvgScore(this.getBusiAvgScore());
		e.setPriceAvgScore(this.getPriceAvgScore());
		e.setIsValid(this.getIsValid());
		e.setAssessScore(this.getAssessScore());
		e.setBusinessId(this.getBusinessId());
		e.setTechJqScore(this.getTechJqScore());
		e.setBusiJqScore(this.getBusiJqScore());
		e.setPriceJqScore(this.getPriceJqScore());
		e.setAssessJqScore(this.getAssessJqScore());
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

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getFinishScore() {
		return finishScore;
	}

	public void setFinishScore(Integer finishScore) {
		this.finishScore = finishScore;
	}

	public Integer getIsGetbid() {
		return isGetbid;
	}

	public void setIsGetbid(Integer isGetbid) {
		this.isGetbid = isGetbid;
	}

	public Integer getRepealStatus() {
		return repealStatus;
	}

	public void setRepealStatus(Integer repealStatus) {
		this.repealStatus = repealStatus;
	}

	public Integer getRepealType() {
		return repealType;
	}

	public void setRepealType(Integer repealType) {
		this.repealType = repealType;
	}

	public Integer getBePrice() {
		return bePrice;
	}

	public void setBePrice(Integer bePrice) {
		this.bePrice = bePrice;
	}

	public Integer getSumSeq() {
		return sumSeq;
	}

	public void setSumSeq(Integer sumSeq) {
		this.sumSeq = sumSeq;
	}

	public Integer getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}

	public Integer getIsModify() {
		return isModify;
	}

	public void setIsModify(Integer isModify) {
		this.isModify = isModify;
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

	public Integer getTechAvgScore() {
		return techAvgScore;
	}

	public void setTechAvgScore(Integer techAvgScore) {
		this.techAvgScore = techAvgScore;
	}

	public Integer getBusiAvgScore() {
		return busiAvgScore;
	}

	public void setBusiAvgScore(Integer busiAvgScore) {
		this.busiAvgScore = busiAvgScore;
	}

	public Integer getPriceAvgScore() {
		return priceAvgScore;
	}

	public void setPriceAvgScore(Integer priceAvgScore) {
		this.priceAvgScore = priceAvgScore;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Integer getAssessScore() {
		return assessScore;
	}

	public void setAssessScore(Integer assessScore) {
		this.assessScore = assessScore;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public Integer getTechJqScore() {
		return techJqScore;
	}

	public void setTechJqScore(Integer techJqScore) {
		this.techJqScore = techJqScore;
	}

	public Integer getBusiJqScore() {
		return busiJqScore;
	}

	public void setBusiJqScore(Integer busiJqScore) {
		this.busiJqScore = busiJqScore;
	}

	public Integer getPriceJqScore() {
		return priceJqScore;
	}

	public void setPriceJqScore(Integer priceJqScore) {
		this.priceJqScore = priceJqScore;
	}

	public Integer getAssessJqScore() {
		return assessJqScore;
	}

	public void setAssessJqScore(Integer assessJqScore) {
		this.assessJqScore = assessJqScore;
	}

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}
}