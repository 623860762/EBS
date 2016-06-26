package com.ceit.common.enumDefine;

public enum YesNoEnum {
	Y{ 
		public String getCode() { 
			return "Y";
		}
	 
		public String getName() { 
			return "是";
		}
	},N{ 
		public String getCode() { 
			return "N";
		}
	 
		public String getName() { 
			return "否";
		}
	};
	public abstract String  getCode();
	public abstract String  getName();
}
