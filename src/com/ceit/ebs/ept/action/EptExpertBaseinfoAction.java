/**
 * @文件名: EptExpertBaseinfoAction.java 
 * @包名: com.ceit.ebs.ept.action  
 * @描述: TODO   
 * @作者: 梁艾   
 * @日期: 2014-8-25 下午04:38:01   
 * @版本: V1.0 
 */
package com.ceit.ebs.ept.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.service.IEptExpertBaseinfoService;
import com.ceit.ebs.ept.vo.EptExpertBaseinfoVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @ClassName: EptExpertBaseinfoAction
 * @Description: 
 * @author 梁艾
 * @date 2014-8-25 下午04:38:01
 */
public class EptExpertBaseinfoAction extends ActionSupport implements ModelDriven{

	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = 7441597205514080981L;
	private EptExpertBaseinfoVo eptExpertBaseinfoVo;
	private JSONArray infoJSON;
	private JSONObject infoObj;
	
	private IEptExpertBaseinfoService eptExpertBaseinfoService;
	
	//每页行数
	private String rows;
	//当前页码
	private String page;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public Object getModel() {
		if(eptExpertBaseinfoVo == null){
			eptExpertBaseinfoVo = new EptExpertBaseinfoVo();
	       }
	       return eptExpertBaseinfoVo;
	}
	/**
	 * @return the eptExpertBaseinfoVo
	 */
	public EptExpertBaseinfoVo getEptExpertBaseinfoVo() {
		return eptExpertBaseinfoVo;
	}
	/**
	 * @param eptExpertBaseinfoVo the eptExpertBaseinfoVo to set
	 */
	public void setEptExpertBaseinfoVo(EptExpertBaseinfoVo eptExpertBaseinfoVo) {
		this.eptExpertBaseinfoVo = eptExpertBaseinfoVo;
	}
	/**
	 * @return the infoJSON
	 */
	public JSONArray getInfoJSON() {
		return infoJSON;
	}
	/**
	 * @param infoJSON the infoJSON to set
	 */
	public void setInfoJSON(JSONArray infoJSON) {
		this.infoJSON = infoJSON;
	}
	/**
	 * @return the infoObj
	 */
	public JSONObject getInfoObj() {
		return infoObj;
	}
	/**
	 * @param infoObj the infoObj to set
	 */
	public void setInfoObj(JSONObject infoObj) {
		this.infoObj = infoObj;
	}
	/**
	 * @return the rows
	 */
	public String getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(String rows) {
		this.rows = rows;
	}
	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}
	/**
	 * @param eptExpertBaseinfoService the eptExpertBaseinfoService to set
	 */
	public void setEptExpertBaseinfoService(
			IEptExpertBaseinfoService eptExpertBaseinfoService) {
		this.eptExpertBaseinfoService = eptExpertBaseinfoService;
	}
	
	public String querydata(){
		try {
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EptExpertBaseinfoVo> volist = eptExpertBaseinfoService.querydata(Integer.parseInt(page), Integer.parseInt(rows));
				infoObj = JSONObject.fromObject(volist.getContentJSon());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
	

}
