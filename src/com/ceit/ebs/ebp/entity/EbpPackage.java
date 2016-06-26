package com.ceit.ebs.ebp.entity;


/**
 * EbpObjectVo 系统的招标项目划分包信息构件的VO
 * @author czg
 * date 2014-8-9
 */

public class EbpPackage{

	// Fields

	private Integer id;                  //主键
	private Integer objectId;            //标ID      
	private Integer projectId;           //项目ID
	private String packageName;          //包名称
	private Integer chargePersonId;       //负责人id
	private Integer businessWeight;      //商务权重
	private Integer technicalWeight;     //技术权重
	private Integer priceWeight;         //价格权重
	private Integer creatorId;            //创建人编号
	private String createTime;          //创建时间
	private String updateTime;          //最后更新时间
	private Integer packageOrder;        //包排序
	private Integer packagePriceMethod;  //包报价方式（1、按行项目报价，2、总价）
	private String isValid;              //是否有效，真假删除，Y：是
	private String packageStatus;        //分包状态，审核中等等，根据枚举文件详细说明
	private String isProduct;            //是否已关联产品，Y：是
	private Integer packagePrice;        //包价格
	private Integer suppNum;   
	private Integer dispIndex;           //排序索引
	private String isOpenBid;             //是否开标设置



	/** default constructor */
	public EbpPackage() {
	}

	// Constructors


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Integer getChargePersonId() {
		return this.chargePersonId;
	}

	public void setChargePersonId(Integer chargePersonId) {
		this.chargePersonId = chargePersonId;
	}

	public Integer getBusinessWeight() {
		return this.businessWeight;
	}

	public void setBusinessWeight(Integer businessWeight) {
		this.businessWeight = businessWeight;
	}

	public Integer getTechnicalWeight() {
		return this.technicalWeight;
	}

	public void setTechnicalWeight(Integer technicalWeight) {
		this.technicalWeight = technicalWeight;
	}

	public Integer getPriceWeight() {
		return this.priceWeight;
	}

	public void setPriceWeight(Integer priceWeight) {
		this.priceWeight = priceWeight;
	}

	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getPackageOrder() {
		return this.packageOrder;
	}

	public void setPackageOrder(Integer packageOrder) {
		this.packageOrder = packageOrder;
	}

	public Integer getPackagePriceMethod() {
		return this.packagePriceMethod;
	}

	public void setPackagePriceMethod(Integer packagePriceMethod) {
		this.packagePriceMethod = packagePriceMethod;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getPackageStatus() {
		return this.packageStatus;
	}

	public void setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
	}

	public String getIsProduct() {
		return this.isProduct;
	}

	public void setIsProduct(String isProduct) {
		this.isProduct = isProduct;
	}

	public Integer getPackagePrice() {
		return this.packagePrice;
	}

	public void setPackagePrice(Integer packagePrice) {
		this.packagePrice = packagePrice;
	}

	public Integer getSuppNum() {
		return this.suppNum;
	}

	public void setSuppNum(Integer suppNum) {
		this.suppNum = suppNum;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}


	public String getIsOpenBid() {
		return isOpenBid;
	}


	public void setIsOpenBid(String isOpenBid) {
		this.isOpenBid = isOpenBid;
	}

}