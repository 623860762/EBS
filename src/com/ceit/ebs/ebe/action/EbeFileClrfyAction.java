package com.ceit.ebs.ebe.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.service.IEbeFileClrfyService;
import com.ceit.ebs.ebe.vo.EbeFileClrfyVo;
import com.ceit.ebs.ebp.service.IEbpPackageService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings({ "serial", "unchecked" })
public class EbeFileClrfyAction extends ActionSupport implements ModelDriven{
	//项目管理页面参数
	private EbeFileClrfyVo ebeFileClrfyVo;
	private IEbeFileClrfyService ebeFileClrfyService;
	private IEbpPackageService ebpPackageService;
	private JSONArray ebeFileClrfyJSON;
	private JSONObject ebeFileClrfyObj;
	//每页行数
	private String rows;
	//当前页码
	private String page;
	
	private String ebeFileClrfyId;
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
	public JSONArray getEbeFileClrfyJSON() {
		return ebeFileClrfyJSON;
	}
	public String getEbeFileClrfyId() {
		return ebeFileClrfyId;
	}
	public void setEbeFileClrfyId(String ebeFileClrfyId) {
		this.ebeFileClrfyId = ebeFileClrfyId;
	}
	public void setEbeFileClrfyJSON(JSONArray ebeFileClrfyJSON) {
		this.ebeFileClrfyJSON = ebeFileClrfyJSON;
	}

	public JSONObject getEbeFileClrfyObj() {
		return ebeFileClrfyObj;
	}
	public void setEbeFileClrfyObj(JSONObject ebeFileClrfyObj) {
		this.ebeFileClrfyObj = ebeFileClrfyObj;
	}
	public EbeFileClrfyVo getEbeFileClrfyVo() {
		return ebeFileClrfyVo;
	}
	public void setEbeFileClrfyVo(EbeFileClrfyVo ebeFileClrfyVo) {
		this.ebeFileClrfyVo = ebeFileClrfyVo;
	}
	public IEbeFileClrfyService getEbeFileClrfyService() {
		return ebeFileClrfyService;
	}
	public void setEbeFileClrfyService(IEbeFileClrfyService ebeFileClrfyService) {
		this.ebeFileClrfyService = ebeFileClrfyService;
	}
	public Object getModel() {
	       if(ebeFileClrfyVo == null){
	    	   ebeFileClrfyVo = new EbeFileClrfyVo();
	       }
	       return ebeFileClrfyVo;
	    }

	public String insertEbeFileClrfy(){
		if(ebeFileClrfyService.insertEbeFileClrfy(ebeFileClrfyVo) > 0){
			ebeFileClrfyObj = new JSONObject();
			ebeFileClrfyObj = JSONObject.fromObject("{'result':'true'}");
			return SUCCESS;
		}
		else{
			ebeFileClrfyObj = new JSONObject();
			ebeFileClrfyObj = JSONObject.fromObject("{'result':'false'}");
			return "Failure";
		}
	}
	//查询详细废标记录
	public String showEbeFileClrfy() throws UnsupportedEncodingException{
		String mySupplierName1=java.net.URLDecoder.decode(mySupplierName, "UTF-8");
			ebeFileClrfyVo = ebeFileClrfyService.getEbeFileClrfybyId(ebeFileClrfyVo.getId());
			ebeFileClrfyVo.setProviderName(mySupplierName1);
			ebeFileClrfyObj = new JSONObject();
			ebeFileClrfyObj = JSONObject.fromObject(ebeFileClrfyVo);
		return SUCCESS;
	}
	//澄清记录列表
	public String queryData(){
		try {
			if(this.getPage()!=null&&this.getPage()!=null){
				PageInfo<EbeFileClrfyVo> ebeFileClrfyvolistPI = ebeFileClrfyService.querydata(
						Integer.parseInt(page), Integer.parseInt(rows));
				List<EbeFileClrfyVo> ebeFileClrfyVoList = ebeFileClrfyvolistPI.getEntityList();
				//遍历Vo列表，获取每一个的各种name属性
				for(int i = 0; i < ebeFileClrfyVoList.size(); i++){
					Integer packageId = ebeFileClrfyVoList.get(i).getPackageId();
					if(ebpPackageService.getEbpPackagebyId(packageId) != null){
						ebeFileClrfyVoList.get(i).setPackageName(ebpPackageService.getEbpPackagebyId(packageId).getPackageName());
					}
					//TODO 没有供应商表，写死
					Integer supplierId = ebeFileClrfyVoList.get(i).getProviderId();
					ebeFileClrfyVoList.get(i).setProviderName("xxx公司");
				}
				//重新包装成pageInfo对象
				ebeFileClrfyvolistPI=new PageInfo<EbeFileClrfyVo>(ebeFileClrfyVoList,ebeFileClrfyvolistPI.getDataCount(),Integer.parseInt(page), Integer.parseInt(rows));
				ebeFileClrfyObj = JSONObject.fromObject(ebeFileClrfyvolistPI.getContentJSon());
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
	
	//通过id删除一条EbeFileClrfy记录
	public String deleteEbeFileClrfybyId(){
		try {	
			boolean result = ebeFileClrfyService.deleteEbeFileClrfybyId(Integer.parseInt(this.getEbeFileClrfyId()));
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
	public String updateEbeFileClrfy(){
		try {
			boolean result = ebeFileClrfyService.modifyEbeFileClrfy(ebeFileClrfyVo);
			if(result)return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failure";
	}
}
