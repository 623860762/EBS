package com.ceit.ebs.ebe.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.service.IEbeGroupService;
import com.ceit.ebs.ebe.vo.EbeGroupVo;
import com.ceit.ebs.ebp.service.IEbpPackageService;
import com.ceit.ebs.ebp.service.IEbpProjectService;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings({ "serial", "unchecked" })
public class EbeGroupAction extends ActionSupport implements ModelDriven{
	//项目管理页面参数
	private EbeGroupVo ebeGroupVo;
	private IEbeGroupService ebeGroupService;
	private IEbpPackageService ebpPackageService;
	private IEbpProjectService ebpProjectService;
	private JSONArray ebeGroupJSON;
	private JSONObject ebeGroupObj;
	//每页行数
	private String rows;
	//当前页码
	private String page;
	
	private String groupId;
	private String myProjectName;
	private String myProjectId;

	
	public String getMyProjectId() {
		return myProjectId;
	}
	public void setMyProjectId(String myProjectId) {
		this.myProjectId = myProjectId;
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
	public String getMyProjectName() {
		return myProjectName;
	}
	public void setMyProjectName(String myProjectName) {
		this.myProjectName = myProjectName;
	}
	public JSONArray getEbeGroupJSON() {
		return ebeGroupJSON;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public void setEbeGroupJSON(JSONArray ebeGroupJSON) {
		this.ebeGroupJSON = ebeGroupJSON;
	}
	public JSONObject getEbeGroupObj() {
		return ebeGroupObj;
	}
	public void setEbeGroupObj(JSONObject ebeGroupObj) {
		this.ebeGroupObj = ebeGroupObj;
	}
	public EbeGroupVo getEbeGroupVo() {
		return ebeGroupVo;
	}
	public void setEbeGroupVo(EbeGroupVo ebeGroupVo) {
		this.ebeGroupVo = ebeGroupVo;
	}
	public IEbeGroupService getEbeGroupService() {
		return ebeGroupService;
	}
	public void setEbeGroupService(IEbeGroupService ebeGroupService) {
		this.ebeGroupService = ebeGroupService;
	}
	public Object getModel() {
	       if(ebeGroupVo == null){
	    	   ebeGroupVo = new EbeGroupVo();
	       }
	       return ebeGroupVo;
	    }

	public String insertEbeGroup(){
		ebeGroupVo.setGroupPrincipalId(null);
		ebeGroupVo.setGroupPrincipalName(null);
		ebeGroupVo.setProjectId(Integer.parseInt(myProjectId));
		if(ebeGroupService.insertEbeGroup(ebeGroupVo) > 0){
			
			ebeGroupObj = new JSONObject();
			ebeGroupObj = JSONObject.fromObject("{'result':'true'}");
			return SUCCESS;
		}
		else{
			ebeGroupObj = new JSONObject();
			ebeGroupObj = JSONObject.fromObject("{'result':'false'}");
			return "Failure";
		}
	}
	
	//小组记录列表
	public String queryGroupInProject(){
		try {
			if(this.getPage()!=null&&this.getPage()!=null){
				PageInfo<EbeGroupVo> ebeGroupvolistPI = ebeGroupService.queryGroupInProject(
						Integer.parseInt(page), Integer.parseInt(rows),Integer.parseInt(myProjectId));
				ebeGroupObj = JSONObject.fromObject(ebeGroupvolistPI.getContentJSon());
			}
			//System.out.println("projectJSON======"+projectJSON);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
	
	//通过id删除一条EbeGroup记录
	public String deleteEbeGroupbyId(){
		try {	
			boolean result = ebeGroupService.deleteEbeGroupbyId(Integer.parseInt(this.getGroupId()));
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
	public String updateEbeGroup(){
		try {
			boolean result = ebeGroupService.modifyEbeGroup(ebeGroupVo);
			if(result)return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failure";
	}
	
	public String showEbeGroup(){
		ebeGroupVo = ebeGroupService.getEbeGroupbyId(ebeGroupVo.getId());
		ebeGroupObj = new JSONObject();
		ebeGroupObj = JSONObject.fromObject(ebeGroupVo);
		return SUCCESS;
	}
	
	//跳转用
	public String  jumpEbeGroup(){
		return SUCCESS;
	}
	
	//获得小组树,按分类显示
	public String getGroupTree(){
		ebeGroupJSON=new JSONArray();
		JSONObject busiObj;JSONArray busiJSON=new JSONArray();
		JSONObject techObj;JSONArray techJSON=new JSONArray();
		JSONObject priceObj;JSONArray priceJSON=new JSONArray();
		int busiCount=0,techCount=0,priceCount=0;
		try {
			//获取所有指定项目下的小组
			PageInfo<EbeGroupVo> ebeGroupvolistPI = ebeGroupService.queryGroupInProject(
					1, ebeGroupService.getCount(),Integer.parseInt(myProjectId));
			List<EbeGroupVo> egv = ebeGroupvolistPI.getEntityList();
			for(int i=0 ; i< egv.size(); i++)
			{
				//按分类加入指定的child jsonobject
				if("BUSI".equals(egv.get(i).getGroupType())){
					busiObj=new JSONObject();
					busiObj.put("id",egv.get(i).getId()+"");
					busiObj.put("text",egv.get(i).getGroupName());
					busiJSON.add(busiObj);busiCount++;
				}else if("PRICE".equals(egv.get(i).getGroupType())){
					priceObj=new JSONObject();
					priceObj.put("id",egv.get(i).getId()+"");
					priceObj.put("text",egv.get(i).getGroupName());
					priceJSON.add(priceObj);priceCount++;
				}else if("TECH".equals(egv.get(i).getGroupType())){
					techObj=new JSONObject();
					techObj.put("id",egv.get(i).getId()+"");
					techObj.put("text",egv.get(i).getGroupName());
					techJSON.add(techObj);techCount++;
				}
			}
			//TODO　设置成９９９９防止点击小组分类就显示小组成员
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "9999");jsonObject.put("text", "商务类专家小组");
			if(busiCount != 0){jsonObject.put("children", busiJSON);}
			ebeGroupJSON.add(jsonObject);
			jsonObject = new JSONObject();
			jsonObject.put("id", "9999");jsonObject.put("text", "价格类专家小组");
			if(priceCount != 0){jsonObject.put("children",priceJSON); jsonObject.put("state","closed");}
			ebeGroupJSON.add(jsonObject);
			jsonObject = new JSONObject();
			jsonObject.put("id", "9999");jsonObject.put("text", "技术类专家小组");
			if(techCount != 0){jsonObject.put("children",techJSON); jsonObject.put("state","closed");}
			ebeGroupJSON.add(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
}
