package com.ceit.ebs.ebp.vo;

import com.ceit.ebs.ebp.entity.EbpProject;

/**
 *@author gr
 *@date 2014-8-10 上午10:19:46
 */
public class EbpProjectVo  {

	// Fields

	private Integer projectId;//id
	private Integer planId;//计划id
	private String projectName;//项目名称
	private String projectCode;//编码方式
	private String isPlan;//是否为计划
	private String createTime;//创建时间
	private Integer budgetMoney;//预算金额
	private Integer needDepartmentId;//需求部门
	private Integer projectManagerId;//管理id
	private String projectRemark;//项目描述
	private String projectYear;//招标年份
	private String isPublic;//公开/邀请，Y：公开；N：邀请
	private String winRule;//中标规则
	private String projectStatus;//项目状态：准备状态、招标中、开标等等，具体根据枚举文件详细说明
	private String smallStatus;//项目小状态，例如招标准备中分包、分标等，具体根据枚举文件详细说明
	private Integer numberTurn;//招标轮次
	private Integer creatorId;//招标项目创建人id
	private String isValid;
	private String updateTime;
	private String startBuyTime;//标书开始购买时间
	private String endBuyTime;//标书购买截至时间
	private String closeBidTime;//截标时间
	private String openBidTime;//开标时间
	private String singBidTime;//唱标时间
	private String sureBidTime;//定标时间
	private String replyStartTime;//应答开始时间
	private String replyStopTime;//应答结束时间
	private String isPrequalification;//是否需要资格认证，Y：需要
	private String projectAuditStatus;//项目审核状态：未审核、审核中、审核通过、审核未通过等，根据枚举文件详细说明
	private Integer projectAuditId;//审核人编号
	private String projectAuditOpinion;//项目审核意见
	private String priceUnit;//报价单位，人民币、美元等
	private String isObject;//是否分标（三层结构），Y：分
	private String comments;//备注
	private String expertProjectStatus;//抽取专家字段
	
	private String projectAuditStatusName;//项目审核状态名称，用于在页面显示 
	
	private Integer dispIndex;
//	private String extends1;//预留扩展字段
//	private String extends2;
//	private String extends3;
//	private String extends4;
//	private String extends5;
//	private String extends6;
//	private String extends7;
//	private String extends8;
//	private String extends9;
//	private String extends10;
//	private Set ebeProviderPackages = new HashSet(0);
//	private Set ebeGroups = new HashSet(0);
//	private Set ebpObjects = new HashSet(0);
//	private Set ebpPackages = new HashSet(0);

	// Constructors

	/** default constructor */
	public EbpProjectVo() {
	}


	
	public EbpProjectVo(EbpProject p) {
		this.setBudgetMoney(p.getBudgetMoney());
		this.setCloseBidTime(p.getCloseBidTime());
		this.setComments(p.getComments());
		this.setCreateTime(p.getCreateTime());
		this.setCreatorId(p.getCreatorId());
//		this.setEbeGroups(p.getEbeGroups());
//		this.setEbeProviderPackages(p.getEbeProviderPackages());
//		this.setEbpObjects(p.getEbpObjects());
//		this.setEbpPackages(p.getEbpPackages());
		this.setEndBuyTime(p.getEndBuyTime());
//		this.setExtends1(p.getExtends1());
//		this.setExtends10(p.getExtends10());
//		this.setExtends2(p.getExtends2());
//		this.setExtends3(p.getExtends3());
//		this.setExtends4(p.getExtends4());
//		this.setExtends5(p.getExtends5());
//		this.setExtends6(p.getExtends6());
//		this.setExtends7(p.getExtends7());
//		this.setExtends8(p.getExtends8());
//		this.setExtends9(p.getExtends9());
		this.setIsObject(p.getIsObject());
		this.setIsPlan(p.getIsPlan());
		this.setIsPrequalification(p.getIsPrequalification());
		this.setIsPublic(p.getIsPublic());
		this.setIsValid(p.getIsValid());
		this.setNeedDepartmentId(p.getNeedDepartmentId());
		this.setNumberTurn(p.getNumberTurn());
		this.setOpenBidTime(p.getOpenBidTime());
		this.setPlanId(p.getPlanId());
		this.setPriceUnit(p.getPriceUnit());
		this.setProjectAuditId(p.getProjectAuditId());
		this.setProjectAuditOpinion(p.getProjectAuditOpinion());
		this.setProjectAuditStatus(p.getProjectAuditStatus());
		this.setProjectCode(p.getProjectCode());
		this.setProjectId(p.getId());
//		this.setProjectManagerId(Integer.toString(p.getProjectManagerId()));
		this.setProjectManagerId(p.getProjectManagerId());
		this.setProjectName(p.getProjectName());
		this.setProjectRemark(p.getProjectRemark());
		this.setProjectStatus(p.getProjectStatus());
		this.setProjectYear(p.getProjectYear());
		this.setReplyStartTime(p.getReplyStartTime());
		this.setReplyStopTime(p.getReplyStopTime());
		this.setSingBidTime(p.getSingBidTime());
		this.setSmallStatus(p.getSmallStatus());
		this.setStartBuyTime(p.getSureBidTime());
		this.setSureBidTime(p.getSureBidTime());
		this.setUpdateTime(p.getUpdateTime());
		this.setWinRule(p.getWinRule());
		this.setDispIndex(p.getDispIndex());
		this.setExpertProjectStatus(p.getExpertProjectStatus());
		
		//设置页面显示的项目审核状态名称
		if(("EDIT").equals(p.getProjectStatus())){
			if(("ZB").equals(p.getSmallStatus())){
				this.setProjectAuditStatusName("等待审核");
			}else if(("SH").equals(p.getSmallStatus())){
				if(("SHPASS").equals(p.getProjectAuditStatus())){
					this.setProjectAuditStatusName("审核通过");
				}else if(("SHNOPASS").equals(p.getProjectAuditStatus())){
					this.setProjectAuditStatusName("审核未通过");
				}else{
					this.setProjectAuditStatusName("审核中");
				}
			}
		}

	}
	
	public EbpProject adapterToEbpProject(){
		EbpProject p = new EbpProject();
		p.setBudgetMoney(this.getBudgetMoney());
		p.setCloseBidTime(this.getCloseBidTime());
		p.setComments(this.getComments());
		p.setCreateTime(this.getCreateTime());
		p.setCreatorId(this.getCreatorId());
//		p.setEbeGroups(this.getEbeGroups());
//		p.setEbeProviderPackages(this.getEbeProviderPackages());
//		p.setEbpObjects(this.getEbpObjects());
//		p.setEbpPackages(this.getEbpPackages());
		p.setEndBuyTime(this.getEndBuyTime());
//		p.setExtends1(this.getExtends1());
//		p.setExtends10(this.getExtends10());
//		p.setExtends2(this.getExtends2());
//		p.setExtends3(this.getExtends3());
//		p.setExtends4(this.getExtends4());
//		p.setExtends5(this.getExtends5());
//		p.setExtends6(this.getExtends6());
//		p.setExtends7(this.getExtends7());
//		p.setExtends8(this.getExtends8());
//		p.setExtends9(this.getExtends9());
		p.setIsObject(this.getIsObject());
		p.setIsPlan(this.getIsPlan());
		p.setIsPrequalification(this.getIsPrequalification());
		p.setIsPublic(this.getIsPublic());
		p.setIsValid(this.getIsValid());
		p.setNeedDepartmentId(this.getNeedDepartmentId());
		p.setNumberTurn(this.getNumberTurn());
		p.setOpenBidTime(this.getOpenBidTime());
		p.setPlanId(this.getPlanId());
		p.setPriceUnit(this.getPriceUnit());
		p.setProjectAuditId(this.getProjectAuditId());
		p.setProjectAuditOpinion(this.getProjectAuditOpinion());
		p.setProjectAuditStatus(this.getProjectAuditStatus());
		p.setProjectCode(this.getProjectCode());
		p.setId(this.getProjectId());
//		p.setProjectManagerId(Integer.parseInt(this.getProjectManagerId()));
		p.setProjectManagerId(this.getProjectManagerId());
		p.setProjectName(this.getProjectName());
		p.setProjectRemark(this.getProjectRemark());
		p.setProjectStatus(this.getProjectStatus());
		p.setProjectYear(this.getProjectYear());
		p.setReplyStartTime(this.getReplyStartTime());
		p.setReplyStopTime(this.getReplyStopTime());
		p.setSingBidTime(this.getSingBidTime());
		p.setSmallStatus(this.getSmallStatus());
		p.setSureBidTime(this.getStartBuyTime());
		p.setSureBidTime(this.getSureBidTime());
		p.setUpdateTime(this.getUpdateTime());
		p.setWinRule(this.getWinRule());
		p.setDispIndex(this.getDispIndex());
		p.setExpertProjectStatus(this.getExpertProjectStatus());
		return p;
	}

	// Property accessors

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getIsPlan() {
		return this.isPlan;
	}

	public void setIsPlan(String isPlan) {
		this.isPlan = isPlan;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getBudgetMoney() {
		return this.budgetMoney;
	}

	public void setBudgetMoney(Integer budgetMoney) {
		this.budgetMoney = budgetMoney;
	}

	public Integer getNeedDepartmentId() {
		return this.needDepartmentId;
	}

	public void setNeedDepartmentId(Integer needDepartmentId) {
		this.needDepartmentId = needDepartmentId;
	}

	public Integer getProjectManagerId() {
		return this.projectManagerId;
	}

	public void setProjectManagerId(Integer projectManagerId) {
		this.projectManagerId = projectManagerId;
	}

	public String getProjectRemark() {
		return this.projectRemark;
	}

	public void setProjectRemark(String projectRemark) {
		this.projectRemark = projectRemark;
	}

	public String getProjectYear() {
		return this.projectYear;
	}

	public void setProjectYear(String projectYear) {
		this.projectYear = projectYear;
	}

	public String getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public String getWinRule() {
		return this.winRule;
	}

	public void setWinRule(String winRule) {
		this.winRule = winRule;
	}

	public String getProjectStatus() {
		return this.projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getSmallStatus() {
		return this.smallStatus;
	}

	public void setSmallStatus(String smallStatus) {
		this.smallStatus = smallStatus;
	}

	public Integer getNumberTurn() {
		return this.numberTurn;
	}

	public void setNumberTurn(Integer numberTurn) {
		this.numberTurn = numberTurn;
	}

	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getStartBuyTime() {
		return this.startBuyTime;
	}

	public void setStartBuyTime(String startBuyTime) {
		this.startBuyTime = startBuyTime;
	}

	public String getEndBuyTime() {
		return this.endBuyTime;
	}

	public void setEndBuyTime(String endBuyTime) {
		this.endBuyTime = endBuyTime;
	}

	public String getCloseBidTime() {
		return this.closeBidTime;
	}

	public void setCloseBidTime(String closeBidTime) {
		this.closeBidTime = closeBidTime;
	}

	public String getOpenBidTime() {
		return this.openBidTime;
	}

	public void setOpenBidTime(String openBidTime) {
		this.openBidTime = openBidTime;
	}

	public String getSingBidTime() {
		return this.singBidTime;
	}

	public void setSingBidTime(String singBidTime) {
		this.singBidTime = singBidTime;
	}

	public String getSureBidTime() {
		return this.sureBidTime;
	}

	public void setSureBidTime(String sureBidTime) {
		this.sureBidTime = sureBidTime;
	}

	public String getReplyStartTime() {
		return this.replyStartTime;
	}

	public void setReplyStartTime(String replyStartTime) {
		this.replyStartTime = replyStartTime;
	}

	public String getReplyStopTime() {
		return this.replyStopTime;
	}

	public void setReplyStopTime(String replyStopTime) {
		this.replyStopTime = replyStopTime;
	}

	public String getIsPrequalification() {
		return this.isPrequalification;
	}

	public void setIsPrequalification(String isPrequalification) {
		this.isPrequalification = isPrequalification;
	}

	public String getProjectAuditStatus() {
		return this.projectAuditStatus;
	}

	public void setProjectAuditStatus(String projectAuditStatus) {
		this.projectAuditStatus = projectAuditStatus;
	}

	public Integer getProjectAuditId() {
		return this.projectAuditId;
	}

	public void setProjectAuditId(Integer projectAuditId) {
		this.projectAuditId = projectAuditId;
	}

	public String getProjectAuditOpinion() {
		return this.projectAuditOpinion;
	}

	public void setProjectAuditOpinion(String projectAuditOpinion) {
		this.projectAuditOpinion = projectAuditOpinion;
	}

	public String getPriceUnit() {
		return this.priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getIsObject() {
		return this.isObject;
	}

	public void setIsObject(String isObject) {
		this.isObject = isObject;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}



	public Integer getDispIndex() {
		return dispIndex;
	}



	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}



	/**
	 * @return the expertProjectStatus
	 */
	public String getExpertProjectStatus() {
		return expertProjectStatus;
	}



	/**
	 * @param expertProjectStatus the expertProjectStatus to set
	 */
	public void setExpertProjectStatus(String expertProjectStatus) {
		this.expertProjectStatus = expertProjectStatus;
	}



	public String getProjectAuditStatusName() {
		return projectAuditStatusName;
	}



	public void setProjectAuditStatusName(String projectAuditStatusName) {
		this.projectAuditStatusName = projectAuditStatusName;
	}
	
	

//	public String getExtends1() {
//		return this.extends1;
//	}
//
//	public void setExtends1(String extends1) {
//		this.extends1 = extends1;
//	}
//
//	public String getExtends2() {
//		return this.extends2;
//	}
//
//	public void setExtends2(String extends2) {
//		this.extends2 = extends2;
//	}
//
//	public String getExtends3() {
//		return this.extends3;
//	}
//
//	public void setExtends3(String extends3) {
//		this.extends3 = extends3;
//	}
//
//	public String getExtends4() {
//		return this.extends4;
//	}
//
//	public void setExtends4(String extends4) {
//		this.extends4 = extends4;
//	}
//
//	public String getExtends5() {
//		return this.extends5;
//	}
//
//	public void setExtends5(String extends5) {
//		this.extends5 = extends5;
//	}
//
//	public String getExtends6() {
//		return this.extends6;
//	}
//
//	public void setExtends6(String extends6) {
//		this.extends6 = extends6;
//	}
//
//	public String getExtends7() {
//		return this.extends7;
//	}
//
//	public void setExtends7(String extends7) {
//		this.extends7 = extends7;
//	}
//
//	public String getExtends8() {
//		return this.extends8;
//	}
//
//	public void setExtends8(String extends8) {
//		this.extends8 = extends8;
//	}
//
//	public String getExtends9() {
//		return this.extends9;
//	}
//
//	public void setExtends9(String extends9) {
//		this.extends9 = extends9;
//	}
//
//	public String getExtends10() {
//		return this.extends10;
//	}
//
//	public void setExtends10(String extends10) {
//		this.extends10 = extends10;
//	}

//	public Set getEbeProviderPackages() {
//		return this.ebeProviderPackages;
//	}
//
//	public void setEbeProviderPackages(Set ebeProviderPackages) {
//		this.ebeProviderPackages = ebeProviderPackages;
//	}
//
//	public Set getEbeGroups() {
//		return this.ebeGroups;
//	}
//
//	public void setEbeGroups(Set ebeGroups) {
//		this.ebeGroups = ebeGroups;
//	}
//
//	public Set getEbpObjects() {
//		return this.ebpObjects;
//	}
//
//	public void setEbpObjects(Set ebpObjects) {
//		this.ebpObjects = ebpObjects;
//	}
//
//	public Set getEbpPackages() {
//		return this.ebpPackages;
//	}
//
//	public void setEbpPackages(Set ebpPackages) {
//		this.ebpPackages = ebpPackages;
//	}

}