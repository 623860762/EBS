package com.ceit.common.util;

import java.io.Serializable;
import java.util.List;

public class PageInfo<E> implements Serializable {

	private static final long serialVersionUID = -314272199043388590L;
	public static String DEFAULT_ROWS = "15";  

	public PageInfo(List<E> list,Integer dataCount,Integer currentPageNumber,Integer perPageCount)
	{
		this.entityList=list;
		this.dataCount=dataCount;
		this.currentPageNumber=currentPageNumber;
		this.perPageCount=perPageCount;
		invoke();
	}
	
   void	invoke()
	{
		//首先计算总页数
	   this.maxPageNumber=dataCount/perPageCount;
	   if(dataCount%perPageCount!=0)  maxPageNumber++;
	   if(maxPageNumber==0) maxPageNumber=1;
	   
	   //是否首/尾页
	   if(currentPageNumber<=1) {currentPageNumber=1; isFirstPage=true;};
	   if(currentPageNumber>=maxPageNumber) {currentPageNumber=maxPageNumber;isLastPage=true;}

	   
	   //计算上一页
	   if(currentPageNumber==1||currentPageNumber==0) previousPageNumber=1;
	   else previousPageNumber=currentPageNumber-1;
	   
	   //计算下一页
	   if(currentPageNumber>=maxPageNumber) nextPageNumber=maxPageNumber;
	   else nextPageNumber=currentPageNumber+1;
		
	   //是否首/尾页
	 
	   if(currentPageNumber>=maxPageNumber) {currentPageNumber=maxPageNumber;isLastPage=true;}
	   
	   StringBuffer sb = new StringBuffer();
	   sb.append("{\"total\":"+dataCount+",\"rows\":[");
	   for(int i=0;i<entityList.size();i++){
		   if(i!=0){
			   sb.append(",");
		   }
		   sb.append(GenericsUtils.toJson(entityList.get(i)));
		   
	   }
      sb.append("]}"); 
      setContentJSon(sb.toString());
	}
	
	public List<E> getEntityList() {
		return entityList;
	}
	public Integer getDataCount() {
		return dataCount;
	}
	public Integer getCurrentPageNumber() {
		return currentPageNumber;
	}
	public Integer getNextPageNumber() { 
		return nextPageNumber;
	}
	public Integer getPreviousPageNumber() { 
		return previousPageNumber;
	}
	public Integer getPerPageCount() {
		return perPageCount;
	}
	public Integer getMaxPageNumber() { 
		return maxPageNumber;
	}
    private Boolean isFirstPage;
    private Boolean isLastPage;
    
	public Boolean getIsFirstPage() {
		return isFirstPage;
	}

	public Boolean getIsLastPage() {
		return isLastPage;
	}
	public void setContentJSon(String contentJSon) {
		this.contentJSon = contentJSon;
	}

	public String getContentJSon() {
		return contentJSon;
	}
	private List<E> entityList;
	private Integer dataCount;//数据总条数
    private Integer currentPageNumber;//当前页码
    private Integer nextPageNumber;//下一页页码
    private Integer previousPageNumber; //前一页
    private Integer perPageCount;//每页显示条数
    private Integer maxPageNumber;//最大页码数
    private String  contentJSon;//JSon内容
}
