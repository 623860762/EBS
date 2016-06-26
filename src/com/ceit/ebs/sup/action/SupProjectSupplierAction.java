package com.ceit.ebs.sup.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.ebs.sup.service.ISupProjectSupplierService;
import com.ceit.ebs.sup.vo.SupProjectSupplierVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 *@author czg
 *@date 2014-8-18 
 */


public class SupProjectSupplierAction extends ActionSupport implements ModelDriven<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6362255722824247151L;
	private SupProjectSupplierVo supProjectSupplierVo;
	private JSONArray projectSupplierJSON;
	private JSONObject projectSupplierObj;
	
	private ISupProjectSupplierService supProjectSupplierService;
	
	private String rows;
	private String page;
	private String supplierId;
	private String pacId;
	private String proId;
	
	

	public SupProjectSupplierVo getSupProjectSupplierVo() {
		return supProjectSupplierVo;
	}

	public void setSupProjectSupplierVo(SupProjectSupplierVo supProjectSupplierVo) {
		this.supProjectSupplierVo = supProjectSupplierVo;
	}

	public JSONArray getProjectSupplierJSON() {
		return projectSupplierJSON;
	}

	public void setProjectSupplierJSON(JSONArray projectSupplierJSON) {
		this.projectSupplierJSON = projectSupplierJSON;
	}

	public JSONObject getProjectSupplierObj() {
		return projectSupplierObj;
	}

	public void setProjectSupplierObj(JSONObject projectSupplierObj) {
		this.projectSupplierObj = projectSupplierObj;
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

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getPacId() {
		return pacId;
	}

	public void setPacId(String pacId) {
		this.pacId = pacId;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public void setSupProjectSupplierService(
			ISupProjectSupplierService supProjectSupplierService) {
		this.supProjectSupplierService = supProjectSupplierService;
	}

	//传给投标各个Id
	public String getPriId(){
		System.out.println(supplierId);
		System.out.println(pacId);
		System.out.println(proId);
		try{
			supProjectSupplierVo=supProjectSupplierService.getVoByOtherId(Integer.parseInt(supplierId), Integer.parseInt(pacId), Integer.parseInt(proId));
			if(supProjectSupplierVo!=null){
				projectSupplierObj=new JSONObject();
				projectSupplierObj=JSONObject.fromObject("{'result':'true'}");
			    return SUCCESS;
				
			}
			else{
				projectSupplierObj = new JSONObject();
				projectSupplierObj = JSONObject.fromObject("{'result':'false'}");
						
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Failture";	
	}
	
	
	//购买招标文件
	public String buyFiles(){
		try{
			boolean result;
			result=supProjectSupplierService.buyObjectFiles(Integer.parseInt(supplierId), Integer.parseInt(pacId));
			if(result){
				projectSupplierObj=new JSONObject();
				projectSupplierObj=JSONObject.fromObject("{'result':'true'}");
			    return SUCCESS;
			}
			else{
				projectSupplierObj = new JSONObject();
				projectSupplierObj = JSONObject.fromObject("{'result':'false'}");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Failture";
	}
	
	//下载招标文件
	public String loadFiles(){
		try{
			Integer count = (supProjectSupplierService.getFilePath(Integer.parseInt(supplierId), Integer.parseInt(proId), Integer.parseInt(pacId))).size();
			if(count>0){
				projectSupplierObj=new JSONObject();
				projectSupplierObj=JSONObject.fromObject("{'result':'true'}");
			    return SUCCESS;
			}
			else{
				projectSupplierObj = new JSONObject();
				projectSupplierObj = JSONObject.fromObject("{'result':'false'}");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Failture";
	}

	//override
	public Object getModel() {
	       if(supProjectSupplierVo == null){
	    	   supProjectSupplierVo = new SupProjectSupplierVo();
	       }
	       return supProjectSupplierVo;
	}
	
}