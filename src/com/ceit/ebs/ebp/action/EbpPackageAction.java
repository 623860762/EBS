package com.ceit.ebs.ebp.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.service.IEbpPackageService;
import com.ceit.ebs.ebp.vo.EbpObjectVo;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *@author gr
 *@date 2014-8-22 上午11:29:38
 */

@SuppressWarnings({ "serial", "unchecked" })
public class EbpPackageAction extends ActionSupport implements ModelDriven{
	
	
	static Log log=LogFactory.getLog(EbpPackageAction.class);
	
	//业务数据
	private EbpPackageVo ebpPackageVo;
	private EbpObjectVo ebpObjectVo;
	private JSONArray packageJSON;
	private JSONObject packageObj;
	private IEbpPackageService ebpPackageService;
	
	//分包业务数据
	private String num;//分标的个数
	private String objectid;//字符串可能是11，也可能是（11，12）形式
	private String projectid;
	private String packageid;
	
	//分布数据
	private String rows;//每页显示行数
	private String page;//当前页码
	
	/**
	 * 跳转到分包页面
	 * @return
	 */
	public String turnToDividePackage(){
		return SUCCESS;
	}
	/**
	 * 跳转到树形标分包页面
	 * @return
	 */
	public String turnToDivideObjectTree(){
		return SUCCESS;
	}
	/**
	 * 获得标下所有包
	 * @return
	 */
	public String getPackageByObjectId(){
		try {
			if(objectid==null||("").equals(objectid)){
				objectid = "0";
			}
			if(page==null||("").equals(page)){
				page = "0";
			}
			if(rows==null||("").equals(rows)){
				rows = "10";
			}
			PageInfo<EbpPackageVo> ebpvolist = ebpPackageService.getEbpPackagebyObjectId(Integer
					.parseInt(objectid), Integer.parseInt(page), Integer
					.parseInt(rows));
			packageObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			
		} catch (Exception e) {
			log.info("EbpPackage");
			return "Failure";
		}
		return SUCCESS;
	}
	/**
	 * 修改一条记录
	 * @return
	 */
	public String modifyEbpPackage(){
		try{
			boolean result = ebpPackageService.modifyEbpPackage(ebpPackageVo);
			if(result){
				packageObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		packageObj = JSONObject.fromObject("{'result':'false'}");
		return "Failure";
	}
	
	/**
	 * 通过id删除一条记录,对是否进行批量删除进行了判断
	 * @return
	 */
	public String deletePackagebyId(){
		boolean result = false;
		try {
			if(packageid.contains(",")){
				//进行批量删除操作
				result = ebpPackageService.deleteEbpPackageBatch(packageid);
			}else{
				result = ebpPackageService.deleteEbpPackagebyId(Integer.parseInt(this.getPackageid()));
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
	
	/**
	 * 根据标id来获取一个标vo，并在页面上显示详情
	 * @return
	 */
	public String getPackagebyId(){
		try{
			if(packageid!=null&!("").equals(packageid)){
				ebpPackageVo = ebpPackageService.getEbpPackagebyId(Integer.parseInt(packageid));
				return SUCCESS;
			}
		}catch(Exception e){
			log.info(e);
			e.printStackTrace();
		}
		
		return "Failure";
	}
	/**
	 * 获得某一projectid下的所有分包
	 * @return
	 */
	public String getEbpPackagebyProjectId(){
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
			PageInfo<EbpPackageVo> ebpvolist = ebpPackageService.getEbpPackagebyProjectId(Integer
					.parseInt(projectid), Integer.parseInt(page), Integer
					.parseInt(rows));
			packageObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			
		} catch (Exception e) {
			log.info("EbpPackage");
			return "Failure";
		}
		return SUCCESS;

	}
	/**
	 * 项目下分包
	 * @return
	 */
	public String dividePackageInProject(){
		packageObj = new JSONObject();
		packageJSON = new JSONArray();
		boolean result = false;
		try {
			if (num != null && projectid != null) {
				int a = Integer.parseInt(projectid);
				int b = Integer.parseInt(num);
				result = ebpPackageService.dividePackageInProject(a, b);
				if (result){
					packageObj = JSONObject.fromObject("{'result':'true'}");
					//packageJSON.add(packageObj);
					return SUCCESS;
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("EbpPackageAciton");
		}
		packageObj = JSONObject.fromObject("{'result':'false'}");
		packageJSON.add(packageObj);
		return "Failure";
	}
	/**
	 * 标下分包
	 * @return
	 */
	public String dividePackageInObject(){
		packageObj = new JSONObject();
		packageJSON = new JSONArray();
		boolean result = false;
		try {
			if (num != null && objectid != null) {
				int a = Integer.parseInt(objectid);
				int b = Integer.parseInt(num);
				result = ebpPackageService.dividePackageInObject(Integer.parseInt(projectid), a, b);
				if (result){
					packageObj = JSONObject.fromObject("{'result':'true'}");
					//packageJSON.add(packageObj);
					return SUCCESS;
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("EbpPackageAciton");
		}
		packageObj = JSONObject.fromObject("{'result':'false'}");
		packageJSON.add(packageObj);
		return "Failure";
	}
	/**
	 * 查询所有数据，供列表显示
	 * @return
	 */
	public String querydata(){
		try {
			if(this.getPage()!=null&&this.getRows()!=null){
				PageInfo<EbpPackageVo> ebpvolist = ebpPackageService.querydata(
						Integer.parseInt(page), Integer.parseInt(rows));
				packageObj = JSONObject.fromObject(ebpvolist.getContentJSon());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;	
	}
	
	public Object getModel() {
	       if(ebpPackageVo == null){
	    	   ebpPackageVo = new EbpPackageVo();
	       }
	       return ebpPackageVo;
	    }

	//getter setter方法
	public EbpPackageVo getEbpPackageVo() {
		return ebpPackageVo;
	}


	public void setEbpPackageVo(EbpPackageVo ebpPackageVo) {
		this.ebpPackageVo = ebpPackageVo;
	}


	public EbpObjectVo getEbpObjectVo() {
		return ebpObjectVo;
	}


	public void setEbpObjectVo(EbpObjectVo ebpObjectVo) {
		this.ebpObjectVo = ebpObjectVo;
	}

	public JSONArray getPackageJSON() {
		return packageJSON;
	}


	public void setPackageJSON(JSONArray packageJSON) {
		this.packageJSON = packageJSON;
	}


	public JSONObject getPackageObj() {
		return packageObj;
	}


	public void setPackageObj(JSONObject packageObj) {
		this.packageObj = packageObj;
	}


	public IEbpPackageService getEbpPackageService() {
		return ebpPackageService;
	}


	public void setEbpPackageService(IEbpPackageService ebpPackageService) {
		this.ebpPackageService = ebpPackageService;
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


	public String getProjectid() {
		return projectid;
	}


	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}


	public String getPackageid() {
		return packageid;
	}


	public void setPackageid(String packageid) {
		this.packageid = packageid;
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
