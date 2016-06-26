package com.ceit.common.entity;

import java.io.Serializable;

/**
 * 字典表实体类
 * @author wujinshui
 * 
 */

public class EBPDict implements Serializable,Comparable<EBPDict>{
	private static final long serialVersionUID = 2123268741974488717L;
	
	private String dicId; 
	
	private String dicName; 
	 	 
	private String dicParentId; 
 
	private Integer dispIndex;
	
	private String memo;
	
	private String updateTime;

	public String getDicId() {
		return dicId;
	}

	public void setDicId(String dicId) {
		this.dicId = dicId;
	}

	public String getDicName() {
		return dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	public String getDicParentId() {
		return dicParentId;
	}

	public void setDicParentId(String dicParentId) {
		this.dicParentId = dicParentId;
	}

	public Integer getDispIndex() {
		return dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public int compareTo(EBPDict o) {
		if(getDicId().equals(o.getDicId())) {
			return 0;
		}else{
			if(getDispIndex()==o.getDispIndex()) { 
				return 1;
			}else{
				return  getDispIndex().compareTo(o.getDispIndex());
			}
		} 
	}
	

}
