package com.ceit.ebs.sys.entity;


/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

/**
 * @author wujinshui
 *
 */
public class SysUser {

	private Integer id;
	private String userName;
	private String password;
	private String accountStatus;
	private String createTime;
	private String lockTime;
	private Integer parentId;
	private Integer employeeId;
	private String email;
	private String msn;
	private String qq;
	private String mobile;
	private String telephone;
	private String pwdChangeTime;
	private String loginTimes;
	private String comments;
	private Integer dispIndex;

	public SysUser() {
	}


	public String getUserName() {
		return this.userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	

}