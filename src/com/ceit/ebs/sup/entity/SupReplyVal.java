package com.ceit.ebs.sup.entity;


/**
 * SupReplyVal 系统的供应商应答值构件
 * @author czg
 * date 2014-8-15
 */

public class SupReplyVal  implements java.io.Serializable {


    // Fields    

     private Integer id;               //主键    
     private Integer projectId;        //项目Id
     private Integer packageId;        //包Id
     private Integer objectId;         //标Id
     private Integer suppReplyId;      //邀请 报名表Id
     private String termCode;          //应答项code
     private String termName;          //应答项名称
     private Integer termValueEnc;      //应答项的值(密文)
     private String termValueDec;      //应答项的值（明文）
     private String isMust;            //是否必填
     private String termType;          //应答类型
     private Integer termOrder;        //应答排序
     private String opTime;            
     private String isValid;           
     private Integer supplierId;       //供应商Id
     private String supplierName;      //供应商名称
     private String createTime;        //创建时间
     private String decryptStatus;     //解密状态：unDecrypt，未解密;decrypting，正在解密;decryptSuccess，解密成功;decryptFail，解密失败

     private String isOpenBid;         //是否开标
     private Integer dispIndex;        //排序索引


    // Constructors

    /** default constructor */
    public SupReplyVal() {
    }

	/** minimal constructor */
    public SupReplyVal(Integer id) {
        this.id = id;
    }
    
   

   
    // Property accessors

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

    public Integer getObjectId() {
        return this.objectId;
    }
    
    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getSuppReplyId() {
        return this.suppReplyId;
    }
    
    public void setSuppReplyId(Integer suppReplyId) {
        this.suppReplyId = suppReplyId;
    }

    public String getTermCode() {
        return this.termCode;
    }
    
    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getTermName() {
        return this.termName;
    }
    
    public void setTermName(String termName) {
        this.termName = termName;
    }

    public Integer getTermValueEnc() {
        return this.termValueEnc;
    }
    
    public void setTermValueEnc(Integer termValueEnc) {
        this.termValueEnc = termValueEnc;
    }

    public String getTermValueDec() {
        return this.termValueDec;
    }
    
    public void setTermValueDec(String termValueDec) {
        this.termValueDec = termValueDec;
    }

    public String getIsMust() {
        return this.isMust;
    }
    
    public void setIsMust(String isMust) {
        this.isMust = isMust;
    }

    public String getTermType() {
        return this.termType;
    }
    
    public void setTermType(String termType) {
        this.termType = termType;
    }

    public Integer getTermOrder() {
        return this.termOrder;
    }
    
    public void setTermOrder(Integer termOrder) {
        this.termOrder = termOrder;
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

    public Integer getSupplierId() {
        return this.supplierId;
    }
    
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return this.supplierName;
    }
    
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDecryptStatus() {
        return this.decryptStatus;
    }
    
    public void setDecryptStatus(String decryptStatus) {
        this.decryptStatus = decryptStatus;
    }



    public String getIsOpenBid() {
        return this.isOpenBid;
    }
    
    public void setIsOpenBid(String isOpenBid) {
        this.isOpenBid = isOpenBid;
    }

    public Integer getDispIndex() {
        return this.dispIndex;
    }
    
    public void setDispIndex(Integer dispIndex) {
        this.dispIndex = dispIndex;
    }
   








}