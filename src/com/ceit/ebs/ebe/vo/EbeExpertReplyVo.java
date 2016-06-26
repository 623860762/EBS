package com.ceit.ebs.ebe.vo;

import com.ceit.ebs.ebe.entity.EbeExpertReply;
import com.ceit.ebs.ebp.entity.EbpPackage;

/*
 * @author lcy date : 2014.8.7
 */

public class EbeExpertReplyVo implements java.io.Serializable {

	// Fields

	private Integer expertId;             //专家id
	private Integer packageId;           //包ID
	private Integer id;                  //主键
	private Integer projectId;            //项目id
	private Integer replyId;              //应答记录id
	private Integer supplierId;           //供应商id
	private Integer businessScore;       //商务分
	private Integer technicalScore;      //技术分
	private Integer priceScore;          //价格得分
	private Integer assessScore;         //后评估得分
	private String opTime;              //最后更新时间
	private String isValid;
	private Integer businessId;           //保留
	private Integer objectId;
	private Integer weightTotal;         //专家权重
	private Integer diapIndex;           //排序索引

	// Constructors
	public EbeExpertReplyVo(EbeExpertReply p) {
		this.setAssessScore(p.getAssessScore());
		this.setBusinessId(p.getBusinessId());
		this.setBusinessScore(p.getBusinessScore());
		this.setPackageId(p.getPackageId());
		this.setExpertId(p.getExpertId());
		this.setId(p.getId());
		this.setIsValid(p.getIsValid());
		this.setObjectId(p.getObjectId());
		this.setOpTime(p.getOpTime());
		this.setPriceScore(p.getPriceScore());
		this.setProjectId(p.getProjectId());
		this.setReplyId(p.getReplyId());
		this.setSupplierId(p.getSupplierId());
		this.setTechnicalScore(p.getTechnicalScore());
		this.setWeightTotal(p.getWeightTotal());
		this.setDiapIndex(p.getDiapIndex());
	}
	
	public EbeExpertReply adapterToEbeExpertReply(){
		EbeExpertReply p = new EbeExpertReply();
		p.setAssessScore(this.getAssessScore());
		p.setBusinessId(this.getBusinessId());
		p.setBusinessScore(this.getBusinessScore());
		p.setPackageId(this.getPackageId());
		p.setExpertId(this.getExpertId());
		p.setId(this.getId());
		p.setIsValid(this.getIsValid());
		p.setObjectId(this.getObjectId());
		p.setOpTime(this.getOpTime());
		p.setPriceScore(this.getPriceScore());
		p.setProjectId(this.getProjectId());
		p.setReplyId(this.getReplyId());
		p.setSupplierId(this.getSupplierId());
		p.setTechnicalScore(this.getTechnicalScore());
		p.setWeightTotal(this.getWeightTotal());
		p.setDiapIndex(this.getDiapIndex());
		return p;
		
	}
	
	

	 /** default constructor */
    public EbeExpertReplyVo() {
    }

	/** minimal constructor */
    public EbeExpertReplyVo(Integer expertId, Integer id) {
        this.expertId = expertId;
        this.id = id;
    }
    
    /** full constructor */
    public EbeExpertReplyVo(Integer expertId, Integer id, Integer projectId, Integer packageId, Integer replyId, Integer supplierId, Integer businessScore, Integer technicalScore, Integer priceScore, Integer assessScore, String opTime, String isValid, Integer businessId, Integer objectId, Integer weightTotal, Integer diapIndex) {
        this.expertId = expertId;
        this.id = id;
        this.projectId = projectId;
        this.packageId = packageId;
        this.replyId = replyId;
        this.supplierId = supplierId;
        this.businessScore = businessScore;
        this.technicalScore = technicalScore;
        this.priceScore = priceScore;
        this.assessScore = assessScore;
        this.opTime = opTime;
        this.isValid = isValid;
        this.businessId = businessId;
        this.objectId = objectId;
        this.weightTotal = weightTotal;
        this.diapIndex = diapIndex;
    }

   
    // Property accessors

    public Integer getExpertId() {
        return this.expertId;
    }
    
    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

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

    public Integer getPackageId() {
        return this.packageId;
    }
    
    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getReplyId() {
        return this.replyId;
    }
    
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getSupplierId() {
        return this.supplierId;
    }
    
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getBusinessScore() {
        return this.businessScore;
    }
    
    public void setBusinessScore(Integer businessScore) {
        this.businessScore = businessScore;
    }

    public Integer getTechnicalScore() {
        return this.technicalScore;
    }
    
    public void setTechnicalScore(Integer technicalScore) {
        this.technicalScore = technicalScore;
    }

    public Integer getPriceScore() {
        return this.priceScore;
    }
    
    public void setPriceScore(Integer priceScore) {
        this.priceScore = priceScore;
    }

    public Integer getAssessScore() {
        return this.assessScore;
    }
    
    public void setAssessScore(Integer assessScore) {
        this.assessScore = assessScore;
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

    public Integer getBusinessId() {
        return this.businessId;
    }
    
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getObjectId() {
        return this.objectId;
    }
    
    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getWeightTotal() {
        return this.weightTotal;
    }
    
    public void setWeightTotal(Integer weightTotal) {
        this.weightTotal = weightTotal;
    }

    public Integer getDiapIndex() {
        return this.diapIndex;
    }
    
    public void setDiapIndex(Integer diapIndex) {
        this.diapIndex = diapIndex;
    }
}