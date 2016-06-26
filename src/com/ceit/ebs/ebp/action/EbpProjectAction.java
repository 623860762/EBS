package com.ceit.ebs.ebp.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.service.IEbpProjectService;
import com.ceit.ebs.ebp.vo.EbpProjectVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 *@author gr
 *@date 2014-8-16 上午09:44:41
 */

@SuppressWarnings({ "serial", "unchecked" })
public class EbpProjectAction extends ActionSupport implements ModelDriven{
	
	static Log log=LogFactory.getLog(EbpProjectAction.class);
	
	//项目管理页面参数
	private EbpProjectVo ebpProjectVo;
	private JSONArray projectJSON;
	private JSONObject projectObj;
	
	private IEbpProjectService ebpProjectService;
	
	//每页行数
	private String rows;
	//当前页码
	private String page;
	
	private String projectid;

	//通过id获取vo对象
	public String getEbpProjectVobyId(){
		try {
			if(projectid!=null)
			ebpProjectVo = ebpProjectService.getEbpProjectbyId(Integer
					.parseInt(projectid));
			return SUCCESS;
		} catch (Exception e) {
			log.info("ebpprojectaction");
		}
		return "Failure";
	}
	/**
	 * 由立项下发到分标
	 * @return
	 */
	public String nextFromProject(){
		boolean result = false;
		try{
			EbpProjectVo epv = ebpProjectService.getEbpProjectbyId(Integer.parseInt(projectid));
			if(epv.getIsObject()!="N"){
				result = ebpProjectService.statusTransformed(Integer.parseInt(projectid), "EDIT", "FBOBJECT");
			}else{
				result = ebpProjectService.statusTransformed(Integer.parseInt(projectid), "EDIT", "FBPACKAGE");
			}
			if(result){
				projectObj = new JSONObject();
				projectObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		projectObj = new JSONObject();
		projectObj = JSONObject.fromObject("{'result':'false'}");
		return "Failure";
	}
	/**
	 * 确认分标操作
	 * @return
	 */
	public String nextFromObject(){
		boolean result = false;
		try{
			result = ebpProjectService.statusTransformed(Integer.parseInt(projectid), "EDIT", "FBPACKAGE");
			if(result){
				projectObj = new JSONObject();
				projectObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		projectObj = new JSONObject();
		projectObj = JSONObject.fromObject("{'result':'false'}");
		return "Failure";
	}
	
	/**
	 * 确认分包操作
	 * @return
	 */
	public String nextFromPackage(){
		boolean result = false;
		try{
			result = ebpProjectService.statusTransformed(Integer.parseInt(projectid), "EDIT", "ZB");
			if(result){
				projectObj = new JSONObject();
				projectObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		projectObj = new JSONObject();
		projectObj = JSONObject.fromObject("{'result':'false'}");
		return "Failure";
	}
	
	
	//通过一个vo来修改一条记录
	public String updateEbpProject(){
		try {
			boolean result = ebpProjectService.modifyEbpProject(ebpProjectVo);
			if(result){
				projectObj = new JSONObject();
				projectObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
		} catch (Exception e) {
			log.info("ebpprojectaction");
			e.printStackTrace();
		}
		projectObj = new JSONObject();
		projectObj = JSONObject.fromObject("{'result':'false'}");
		return "Failure";
	}
	//通过id删除一条EbpProject记录
	public String deleteEbpProjectbyId(){
		try {
			
			boolean result = ebpProjectService.deleteEbpProjectbyId(Integer.parseInt(this.getProjectid()));
			if(result){
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failure";
	}
	
	//通过pageSize,pageIndex获取数据,并把取到的数据放入到数据库里
	public String queryData(){
		try {
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EbpProjectVo> ebpvolist = ebpProjectService.querydata(
						Integer.parseInt(page), Integer.parseInt(rows));
				projectObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
	/**
	 * 插入一条记录
	 * @return
	 */
	public String insertProject(){
		Integer reid = 0;
		try {
			reid = ebpProjectService.insertEbpProject(ebpProjectVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//获取新增的vo对象
		if(reid>0){
			projectObj = new JSONObject();
			projectObj = JSONObject.fromObject("{'result':'true'}");
			return SUCCESS;
		}else{
			projectObj = new JSONObject();
			projectObj = JSONObject.fromObject("{'result':'false'}");
			return "Failure";
		}
	}
	/**
	 * 重写getModel方法
	 */
	public Object getModel() {
	       if(ebpProjectVo == null){
	    	   ebpProjectVo = new EbpProjectVo();
	       }
	       return ebpProjectVo;
	    }
	/**
	 * 获取所有分标的项目,即分标字段为“Y”
	 * @return
	 */
	public String getEbpProjectbyIsObject(){
		try{
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EbpProjectVo> ebpvolist = ebpProjectService.querydata(Integer.parseInt(page), Integer.parseInt(rows));
				projectObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			}
			return SUCCESS;
		}catch(Exception e){
			log.info("EbpProjectAction===="+e);
			e.printStackTrace();
		}
		return "Failure";
	}
	
	/**
	 * 获取所有分标的项目,即分标字段为“N”(其实也有可能为空)
	 * @return
	 */
	public String getEbpProjectNotIsObject(){
		try{
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EbpProjectVo> ebpvolist = ebpProjectService.getEbpProjectVobyIsObject("N", Integer.parseInt(page), Integer.parseInt(rows));
				projectObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			}
			return SUCCESS;
		}catch(Exception e){
			log.info("EbpProjectAction===="+e);
			e.printStackTrace();
		}
		return "Failure";
	}
	/**
	 * 得到立项数据
	 * @return
	 */
	public String getLXEbpProject(){
		try{
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EbpProjectVo> ebpvolist = ebpProjectService.getEbpProjectVobyStatus("EDIT", "LX", Integer.parseInt(page), Integer.parseInt(rows));
				projectObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			}
			return SUCCESS;
		}catch(Exception e){
			log.info("EbpProjectAction===="+e);
			e.printStackTrace();
		}
		return "Failure";
	}
	/**
	 * 得到审核数据，小状态是SH，审核状态有未审核，审核中，通过，未通过
	 * @return
	 */
	public String getSHEbpProject(){
		try{
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EbpProjectVo> ebpvolist = ebpProjectService.getSHEbpProjectVo(Integer.parseInt(page), Integer.parseInt(rows));
				projectObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			}
			return SUCCESS;
		}catch(Exception e){
			log.info("EbpProjectAction===="+e);
			e.printStackTrace();
		}
		return "Failure";
	}
	/**
	 * 重立项操作
	 * @return
	 */
	public String returnToLXProject(){
		try{
			boolean result = ebpProjectService.returnToLXProject(Integer.parseInt(projectid));
			if(result){
				projectObj = new JSONObject();
				projectObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.info(e);
		}
		projectObj = new JSONObject();
		projectObj = JSONObject.fromObject("{'result':'false'}");
		return "Failure";
	}
	/**
	 * 提交审核操作
	 */
	public String submitForAudit(){
		try{
			boolean result = ebpProjectService.statusTransformed(Integer.parseInt(projectid), "EDIT", "SH");
			if(result){
				projectObj = new JSONObject();
				projectObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.info(e);
		}
		projectObj = new JSONObject();
		projectObj = JSONObject.fromObject("{'result':'false'}");
		return "Failure";
	}
	/**
	 * 发标操作
	 * @return
	 */
	public String sendObject(){
		try{
			boolean result = ebpProjectService.statusTransformed(Integer.parseInt(projectid), "Xxx", "xx");
			if(result){
				projectObj = new JSONObject();
				projectObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
		}catch(Exception e){
			e.printStackTrace();
			log.info(e);
		}
		projectObj = new JSONObject();
		projectObj = JSONObject.fromObject("{'result':'false'}");
		return "Failure";
	}
	/**
	 * 得到分标数据
	 * @return
	 */
	public String getFBIAOEbpProject(){
		try{
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EbpProjectVo> ebpvolist = ebpProjectService.getEbpProjectVobyStatus("EDIT", "FBOBJECT", Integer.parseInt(page), Integer.parseInt(rows));
				projectObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			}
			return SUCCESS;
		}catch(Exception e){
			log.info("EbpProjectAction===="+e);
			e.printStackTrace();
		}
		return "Failure";
	}
	/**
	 * 得到分包数据
	 * @return
	 */
	public String getFBAOEbpProject(){
		try{
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EbpProjectVo> ebpvolist = ebpProjectService.getEbpProjectVobyStatus("EDIT", "FBPACKAGE", Integer.parseInt(page), Integer.parseInt(rows));
				projectObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			}
			return SUCCESS;
		}catch(Exception e){
			log.info("EbpProjectAction===="+e);
			e.printStackTrace();
		}
		return "Failure";
	}

	public IEbpProjectService getEbpProjectService() {
		return ebpProjectService;
	}

	public void setEbpProjectService(IEbpProjectService ebpProjectService) {
		this.ebpProjectService = ebpProjectService;
	}

	public EbpProjectVo getEbpProjectVo() {
		return ebpProjectVo;
	}

	public void setEbpProjectVo(EbpProjectVo ebpProjectVo) {
		this.ebpProjectVo = ebpProjectVo;
	}

	public JSONArray getProjectJSON() {
		return projectJSON;
	}

	public void setProjectJSON(JSONArray projectJSON) {
		this.projectJSON = projectJSON;
	}

	public JSONObject getProjectObj() {
		return projectObj;
	}

	public void setProjectObj(JSONObject projectObj) {
		this.projectObj = projectObj;
	}


	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	
}