package com.ceit.ebs.ebe.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.service.IEbeRepealService;
import com.ceit.ebs.ebe.vo.EbeRepealVo;
import com.ceit.ebs.ebp.service.IEbpPackageService;
import com.ceit.ebs.ebp.service.IEbpProjectService;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings({ "serial", "unchecked" })
public class EbeRepealAction extends ActionSupport implements ModelDriven{
	//项目管理页面参数
	private EbeRepealVo ebeRepealVo;
	private IEbeRepealService ebeRepealService;
	private IEbpPackageService ebpPackageService;
	private IEbpProjectService ebpProjectService;
	private JSONArray ebeRepealJSON;
	private JSONObject ebeRepealObj;
	//每页行数
	private String rows;
	//当前页码
	private String page;
	
	private String repealId;
	private String mySupplierName;
	private String myPackageName;

	
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
	public IEbpProjectService getEbpProjectService() {
		return ebpProjectService;
	}
	public void setEbpProjectService(IEbpProjectService ebpProjectService) {
		this.ebpProjectService = ebpProjectService;
	}
	public IEbpPackageService getEbpPackageService() {
		return ebpPackageService;
	}
	public void setEbpPackageService(IEbpPackageService ebpPackageService) {
		this.ebpPackageService = ebpPackageService;
	}

	public String getMySupplierName() {
		return mySupplierName;
	}
	public void setMySupplierName(String mySupplierName) {
		this.mySupplierName = mySupplierName;
	}
	public String getMyPackageName() {
		return myPackageName;
	}
	public void setMyPackageName(String myPackageName) {
		this.myPackageName = myPackageName;
	}
	public JSONArray getEbeRepealJSON() {
		return ebeRepealJSON;
	}


	public String getRepealId() {
		return repealId;
	}
	public void setRepealId(String repealId) {
		this.repealId = repealId;
	}
	public void setEbeRepealJSON(JSONArray ebeRepealJSON) {
		this.ebeRepealJSON = ebeRepealJSON;
	}

	public JSONObject getEbeRepealObj() {
		return ebeRepealObj;
	}
	public void setEbeRepealObj(JSONObject ebeRepealObj) {
		this.ebeRepealObj = ebeRepealObj;
	}
	public EbeRepealVo getEbeRepealVo() {
		return ebeRepealVo;
	}
	public void setEbeRepealVo(EbeRepealVo ebeRepealVo) {
		this.ebeRepealVo = ebeRepealVo;
	}
	public IEbeRepealService getEbeRepealService() {
		return ebeRepealService;
	}
	public void setEbeRepealService(IEbeRepealService ebeRepealService) {
		this.ebeRepealService = ebeRepealService;
	}
	public Object getModel() {
	       if(ebeRepealVo == null){
	    	   ebeRepealVo = new EbeRepealVo();
	       }
	       return ebeRepealVo;
	    }

	public String insertEbeRepeal(){
		if(ebeRepealService.insertEbeRepeal(ebeRepealVo) > 0){
			ebeRepealObj = new JSONObject();
			ebeRepealObj = JSONObject.fromObject("{'result':'true'}");
			return SUCCESS;
		}
		else{
			ebeRepealObj = new JSONObject();
			ebeRepealObj = JSONObject.fromObject("{'result':'false'}");
			return "Failure";
		}
	}
	//查询详细废标记录
	public String showEbeRepeal() throws UnsupportedEncodingException{
		String myPackageName1=java.net.URLDecoder.decode(myPackageName, "UTF-8");
		String mySupplierName1=java.net.URLDecoder.decode(mySupplierName, "UTF-8");
			ebeRepealVo = ebeRepealService.getEbeRepealbyId(ebeRepealVo.getId());
			ebeRepealVo.setPackageName(myPackageName1);
			ebeRepealVo.setSupplierName(mySupplierName1);
			ebeRepealObj = new JSONObject();
			ebeRepealObj = JSONObject.fromObject(ebeRepealVo);
		return SUCCESS;
	}
	//废标记录列表
	public String queryEbeRepealData(){
		try {
			if(this.getPage()!=null&&this.getPage()!=null){
				PageInfo<EbeRepealVo> ebeRepealvolistPI = ebeRepealService.querydata(
						Integer.parseInt(page), Integer.parseInt(rows));
				List<EbeRepealVo> ebeRepealVoList = ebeRepealvolistPI.getEntityList();
				//遍历Vo列表，获取每一个的各种name属性
				for(int i = 0; i < ebeRepealVoList.size(); i++){
				
					Integer packageId = ebeRepealVoList.get(i).getPackageId();
					if(ebpPackageService.getEbpPackagebyId(packageId) != null){
						ebeRepealVoList.get(i).setPackageName(ebpPackageService.getEbpPackagebyId(packageId).getPackageName());
					}
					//TODO 没有供应商表，写死
					Integer supplierId = ebeRepealVoList.get(i).getSupplierId();
					ebeRepealVoList.get(i).setSupplierName("xxx公司");
					Integer projectId = ebeRepealVoList.get(i).getProjectId();
					if(ebpProjectService.getEbpProjectbyId(projectId) != null){
						ebeRepealVoList.get(i).setProjectName(ebpProjectService.getEbpProjectbyId(projectId).getProjectName());
					}else {ebeRepealVoList.get(i).setProjectName("null");}
				}
				//重新包装成pageInfo对象
				ebeRepealvolistPI=new PageInfo<EbeRepealVo>(ebeRepealVoList,ebeRepealvolistPI.getDataCount(),Integer.parseInt(page), Integer.parseInt(rows));
				ebeRepealObj = JSONObject.fromObject(ebeRepealvolistPI.getContentJSon());
			}
			//System.out.println("projectJSON======"+projectJSON);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
	
	//通过id删除一条EbeRepeal记录
	public String deleteEbeRepealbyId(){
		try {	
			boolean result = ebeRepealService.deleteEbeRepealbyId(Integer.parseInt(this.getRepealId()));
			if(result){
				System.out.println("删除成功！");
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failure";
	}
	
	//修改一条记录
	public String updateEbeRepeal(){
		try {
			boolean result = ebeRepealService.modifyEbeRepeal(ebeRepealVo);
			if(result)return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failure";
	}
}
