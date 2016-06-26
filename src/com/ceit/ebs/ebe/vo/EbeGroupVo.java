package com.ceit.ebs.ebe.vo;

import java.util.HashSet;
import java.util.Set;

import com.ceit.ebs.ebe.entity.EbeGroup;
import com.ceit.ebs.ebp.entity.EbpProject;

/*
 * @author lcy date : 2014.8.7
 */

public class EbeGroupVo implements java.io.Serializable {

	// Fields

	private Integer id;                           //主键
	private Integer projectId;                     //谈判组名称
	private String groupName;                          //组名称
	private String groupType;                          //组类型
	private Integer groupPrincipalId;                   //组负责人id
	private String groupPrincipalName;                 //组负责人名字
	private String opTime;                            //最后更新时间
	private Integer businessId;
	private String isValid;
	private Integer dispIndex;

	// Constructors
	public EbeGroupVo(EbeGroup p) {
		this.setId(p.getId());
		this.setProjectId(p.getProjectId());		
		this.setBusinessId(p.getBusinessId());
		this.setGroupName(p.getGroupName());
		this.setGroupPrincipalId(p.getGroupPrincipalId());
		this.setGroupPrincipalName(p.getGroupPrincipalName());
		this.setGroupType(p.getGroupType());
		this.setIsValid(p.getIsValid());
		this.setOpTime(p.getOpTime());
		this.setDispIndex(p.getDispIndex());
	}
	
	public EbeGroup adapterToEbeGroup(){
		EbeGroup p = new EbeGroup();
		p.setId(this.getId());
		p.setProjectId(this.getProjectId());
		p.setBusinessId(this.getBusinessId());
		p.setGroupName(this.getGroupName());
		p.setGroupPrincipalId(this.getGroupPrincipalId());
		p.setGroupPrincipalName(this.getGroupPrincipalName());
		p.setGroupType(this.getGroupType());
		p.setIsValid(this.getIsValid());
		p.setOpTime(this.getOpTime());
		p.setDispIndex(this.getDispIndex());
		return p;
		
	}
	

    /** default constructor */
    public EbeGroupVo() {
    }

	/** minimal constructor */
    public EbeGroupVo(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public EbeGroupVo(Integer id, String groupName, Integer projectId, String groupType, Integer groupPrincipalId, String groupPrincipalName, String opTime, Integer businessId, String isValid, Integer dispIndex) {
        this.id = id;
        this.groupName = groupName;
        this.projectId = projectId;
        this.groupType = groupType;
        this.groupPrincipalId = groupPrincipalId;
        this.groupPrincipalName = groupPrincipalName;
        this.opTime = opTime;
        this.businessId = businessId;
        this.isValid = isValid;
        this.dispIndex = dispIndex;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getGroupType() {
        return this.groupType;
    }
    
    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public Integer getGroupPrincipalId() {
        return this.groupPrincipalId;
    }
    
    public void setGroupPrincipalId(Integer groupPrincipalId) {
        this.groupPrincipalId = groupPrincipalId;
    }

    public String getGroupPrincipalName() {
        return this.groupPrincipalName;
    }
    
    public void setGroupPrincipalName(String groupPrincipalName) {
        this.groupPrincipalName = groupPrincipalName;
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

    public String getIsValid() {
        return this.isValid;
    }
    
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public Integer getDispIndex() {
        return this.dispIndex;
    }
    
    public void setDispIndex(Integer dispIndex) {
        this.dispIndex = dispIndex;
    }
}