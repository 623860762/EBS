package com.ceit.common.core;

import java.io.Serializable;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 2078543521990904735L;
	protected Long opTime;
	
	public Long getOpTime() {
		return opTime;
	}
	public void setOpTime(Long opTime) {
		this.opTime = opTime;
	}

}
