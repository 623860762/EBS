package com.ceit.ebs.ebe.entity;



/**
 * EbeExpertGroup entity. @author MyEclipse Persistence Tools
 */


public class EbeExpertGroup{


    // Fields    

	private Integer id;                                      //主键
	private Integer projectId;                                      //项目主键
	private Integer extractionNameListId;                    //组id
	private Integer groupId;                                 //专家抽取名单主键
	private Integer isExpert;                                     //是否专家
	private String relevanceProject;                             //和项目关联的状态 默认为1：关联 取消关联后置为0
	private String relevanceGroup;                               //专家和组的关联默认为1：关联 取消关联后置为0
	private String opTime;                                      //最后更新时间
	private Integer businessId;
	private Integer isValid;
	private Integer isHeader;                                     //是否组长
	private Integer isTechFinish;                                   //是否完成技术打分
	private Integer isTechScore;                                    //是否有技术打分权限
	private Integer isBusiFinish;                                   //是否完成商务打分
	private Integer isBusiScore;                                  //是否有商务打分权限
	private Integer isPriceScore;                                   //是否有价格打分权限
	private Integer isPriceFinish;                                //是否完成商务打分
	private Integer isRepeal;                                     //是有权限发布废标
	private Integer isClarfy;                                     //是否有权发布澄清
	private Integer dispIndex;                                   //排序索引
	

    // Constructors
	
    /** default constructor */
    public EbeExpertGroup() {
    }

    // Property accessors

    /**
	 * @return the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getExtractionNameListId() {
        return this.extractionNameListId;
    }
    
    public void setExtractionNameListId(Integer extractionNameListId) {
        this.extractionNameListId = extractionNameListId;
    }

    public Integer getIsExpert() {
        return this.isExpert;
    }
    
    public void setIsExpert(Integer isExpert) {
        this.isExpert = isExpert;
    }

    public String getRelevanceProject() {
        return this.relevanceProject;
    }
    
    public void setRelevanceProject(String relevanceProject) {
        this.relevanceProject = relevanceProject;
    }

    public String getRelevanceGroup() {
        return this.relevanceGroup;
    }
    
    public void setRelevanceGroup(String relevanceGroup) {
        this.relevanceGroup = relevanceGroup;
    }

    public String getOpTime() {
        return this.opTime;
    }
    
    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    public Integer getBusinessId() {
        return this.businessId;
    }
    
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getIsValid() {
        return this.isValid;
    }
    
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getIsHeader() {
        return this.isHeader;
    }
    
    public void setIsHeader(Integer isHeader) {
        this.isHeader = isHeader;
    }

    public Integer getIsTechFinish() {
        return this.isTechFinish;
    }
    
    public void setIsTechFinish(Integer isTechFinish) {
        this.isTechFinish = isTechFinish;
    }

    public Integer getIsTechScore() {
        return this.isTechScore;
    }
    
    public void setIsTechScore(Integer isTechScore) {
        this.isTechScore = isTechScore;
    }

    public Integer getIsBusiFinish() {
        return this.isBusiFinish;
    }
    
    public void setIsBusiFinish(Integer isBusiFinish) {
        this.isBusiFinish = isBusiFinish;
    }

    public Integer getIsBusiScore() {
        return this.isBusiScore;
    }
    
    public void setIsBusiScore(Integer isBusiScore) {
        this.isBusiScore = isBusiScore;
    }

    public Integer getIsPriceScore() {
        return this.isPriceScore;
    }
    
    public void setIsPriceScore(Integer isPriceScore) {
        this.isPriceScore = isPriceScore;
    }

    public Integer getIsPriceFinish() {
        return this.isPriceFinish;
    }
    
    public void setIsPriceFinish(Integer isPriceFinish) {
        this.isPriceFinish = isPriceFinish;
    }

    public Integer getIsRepeal() {
        return this.isRepeal;
    }
    
    public void setIsRepeal(Integer isRepeal) {
        this.isRepeal = isRepeal;
    }

    public Integer getIsClarfy() {
        return this.isClarfy;
    }
    
    public void setIsClarfy(Integer isClarfy) {
        this.isClarfy = isClarfy;
    }

    public Integer getDispIndex() {
        return this.dispIndex;
    }
    
    public void setDispIndex(Integer dispIndex) {
        this.dispIndex = dispIndex;
    }
}