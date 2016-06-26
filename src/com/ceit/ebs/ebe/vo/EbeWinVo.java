package com.ceit.ebs.ebe.vo;

import com.ceit.ebs.ebe.entity.EbeWin;


/**
 * EbeWinVo 系统的定标的VO
 * @author czg
 * date 2014-8-8
 */

public class EbeWinVo{

	// Fields

	private Integer id;            //主键
	private Integer packageId;     //包ID
	private Integer projectId;      //项目ID
	private Integer winProportion; //中标比例
	private String isValid;        //是否有效
	private Integer providerId;     //供应商ID
	private Integer objectId;       //标ID
	private String opTime;        //操作时间
	private Integer dispIndex;     //排序索引

	// Constructors

	/** default constructor */
	/** default constructor */
	public EbeWinVo() {
	}

	/** minimal constructor */
	public EbeWinVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public EbeWinVo(Integer id, Integer projectId, Integer winProportion,
			Integer packageId, String isValid, Integer providerId, Integer objectId,
			String opTime, Integer dispIndex) {
		this.id = id;
		this.projectId = projectId;
		this.winProportion = winProportion;
		this.packageId = packageId;
		this.isValid = isValid;
		this.providerId = providerId;
		this.objectId = objectId;
		this.opTime = opTime;
		this.dispIndex = dispIndex;
	}
	
	//po->vo
	public EbeWinVo(EbeWin e){
		this.setId(e.getId());
		this.setPackageId(e.getPackageId());
		this.setProjectId(e.getProjectId());
		this.setWinProportion(e.getWinProportion());
		this.setIsValid(e.getIsValid());
		this.setProviderId(e.getProviderId());
		this.setObjectId(e.getObjectId());
		this.setOpTime(e.getOpTime());
		this.setDispIndex(e.getDispIndex());
	}
	
	//此方法将vo转为po
	public EbeWin adapterToEbeWin(){
		EbeWin e = new EbeWin();
		e.setId(this.getId());
		e.setPackageId(this.getPackageId());
		e.setProjectId(this.getProjectId());
		e.setWinProportion(this.getWinProportion());
		e.setIsValid(this.getIsValid());
		e.setProviderId(this.getProviderId());
		e.setObjectId(this.getObjectId());
		e.setOpTime(this.getOpTime());
		e.setDispIndex(this.getDispIndex());
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

	public Integer getWinProportion() {
		return this.winProportion;
	}

	public void setWinProportion(Integer winProportion) {
		this.winProportion = winProportion;
	}

	public Integer getPackageId() {
		return this.packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}