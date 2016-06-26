package com.ceit.ebs.sys.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.ebs.sys.service.ISysResourceService;
import com.ceit.ebs.sys.vo.SysResourceVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class SysResourceAction extends ActionSupport implements ModelDriven{
	static Log log=LogFactory.getLog(SysResourceAction.class);
	private static final long serialVersionUID = 398335955122618041L;
	private ISysResourceService sysResourceService;
	private JSONArray resourceJSON;
	private SysResourceVo sysResourceVo;

	public JSONArray getResourceJSON() {
		return resourceJSON;
	}
	
	public void setResourceJSON(JSONArray resourceJSON) {
		this.resourceJSON = resourceJSON;
	}
	
	public void setSysResourceService(ISysResourceService sysResourceService) {
		this.sysResourceService = sysResourceService;
	}
	

	public SysResourceVo getSysResourceVo() {
		return sysResourceVo;
	}

	public void setSysResourceVo(SysResourceVo sysResourceVo) {
		this.sysResourceVo = sysResourceVo;
	}

	public Object getModel() {
       if(sysResourceVo == null){
    	   sysResourceVo = new SysResourceVo();
       }
       return sysResourceVo;
    }
	
	/**
	 * 根据功能id获取子级资源,tree JSON形式
	 * @author wujinshui
	 */
	public String getResourceForTree(){
		try {
			resourceJSON = new JSONArray();
			if(sysResourceVo.getParentId() != null){
				List<SysResourceVo> resoruceData = this.sysResourceService.getResourceListByParentId(sysResourceVo.getParentId());
				for(int i=0; i<resoruceData.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", resoruceData.get(i).getId());
					jsonObject.put("text", resoruceData.get(i).getResourceName());
					//flag表示类型 0-模块，1-功能，2-资源
					jsonAttribute.put("flag", 2);
					jsonAttribute.put("resourceAlias", resoruceData.get(i).getResourceAlias());
					jsonAttribute.put("resourceUrl", resoruceData.get(i).getResourceUrl());
					jsonAttribute.put("dispIndex", resoruceData.get(i).getDispIndex());
					jsonAttribute.put("parentId", resoruceData.get(i).getParentId());
					jsonAttribute.put("isAudit", resoruceData.get(i).getIsAudit());
					jsonObject.put("attributes", jsonAttribute);
					jsonObject.put("state", "open");
					resourceJSON.add(jsonObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("通过父节点id获取所有子级资源出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取资源
	 * @author wujinshui
	 */
	public String getResourceById(){
		try {
			if(sysResourceVo.getId() != null){
				sysResourceVo = this.sysResourceService.getSysResourcebyId(sysResourceVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取资源出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取资源
	 * @author wujinshui
	 */
	public String modifyResourceById(){
		try {
			if(sysResourceVo.getId() != null){
				sysResourceVo = this.sysResourceService.getSysResourcebyId(sysResourceVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取资源出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id更新资源信息
	 */
	public String updateResourceById(){
		try {
			resourceJSON = new JSONArray();
			this.sysResourceService.modifySysResource(sysResourceVo);
			resourceJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("根据id更新资源信息出现异常");
			resourceJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id上移资源节点
	 * @author wujinshui
	 */
	public String upMoveResource(){
		try {
			resourceJSON = new JSONArray();
			this.sysResourceService.moveResource(sysResourceVo.getId(), 1);
			resourceJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("上移菜单出现异常");
			resourceJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id下移资源节点
	 * @author wujinshui
	 */
	public String downMoveResource(){
		try {
			resourceJSON = new JSONArray();
			this.sysResourceService.moveResource(sysResourceVo.getId(), 0);
			resourceJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("下移菜单出现异常");
			resourceJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 插入新的资源节点
	 * @author wujinshui
	 */
	public String insertResource(){
		try{
			resourceJSON = new JSONArray();
			this.sysResourceService.insertSysResource(sysResourceVo);
			resourceJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("插入资源节点出现异常");
			resourceJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id删除资源节点
	 */
	public String deleteResource(){
		try {
			resourceJSON = new JSONArray();
			this.sysResourceService.deleteSysResourcebyId(sysResourceVo.getId());
			resourceJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("删除资源节点出现异常");
			resourceJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}

}
