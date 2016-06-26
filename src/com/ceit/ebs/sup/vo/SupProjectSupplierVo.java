package com.ceit.ebs.sup.vo;

import com.ceit.ebs.sup.entity.SupProjectSupplier;


/**
 * SupProjectSupplierVo 系统的供应商与标关系构件Vo
 * @author czg
 * date 2014-8-16
 */

public class SupProjectSupplierVo implements java.io.Serializable {

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
	public SupProjectSupplierVo() {
	}


	//po->vo
  	public SupProjectSupplierVo(SupProjectSupplier e){
  		this.setId(e.getId());
		this.setProjectId(e.getProjectId());
		this.setObjectId(e.getObjectId());
		this.setPackageId(e.getPackageId());
		this.setSupId(e.getSupId());
		this.setPayStatus(e.getPayStatus());
		this.setIsBid(e.getIsBid());
		this.setIsWinBid(e.getIsWinBid());
		this.setDispIndex(e.getDispIndex());
		this.setOpTime(e.getOpTime());
		this.setIsValid(e.getIsValid());
		this.setIsLoad(e.getIsLoad());
  	}
  	
  	//此方法将vo转为po
  	public SupProjectSupplier adapterToSupProjectSupplier(){
  		SupProjectSupplier e = new SupProjectSupplier();
  		e.setId(this.getId());
		e.setProjectId(this.getProjectId());
		e.setObjectId(this.getObjectId());
		e.setPackageId(this.getPackageId());
		e.setSupId(this.getSupId());
		e.setPayStatus(this.getPayStatus());
		e.setIsBid(this.getIsBid());
		e.setIsWinBid(this.getIsWinBid());
		e.setDispIndex(this.getDispIndex());
		e.setOpTime(this.getOpTime());
		e.setIsValid(this.getIsValid());
		e.setIsLoad(this.getIsLoad());
  		return e;
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

	public Integer getIsLoad() {
		return isLoad;
	}

	public void setIsLoad(Integer isLoad) {
		this.isLoad = isLoad;
	}

}