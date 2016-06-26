package com.ceit.ebs.sys.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.ebs.sys.service.ISysOrganService;
import com.ceit.ebs.sys.service.ISysUserService;
import com.ceit.ebs.sys.vo.SysOrganVo;
import com.ceit.ebs.sys.vo.SysUserVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class SysUserAction extends ActionSupport implements ModelDriven{
	static Log log=LogFactory.getLog(SysUserAction.class);
	private static final long serialVersionUID = 398335955122618041L;
	private ISysUserService sysUserService;
	private ISysOrganService sysOrganService;
	private JSONArray userJSON;
	private SysUserVo sysUserVo;
	
	
	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	
	
	public void setSysOrganService(ISysOrganService sysOrganService) {
		this.sysOrganService = sysOrganService;
	}


	public SysUserVo getSysUserVo() {
		return sysUserVo;
	}
	public void setSysUserVo(SysUserVo sysUserVo) {
		this.sysUserVo = sysUserVo;
	}
	public JSONArray getUserJSON() {
		return userJSON;
	}
	public void setUserJSON(JSONArray userJSON) {
		this.userJSON = userJSON;
	}
	
	public Object getModel() {
       if(sysUserVo == null){
    	   sysUserVo = new SysUserVo();
       }
       return sysUserVo;
    }
	
	/**
	 * 根据organId(组织机构id，在用户表中为corporationId)获取下属用户
	 * @author wujinshui
	 */
	public String getUserData(){
		try {
			userJSON = new JSONArray();
			if(sysUserVo.getParentId() != null){
				List<SysUserVo> userData = this.sysUserService.getUserListByOrganId(sysUserVo.getParentId());
				userJSON = JSONArray.fromObject(userData);
			}
		} catch (Exception e) {
			log.info("通过组织机构id获取所有下属用户出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据组织机构的parentId获取子级组织机构及下属用户,tree JSON形式
	 * @author wujinshui
	 */
	public String getUserForTree(){
		try {
			userJSON = new JSONArray();
			if(sysUserVo.getParentId() != null){
				List<SysOrganVo> organData = this.sysOrganService.getOrganListByParentId(sysUserVo.getParentId());
				for(int i=0; i<organData.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", organData.get(i).getId());
					jsonObject.put("text", organData.get(i).getOrganName());
					//flag表示是否为组织机构几点 0-组织机构，1-下属用户
					jsonAttribute.put("flag", 0);
					jsonAttribute.put("organCode", organData.get(i).getOrganCode());
					jsonAttribute.put("icon", organData.get(i).getOrganIcon());
					jsonAttribute.put("dispIndex", organData.get(i).getDispIndex());
					jsonAttribute.put("parentId", organData.get(i).getParentId());
					jsonAttribute.put("shortName", organData.get(i).getShortName());
					jsonAttribute.put("organState", organData.get(i).getOrganState());
					jsonObject.put("attributes", jsonAttribute);
					if(this.sysOrganService.getOrganListByParentId(organData.get(i).getId()).size() > 0 || this.sysUserService.getUserListByOrganId(organData.get(i).getId()).size() > 0){
						jsonObject.put("state", "closed");
					}
					userJSON.add(jsonObject);
				}
				List<SysUserVo> userData = this.sysUserService.getUserListByOrganId(sysUserVo.getParentId());
				for (int j = 0; j < userData.size(); j++) {
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id",userData.get(j).getId());
					jsonObject.put("text",userData.get(j).getUserName());
					jsonAttribute.put("flag", 1);
					jsonAttribute.put("accountStatus", userData.get(j).getAccountStatus());
					jsonAttribute.put("parentId", userData.get(j).getParentId());
					jsonAttribute.put("employeeId",userData.get(j).getEmployeeId());
					jsonAttribute.put("email",userData.get(j).getEmail());
					jsonAttribute.put("msn",userData.get(j).getMsn());
					jsonAttribute.put("qq",userData.get(j).getQq());
					jsonAttribute.put("mobile",userData.get(j).getMobile());
					jsonAttribute.put("telephone",userData.get(j).getTelephone());
					jsonAttribute.put("comments",userData.get(j).getComment());
					jsonAttribute.put("dispIndex",userData.get(j).getDispIndex());
					jsonObject.put("attributes",jsonAttribute);
					userJSON.add(jsonObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("通过父节点id获取所有子级组织机构节点出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取用户
	 * @author wujinshui
	 */
	public String getUserById(){
		try {
			if(sysUserVo.getId() != null && !("".equals(sysUserVo.getId()))){
				sysUserVo = this.sysUserService.getSysUserbyId(sysUserVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取用户出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取用户
	 * @author wujinshui
	 */
	public String modifyUserById(){
		try {
			if(sysUserVo.getId() != null && !("".equals(sysUserVo.getId()))){
				sysUserVo = this.sysUserService.getSysUserbyId(sysUserVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取用户出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id更新用户信息
	 */
	public String updateUserById(){
		try {
			userJSON = new JSONArray();
			this.sysUserService.modifySysUser(sysUserVo);
			userJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("根据id更新用户信息出现异常");
			userJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id上移用户节点
	 * @author wujinshui
	 */
	public String upMoveUser(){
		try {
			userJSON = new JSONArray();
			this.sysUserService.moveUser(sysUserVo.getId(), 1);
			userJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("上移菜单出现异常");
			userJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id下移用户节点
	 * @author wujinshui
	 */
	public String downMoveUser(){
		try {
			userJSON = new JSONArray();
			this.sysUserService.moveUser(sysUserVo.getId(), 0);
			userJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("下移菜单出现异常");
			userJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 插入新的用户节点
	 * @author wujinshui
	 */
	public String insertUser(){
		try{
			userJSON = new JSONArray();
			this.sysUserService.insertSysUser(sysUserVo);
			userJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("插入用户节点出现异常");
			userJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id删除用户节点
	 */
	public String deleteUser(){
		try {
			userJSON = new JSONArray();
			this.sysUserService.deleteSysUserbyId(sysUserVo.getId());
			userJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("删除用户节点出现异常");
			userJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}

}
