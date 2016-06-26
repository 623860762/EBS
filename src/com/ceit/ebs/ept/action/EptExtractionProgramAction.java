/**
 * @文件名: EptExtractionProgramAction.java 
 * @包名: com.ceit.ebs.ept.action  
 * @描述: TODO   
 * @作者: 梁艾   
 * @日期: 2014-8-22 下午03:57:19   
 * @版本: V1.0 
 */
package com.ceit.ebs.ept.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.action.EbpProjectAction;
import com.ceit.ebs.ept.service.IEptExtractionProgramService;
import com.ceit.ebs.ept.vo.EptExtractionProgramVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @ClassName: EptExtractionProgramAction
 * @Description: 抽取方案Action
 * @author 梁艾
 * @date 2014-8-22 下午03:57:19
 */
public class EptExtractionProgramAction extends ActionSupport implements ModelDriven{

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = 1374547500945409829L;

	static Log log=LogFactory.getLog(EbpProjectAction.class);
	
	
	private EptExtractionProgramVo eptExtractionProgramVo;
	private JSONArray programJSON;
	private JSONObject programObj;
	
	private IEptExtractionProgramService eptExtractionProgramService;
	
	//每页行数
	private String rows;
	//当前页码
	private String page;
	
	private String projectid;
	private String programid;
	

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public Object getModel() {
		  if(eptExtractionProgramVo == null){
			  eptExtractionProgramVo = new EptExtractionProgramVo();
	       }
	       return eptExtractionProgramVo;
	}

	

	/**
	 * @return the programid
	 */
	public String getProgramid() {
		return programid;
	}



	/**
	 * @param programid the programid to set
	 */
	public void setProgramid(String programid) {
		this.programid = programid;
	}



	/**
	 * @param eptExtractionProgramService the eptExtractionProgramService to set
	 */
	public void setEptExtractionProgramService(
			IEptExtractionProgramService eptExtractionProgramService) {
		this.eptExtractionProgramService = eptExtractionProgramService;
	}



	/**
	 * @param eptExtractionProgramVo the eptExtractionProgramVo to set
	 */
	public void setEptExtractionProgramVo(
			EptExtractionProgramVo eptExtractionProgramVo) {
		this.eptExtractionProgramVo = eptExtractionProgramVo;
	}

	/**
	 * @return the programJSON
	 */
	public JSONArray getProgramJSON() {
		return programJSON;
	}

	/**
	 * @param programJSON the programJSON to set
	 */
	public void setProgramJSON(JSONArray programJSON) {
		this.programJSON = programJSON;
	}

	/**
	 * @return the programObj
	 */
	public JSONObject getProgramObj() {
		return programObj;
	}

	/**
	 * @param programObj the programObj to set
	 */
	public void setProgramObj(JSONObject programObj) {
		this.programObj = programObj;
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
	 * @return the eptExtractionProgramVo
	 */
	public EptExtractionProgramVo getEptExtractionProgramVo() {
		return eptExtractionProgramVo;
	}

	/**
	 * 
	 * @Title: getProgramByProjectId
	 * @Description: 项目下抽取方案
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-23 上午11:16:10
	 * @throws
	 */
	public String getProgramByProjectId(){
		try {
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EptExtractionProgramVo> volist = eptExtractionProgramService.getProgramByProjectId(Integer.parseInt(projectid), Integer.parseInt(page), Integer.parseInt(rows));
				programObj = JSONObject.fromObject(volist.getContentJSon());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
	
	public String autoExtractExpert(){
		boolean result = false;
		try{
			result = eptExtractionProgramService.autoExtractExpert(Integer.parseInt(programid));
			if(result){
				programObj = new JSONObject();
				programObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		programObj = new JSONObject();
		programObj = JSONObject.fromObject("{'result':'false'}");
		return "Failure";
	}
}
