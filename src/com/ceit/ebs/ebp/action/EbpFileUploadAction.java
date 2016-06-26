package com.ceit.ebs.ebp.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.service.IEbpFileUploadService;
import com.ceit.ebs.ebp.vo.EbpFileUploadVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 *@author czg
 *@date 2014-8-18 
 */

@SuppressWarnings({ "serial", "unchecked" })
public class EbpFileUploadAction extends ActionSupport implements ModelDriven{

	// Fields


	
	//项目管理页面参数
	private EbpFileUploadVo ebpFileUploadVo;
	private JSONArray fileUploadJSON;
	private JSONObject fileUploadObj;
	
	private IEbpFileUploadService ebpFileUploadService;
	
	private String rows;
	private String page;
	private String supId;

	
	//通过id获取vo对象
	public String getEbpFileUploadVobyId(){
		try {
			if(supId!=null&&!("").equals(supId)){
				ebpFileUploadVo = ebpFileUploadService.getEbpFileUploadbyId(Integer.parseInt(supId));
				return SUCCESS;
			}
			return "Failure";
				
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}		
	}

	
	//通过rows,page获取数据,并把取到的数据放入到数据库里
	
	public String queryData(){
		try {
			if(this.getPage()!=null && this.getRows()!=null){
				PageInfo<EbpFileUploadVo> supvolist = ebpFileUploadService.querydata(//此处用到依赖注入
						Integer.parseInt(page), Integer.parseInt(rows));
				fileUploadObj = JSONObject.fromObject(supvolist.getContentJSon());//vo——>json
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failure";
		
	}

	// Property accessors
	//override
	public Object getModel() {
	       if(ebpFileUploadVo == null){
	    	   ebpFileUploadVo = new EbpFileUploadVo();
	       }
	       return ebpFileUploadVo;
	    }
	
	
	


	public String getSupId() {
		return supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	public JSONArray getSupplierJSON() {
		return fileUploadJSON;
	}

	public void setSupplierJSON(JSONArray fileUploadJSON) {
		this.fileUploadJSON = fileUploadJSON;
	}

	public JSONObject getSupplierObj() {
		return fileUploadObj;
	}

	public void setSupplierObj(JSONObject fileUploadObj) {
		this.fileUploadObj = fileUploadObj;
	}

	public IEbpFileUploadService getEbpFileUploadService() {
		return ebpFileUploadService;
	}

	public void setEbpFileUploadService(IEbpFileUploadService ebpFileUploadService) {
		this.ebpFileUploadService = ebpFileUploadService;
	}

	public EbpFileUploadVo getEbpFileUploadVo() {
		return ebpFileUploadVo;
	}

	public void setEbpFileUploadVo(EbpFileUploadVo ebpFileUploadVo) {
		this.ebpFileUploadVo = ebpFileUploadVo;
	}

	public JSONArray getFileUploadJSON() {
		return fileUploadJSON;
	}

	public void setFileUploadJSON(JSONArray fileUploadJSON) {
		this.fileUploadJSON = fileUploadJSON;
	}

	public JSONObject getFileUploadObj() {
		return fileUploadObj;
	}

	public void setFileUploadObj(JSONObject fileUploadObj) {
		this.fileUploadObj = fileUploadObj;
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

	

}