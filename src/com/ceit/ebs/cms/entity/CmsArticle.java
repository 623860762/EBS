package com.ceit.ebs.cms.entity;

/**
 * CmsArticle entity. @author lcy  2014/8/19
 */

public class CmsArticle implements java.io.Serializable {

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

	// Constructors

	/** default constructor */
	public CmsArticle() {
	}

	/** minimal constructor */
	public CmsArticle(Integer id) {
		this.id = id;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}