package com.ceit.ebs.sys.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.ebs.sys.service.ISysFunctionService;
import com.ceit.ebs.sys.service.ISysResourceService;
import com.ceit.ebs.sys.vo.SysFunctionVo;
import com.ceit.ebs.sys.vo.SysResourceVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class SysFunctionAction extends ActionSupport implements ModelDriven{
	static Log log=LogFactory.getLog(SysFunctionAction.class);
	private static final long serialVersionUID = 398335955122618041L;
	private ISysFunctionService sysFunctionService;
	private ISysResourceService sysResourceService;
	private JSONArray functionJSON;
	private SysFunctionVo sysFunctionVo;

	public JSONArray getFunctionJSON() {
		return functionJSON;
	}

	public void setFunctionJSON(JSONArray functionJSON) {
		this.functionJSON = functionJSON;
	}

	public void setSysFunctionService(ISysFunctionService sysFunctionService) {
		this.sysFunctionService = sysFunctionService;
	}
	
	public void setSysResourceService(ISysResourceService sysResourceService) {
		this.sysResourceService = sysResourceService;
	}

	public SysFunctionVo getSysFunctionVo() {
		return sysFunctionVo;
	}

	public void setSysFunctionVo(SysFunctionVo sysFunctionVo) {
		this.sysFunctionVo = sysFunctionVo;
	}

	public Object getModel() {
       if(sysFunctionVo == null){
    	   sysFunctionVo = new SysFunctionVo();
       }
       return sysFunctionVo;
    }
	
	/**
	 * 根据功能id获取子级资源,tree JSON形式
	 * @author wujinshui
	 */
	public String getFunctionForTree(){
		try {
			functionJSON = new JSONArray();
			if(sysFunctionVo.getParentId() != null){
				List<SysFunctionVo> functionData = this.sysFunctionService.getFunctionListByParentId(sysFunctionVo.getParentId());
				for(int i=0; i<functionData.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", functionData.get(i).getId());
					jsonObject.put("text", functionData.get(i).getName());
					//flag表示类型 0-模块，1-功能，2-资源
					jsonAttribute.put("flag", 1);
					jsonAttribute.put("dispIndex", functionData.get(i).getDispIndex());
					jsonAttribute.put("parentId", functionData.get(i).getParentId());
					jsonObject.put("attributes", jsonAttribute);
					if(this.sysResourceService.getResourceListByParentId(functionData.get(i).getId()).size() > 0){
						jsonObject.put("state", "closed");
					}
					functionJSON.add(jsonObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("通过父节点id获取所有子级功能出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取功能
	 * @author wujinshui
	 */
	public String getFunctionById(){
		try {
			if(sysFunctionVo.getId() != null){
				sysFunctionVo = this.sysFunctionService.getSysFunctionbyId(sysFunctionVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取功能出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取功能
	 * @author wujinshui
	 */
	public String modifyFunctionById(){
		try {
			if(sysFunctionVo.getId() != null){
				sysFunctionVo = this.sysFunctionService.getSysFunctionbyId(sysFunctionVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取功能出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id更新功能信息
	 */
	public String updateFunctionById(){
		try {
			functionJSON = new JSONArray();
			this.sysFunctionService.modifySysFunction(sysFunctionVo);
			functionJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("根据id更新用户信息出现异常");
			functionJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id上移功能节点
	 * @author wujinshui
	 */
	public String upMoveFunction(){
		try {
			functionJSON = new JSONArray();
			this.sysFunctionService.moveFunction(sysFunctionVo.getId(), 1);
			functionJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("上移功能出现异常");
			functionJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id下移功能节点
	 * @author wujinshui
	 */
	public String downMoveFunction(){
		try {
			functionJSON = new JSONArray();
			this.sysFunctionService.moveFunction(sysFunctionVo.getId(), 0);
			functionJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("下移功能出现异常");
			functionJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 插入新的功能节点
	 * @author wujinshui
	 */
	public String insertFunction(){
		try{
			functionJSON = new JSONArray();
			this.sysFunctionService.insertSysFunction(sysFunctionVo);
			functionJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("插入功能节点出现异常");
			functionJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id删除功能节点
	 */
	public String deleteFunction(){
		try {
			functionJSON = new JSONArray();
			List<SysResourceVo> sysResourceVoList = this.sysResourceService.getResourceListByParentId(sysFunctionVo.getId());
			for(int i=0; i<sysResourceVoList.size(); i++){
				this.sysResourceService.deleteSysResourcebyId(sysResourceVoList.get(i).getId());
			}
			this.sysFunctionService.deleteSysFunctionbyId(sysFunctionVo.getId());
			functionJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("删除功能节点出现异常");
			functionJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}

}
