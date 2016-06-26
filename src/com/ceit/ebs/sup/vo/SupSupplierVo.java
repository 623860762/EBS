package com.ceit.ebs.sup.vo;

import com.ceit.ebs.sup.entity.SupSupplier;

/**
 * SupSupplierVo 系统的供应商基本信息构件Vo
 * @author czg
 * date 2014-8-15
 */
public class SupSupplierVo  implements java.io.Serializable {


    // Fields    

     private Integer id;              //主键
     private Integer objectId;        //标ID
     private Integer packageId;       //包ID
     private Integer projectId;       //项目ID
     private String userName;         //供应商登陆名
     private String supplierName;     //供应商注册名称
     private String companyType;      //机构类型：1.企业单位，2.事业单位 3.自然人，4个体户，5社会团体6，其他组织机构
     private String companyProperty;  //公司性质：1.国有企业 2 民营企业 3 外商独资（含港澳台） 4 中外合资 5 境外企业，6集体所有制企业，7其他企业
     private String supplierTypeCode; //供应商类别code,1产品供应商，2工程（劳务）分包商3服务供应商
     private String unitDivide;       //单位划分：0 外部单位，1内部单位
     private String englishName;      //企业英文名称
     private String shortName;        //企业简称
     private String webSite;          //企业网址（非必填）
     private String certificateType;  //法人证件类型
     private String corporationName;  //法人姓名
     private String certificateCode;  //法人证件号码
     private String orgNo;            //组织机构代码
     private String licenceNo;        //营业执照注册号
     private String licenceSignDate;  //营业执照签发日期
     private String ratifyNumber;     //批准文号
     private String businessNumber;   //工商登记号
     private String nationalTax;      //国税税务号
     private String districtTax;      //地税税务号
     private String orgStructFileCode;    //公司组织结构图文件字典值，关联文件存放表
     private String licenceFileCode;      //营业执照证扫描件  字典值
     private String licenceYearcheckDate; //营业执照最新年检时间
     private String licenceFilePassdate;  //营业执照证(副本)到期时间
     private String organFileCode;        //组织机构代码证扫描件   字典值
     private String organFilePassdate;    //组织机构代码证年检时间
     private String taxregFileCode;       //税务登记证(扫描件)  字典值
     private String taxregFilePassdate;   //税务登记证(正本)到期时间
     private String contactMan;           //联系人
     private String contactManTel;        //联系人电话
     private String contactManEmail;      //联系人邮箱
     private String regProvince;          //省
     private String regCity;              //市
     private String regArea;              //区
     private String regAddressNo;         //注册地址区号
     private String regAddressPostcode;   //注册地址区邮编
     private String regAddress;           //注册地址
     private String fundationDate;        //成立时间
     private String telPhone;             //固定电话
     private String telFax;               //传真
     private String auditStatus;          //审核状态： 0：不通过，1：审核通过，2：待审核
     private String remarks;              //备注（非必填）
     private String auditTips;            //审核备注
     private String regCapital;           //注册资金（单位：万元）
     private String buinessLimitDate;     //营业期限时间
     private String isAgent;              //是否代理商
     private String opTime;               //操作日期
     private String businessScope;        //经营范围（多选）选的是物资种类
     private String isValid;          
     private String mainBusinessName;     //主营业务
     private String extends1;             //预留扩展字段
     private String extends2;             //预留扩展字段
     private String extends3;             //预留扩展字段
     private String extends4;             //预留扩展字段
     private String extends5;             //预留扩展字段
     private String extends6;             //预留扩展字段
     private String extends7;             //预留扩展字段
     private String extends8;             //预留扩展字段
     private String extends9;             //实收资本币种(移动)
     private String extends10;            //预留扩展字段
     private Integer dispIndex;           //排序索引

    // Constructors

    /** default constructor */
    public SupSupplierVo() {
    }

//    BeanUtil.copyProperties();
    //po->vo
  	public SupSupplierVo(SupSupplier e){
        this.setId(e.getId());
        this.setObjectId(e.getObjectId());
        this.setPackageId(e.getPackageId());
        this.setProjectId(e.getProjectId());
        this.setUserName(e.getUserName());
        this.setSupplierName(e.getSupplierName());
        this.setCompanyType(e.getCompanyType());
        this.setCompanyProperty(e.getCompanyProperty());
        this.setSupplierTypeCode(e.getSupplierTypeCode());
        this.setUnitDivide(e.getUnitDivide());
        this.setEnglishName(e.getEnglishName());
        this.setShortName(e.getShortName());
        this.setWebSite(e.getWebSite());
        this.setCertificateType(e.getCertificateType());
        this.setCorporationName(e.getCorporationName());
        this.setCertificateCode(e.getCertificateCode());
        this.setOrgNo(e.getOrgNo());
        this.setLicenceNo(e.getLicenceNo());
        this.setLicenceSignDate(e.getLicenceSignDate());
        this.setRatifyNumber(e.getRatifyNumber());
        this.setBusinessNumber(e.getBusinessNumber());
        this.setNationalTax(e.getNationalTax());
        this.setDistrictTax(e.getDistrictTax());
        this.setOrgStructFileCode(e.getOrgStructFileCode());
        this.setLicenceFileCode(e.getLicenceFileCode());
        this.setLicenceYearcheckDate(e.getLicenceYearcheckDate());
        this.setLicenceFilePassdate(e.getLicenceFilePassdate());
        this.setOrganFileCode(e.getOrganFileCode());
        this.setOrganFilePassdate(e.getOrganFilePassdate());
        this.setTaxregFileCode(e.getTaxregFileCode());
        this.setTaxregFilePassdate(e.getTaxregFilePassdate());
        this.setContactMan(e.getContactMan());
        this.setContactManTel(e.getContactManTel());
        this.setContactManEmail(e.getContactManEmail());
        this.setRegProvince(e.getRegProvince());
        this.setRegCity(e.getRegCity());
        this.setRegArea(e.getRegArea());
        this.setRegAddressNo(e.getRegAddressNo());
        this.setRegAddressPostcode(e.getRegAddressPostcode());
        this.setRegAddress(e.getRegAddress());
        this.setFundationDate(e.getFundationDate());
        this.setTelPhone(e.getTelPhone());
        this.setTelFax(e.getTelFax());
        this.setAuditStatus(e.getAuditStatus());
        this.setRemarks(e.getRemarks());
        this.setAuditTips(e.getAuditTips());
        this.setRegCapital(e.getRegCapital());
        this.setBuinessLimitDate(e.getBuinessLimitDate());
        this.setIsAgent(e.getIsAgent());
        this.setOpTime(e.getOpTime());
        this.setBusinessScope(e.getBusinessScope());
        this.setIsValid(e.getIsValid());
        this.setMainBusinessName(e.getMainBusinessName());
        this.setExtends1(e.getExtends1());
        this.setExtends2(e.getExtends2());
        this.setExtends3(e.getExtends3());
        this.setExtends4(e.getExtends4());
        this.setExtends5(e.getExtends5());
        this.setExtends6(e.getExtends6());
        this.setExtends7(e.getExtends7());
        this.setExtends8(e.getExtends8());
        this.setExtends9(e.getExtends9());
        this.setExtends10(e.getExtends10());
        this.setDispIndex(e.getDispIndex());
  	}
  	
  	//此方法将vo转为po
  	public SupSupplier adapterToSupSupplier(){
  		SupSupplier e = new SupSupplier();
        e.setId(this.getId());
        e.setObjectId(this.getObjectId());
        e.setPackageId(this.getPackageId());
        e.setProjectId(this.getProjectId());
		e.setUserName(this.getUserName());
        e.setSupplierName(this.getSupplierName());
        e.setCompanyType(this.getCompanyType());
        e.setCompanyProperty(this.getCompanyProperty());
        e.setSupplierTypeCode(this.getSupplierTypeCode());
        e.setUnitDivide(this.getUnitDivide());
        e.setEnglishName(this.getEnglishName());
        e.setShortName(this.getShortName());
        e.setWebSite(this.getWebSite());
        e.setCertificateType(this.getCertificateType());
        e.setCorporationName(this.getCorporationName());
        e.setCertificateCode(this.getCertificateCode());
        e.setOrgNo(this.getOrgNo());
        e.setLicenceNo(this.getLicenceNo());
        e.setLicenceSignDate(this.getLicenceSignDate());
        e.setRatifyNumber(this.getRatifyNumber());
        e.setBusinessNumber(this.getBusinessNumber());
        e.setNationalTax(this.getNationalTax());
        e.setDistrictTax(this.getDistrictTax());
        e.setOrgStructFileCode(this.getOrgStructFileCode());
        e.setLicenceFileCode(this.getLicenceFileCode());
        e.setLicenceYearcheckDate(this.getLicenceYearcheckDate());
        e.setLicenceFilePassdate(this.getLicenceFilePassdate());
        e.setOrganFileCode(this.getOrganFileCode());
        e.setOrganFilePassdate(this.getOrganFilePassdate());
        e.setTaxregFileCode(this.getTaxregFileCode());
        e.setTaxregFilePassdate(this.getTaxregFilePassdate());
        e.setContactMan(this.getContactMan());
        e.setContactManTel(this.getContactManTel());
        e.setContactManEmail(this.getContactManEmail());
        e.setRegProvince(this.getRegProvince());
        e.setRegCity(this.getRegCity());
        e.setRegArea(this.getRegArea());
        e.setRegAddressNo(this.getRegAddressNo());
        e.setRegAddressPostcode(this.getRegAddressPostcode());
        e.setRegAddress(this.getRegAddress());
        e.setFundationDate(this.getFundationDate());
        e.setTelPhone(this.getTelPhone());
        e.setTelFax(this.getTelFax());
        e.setAuditStatus(this.getAuditStatus());
        e.setRemarks(this.getRemarks());
        e.setAuditTips(this.getAuditTips());
        e.setRegCapital(this.getRegCapital());
        e.setBuinessLimitDate(this.getBuinessLimitDate());
        e.setIsAgent(this.getIsAgent());
        e.setOpTime(this.getOpTime());
        e.setBusinessScope(this.getBusinessScope());
        e.setIsValid(this.getIsValid());
        e.setMainBusinessName(this.getMainBusinessName());
        e.setExtends1(this.getExtends1());
        e.setExtends2(this.getExtends2());
        e.setExtends3(this.getExtends3());
        e.setExtends4(this.getExtends4());
        e.setExtends5(this.getExtends5());
        e.setExtends6(this.getExtends6());
        e.setExtends7(this.getExtends7());
        e.setExtends8(this.getExtends8());
        e.setExtends9(this.getExtends9());
        e.setExtends10(this.getExtends10());
        e.setDispIndex(this.getDispIndex());
  		return e;
  	}
   
    
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObjectId() {
        return this.objectId;
    }
    
    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getPackageId() {
        return this.packageId;
    }
    
    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSupplierName() {
        return this.supplierName;
    }
    
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCompanyType() {
        return this.companyType;
    }
    
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyProperty() {
        return this.companyProperty;
    }
    
    public void setCompanyProperty(String companyProperty) {
        this.companyProperty = companyProperty;
    }

    public String getSupplierTypeCode() {
        return this.supplierTypeCode;
    }
    
    public void setSupplierTypeCode(String supplierTypeCode) {
        this.supplierTypeCode = supplierTypeCode;
    }

    public String getUnitDivide() {
        return this.unitDivide;
    }
    
    public void setUnitDivide(String unitDivide) {
        this.unitDivide = unitDivide;
    }

    public String getEnglishName() {
        return this.englishName;
    }
    
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getShortName() {
        return this.shortName;
    }
    
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getWebSite() {
        return this.webSite;
    }
    
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getCertificateType() {
        return this.certificateType;
    }
    
    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCorporationName() {
        return this.corporationName;
    }
    
    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public String getCertificateCode() {
        return this.certificateCode;
    }
    
    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getOrgNo() {
        return this.orgNo;
    }
    
    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getLicenceNo() {
        return this.licenceNo;
    }
    
    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getLicenceSignDate() {
        return this.licenceSignDate;
    }
    
    public void setLicenceSignDate(String licenceSignDate) {
        this.licenceSignDate = licenceSignDate;
    }

    public String getRatifyNumber() {
        return this.ratifyNumber;
    }
    
    public void setRatifyNumber(String ratifyNumber) {
        this.ratifyNumber = ratifyNumber;
    }

    public String getBusinessNumber() {
        return this.businessNumber;
    }
    
    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getNationalTax() {
        return this.nationalTax;
    }
    
    public void setNationalTax(String nationalTax) {
        this.nationalTax = nationalTax;
    }

    public String getDistrictTax() {
        return this.districtTax;
    }
    
    public void setDistrictTax(String districtTax) {
        this.districtTax = districtTax;
    }

    public String getOrgStructFileCode() {
        return this.orgStructFileCode;
    }
    
    public void setOrgStructFileCode(String orgStructFileCode) {
        this.orgStructFileCode = orgStructFileCode;
    }

    public String getLicenceFileCode() {
        return this.licenceFileCode;
    }
    
    public void setLicenceFileCode(String licenceFileCode) {
        this.licenceFileCode = licenceFileCode;
    }

    public String getLicenceYearcheckDate() {
        return this.licenceYearcheckDate;
    }
    
    public void setLicenceYearcheckDate(String licenceYearcheckDate) {
        this.licenceYearcheckDate = licenceYearcheckDate;
    }

    public String getLicenceFilePassdate() {
        return this.licenceFilePassdate;
    }
    
    public void setLicenceFilePassdate(String licenceFilePassdate) {
        this.licenceFilePassdate = licenceFilePassdate;
    }

    public String getOrganFileCode() {
        return this.organFileCode;
    }
    
    public void setOrganFileCode(String organFileCode) {
        this.organFileCode = organFileCode;
    }

    public String getOrganFilePassdate() {
        return this.organFilePassdate;
    }
    
    public void setOrganFilePassdate(String organFilePassdate) {
        this.organFilePassdate = organFilePassdate;
    }

    public String getTaxregFileCode() {
        return this.taxregFileCode;
    }
    
    public void setTaxregFileCode(String taxregFileCode) {
        this.taxregFileCode = taxregFileCode;
    }

    public String getTaxregFilePassdate() {
        return this.taxregFilePassdate;
    }
    
    public void setTaxregFilePassdate(String taxregFilePassdate) {
        this.taxregFilePassdate = taxregFilePassdate;
    }

    public String getContactMan() {
        return this.contactMan;
    }
    
    public void setContactMan(String contactMan) {
        this.contactMan = contactMan;
    }

    public String getContactManTel() {
        return this.contactManTel;
    }
    
    public void setContactManTel(String contactManTel) {
        this.contactManTel = contactManTel;
    }

    public String getContactManEmail() {
        return this.contactManEmail;
    }
    
    public void setContactManEmail(String contactManEmail) {
        this.contactManEmail = contactManEmail;
    }

    public String getRegProvince() {
        return this.regProvince;
    }
    
    public void setRegProvince(String regProvince) {
        this.regProvince = regProvince;
    }

    public String getRegCity() {
        return this.regCity;
    }
    
    public void setRegCity(String regCity) {
        this.regCity = regCity;
    }

    public String getRegArea() {
        return this.regArea;
    }
    
    public void setRegArea(String regArea) {
        this.regArea = regArea;
    }

    public String getRegAddressNo() {
        return this.regAddressNo;
    }
    
    public void setRegAddressNo(String regAddressNo) {
        this.regAddressNo = regAddressNo;
    }

    public String getRegAddressPostcode() {
        return this.regAddressPostcode;
    }
    
    public void setRegAddressPostcode(String regAddressPostcode) {
        this.regAddressPostcode = regAddressPostcode;
    }

    public String getRegAddress() {
        return this.regAddress;
    }
    
    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public String getFundationDate() {
        return this.fundationDate;
    }
    
    public void setFundationDate(String fundationDate) {
        this.fundationDate = fundationDate;
    }

    public String getTelPhone() {
        return this.telPhone;
    }
    
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getTelFax() {
        return this.telFax;
    }
    
    public void setTelFax(String telFax) {
        this.telFax = telFax;
    }

    public String getAuditStatus() {
        return this.auditStatus;
    }
    
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAuditTips() {
        return this.auditTips;
    }
    
    public void setAuditTips(String auditTips) {
        this.auditTips = auditTips;
    }

    public String getRegCapital() {
        return this.regCapital;
    }
    
    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    public String getBuinessLimitDate() {
        return this.buinessLimitDate;
    }
    
    public void setBuinessLimitDate(String buinessLimitDate) {
        this.buinessLimitDate = buinessLimitDate;
    }

    public String getIsAgent() {
        return this.isAgent;
    }
    
    public void setIsAgent(String isAgent) {
        this.isAgent = isAgent;
    }

    public String getOpTime() {
        return this.opTime;
    }
    
    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    public String getBusinessScope() {
        return this.businessScope;
    }
    
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getIsValid() {
        return this.isValid;
    }
    
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getMainBusinessName() {
        return this.mainBusinessName;
    }
    
    public void setMainBusinessName(String mainBusinessName) {
        this.mainBusinessName = mainBusinessName;
    }

    public String getExtends1() {
        return this.extends1;
    }
    
    public void setExtends1(String extends1) {
        this.extends1 = extends1;
    }

    public String getExtends2() {
        return this.extends2;
    }
    
    public void setExtends2(String extends2) {
        this.extends2 = extends2;
    }

    public String getExtends3() {
        return this.extends3;
    }
    
    public void setExtends3(String extends3) {
        this.extends3 = extends3;
    }

    public String getExtends4() {
        return this.extends4;
    }
    
    public void setExtends4(String extends4) {
        this.extends4 = extends4;
    }

    public String getExtends5() {
        return this.extends5;
    }
    
    public void setExtends5(String extends5) {
        this.extends5 = extends5;
    }

    public String getExtends6() {
        return this.extends6;
    }
    
    public void setExtends6(String extends6) {
        this.extends6 = extends6;
    }

    public String getExtends7() {
        return this.extends7;
    }
    
    public void setExtends7(String extends7) {
        this.extends7 = extends7;
    }

    public String getExtends8() {
        return this.extends8;
    }
    
    public void setExtends8(String extends8) {
        this.extends8 = extends8;
    }

    public String getExtends9() {
        return this.extends9;
    }
    
    public void setExtends9(String extends9) {
        this.extends9 = extends9;
    }

    public String getExtends10() {
        return this.extends10;
    }
    
    public void setExtends10(String extends10) {
        this.extends10 = extends10;
    }

    public Integer getDispIndex() {
        return this.dispIndex;
    }
    
    public void setDispIndex(Integer dispIndex) {
        this.dispIndex = dispIndex;
    }
   








}