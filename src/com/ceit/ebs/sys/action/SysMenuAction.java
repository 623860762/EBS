package com.ceit.ebs.sys.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.ebs.sys.service.ISysMenuService;
import com.ceit.ebs.sys.vo.SysMenuVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public class SysMenuAction extends ActionSupport implements ModelDriven {
	static Log log=LogFactory.getLog(SysMenuAction.class);
	private static final long serialVersionUID = -2634054117178203250L;
	private ISysMenuService sysMenuService;
	private JSONArray menuJSON;
	private SysMenuVo sysMenuVo;
	
	public JSONArray getMenuJSON() {
		return menuJSON;
	}

	public void setMenuJSON(JSONArray menuJSON) {
		this.menuJSON = menuJSON;
	}

	public void setSysMenuService(ISysMenuService sysMenuService) {
		this.sysMenuService = sysMenuService;
	}
	
	public void setMenuData(SysMenuVo sysMenuVo) {
		this.sysMenuVo = sysMenuVo;
	}

	public SysMenuVo getSysMenuVo() {
		return sysMenuVo;
	}
	
	public Object getModel() {
       if(sysMenuVo == null){
    	   sysMenuVo = new SysMenuVo();
       }
       return sysMenuVo;
    }

	/**
	 * 根据parentId获取子级菜单
	 * @author wujinshui
	 */
	public String getMenuData(){
		try {
			menuJSON = new JSONArray();
			if(sysMenuVo.getParentId() != null && !("".equals(sysMenuVo.getParentId()))){
				List<SysMenuVo> menuData = this.sysMenuService.getMenuListByParentId(sysMenuVo.getParentId());
				menuJSON = JSONArray.fromObject(menuData);
			}
		} catch (Exception e) {
			log.info("通过父节点id获取所有子级节点出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据parentId获取子级菜单,easyui 完整tree的JSON形式
	 * @author wujinshui
	 */
	public String getMenuDataForTree(){
		try {
			menuJSON = new JSONArray();
			if(sysMenuVo.getParentId() != null && !("".equals(sysMenuVo.getParentId()))){
				menuJSON = getMenuJSONForTree(sysMenuVo.getParentId());
			}
		} catch (Exception e) {
			log.info("通过父节点id获取所有子级节点出现异常!");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 根据parentId获取子级菜单,easyui 完整tree的JSON形式并返回,递归
	 * @author wujinshui
	 */
	public JSONArray getMenuJSONForTree(Integer objectId){
		JSONArray jsonArray = new JSONArray();
		try {
			if(objectId != null && !("".equals(objectId))){
				List<SysMenuVo> menuData = this.sysMenuService.getMenuListByParentId(objectId);
				for(int i=0; i<menuData.size(); i++){
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("id", menuData.get(i).getId()+"");
					jsonObject.put("text", menuData.get(i).getName());
					if("Y".equals(menuData.get(i).getIsLeaf())){
						jsonArray.add(jsonObject);
					}else{
						jsonObject.element("children", getMenuJSONForTree(Integer.parseInt(menuData.get(i).getId())));
						jsonArray.add(jsonObject);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("通过父节点id获取所有子级节点出现异常!");
		}
		return jsonArray;
	}
	
	/**
	 * 根据parentId获取子级菜单,tree JSON形式
	 * @author wujinshui
	 */
	public String getMenuForTree(){
		try {
			menuJSON = new JSONArray();
			if(sysMenuVo.getParentId() != null && !("".equals(sysMenuVo.getParentId()))){
				List<SysMenuVo> menuData = this.sysMenuService.getMenuListByParentId(sysMenuVo.getParentId());
				for(int i=0; i<menuData.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", menuData.get(i).getId()+"");
					jsonObject.put("text", menuData.get(i).getName());
					jsonAttribute.put("url", menuData.get(i).getLinkValue());
					jsonAttribute.put("icon", menuData.get(i).getIcon());
					jsonAttribute.put("dispIndex", menuData.get(i).getDispIndex());
					jsonAttribute.put("parentId", menuData.get(i).getParentId());
					jsonObject.put("attributes", jsonAttribute);
					if(this.sysMenuService.getMenuListByParentId(Integer.parseInt(menuData.get(i).getId())).size() > 0){
						jsonObject.put("state", "closed");
					}
					menuJSON.add(jsonObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("通过父节点id获取所有子级节点出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过id获取菜单节点
	 * @author wujinshui
	 */
	public String getMenuById(){
		try {
			if(sysMenuVo.getId() != null && !("".equals(sysMenuVo.getId()))){
				sysMenuVo = this.sysMenuService.getSysMenubyId(Integer.parseInt(sysMenuVo.getId()));
			}
		} catch (Exception e) {
			log.info("通过id获取菜单节点出现异常!");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id更新菜单信息
	 */
	public String updateMenuById(){
		try {
			menuJSON = new JSONArray();
			this.sysMenuService.modifySysMenu(sysMenuVo);
			menuJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("根据id更新菜单信息出现异常");
			menuJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 插入新的菜单节点
	 * @author wujinshui
	 */
	public String insertMenu(){
		try{
			menuJSON = new JSONArray();
			this.sysMenuService.insertSysMenu(sysMenuVo);
			menuJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("插入菜单节点出现异常");
			menuJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据id删除菜单节点
	 */
	
	public String deleteMenu(){
		try {
			menuJSON = new JSONArray();
			this.sysMenuService.deleteSysMenubyId(Integer.parseInt(sysMenuVo.getId()));
			menuJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("删除节点出现异常");
			menuJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id上移菜单节点
	 * @author wujinshui
	 */
	public String upMoveMenu(){
		try {
			menuJSON = new JSONArray();
			this.sysMenuService.moveMenu(Integer.parseInt(sysMenuVo.getId()), 1);
			menuJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("上移菜单出现异常");
			menuJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 根据节点id下移菜单节点
	 * @author wujinshui
	 */
	public String downMoveMenu(){
		try {
			menuJSON = new JSONArray();
			this.sysMenuService.moveMenu(Integer.parseInt(sysMenuVo.getId()), 0);
			menuJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("下移菜单出现异常");
			menuJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
}
