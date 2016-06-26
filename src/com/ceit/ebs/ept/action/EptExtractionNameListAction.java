/**
 * @文件名: EptExtractionNameListAction.java 
 * @包名: com.ceit.ebs.ept.action  
 * @描述: TODO   
 * @作者: 梁艾   
 * @日期: 2014-8-23 上午10:52:53   
 * @版本: V1.0 
 */
package com.ceit.ebs.ept.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.service.IEptExtractionNameListService;
import com.ceit.ebs.ept.vo.EptExpertBaseinfoVo;
import com.ceit.ebs.ept.vo.EptExtractionNameListVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @ClassName: EptExtractionNameListAction
 * @Description: 专家名单Action
 * @author 梁艾
 * @date 2014-8-23 上午10:52:53
 */
public class EptExtractionNameListAction extends ActionSupport implements ModelDriven{

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = -4542444117209337939L;
	private EptExtractionNameListVo eptExtractionNameListVo;
	private JSONArray namelistJSON;
	private JSONObject namelistObj;
	
	private IEptExtractionNameListService eptExtractionNameListService;
	
	//每页行数
	private String rows;
	//当前页码
	private String page;
	
	private String projectid;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public Object getModel() {
		if(eptExtractionNameListVo == null){
			  eptExtractionNameListVo = new EptExtractionNameListVo();
	       }
	       return eptExtractionNameListVo;
	}
	
	/**
	 * @return the namelistJSON
	 */
	public JSONArray getNamelistJSON() {
		return namelistJSON;
	}

	/**
	 * @param namelistJSON the namelistJSON to set
	 */
	public void setNamelistJSON(JSONArray namelistJSON) {
		this.namelistJSON = namelistJSON;
	}

	/**
	 * @return the namelistObj
	 */
	public JSONObject getNamelistObj() {
		return namelistObj;
	}

	/**
	 * @param namelistObj the namelistObj to set
	 */
	public void setNamelistObj(JSONObject namelistObj) {
		this.namelistObj = namelistObj;
	}

	/**
	 * @return the eptExtractionNameListVo
	 */
	public EptExtractionNameListVo getEptExtractionNameListVo() {
		return eptExtractionNameListVo;
	}
	/**
	 * @param eptExtractionNameListVo the eptExtractionNameListVo to set
	 */
	public void setEptExtractionNameListVo(
			EptExtractionNameListVo eptExtractionNameListVo) {
		this.eptExtractionNameListVo = eptExtractionNameListVo;
	}
	/**
	 * @return the namelistJSON
	 */
	public JSONArray getnamelistJSON() {
		return namelistJSON;
	}
	/**
	 * @param namelistJSON the namelistJSON to set
	 */
	public void setnamelistJSON(JSONArray namelistJSON) {
		this.namelistJSON = namelistJSON;
	}
	/**
	 * @return the namelistObj
	 */
	public JSONObject getnamelistObj() {
		return namelistObj;
	}
	/**
	 * @param namelistObj the namelistObj to set
	 */
	public void setnamelistObj(JSONObject namelistObj) {
		this.namelistObj = namelistObj;
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
	 * @return the projectid
	 */
	public String getProjectid() {
		return projectid;
	}
	/**
	 * @param projectid the projectid to set
	 */
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	/**
	 * @param eptExtractionNameListService the eptExtractionNameListService to set
	 */
	public void setEptExtractionNameListService(
			IEptExtractionNameListService eptExtractionNameListService) {
		this.eptExtractionNameListService = eptExtractionNameListService;
	}
	/**
	 * 
	 * @Title: getNameListByProjectId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-23 下午06:21:32
	 * @throws
	 */
	public String getNameListByProjectId(){
		try {
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EptExpertBaseinfoVo> volist = eptExtractionNameListService.getExpertIdsByProjectId(Integer.parseInt(projectid), Integer.parseInt(page), Integer.parseInt(rows));
				namelistObj = JSONObject.fromObject(volist.getContentJSon());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	
	}

}
