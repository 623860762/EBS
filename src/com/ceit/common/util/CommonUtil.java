package com.ceit.common.util;

import org.hibernate.Hibernate;
import org.hibernate.type.NullableType;

public class CommonUtil {
	private static CommonUtil instance;// 设置私有静态变量（类变量）
	private CommonUtil() {}

	/**
	 * 获得CommonUtil实例
	 * @return CommonUtil 对象实例
	 */
	public static synchronized CommonUtil getInstance() {
		if (instance == null) {
			instance = new CommonUtil();
		}
		return instance;
	}
	@SuppressWarnings("unchecked")
	public static NullableType getNullabletype(Class type){
		if(type.equals(Integer.class)){
			return Hibernate.INTEGER;
		}else if(type.equals(String.class)){
			return Hibernate.STRING;
		}
	    
		return null;
	}
	
	public static String getFileSize(String filesize){
		Double temp=Double.parseDouble(filesize);
		String resultString="";
		int i=0;
		if(temp<1024*1024){
			resultString =((Double)(temp/1024)).toString();
			i=resultString.indexOf(".");
			resultString=resultString.substring(0, i+2)+"KB";
		}else if(temp<1024*1024*1024 && temp>=1024*1024){
			resultString =((Double)(temp/(1024*1024))).toString();
			i=resultString.indexOf(".");
			resultString=resultString.substring(0, i+2)+"MB";
		}else{
			resultString =((Double)(temp/(1024*1024*1024))).toString();
			i=resultString.indexOf(".");
			resultString=resultString.substring(0, i+2)+"GB";
		}
		return resultString;
	}
}
