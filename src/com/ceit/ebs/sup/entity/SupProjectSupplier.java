package com.ceit.ebs.sup.entity;

/**
 * SupProjectSupplier 系统的供应商与标关系构件
 * @author czg
 * date 2014-8-16
 */

public class SupProjectSupplier implements java.io.Serializable {

	// Fields

	private Integer id;         //主键
	private Integer projectId;  //项目ID
	private Integer objectId;   //标ID
	private Integer packageId;  //包ID
	private Integer supId;      //供应商ID
	private Integer payStatus;     //支付状态（0：未支付，1：已支付）
	private Integer isBid;         //是否投标（0：不投 ，1：投）
	private Integer isWinBid;      //是否中标（0：没中，1：中标）
	private Integer dispIndex;  //排序索引
	private String opTime;
	private String isValid;
	private Integer isLoad;         //是否已经下载招标文件（0：没有，1：是）

	// Constructors

	public Integer getIsLoad() {
		return isLoad;
	}

	public void setIsLoad(Integer isLoad) {
		this.isLoad = isLoad;
	}

	public String getOpTime() {
		return opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	/** default constructor */
	public SupProjectSupplier() {
	}

	// Property accessors

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

	public Integer getPackageId() {
		return this.packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public Integer getSupId() {
		return this.supId;
	}

	public void setSupId(Integer supId) {
		this.supId = supId;
	}

	public Integer getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getIsBid() {
		return this.isBid;
	}

	public void setIsBid(Integer isBid) {
		this.isBid = isBid;
	}

	public Integer getIsWinBid() {
		return this.isWinBid;
	}

	public void setIsWinBid(Integer isWinBid) {
		this.isWinBid = isWinBid;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}