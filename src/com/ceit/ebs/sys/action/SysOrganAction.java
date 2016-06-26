package com.ceit.ebs.sys.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.ebs.sys.service.ISysOrganService;
import com.ceit.ebs.sys.vo.SysOrganVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class SysOrganAction extends ActionSupport implements ModelDriven{
	static Log log=LogFactory.getLog(SysOrganAction.class);
	private static final long serialVersionUID = 398335955122618041L;
	private ISysOrganService sysOrganService;
	private JSONArray organJSON;
	private SysOrganVo sysOrganVo;
	
	
	public void setSysOrganService(ISysOrganService sysOrganService) {
		this.sysOrganService = sysOrganService;
	}
	public JSONArray getOrganJSON() {
		return organJSON;
	}
	public void setOrganJSON(JSONArray organJSON) {
		this.organJSON = organJSON;
	}
	public SysOrganVo getSysOrganVo() {
		return sysOrganVo;
	}
	public void setSysOrganVo(SysOrganVo sysOrganVo) {
		this.sysOrganVo = sysOrganVo;
	}
	
	public Object getModel() {
       if(sysOrganVo == null){
    	   sysOrganVo = new SysOrganVo();
       }
       return sysOrganVo;
    }
	
	/**
	 * 根据parentId获取子级机构
	 * @author wujinshui
	 */
	public String getOrganData(){
		try {
			organJSON = new JSONArray();
			if(sysOrganVo.getParentId() != null){
				List<SysOrganVo> OrganData = this.sysOrganService.getOrganListByParentId(sysOrganVo.getParentId());
				organJSON = JSONArray.fromObject(OrganData);
			}
		} catch (Exception e) {
			log.info("通过父节点id获取所有组织机构子级节点出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据parentId获取子级组织机构,tree JSON形式
	 * @author wujinshui
	 */
	public String getOrganForTree(){
		try {
			organJSON = new JSONArray();
			if(sysOrganVo.getParentId() != null){
				List<SysOrganVo> organData = this.sysOrganService.getOrganListByParentId(sysOrganVo.getParentId());
				for(int i=0; i<organData.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", organData.get(i).getId());
					jsonObject.put("text", organData.get(i).getOrganName());
					jsonAttribute.put("organCode", organData.get(i).getOrganCode());
					jsonAttribute.put("icon", organData.get(i).getOrganIcon());
					jsonAttribute.put("dispIndex", organData.get(i).getDispIndex());
					jsonAttribute.put("parentId", organData.get(i).getParentId());
					jsonAttribute.put("shortName", organData.get(i).getShortName());
					jsonAttribute.put("organState", organData.get(i).getOrganState());
					jsonObject.put("attributes", jsonAttribute);
					if(this.sysOrganService.getOrganListByParentId(organData.get(i).getId()).size() > 0){
						jsonObject.put("state", "closed");
					}
					organJSON.add(jsonObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("通过父节点id获取所有子级组织机构节点出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取组织机构节点
	 * @author wujinshui
	 */
	public String getOrganById(){
		try {
			if(sysOrganVo.getId() != null){
				sysOrganVo = this.sysOrganService.getSysOrganbyId(sysOrganVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取组织机构节点出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id更新组织机构信息
	 */
	public String updateOrganById(){
		try {
			organJSON = new JSONArray();
			this.sysOrganService.modifySysOrgan(sysOrganVo);
			organJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("根据id更新组织机构信息出现异常");
			organJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 插入新的组织机构节点
	 * @author wujinshui
	 */
	public String insertOrgan(){
		try{
			organJSON = new JSONArray();
			this.sysOrganService.insertSysOrgan(sysOrganVo);
			organJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("插入组织机构节点出现异常");
			organJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id删除组织机构节点
	 */
	
	public String deleteOrgan(){
		try {
			organJSON = new JSONArray();
			this.sysOrganService.deleteSysOrganbyId(sysOrganVo.getId());
			organJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("删除组织机构节点出现异常");
			organJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id上移组织机构节点
	 * @author wujinshui
	 */
	public String upMoveOrgan(){
		try {
			organJSON = new JSONArray();
			this.sysOrganService.moveOrgan(sysOrganVo.getId(), 1);
			organJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("上移组织机构出现异常");
			organJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id下移组织机构节点
	 * @author wujinshui
	 */
	public String downMoveOrgan(){
		try {
			organJSON = new JSONArray();
			this.sysOrganService.moveOrgan(sysOrganVo.getId(), 0);
			organJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("下移组织机构出现异常");
			organJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
}
