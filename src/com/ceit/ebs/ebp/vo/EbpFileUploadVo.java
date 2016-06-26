package com.ceit.ebs.ebp.vo;

import com.ceit.ebs.ebp.entity.EbpFileUpload;


/**
 * EbpFileUploadVo 系统的上传文件构件Vo
 * @author czg
 * date 2014-8-15
 */

public class EbpFileUploadVo implements java.io.Serializable {

	// Fields

	private Integer id;           //主键
	private Integer packageId;    //包ID
	private Integer projectId;    //项目ID
	private Integer codeId;       //编码ID
	private String fileName;      //文件名
	private String fileType;      //文件类型
	private String filePath;      //文件路径
	private String fileSize;      //文件大小
	private String isValid;       
	private String opTime;
	private String userName;      //操作人
	private Integer dispIndex;    //排序索引
	private Integer objectId;    //排序索引

	// Constructors

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	/** default constructor */
	public EbpFileUploadVo() {
	}

	

	  //po->vo
  	public EbpFileUploadVo(EbpFileUpload e){
		this.setId(e.getId());
		this.setPackageId(e.getPackageId());
		this.setProjectId(e.getProjectId());
		this.setCodeId(e.getCodeId());
		this.setFileName(e.getFileName());
		this.setFileType(e.getFileType());
		this.setFilePath(e.getFilePath());
		this.setFileSize(e.getFileSize());
		this.setIsValid(e.getIsValid());
		this.setOpTime(e.getOpTime());
		this.setUserName(e.getUserName());
		this.setDispIndex(e.getDispIndex());
		this.setObjectId(e.getObjectId());
  	}
  	
  	//此方法将vo转为po
  	public EbpFileUpload adapterToEbpFileUpload(){
  		EbpFileUpload e = new EbpFileUpload();
		e.setId(this.getId());
		e.setPackageId(this.getPackageId());
		e.setProjectId(this.getProjectId());
		e.setCodeId(this.getCodeId());
		e.setFileName(this.getFileName());
		e.setFileType(this.getFileType());
		e.setFilePath(this.getFilePath());
		e.setFileSize(this.getFileSize());
		e.setIsValid(this.getIsValid());
		e.setOpTime(this.getOpTime());
		e.setUserName(this.getUserName());
		e.setDispIndex(this.getDispIndex());
		e.setObjectId(this.getObjectId());
  		return e;
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

	public Integer getCodeId() {
		return this.codeId;
	}

	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

}