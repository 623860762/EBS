package com.ceit.ebs.sys.vo;

import com.ceit.ebs.sys.entity.SysUser;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

/**
 *@author gr
 *@date 2014-8-7 下午03:46:22
 */

public class SysUserVo {

	// Fields

	private Integer id;                //用户id
	private String userName;              //用户姓名
	private String password;              //用户登陆密码
	private String accountStatus;         //账户状态：0为锁定，1为启用
	private String createTime;           //用户创建时间
	private String lockTime;             //若账户处于锁定状态，则对应锁定时间
	private Integer parentId;         //账户所在企业部门id，与组织机构organ_id对应
	private Integer employeeId;            //用户员工编号
	private String email;                 //用户电子邮件
	private String msn;                   //用户msn账号
	private String qq;                    //用户QQ账号
	private String mobile;                //用户手机号
	private String telephone;             //用户电话号
	private String pwdChangeTime;        //账号密码修改时间
	private String loginTimes;           //账户最新登陆时间
	private String comment;               //备注信息
	private Integer dispIndex;            //排序

	// Constructors
	public SysUserVo(SysUser p) {
		this.setAccountStatus(p.getAccountStatus());
		this.setComment(p.getComments());
		this.setParentId(p.getParentId());
		this.setCreateTime(p.getCreateTime());
		this.setEmail(p.getEmail());
		this.setEmployeeId(p.getEmployeeId());
		this.setLockTime(p.getLockTime());
		this.setLoginTimes(p.getLoginTimes());
		this.setMobile(p.getMobile());
		this.setMsn(p.getMsn());
		this.setPassword(p.getPassword());
		this.setPwdChangeTime(p.getPwdChangeTime());
		this.setQq(p.getQq());
		this.setTelephone(p.getTelephone());
		this.setId(p.getId());
		this.setUserName(p.getUserName());
		this.setDispIndex(p.getDispIndex());
	}
	
	public SysUser adapterToSysUser(){
		SysUser p = new SysUser();
		p.setAccountStatus(this.getAccountStatus());
		p.setComments(this.getComment());
		p.setParentId(this.getParentId());
		p.setCreateTime(this.getCreateTime());
		p.setEmail(this.getEmail());
		p.setEmployeeId(this.getEmployeeId());
		p.setLockTime(this.getLockTime());
		p.setLoginTimes(this.getLoginTimes());
		p.setMobile(this.getMobile());
		p.setMsn(this.getMsn());
		p.setPassword(this.getPassword());
		p.setPwdChangeTime(this.getPwdChangeTime());
		p.setQq(this.getQq());
		p.setTelephone(this.getTelephone());
		p.setId(this.getId());
		p.setUserName(this.getUserName());
		p.setDispIndex(this.getDispIndex());
		return p;
	}

	/** default constructor */
	public SysUserVo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer Id) {
		this.id = Id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLockTime() {
		return this.lockTime;
	}

	public void setLockTime(String lockTime) {
		this.lockTime = lockTime;
	}

	

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPwdChangeTime() {
		return this.pwdChangeTime;
	}

	public void setPwdChangeTime(String pwdChangeTime) {
		this.pwdChangeTime = pwdChangeTime;
	}

	public String getLoginTimes() {
		return this.loginTimes;
	}

	public void setLoginTimes(String loginTimes) {
		this.loginTimes = loginTimes;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}
	
	

}