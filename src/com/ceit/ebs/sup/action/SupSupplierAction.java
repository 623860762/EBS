package com.ceit.ebs.sup.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sup.service.ISupSupplierService;
import com.ceit.ebs.sup.vo.SupSupplierVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 *@author czg
 *@date 2014-8-18 
 */

@SuppressWarnings({ "serial", "unchecked" })
public class SupSupplierAction extends ActionSupport implements ModelDriven{

	// Fields


	
	//项目管理页面参数
	private SupSupplierVo supSupplierVo;
	private JSONArray supplierJSON;
	private JSONObject supplierObj;
	
	private ISupSupplierService supSupplierService;
	
	private String rows;
	private String page;
	private String supId;
	

	//通过ID设置供应商审核失败
	public String failAudit(){
		try{
			System.out.println(supId);
			boolean result = supSupplierService.failAudit(Integer.parseInt(supId));
			if(result){
				supplierObj = new JSONObject();
				supplierObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
			else{
				
				return "Failture";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "Failture";
		}
	}
	
	//通过ID设置供应商通过审核
	public String passAudit(){
		try{
			System.out.println(supId);
			boolean result = supSupplierService.passAudit(Integer.parseInt(supId));
			if(result){
				supplierObj = new JSONObject();
				supplierObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
			else{
				supplierObj = new JSONObject();
				supplierObj = JSONObject.fromObject("{'result':'false'}");
				return "Failture";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "Failture";
		}
	}

	
	//通过一个vo来修改一条记录
	public String updateSupSupplier(){
		try {
			boolean result = supSupplierService.modifySupSupplier(supSupplierVo);
			if(result)
				return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failure";
		
	}
	
	//通过id删除一条数据
	public String deleteSupSupplierbyId(){
		try{
			System.out.println(this.getSupId());
			boolean result=supSupplierService.deleteSupSupplierbyId(Integer.parseInt(supId));
			if(result){
				return SUCCESS;
			}
			else{
				return "Failture";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "Failture";
		}
	}
	
	//通过id获取vo对象
	public String getSupSupplierVobyId(){
		try {
			if(supId!=null&&!("").equals(supId)){
				supSupplierVo = supSupplierService.getSupSupplierbyId(Integer.parseInt(supId));
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
				PageInfo<SupSupplierVo> supvolist = supSupplierService.querydata(//此处用到依赖注入
						Integer.parseInt(page), Integer.parseInt(rows));
				supplierObj = JSONObject.fromObject(supvolist.getContentJSon());//vo——>json
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}

	
	public String insertSupplier(){
		
		Integer reid = supSupplierService.insertSupSupplier(supSupplierVo);
		if(reid>0){
			supplierObj = new JSONObject();
			supplierObj = JSONObject.fromObject("{'result':'true'}");
			return SUCCESS;//SUCCESS是ActionSupport中的一個常量
		}else{
			supplierObj = new JSONObject();
			supplierObj = JSONObject.fromObject("{'result':'false'}");
			return "Failure";
		}
	}
	// Property accessors
	//override
	public Object getModel() {
	       if(supSupplierVo == null){
	    	   supSupplierVo = new SupSupplierVo();
	       }
	       return supSupplierVo;
	    }
	
	
	


	public String getSupId() {
		return supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	public JSONArray getSupplierJSON() {
		return supplierJSON;
	}

	public void setSupplierJSON(JSONArray supplierJSON) {
		this.supplierJSON = supplierJSON;
	}

	public JSONObject getSupplierObj() {
		return supplierObj;
	}

	public void setSupplierObj(JSONObject supplierObj) {
		this.supplierObj = supplierObj;
	}

	public ISupSupplierService getSupSupplierService() {
		return supSupplierService;
	}

	public void setSupSupplierService(ISupSupplierService supSupplierService) {
		this.supSupplierService = supSupplierService;
	}

	public SupSupplierVo getSupSupplierVo() {
		return supSupplierVo;
	}

	public void setSupSupplierVo(SupSupplierVo supSupplierVo) {
		this.supSupplierVo = supSupplierVo;
	}

	public JSONArray getProjectJSON() {
		return supplierJSON;
	}

	public void setProjectJSON(JSONArray supplierJSON) {
		this.supplierJSON = supplierJSON;
	}

	public JSONObject getProjectObj() {
		return supplierObj;
	}

	public void setProjectObj(JSONObject supplierObj) {
		this.supplierObj = supplierObj;
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