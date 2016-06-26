package com.ceit.ebs.ebe.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.service.IEbeGroupPackageService;
import com.ceit.ebs.ebe.vo.EbeGroupPackageVo;
import com.ceit.ebs.ebp.service.IEbpPackageService;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings({ "serial", "unchecked" })
public class EbeGroupPackageAction extends ActionSupport implements ModelDriven{
	//项目管理页面参数
	private EbeGroupPackageVo ebeGroupPackageVo;
	private IEbeGroupPackageService ebeGroupPackageService;
	private IEbpPackageService ebpPackageService;
	private JSONArray ebeGroupPackageJSON;
	private JSONObject ebeGroupPackageObj;
	//每页行数
	private String rows;
	//当前页码
	private String page;
	
	private String groupId;
	private String type; 
	private String myPackageName;
	private String myPackageIds;

	
	public String getMyPackageIds() {
		return myPackageIds;
	}
	public void setMyPackageIds(String myPackageIds) {
		this.myPackageIds = myPackageIds;
	}
	public IEbpPackageService getEbpPackageService() {
		return ebpPackageService;
	}
	public void setEbpPackageService(IEbpPackageService ebpPackageService) {
		this.ebpPackageService = ebpPackageService;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	public String getMyPackageName() {
		return myPackageName;
	}
	public void setMyPackageName(String myPackageName) {
		this.myPackageName = myPackageName;
	}
	public JSONArray getEbeGroupPackageJSON() {
		return ebeGroupPackageJSON;
	}

	public void setEbeGroupPackageJSON(JSONArray ebeGroupPackageJSON) {
		this.ebeGroupPackageJSON = ebeGroupPackageJSON;
	}

	public JSONObject getEbeGroupPackageObj() {
		return ebeGroupPackageObj;
	}
	public void setEbeGroupPackageObj(JSONObject ebeGroupPackageObj) {
		this.ebeGroupPackageObj = ebeGroupPackageObj;
	}
	public EbeGroupPackageVo getEbeGroupPackageVo() {
		return ebeGroupPackageVo;
	}
	public void setEbeGroupPackageVo(EbeGroupPackageVo ebeGroupPackageVo) {
		this.ebeGroupPackageVo = ebeGroupPackageVo;
	}
	public IEbeGroupPackageService getEbeGroupPackageService() {
		return ebeGroupPackageService;
	}
	public void setEbeGroupPackageService(IEbeGroupPackageService ebeGroupPackageService) {
		this.ebeGroupPackageService = ebeGroupPackageService;
	}
	public Object getModel() {
	       if(ebeGroupPackageVo == null){
	    	   ebeGroupPackageVo = new EbeGroupPackageVo();
	       }
	       return ebeGroupPackageVo;
	    }

	//初始化组包关系
	public String initPackageGroup(){
		PageInfo<EbpPackageVo> ebpPackVoPI = ebpPackageService.querydata(1,ebpPackageService.getCount());
		List<EbpPackageVo> ebpPackageVoList = ebpPackVoPI.getEntityList();
		for (int i = 0; i < ebpPackageVoList.size(); i++) {
			if(ebeGroupPackageService.initGroupPackage(ebpPackageVoList.get(i)) == false){
				return "Failure";
			}
		}
		return SUCCESS;
	}
	//组内可以关联的包
	public String showPackageNotInGroupList(){
		try {
			if(this.getPage()!=null&&this.getPage()!=null){
				PageInfo<EbeGroupPackageVo> ebeGroupPackagevolistPI = ebeGroupPackageService.showPackageNotInGroupList(
						type,Integer.parseInt(page), Integer.parseInt(rows));
				List<EbeGroupPackageVo> ebeGroupPackageVoList = ebeGroupPackagevolistPI.getEntityList();
				//遍历Vo列表，获取每一个的各种name属性
				for(int i = 0; i < ebeGroupPackageVoList.size(); i++){
					Integer packageId = ebeGroupPackageVoList.get(i).getPackageId();
					if(ebpPackageService.getEbpPackagebyId(packageId) != null){
						ebeGroupPackageVoList.get(i).setPackageName(ebpPackageService.getEbpPackagebyId(packageId).getPackageName());
					}
				}
				//重新包装成pageInfo对象
				ebeGroupPackagevolistPI=new PageInfo<EbeGroupPackageVo>(ebeGroupPackageVoList,ebeGroupPackagevolistPI.getDataCount(),Integer.parseInt(page), Integer.parseInt(rows));
				ebeGroupPackageObj = JSONObject.fromObject(ebeGroupPackagevolistPI.getContentJSon());
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
	//组内关联的包
	public String showGroupPackageList(){
		try {
			if(this.getPage()!=null&&this.getPage()!=null){
				PageInfo<EbeGroupPackageVo> ebeGroupPackagevolistPI = ebeGroupPackageService.showGroupPackageList(
						ebeGroupPackageVo.getGroupId(),type,Integer.parseInt(page), Integer.parseInt(rows));
				List<EbeGroupPackageVo> ebeGroupPackageVoList = ebeGroupPackagevolistPI.getEntityList();
				//遍历Vo列表，获取每一个的各种name属性
				for(int i = 0; i < ebeGroupPackageVoList.size(); i++){
					Integer packageId = ebeGroupPackageVoList.get(i).getPackageId();
					if(ebpPackageService.getEbpPackagebyId(packageId) != null){
						ebeGroupPackageVoList.get(i).setPackageName(ebpPackageService.getEbpPackagebyId(packageId).getPackageName());
					}
				}
				//重新包装成pageInfo对象
				ebeGroupPackagevolistPI=new PageInfo<EbeGroupPackageVo>(ebeGroupPackageVoList,ebeGroupPackagevolistPI.getDataCount(),Integer.parseInt(page), Integer.parseInt(rows));
				ebeGroupPackageObj = JSONObject.fromObject(ebeGroupPackagevolistPI.getContentJSon());
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
	
	//组下关联包
	public String addPackageToGroup(){
		if(ebeGroupPackageService.groupAttachPackage(ebeGroupPackageVo.getGroupId(), type, myPackageIds)== true){
			return SUCCESS;
		}else{
			return "Failure";
		}
	}
	
	public String removePackagefromGroup(){
		if(ebeGroupPackageService.removePackageFromGroup(ebeGroupPackageVo.getGroupId(), type, myPackageIds)== true){
			return SUCCESS;
		}else{
			return "Failure";
		}
	}
}
