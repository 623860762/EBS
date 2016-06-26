package com.ceit.ebs.cms.vo;

import com.ceit.ebs.cms.entity.CmsArticle;

/**
 * CmsArticle entity. @author MyEclipse Persistence Tools
 */

public class CmsArticleVo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String abstractArticle;
	private String source;
	private String status;
	private String creUser;
	private String modUser;
	private String creTime;
	private String isCompetence;
	private String isTemplate;
	private String opTime;
	private Integer projectId;
	private String aduitStatus;
	private String isPublish;
	private Integer supplierId;
	private Integer packageId;
	private Integer parentId;
	private Integer dispIndex;
	private String remark;
	private String type;
	
	private String page;
	private String rows;

	// Constructors
	
	public CmsArticleVo(CmsArticle p) {
		this.setId(p.getId());
		this.setName(p.getName());
		this.setAbstractArticle(p.getAbstractArticle());
		this.setSource(p.getSource());
		this.setStatus(p.getStatus());
		this.setCreUser(p.getCreUser());
		this.setModUser(p.getModUser());
		this.setCreTime(p.getCreTime());
		this.setIsCompetence(p.getIsCompetence());
		this.setIsTemplate(p.getIsTemplate());
		this.setOpTime(p.getOpTime());
		this.setProjectId(p.getProjectId());
		this.setAduitStatus(p.getAduitStatus());
		this.setIsPublish(p.getIsPublish());
		this.setSupplierId(p.getSupplierId());
		this.setPackageId(p.getPackageId());
		this.setParentId(p.getParentId());
		this.setDispIndex(p.getDispIndex());
		this.setRemark(p.getRemark());
		this.setType(p.getType());
	}
	
	public CmsArticle adapterToCmsArticle(){
		CmsArticle p = new CmsArticle();
		p.setId(this.getId());
		p.setName(this.getName());
		p.setAbstractArticle(this.getAbstractArticle());
		p.setSource(this.getSource());
		p.setStatus(this.getStatus());
		p.setCreUser(this.getCreUser());
		p.setModUser(this.getModUser());
		p.setCreTime(this.getCreTime());
		p.setIsCompetence(this.getIsCompetence());
		p.setIsTemplate(this.getIsTemplate());
		p.setOpTime(this.getOpTime());
		p.setProjectId(this.getProjectId());
		p.setAduitStatus(this.getAduitStatus());
		p.setIsPublish(this.getIsPublish());
		p.setSupplierId(this.getSupplierId());
		p.setPackageId(this.getPackageId());
		p.setParentId(this.getParentId());
		p.setDispIndex(this.getDispIndex());
		p.setRemark(this.getRemark());
		p.setType(this.getType());
		return p;
	}

	

	/** default constructor */
	public CmsArticleVo() {
	}

	/** minimal constructor */
	public CmsArticleVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public CmsArticleVo(Integer id, String name, String abstractArticle, String source,
			String status, String creUser, String modUser, String creTime,
			String isCompetence, String isTemplate, String opTime,
			Integer projectId, String aduitStatus, String isPublish,
			Integer supplierId, Integer packageId, Integer parentId, Integer dispIndex,
			String remark) {
		this.id = id;
		this.name = name;
		this.abstractArticle = abstractArticle;
		this.source = source;
		this.status = status;
		this.creUser = creUser;
		this.modUser = modUser;
		this.creTime = creTime;
		this.isCompetence = isCompetence;
		this.isTemplate = isTemplate;
		this.opTime = opTime;
		this.projectId = projectId;
		this.aduitStatus = aduitStatus;
		this.isPublish = isPublish;
		this.supplierId = supplierId;
		this.packageId = packageId;
		this.parentId = parentId;
		this.dispIndex = dispIndex;
		this.remark = remark;
	}
	
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbstractArticle() {
		return this.abstractArticle;
	}

	public void setAbstractArticle(String abstractArticle) {
		this.abstractArticle = abstractArticle;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreUser() {
		return this.creUser;
	}

	public void setCreUser(String creUser) {
		this.creUser = creUser;
	}

	public String getModUser() {
		return this.modUser;
	}

	public void setModUser(String modUser) {
		this.modUser = modUser;
	}

	public String getCreTime() {
		return this.creTime;
	}

	public void setCreTime(String creTime) {
		this.creTime = creTime;
	}

	public String getIsCompetence() {
		return this.isCompetence;
	}

	public void setIsCompetence(String isCompetence) {
		this.isCompetence = isCompetence;
	}

	public String getIsTemplate() {
		return this.isTemplate;
	}

	public void setIsTemplate(String isTemplate) {
		this.isTemplate = isTemplate;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getAduitStatus() {
		return this.aduitStatus;
	}

	public void setAduitStatus(String aduitStatus) {
		this.aduitStatus = aduitStatus;
	}

	public String getIsPublish() {
		return this.isPublish;
	}

	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getPackageId() {
		return this.packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}