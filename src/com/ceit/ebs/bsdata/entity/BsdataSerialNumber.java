package com.ceit.ebs.bsdata.entity;

/**
 * BsdataSerialNumber 系统的流水号构件
 * @author czg
 * date 2014-8-10
 */

public class BsdataSerialNumber  implements java.io.Serializable {


    // Fields    

     private Integer id;             //主键
     private Integer parentId;       //父类节点
     private Integer dispIndex;      //排序索引
     private Integer serialNumber;   //流水号
     private String opTime;         //操作时间
     private String type;            //应用类型
     private Integer struId;         //单位编号
     private String struCode;        //单位编号截取一部分用来拼接流水号


    // Constructors

    /** default constructor */
    public BsdataSerialNumber() {
    }

	/** minimal constructor */
    public BsdataSerialNumber(Integer id, Integer serialNumber) {
        this.id = id;
        this.serialNumber = serialNumber;
    }
    
    /** full constructor */
    public BsdataSerialNumber(Integer id, Integer parentId, Integer dispIndex, Integer serialNumber, String opTime, String type, Integer struId, String struCode) {
        this.id = id;
        this.parentId = parentId;
        this.dispIndex = dispIndex;
        this.serialNumber = serialNumber;
        this.opTime = opTime;
        this.type = type;
        this.struId = struId;
        this.struCode = struCode;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getDispIndex() {
        return this.dispIndex;
    }
    
    public void setDispIndex(Integer dispIndex) {
        this.dispIndex = dispIndex;
    }

    public Integer getSerialNumber() {
        return this.serialNumber;
    }
    
    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOpTime() {
        return this.opTime;
    }
    
    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public Integer getStruId() {
        return this.struId;
    }
    
    public void setStruId(Integer struId) {
        this.struId = struId;
    }

    public String getStruCode() {
        return this.struCode;
    }
    
    public void setStruCode(String struCode) {
        this.struCode = struCode;
    }
   








}