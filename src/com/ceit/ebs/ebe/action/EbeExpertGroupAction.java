package com.ceit.ebs.ebe.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.service.IEbeExpertGroupService;
import com.ceit.ebs.ebe.service.IEbeGroupService;
import com.ceit.ebs.ebe.service.impl.EbeGroupService;
import com.ceit.ebs.ebe.vo.EbeExpertGroupVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings({ "serial", "unchecked" })
public class EbeExpertGroupAction extends ActionSupport implements ModelDriven{
	//项目管理页面参数
	private EbeExpertGroupVo ebeExpertGroupVo;
	private IEbeGroupService ebeGroupService;
	private IEbeExpertGroupService ebeExpertGroupService;
	private JSONArray ebeExpertGroupJSON;
	private JSONObject ebeExpertGroupObj;
	//每页行数
	private String rows;
	//当前页码
	private String page;
	
	private String expertGroupIds;
	private String expertGroupId;
	private String myGroupId;
	private String myProjectName;
	private String myProjectId;
	int tempGroupId;
	
	
	
	public IEbeGroupService getEbeGroupService() {
		return ebeGroupService;
	}
	public void setEbeGroupService(IEbeGroupService ebeGroupService) {
		this.ebeGroupService = ebeGroupService;
	}
	public String getExpertGroupIds() {
		return expertGroupIds;
	}
	public void setExpertGroupIds(String expertGroupIds) {
		this.expertGroupIds = expertGroupIds;
	}
	public String getMyProjectName() {
		return myProjectName;
	}
	public void setMyProjectName(String myProjectName) {
		this.myProjectName = myProjectName;
	}
	public String getMyProjectId() {
		return myProjectId;
	}
	public void setMyProjectId(String myProjectId) {
		this.myProjectId = myProjectId;
	}
	public String getExpertGroupId() {
		return expertGroupId;
	}
	public void setExpertGroupId(String expertGroupId) {
		this.expertGroupId = expertGroupId;
	}
	public int getTempGroupId() {
		return tempGroupId;
	}
	public void setTempGroupId(int tempGroupId) {
		this.tempGroupId = tempGroupId;
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

	public JSONArray getEbeExpertGroupJSON() {
		return ebeExpertGroupJSON;
	}

	public void setEbeExpertGroupJSON(JSONArray ebeExpertGroupJSON) {
		this.ebeExpertGroupJSON = ebeExpertGroupJSON;
	}

	public JSONObject getEbeExpertGroupObj() {
		return ebeExpertGroupObj;
	}
	public void setEbeExpertGroupObj(JSONObject ebeExpertGroupObj) {
		this.ebeExpertGroupObj = ebeExpertGroupObj;
	}
	public EbeExpertGroupVo getEbeExpertGroupVo() {
		return ebeExpertGroupVo;
	}
	public void setEbeExpertGroupVo(EbeExpertGroupVo ebeExpertGroupVo) {
		this.ebeExpertGroupVo = ebeExpertGroupVo;
	}
	public IEbeExpertGroupService getEbeExpertGroupService() {
		return ebeExpertGroupService;
	}
	public void setEbeExpertGroupService(IEbeExpertGroupService ebeExpertGroupService) {
		this.ebeExpertGroupService = ebeExpertGroupService;
	}
	

	public String getMyGroupId() {
		return myGroupId;
	}
	public void setMyGroupId(String myGroupId) {
		this.myGroupId = myGroupId;
	}
	public Object getModel() {
	       if(ebeExpertGroupVo == null){
	    	   ebeExpertGroupVo = new EbeExpertGroupVo();
	       }
	       return ebeExpertGroupVo;
	    }

	//查询组内专家,-1表示没有组
	public String showExpertInGroup(){
		if(this.getMyGroupId() == null || "-1".equals(this.getTempGroupId())){ ebeExpertGroupObj=null;return SUCCESS;}
		try {
			this.setTempGroupId(Integer.parseInt(myGroupId));
			if(this.getPage()!=null&&this.getPage()!=null){
				PageInfo<EbeExpertGroupVo> ebeExpertGroupVo = ebeExpertGroupService.showExpertInGroup(tempGroupId,Integer.parseInt(page), Integer.parseInt(rows));
				ebeExpertGroupObj = JSONObject.fromObject(ebeExpertGroupVo.getContentJSon());
				this.setTempGroupId(-1);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
	
	//专家出组（expertGroup 的groupId置为-1)
	public String deleteEbeExpertGroupbyId(){
		try {
			ebeExpertGroupVo = ebeExpertGroupService.getEbeExpertGroupbyId(Integer.parseInt(expertGroupId));
			ebeExpertGroupVo.setGroupId(-1);
			boolean result = ebeExpertGroupService.modifyEbeExpertGroup(ebeExpertGroupVo);
			if(result)return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failure";
	}
	
	//设置/取消组长（expertGroup 的ishead置为1或0）
	public String setHeader(){
		try {
			ebeExpertGroupVo = ebeExpertGroupService.getEbeExpertGroupbyId(Integer.parseInt(expertGroupId));
			if(ebeExpertGroupVo.getIsHeader() == 1) {ebeExpertGroupVo.setIsHeader(0);}
			else {ebeExpertGroupVo.setIsHeader(1);}
			boolean result = ebeExpertGroupService.modifyEbeExpertGroup(ebeExpertGroupVo);
			if(result)return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failure";
	}
	//从manageBaseInfo跳转到mangeEbeExpertGroup
	public String jumpEbeExpertGroup(){
		return SUCCESS;
	}
	
	//查询可以入组的专家
	public String showExpertCouldInGroup(){
		try {
			if(this.getPage()!=null&&this.getPage()!=null){
				String type = ebeGroupService.getEbeGroupbyId(Integer.parseInt(myGroupId)).getGroupType();
				PageInfo<EbeExpertGroupVo> ebeExpertGroupVo = ebeExpertGroupService.getExpertCouldIntoGroup(type,Integer.parseInt(page), Integer.parseInt(rows));
				ebeExpertGroupObj = JSONObject.fromObject(ebeExpertGroupVo.getContentJSon());
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return SUCCESS;
	}
	
	//专家入组
	public String addExpertToGroup(){
		System.out.println(myGroupId);
		if(ebeExpertGroupService.expertIntoGroup(expertGroupIds, Integer.parseInt(myGroupId))== true){
			return SUCCESS;
		}else{
			return "Failure";
		}
	}
}
