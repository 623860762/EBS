package com.ceit.ebs.sys.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.ebs.sys.service.ISysOrganService;
import com.ceit.ebs.sys.service.ISysRoleService;
import com.ceit.ebs.sys.vo.SysOrganVo;
import com.ceit.ebs.sys.vo.SysRoleVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class SysRoleAction extends ActionSupport implements ModelDriven{
	static Log log=LogFactory.getLog(SysRoleAction.class);
	private static final long serialVersionUID = 398335955122618041L;
	private ISysRoleService sysRoleService;
	private ISysOrganService sysOrganService;
	private JSONArray roleJSON;
	private SysRoleVo sysRoleVo;
	
	
	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}
	
	
	public void setSysOrganService(ISysOrganService sysOrganService) {
		this.sysOrganService = sysOrganService;
	}


	public SysRoleVo getSysRoleVo() {
		return sysRoleVo;
	}
	public void setSysRoleVo(SysRoleVo sysRoleVo) {
		this.sysRoleVo = sysRoleVo;
	}
	
	public JSONArray getRoleJSON() {
		return roleJSON;
	}


	public void setRoleJSON(JSONArray roleJSON) {
		this.roleJSON = roleJSON;
	}


	public Object getModel() {
       if(sysRoleVo == null){
    	   sysRoleVo = new SysRoleVo();
       }
       return sysRoleVo;
    }
	
	/**
	 * 根据organId(组织机构id，在用户表中为corporationId)获取下属角色
	 * @author wujinshui
	 */
	public String getRoleData(){
		try {
			roleJSON = new JSONArray();
			if(sysRoleVo.getParentId() != null){
				List<SysRoleVo> RoleData = this.sysRoleService.getRoleListByOrganId(sysRoleVo.getParentId());
				roleJSON = JSONArray.fromObject(RoleData);
			}
		} catch (Exception e) {
			log.info("通过组织机构id获取所有下属角色出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据组织机构的parentId获取子级组织机构及下属角色,tree JSON形式
	 * @author wujinshui
	 */
	public String getRoleForTree(){
		try {
			roleJSON = new JSONArray();
			if(sysRoleVo.getParentId() != null){
				List<SysOrganVo> organData = this.sysOrganService.getOrganListByParentId(sysRoleVo.getParentId());
				for(int i=0; i<organData.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", organData.get(i).getId());
					jsonObject.put("text", organData.get(i).getOrganName());
					//flag表示是否为组织机构几点 0-组织机构，1-下属角色
					jsonAttribute.put("flag", 0);
					jsonAttribute.put("organCode", organData.get(i).getOrganCode());
					jsonAttribute.put("icon", organData.get(i).getOrganIcon());
					jsonAttribute.put("dispIndex", organData.get(i).getDispIndex());
					jsonAttribute.put("parentId", organData.get(i).getParentId());
					jsonAttribute.put("shortName", organData.get(i).getShortName());
					jsonAttribute.put("organState", organData.get(i).getOrganState());
					jsonObject.put("attributes", jsonAttribute);
					if(this.sysOrganService.getOrganListByParentId(organData.get(i).getId()).size() > 0 || this.sysRoleService.getRoleListByOrganId(organData.get(i).getId()).size() > 0){
						jsonObject.put("state", "closed");
					}
					roleJSON.add(jsonObject);
				}
				List<SysRoleVo> roleData = this.sysRoleService.getRoleListByOrganId(sysRoleVo.getParentId());
				for (int j = 0; j < roleData.size(); j++) {
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id",roleData.get(j).getId());
					jsonObject.put("text",roleData.get(j).getRoleName());
					jsonAttribute.put("flag", 1);
					jsonAttribute.put("accountStatus", roleData.get(j).getRoleAlias());
					jsonAttribute.put("parentId", roleData.get(j).getParentId());
					jsonAttribute.put("employeeId",roleData.get(j).getRoleState());
					jsonAttribute.put("email",roleData.get(j).getComment());
					jsonAttribute.put("msn",roleData.get(j).getDispIndex());
					jsonObject.put("attributes",jsonAttribute);
					roleJSON.add(jsonObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("通过父节点id获取所有子级组织机构节及角色点出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取角色
	 * @author wujinshui
	 */
	public String getRoleById(){
		try {
			if(sysRoleVo.getId() != null){
				sysRoleVo = this.sysRoleService.getSysRolebyId(sysRoleVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取角色出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取角色
	 * @author wujinshui
	 */
	public String modifyRoleById(){
		try {
			if(sysRoleVo.getId() != null){
				sysRoleVo = this.sysRoleService.getSysRolebyId(sysRoleVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取角色出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id更新角色信息
	 */
	public String updateRoleById(){
		try {
			roleJSON = new JSONArray();
			this.sysRoleService.modifySysRole(sysRoleVo);
			roleJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("根据id更新角色信息出现异常");
			roleJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id上移角色节点
	 * @author wujinshui
	 */
	public String upMoveRole(){
		try {
			roleJSON = new JSONArray();
			this.sysRoleService.moveRole(sysRoleVo.getId(), 1);
			roleJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("上移菜单出现异常");
			roleJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id下移角色节点
	 * @author wujinshui
	 */
	public String downMoveRole(){
		try {
			roleJSON = new JSONArray();
			this.sysRoleService.moveRole(sysRoleVo.getId(), 0);
			roleJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("下移菜单出现异常");
			roleJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 插入新的角色节点
	 * @author wujinshui
	 */
	public String insertRole(){
		try{
			roleJSON = new JSONArray();
			this.sysRoleService.insertSysRole(sysRoleVo);
			roleJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("插入角色节点出现异常");
			roleJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id删除角色节点
	 */
	public String deleteRole(){
		try {
			roleJSON = new JSONArray();
			this.sysRoleService.deleteSysRolebyId(sysRoleVo.getId());
			roleJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("删除角色节点出现异常");
			roleJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}

}
