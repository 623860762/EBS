package com.ceit.ebs.sys.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.ebs.sys.service.ISysFunctionService;
import com.ceit.ebs.sys.service.ISysModuleService;
import com.ceit.ebs.sys.service.ISysResourceService;
import com.ceit.ebs.sys.vo.SysFunctionVo;
import com.ceit.ebs.sys.vo.SysModuleVo;
import com.ceit.ebs.sys.vo.SysResourceVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class SysModuleAction extends ActionSupport implements ModelDriven{
	static Log log=LogFactory.getLog(SysModuleAction.class);
	private static final long serialVersionUID = 398335955122618041L;
	private ISysModuleService sysModuleService;
	private ISysFunctionService sysFunctionService;
	private ISysResourceService sysResourceService;
	private JSONArray moduleJSON;
	private SysModuleVo sysModuleVo;

	

	public JSONArray getModuleJSON() {
		return moduleJSON;
	}

	public void setModuleJSON(JSONArray moduleJSON) {
		this.moduleJSON = moduleJSON;
	}

	public void setSysModuleService(ISysModuleService sysModuleService) {
		this.sysModuleService = sysModuleService;
	}
	
	public void setSysResourceService(ISysResourceService sysResourceService) {
		this.sysResourceService = sysResourceService;
	}

	public void setSysFunctionService(ISysFunctionService sysFunctionService) {
		this.sysFunctionService = sysFunctionService;
	}

	public SysModuleVo getSysModuleVo() {
		return sysModuleVo;
	}

	public void setSysModuleVo(SysModuleVo sysModuleVo) {
		this.sysModuleVo = sysModuleVo;
	}

	public Object getModel() {
       if(sysModuleVo == null){
    	   sysModuleVo = new SysModuleVo();
       }
       return sysModuleVo;
    }
	
	/**
	 * 根据功能id获取子级模块,tree JSON形式
	 * @author wujinshui
	 */
	public String getModuleForTree(){
		try {
			moduleJSON = new JSONArray();
			if(sysModuleVo.getParentId() != null){
				List<SysModuleVo> moduleData = this.sysModuleService.getModuleListByParentId(sysModuleVo.getParentId());
				for(int i=0; i<moduleData.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", moduleData.get(i).getId());
					jsonObject.put("text", moduleData.get(i).getModuleName());
					//flag表示类型 0-模块，1-功能，2-资源
					jsonAttribute.put("flag", 0);
					jsonAttribute.put("dispIndex", moduleData.get(i).getDispIndex());
					jsonAttribute.put("parentId", moduleData.get(i).getParentId());
					jsonAttribute.put("isLeaf", moduleData.get(i).getIsLeaf());
					jsonObject.put("attributes", jsonAttribute);
					if(this.sysModuleService.getModuleListByParentId(moduleData.get(i).getId()).size() > 0 || this.sysFunctionService.getFunctionListByParentId(moduleData.get(i).getId()).size() > 0){
						jsonObject.put("state", "closed");
					}
					moduleJSON.add(jsonObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("通过父节点id获取所有子级模块出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取模块
	 * @author wujinshui
	 */
	public String getModuleById(){
		try {
			if(sysModuleVo.getId() != null){
				sysModuleVo = this.sysModuleService.getSysModulebyId(sysModuleVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取模块出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取模块
	 * @author wujinshui
	 */
	public String modifyModuleById(){
		try {
			if(sysModuleVo.getId() != null){
				sysModuleVo = this.sysModuleService.getSysModulebyId(sysModuleVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取模块出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id更新模块信息
	 */
	public String updateModuleById(){
		try {
			moduleJSON = new JSONArray();
			this.sysModuleService.modifySysModule(sysModuleVo);
			moduleJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("根据id更新用户信息出现异常");
			moduleJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id上移模块节点
	 * @author wujinshui
	 */
	public String upMoveModule(){
		try {
			moduleJSON = new JSONArray();
			this.sysModuleService.moveModule(sysModuleVo.getId(), 1);
			moduleJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("上移模块出现异常");
			moduleJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id下移模块节点
	 * @author wujinshui
	 */
	public String downMoveModule(){
		try {
			moduleJSON = new JSONArray();
			this.sysModuleService.moveModule(sysModuleVo.getId(), 0);
			moduleJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("下移模块出现异常");
			moduleJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 插入新的模块节点
	 * @author wujinshui
	 */
	public String insertModule(){
		try{
			moduleJSON = new JSONArray();
			this.sysModuleService.insertSysModule(sysModuleVo);
			moduleJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("插入模块节点出现异常");
			moduleJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id删除模块节点
	 */
	public String deleteModule(){
		try {
			moduleJSON = new JSONArray();
			List<SysFunctionVo> sysFunctionVoList = this.sysFunctionService.getFunctionListByParentId(sysModuleVo.getId());
			List<SysResourceVo> sysResourceVoList;
			for(int i=0; i<sysFunctionVoList.size(); i++){
				sysResourceVoList = this.sysResourceService.getResourceListByParentId(sysFunctionVoList.get(i).getId());
				for(int j=0; j<sysResourceVoList.size(); j++){
					this.sysResourceService.deleteSysResourcebyId(sysResourceVoList.get(j).getId());
				}
				this.sysFunctionService.deleteSysFunctionbyId(sysFunctionVoList.get(i).getId());
			}
			this.sysModuleService.deleteSysModulebyId(sysModuleVo.getId());
			moduleJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("删除模块节点出现异常");
			moduleJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}

}
