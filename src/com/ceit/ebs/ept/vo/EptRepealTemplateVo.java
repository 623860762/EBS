package com.ceit.ebs.ept.vo;

import com.ceit.ebs.ept.entity.EptRepealTemplate;

/**
 *@author gr
 *@date 2014-8-10 下午02:43:37
 */

public class EptRepealTemplateVo {

	// Fields

	private Integer id;//id
	private String repealTemplateName;//名称
	private String repealTemplateType;//类型
	private Integer fileId;//关联文件主键
	private Integer createUserId;//创建人
	private Integer createTime;//创建时间
	private Integer opUserId;//修改人
	private String opTime;//修改时间
	private String isValid;
	private String repealResoun;//弃标原因
	private String fileRequire;//招标文件规定
	private String fileRelpy;//投标文件响应
	private Integer dispIndex;     //排序索引
//	private Set ebeRepeals = new HashSet(0);

	// Constructors

	/** default constructor */
	public EptRepealTemplateVo() {
	}

	public EptRepealTemplateVo(EptRepealTemplate p) {
		this.setCreateTime(p.getCreateTime());
		this.setCreateUserId(p.getCreateUserId());
//		this.setEbeRepeals(p.getEbeRepeals());
		this.setFileId(p.getFileId());
		this.setFileRelpy(p.getFileRelpy());
		this.setFileRequire(p.getFileRequire());
		this.setIsValid(p.getIsValid());
		this.setOpTime(p.getOpTime());
		this.setOpUser(p.getOpUserId());
		this.setRepealResoun(p.getRepealResoun());
		this.setId(p.getId());
		this.setRepealTemplateName(p.getRepealTemplateName());
		this.setRepealTemplateType(p.getRepealTemplateType());
		this.setDispIndex(p.getDispIndex());
	}
	public EptRepealTemplate adapterToEptRepealTemplate(){
		EptRepealTemplate p = new EptRepealTemplate();
		p.setCreateTime(this.getCreateTime());
		p.setCreateUserId(this.getCreateUserId());
//		p.setEbeRepeals(this.getEbeRepeals());
		p.setFileId(this.getFileId());
		p.setFileRelpy(this.getFileRelpy());
		p.setFileRequire(this.getFileRequire());
		p.setIsValid(this.getIsValid());
		p.setOpTime(this.getOpTime());
		p.setOpUserId(this.getOpUserId());
		p.setRepealResoun(this.getRepealResoun());
		p.setId(this.getId());
		p.setRepealTemplateName(this.getRepealTemplateName());
		p.setRepealTemplateType(this.getRepealTemplateType());
		p.setDispIndex(this.getDispIndex());
		return p;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRepealTemplateName() {
		return this.repealTemplateName;
	}

	public void setRepealTemplateName(String repealTemplateName) {
		this.repealTemplateName = repealTemplateName;
	}

	public String getRepealTemplateType() {
		return this.repealTemplateType;
	}

	public void setRepealTemplateType(String repealTemplateType) {
		this.repealTemplateType = repealTemplateType;
	}

	public Integer getFileId() {
		return this.fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Integer getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getOpUserId() {
		return this.opUserId;
	}

	public void setOpUser(Integer opUserId) {
		this.opUserId = opUserId;
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

	public String getRepealResoun() {
		return this.repealResoun;
	}

	public void setRepealResoun(String repealResoun) {
		this.repealResoun = repealResoun;
	}

	public String getFileRequire() {
		return this.fileRequire;
	}

	public void setFileRequire(String fileRequire) {
		this.fileRequire = fileRequire;
	}

	public String getFileRelpy() {
		return this.fileRelpy;
	}

	public void setFileRelpy(String fileRelpy) {
		this.fileRelpy = fileRelpy;
	}
	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

//	public Set getEbeRepeals() {
//		return this.ebeRepeals;
//	}
//
//	public void setEbeRepeals(Set ebeRepeals) {
//		this.ebeRepeals = ebeRepeals;
//	}

}