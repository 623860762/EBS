package com.ceit.ebs.sup.entity;


/**
 * SupAttachment 系统的附件构件
 * @author czg
 * date 2014-8-15
 */

public class SupAttachment  implements java.io.Serializable {


    // Fields    

     private Integer id;            //主键
     private Integer packageId;     //包ID
     private Integer projectId;     //项目ID
     private String attachmentName; //附件名称
     private String attachmentPath; //附件路径
     private String attchmentType;  //附件类型：谈判文件，澄清文件，邀请函，报价，技术，商务，法人授权书，廉洁诚信承若书
     private String opTime;         //最后更新时间
     private String isValid;       
     private Integer dispIndex;     //排序索引


    // Constructors

    /** default constructor */
    public SupAttachment() {
    }

	/** minimal constructor */
    public SupAttachment(Integer id) {
        this.id = id;
    }
   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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

    public String getAttachmentName() {
        return this.attachmentName;
    }
    
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentPath() {
        return this.attachmentPath;
    }
    
    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public String getAttchmentType() {
        return this.attchmentType;
    }
    
    public void setAttchmentType(String attchmentType) {
        this.attchmentType = attchmentType;
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