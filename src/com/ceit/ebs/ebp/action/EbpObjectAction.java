package com.ceit.ebs.ebp.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.service.IEbpObjectService;
import com.ceit.ebs.ebp.service.IEbpProjectService;
import com.ceit.ebs.ebp.vo.EbpObjectVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 *@author gr
 *@date 2014-08-21 08:09:26
 */

@SuppressWarnings({ "serial", "unchecked" })
public class EbpObjectAction extends ActionSupport implements ModelDriven{
	
	static Log log=LogFactory.getLog(EbpObjectAction.class);
	
	//项目管理页面参数
	private EbpObjectVo ebpObjectVo;
	private JSONArray objectJSON;
	private JSONObject objectObj;
	
	private IEbpObjectService ebpObjectService;
	private IEbpProjectService ebpProjectService;
	
	//每页行数
	private String rows;//每页显示行数
	//当前页码
	private String page;//当前页码
	
	//分标业务数据
	private String num;//分标的个数
	
	private String objectid;//字符串可能是11，也可能是（11，12）形式
	private String projectid;
	
	/**
	 * 通过id删除一条记录
	 * @return
	 */
	public String deleteObjectbyId(){
		boolean result = false;
		try {
			if(objectid.contains(",")){
				//进行批量删除操作
				result = ebpObjectService.deleteEbpObjectBatch(objectid);
			}else{
				result = ebpObjectService.deleteEbpObjectbyId(Integer.parseInt(this.getObjectid()));
			}
			if(result){
				return SUCCESS;
			}
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
		}
		return "Failure";
	}
	public String modifyObject(){
		objectObj = new JSONObject();
		try{
			boolean result = ebpObjectService.modifyEbpObject(ebpObjectVo);
			if(result){
				objectObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		objectObj = JSONObject.fromObject("{'result':'false'}");
		return "Failure";
	}
	/**
	 * 获取parentid下的所有object,tree JSON形式
	 */
	public String getObjectForTree(){
		try {
			objectJSON = new JSONArray();
			if(projectid != null){
				List<EbpObjectVo> objectData = this.ebpObjectService.getEbpObjectListbyProjectId(Integer.parseInt(projectid));
				String name = ebpProjectService.getEbpProjectbyId(Integer.parseInt(projectid)).getProjectName();
				JSONArray json = new JSONArray();
				JSONObject json1 = new JSONObject();
				for(int i=0; i<objectData.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", objectData.get(i).getId());
					jsonObject.put("text", objectData.get(i).getObjectName());
					jsonAttribute.put("creatorId", objectData.get(i).getCreatorId());
					jsonAttribute.put("dispIndex", objectData.get(i).getDispIndex());
					jsonAttribute.put("dispIndex", objectData.get(i).getDispIndex());
					jsonAttribute.put("isValid", objectData.get(i).getIsValid());
					jsonAttribute.put("projectId", objectData.get(i).getProjectId());
					jsonAttribute.put("updateTime", objectData.get(i).getUpdateTime());
					jsonObject.put("attributes", jsonAttribute);
					
					json.add(jsonObject);
					
				}
				json1.put("id", projectid);
				json1.put("text", name);
				json1.put("children", json);
				objectJSON.add(json1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("通过父节点id获取所有子级组织机构节点出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据标id来获取一个标vo，并在页面上显示详情
	 * @return
	 */
	public String getObjectbyId(){
		try{
			if(objectid!=null&!("").equals(objectid)){
				ebpObjectVo = ebpObjectService.getEbpObjectbyId(Integer.parseInt(objectid));
				return SUCCESS;
			}
		}catch(Exception e){
			log.info(e);
			e.printStackTrace();
		}
		
		return "Failure";
	}
	/**
	 * 跳转到分标页面
	 * @return
	 */
	public String turnToDivideObject(){
		return SUCCESS;
	}
	/**
	 * 查询所有数据，供列表显示
	 * @return
	 */
	public String querydata(){
		try {
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EbpObjectVo> ebpvolist = ebpObjectService.queryData(
						Integer.parseInt(page), Integer.parseInt(rows));
				objectObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;	
	}
	/**
	 * 分标业务
	 * @return
	 */
	public String divideObject(){
		objectObj = new JSONObject();
		objectJSON = new JSONArray();
		try {
			if (num != null && projectid != null) {
				int ptid = Integer.parseInt(projectid);
				int numi = Integer.parseInt(num);
				boolean result = ebpObjectService.divideObject(ptid, numi);
				if (result){
					objectObj = JSONObject.fromObject("{'result':'true'}");
					objectJSON.add(objectObj);
					return SUCCESS;
				}	
			}
		} catch (Exception e) {
			log.info("EbpObjectAciton");
		}
		objectObj = JSONObject.fromObject("{'result':'false'}");
		objectJSON.add(objectObj);
		return "Failure";
	}
	/**
	 * 通过projectid获取objectvo
	 * @return
	 */
	public String getObjectbyProjectId(){
		try {
			if(projectid==null||("").equals(projectid)){
				projectid = "0";
			}
			if(page==null||("").equals(page)){
				page = "0";
			}
			if(rows==null||("").equals(rows)){
				rows = "10";
			}
			PageInfo<EbpObjectVo> ebpvolist = ebpObjectService.getEbpObjectbyProjectId(Integer
					.parseInt(projectid), Integer.parseInt(page), Integer
					.parseInt(rows));
			objectObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			
		} catch (Exception e) {
			log.info("EbpObject");
			return "Failure";
		}
		return SUCCESS;
	}
	
	
	public EbpObjectVo getEbpObjectVo() {
		return ebpObjectVo;
	}

	public void setEbpObjectVo(EbpObjectVo ebpObjectVo) {
		this.ebpObjectVo = ebpObjectVo;
	}

	public JSONArray getObjectJSON() {
		return objectJSON;
	}


	public void setObjectJSON(JSONArray objectJSON) {
		this.objectJSON = objectJSON;
	}


	public JSONObject getObjectObj() {
		return objectObj;
	}


	public void setObjectObj(JSONObject objectObj) {
		this.objectObj = objectObj;
	}


	public IEbpObjectService getEbpObjectService() {
		return ebpObjectService;
	}

	public void setEbpObjectService(IEbpObjectService ebpObjectService) {
		this.ebpObjectService = ebpObjectService;
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

	public Object getModel() {
	       if(ebpObjectVo == null){
	    	   ebpObjectVo = new EbpObjectVo();
	       }
	       return ebpObjectVo;
	    }

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}

	public String getObjectid() {
		return objectid;
	}

	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	public IEbpProjectService getEbpProjectService() {
		return ebpProjectService;
	}
	public void setEbpProjectService(IEbpProjectService ebpProjectService) {
		this.ebpProjectService = ebpProjectService;
	}

	

}