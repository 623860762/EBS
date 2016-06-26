package com.ceit.ebs.sup.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.sup.service.ISupReplyValService;
import com.ceit.ebs.sup.vo.SupReplyValVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 *@author czg
 *@date 2014-8-18 
 */

@SuppressWarnings({ "serial", "unchecked" })
public class SupReplyValAction extends ActionSupport implements ModelDriven{

	// Fields
	private SupReplyValVo supReplyValVo;
	private JSONArray replyJSON;
	private JSONObject replyObj;
	
	private ISupReplyValService supReplyValService;//注意此处定义的为接口
	
	private String rows;
	private String page;
	private String suppId;
	private String proId;
	private String pacId;
	private String price;
	
	//记录报价
	public String uploadPay(){
		try{
			boolean result = supReplyValService.uploadPrice(Integer.parseInt(suppId), Integer.parseInt(proId), Integer.parseInt(pacId), Integer.parseInt(price));
			if(result){
				replyObj=new JSONObject();
				replyObj=JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
			else{
				replyObj=new JSONObject();
				replyObj=JSONObject.fromObject("{'result':'false'}");				
			}				
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Failture";
	}
	//此处注意该函数必须要加
	public Object getModel() {
	       if(supReplyValVo == null){
	    	   supReplyValVo = new SupReplyValVo();
	       }
	       return supReplyValVo;
	    }
	
	


	public JSONArray getReplyJSON() {
		return replyJSON;
	}

	public void setReplyJSON(JSONArray replyJSON) {
		this.replyJSON = replyJSON;
	}

	public JSONObject getReplyObj() {
		return replyObj;
	}

	public void setReplyObj(JSONObject replyObj) {
		this.replyObj = replyObj;
	}

	public ISupReplyValService getSupReplyValService() {
		return supReplyValService;
	}

	public void setSupReplyValService(ISupReplyValService supReplyValService) {
		this.supReplyValService = supReplyValService;
	}

	public SupReplyValVo getSupReplyValVo() {
		return supReplyValVo;
	}

	public void setSupReplyValVo(SupReplyValVo supReplyValVo) {
		this.supReplyValVo = supReplyValVo;
	}

	public JSONArray getProjectJSON() {
		return replyJSON;
	}

	public void setProjectJSON(JSONArray replyJSON) {
		this.replyJSON = replyJSON;
	}

	public JSONObject getProjectObj() {
		return replyObj;
	}

	public void setProjectObj(JSONObject replyObj) {
		this.replyObj = replyObj;
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


	public String getSuppId() {
		return suppId;
	}
	public void setSuppId(String supId) {
		this.suppId = supId;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getPacId() {
		return pacId;
	}
	public void setPacId(String pacId) {
		this.pacId = pacId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}