package com.ceit.ebs.cnt.entity;


/**
 * CntContractSeller entity. @author MyEclipse Persistence Tools
 */

public class CntContractSeller implements java.io.Serializable {

	// Fields

	private Integer id;                        //卖方信息ID
	private Integer supplierId;                 //供应商ID
	private String supplierMdmNo;              //供应商主数据编号
	private String supplierName;               //供应商名称
	private String supplierBank;               //供应商开户行（卖方）
	private String supplierBankAddr;           //供应商开户行地址（卖方）
	private String supplierPhone;              //供应商联系电话（卖方）
	private String supplierPurchaser;          //供应商经办人（卖方）
	private String supplierAccount;            //供应商帐号（卖方）
	private String supplierEmail;              //供应商邮箱（卖方）
	private String opTime;                    //最后操作时间
	private String isValid;                    //是否可用  是否枚举  中有Y和N两种值 不然会报错
	private Integer dispIndex;                 //排序索引

	// Constructors

	/** default constructor */
	public CntContractSeller() {
	}

	/** minimal constructor */
	public CntContractSeller(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public CntContractSeller(Integer id, Integer supplierId, String supplierMdmNo,
			String supplierName, String supplierBank, String supplierBankAddr,
			String supplierPhone, String supplierPurchaser,
			String supplierAccount, String supplierEmail, String opTime,
			String isValid, Integer dispIndex) {
		this.id = id;
		this.supplierId = supplierId;
		this.supplierMdmNo = supplierMdmNo;
		this.supplierName = supplierName;
		this.supplierBank = supplierBank;
		this.supplierBankAddr = supplierBankAddr;
		this.supplierPhone = supplierPhone;
		this.supplierPurchaser = supplierPurchaser;
		this.supplierAccount = supplierAccount;
		this.supplierEmail = supplierEmail;
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

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierMdmNo() {
		return this.supplierMdmNo;
	}

	public void setSupplierMdmNo(String supplierMdmNo) {
		this.supplierMdmNo = supplierMdmNo;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierBank() {
		return this.supplierBank;
	}

	public void setSupplierBank(String supplierBank) {
		this.supplierBank = supplierBank;
	}

	public String getSupplierBankAddr() {
		return this.supplierBankAddr;
	}

	public void setSupplierBankAddr(String supplierBankAddr) {
		this.supplierBankAddr = supplierBankAddr;
	}

	public String getSupplierPhone() {
		return this.supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public String getSupplierPurchaser() {
		return this.supplierPurchaser;
	}

	public void setSupplierPurchaser(String supplierPurchaser) {
		this.supplierPurchaser = supplierPurchaser;
	}

	public String getSupplierAccount() {
		return this.supplierAccount;
	}

	public void setSupplierAccount(String supplierAccount) {
		this.supplierAccount = supplierAccount;
	}

	public String getSupplierEmail() {
		return this.supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
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