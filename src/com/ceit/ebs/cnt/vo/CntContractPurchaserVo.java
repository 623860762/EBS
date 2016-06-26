package com.ceit.ebs.cnt.vo;

import com.ceit.ebs.cnt.entity.CntContractPurchaser;
import com.ceit.ebs.sys.entity.SysRole;

/**
 * CntContractPurchaser entity. @author MyEclipse Persistence Tools
 */

public class CntContractPurchaserVo implements java.io.Serializable {

	// Fields

	private Integer id;                   //买方信息ID
	private String purchaserCode;         //买方
	private String purchaserName;         //买方名称
	private String purchaserBank;         //买方开户行
	private String purchaserBankAddr;     //买方开户行地址
	private String deptLeader;            //部门领导(买方)
	private String deptLeaderPhone;       //部门领导联系电话(买方)
	private String deptLeaderEmail;       //部门领导邮箱(买方)
	private String purchaserPhone;        //买方联系电话
	private String purchaser;             //买方联系人
	private String purchaserEmail;        //买方电子邮箱
	private String purchaserAccount;      //买方银行帐号
	private String disputeResolve;        //争议解决方式
	private String opTime;               //最后操作时间
	private String isValid;               //是否可用  是否枚举  中有Y和N两种值 不然会报错
	private Integer dispIndex;            //排序索引

	// Constructors
	public CntContractPurchaserVo(CntContractPurchaser p) {
		this.setDeptLeader(p.getDeptLeader());
		this.setDeptLeaderEmail(p.getDeptLeaderEmail());
		this.setDeptLeaderPhone(p.getDeptLeaderPhone());
		this.setDisputeResolve(p.getDisputeResolve());
		this.setIsValid(p.getIsValid());
		this.setOpTime(p.getOpTime());
		this.setPurchaser(p.getPurchaser());
		this.setPurchaserAccount(p.getPurchaserAccount());
		this.setPurchaserBank(p.getPurchaserBank());
		this.setPurchaserBankAddr(p.getPurchaserBankAddr());
		this.setPurchaserCode(p.getPurchaserCode());
		this.setPurchaserEmail(p.getPurchaserEmail());
		this.setId(p.getId());
		this.setPurchaserName(p.getPurchaserName());
		this.setPurchaserPhone(p.getPurchaserPhone());
		this.setDispIndex(p.getDispIndex());
	}
	
	public CntContractPurchaser adapterToCntContractPurchaser(){
		CntContractPurchaser p = new CntContractPurchaser();
		p.setDeptLeader(this.getDeptLeader());
		p.setDeptLeaderEmail(this.getDeptLeaderEmail());
		p.setDeptLeaderPhone(this.getDeptLeaderPhone());
		p.setDisputeResolve(this.getDisputeResolve());
		p.setIsValid(this.getIsValid());
		p.setOpTime(this.getOpTime());
		p.setPurchaser(this.getPurchaser());
		p.setPurchaserAccount(this.getPurchaserAccount());
		p.setPurchaserBank(this.getPurchaserBank());
		p.setPurchaserBankAddr(this.getPurchaserBankAddr());
		p.setPurchaserCode(this.getPurchaserCode());
		p.setPurchaserEmail(this.getPurchaserEmail());
		p.setId(this.getId());
		p.setPurchaserName(this.getPurchaserName());
		p.setPurchaserPhone(this.getPurchaserPhone());
		p.setDispIndex(this.getDispIndex());
		return p;
		
	}
	

	/** default constructor */
	public CntContractPurchaserVo() {
	}

	/** minimal constructor */
	public CntContractPurchaserVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public CntContractPurchaserVo(Integer id, String purchaserCode,
			String purchaserName, String purchaserBank,
			String purchaserBankAddr, String deptLeader,
			String deptLeaderPhone, String deptLeaderEmail,
			String purchaserPhone, String purchaser, String purchaserEmail,
			String purchaserAccount, String disputeResolve, String opTime,
			String isValid, Integer dispIndex) {
		this.id = id;
		this.purchaserCode = purchaserCode;
		this.purchaserName = purchaserName;
		this.purchaserBank = purchaserBank;
		this.purchaserBankAddr = purchaserBankAddr;
		this.deptLeader = deptLeader;
		this.deptLeaderPhone = deptLeaderPhone;
		this.deptLeaderEmail = deptLeaderEmail;
		this.purchaserPhone = purchaserPhone;
		this.purchaser = purchaser;
		this.purchaserEmail = purchaserEmail;
		this.purchaserAccount = purchaserAccount;
		this.disputeResolve = disputeResolve;
		this.opTime = opTime;
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

	public String getPurchaserCode() {
		return this.purchaserCode;
	}

	public void setPurchaserCode(String purchaserCode) {
		this.purchaserCode = purchaserCode;
	}

	public String getPurchaserName() {
		return this.purchaserName;
	}

	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}

	public String getPurchaserBank() {
		return this.purchaserBank;
	}

	public void setPurchaserBank(String purchaserBank) {
		this.purchaserBank = purchaserBank;
	}

	public String getPurchaserBankAddr() {
		return this.purchaserBankAddr;
	}

	public void setPurchaserBankAddr(String purchaserBankAddr) {
		this.purchaserBankAddr = purchaserBankAddr;
	}

	public String getDeptLeader() {
		return this.deptLeader;
	}

	public void setDeptLeader(String deptLeader) {
		this.deptLeader = deptLeader;
	}

	public String getDeptLeaderPhone() {
		return this.deptLeaderPhone;
	}

	public void setDeptLeaderPhone(String deptLeaderPhone) {
		this.deptLeaderPhone = deptLeaderPhone;
	}

	public String getDeptLeaderEmail() {
		return this.deptLeaderEmail;
	}

	public void setDeptLeaderEmail(String deptLeaderEmail) {
		this.deptLeaderEmail = deptLeaderEmail;
	}

	public String getPurchaserPhone() {
		return this.purchaserPhone;
	}

	public void setPurchaserPhone(String purchaserPhone) {
		this.purchaserPhone = purchaserPhone;
	}

	public String getPurchaser() {
		return this.purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	public String getPurchaserEmail() {
		return this.purchaserEmail;
	}

	public void setPurchaserEmail(String purchaserEmail) {
		this.purchaserEmail = purchaserEmail;
	}

	public String getPurchaserAccount() {
		return this.purchaserAccount;
	}

	public void setPurchaserAccount(String purchaserAccount) {
		this.purchaserAccount = purchaserAccount;
	}

	public String getDisputeResolve() {
		return this.disputeResolve;
	}

	public void setDisputeResolve(String disputeResolve) {
		this.disputeResolve = disputeResolve;
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

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}