
package com.ceit.ebs.ept.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.ceit.ebs.ept.service.IEptOrgService;
import com.ceit.ebs.ept.service.impl.EptOrgService;
import com.ceit.ebs.ept.vo.EptOrgVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EptOrgAction extends ActionSupport implements ModelDriven {

	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = 5115860321309833122L;
	static Logger log = Logger.getLogger(EptOrgService.class.getName());
	private JSONArray orgJSON;
	private IEptOrgService eptOrgService;
	private EptOrgVo eptOrgVo;
	



	/**
	 * @return the orgJSON
	 */
	public JSONArray getOrgJSON() {
		return orgJSON;
	}



	/**
	 * @param orgJSON the orgJSON to set
	 */
	public void setOrgJSON(JSONArray orgJSON) {
		this.orgJSON = orgJSON;
	}



	/**
	 * @param eptOrgService the eptSpecialtyService to set
	 */
	public void setEptOrgService(IEptOrgService eptOrgService) {
		this.eptOrgService = eptOrgService;
	}



	/**
	 * @param eptOrgVo the eptOrgVo to set
	 */
	public void setEptOrgVo(EptOrgVo eptOrgVo) {
		this.eptOrgVo = eptOrgVo;
	}
	


	/**
	 * @return the eptOrgVo
	 */
	public EptOrgVo getEptOrgVo() {
		return eptOrgVo;
	}



	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */

	public Object getModel() {
		if(eptOrgVo == null){
			eptOrgVo = new EptOrgVo();
	       }
	       return eptOrgVo;
	}
	/**
	 * 
	 * @Title: getOrgById
	 * @Description: 通过ID获取对象
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 下午04:52:08
	 * @throws
	 */
	public String getOrgById(){
		try {
			if(eptOrgVo.getId() != null && !("".equals(eptOrgVo.getId()))){
				eptOrgVo = this.eptOrgService.getEptOrgbyId(eptOrgVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取节点节点出现异常!");
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: getOrgForTree
	 * @Description: 获取组织机构子树
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 下午04:52:35
	 * @throws
	 */
	public String getOrgForTree(){
//		if(!orgJSON.isEmpty()){
//			orgJSON.clear();
//		}
		try {
			orgJSON = new JSONArray();
			if(eptOrgVo.getParentId() != null && !("".equals(eptOrgVo.getParentId()))){
				List<EptOrgVo> data = this.eptOrgService.getOrgListByParentId(eptOrgVo.getParentId());
				for(int i=0; i<data.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", data.get(i).getId()+"");
					jsonObject.put("text", data.get(i).getOrgName());
//					jsonAttribute.put("url", menuData.get(i).getLinkValue());
//					jsonAttribute.put("icon", menuData.get(i).getIcon());
					jsonAttribute.put("dispIndex", data.get(i).getDispIndex());
					jsonObject.put("attributes", jsonAttribute);
					if(this.eptOrgService.getOrgListByParentId(data.get(i).getId()).size()>0){
						jsonObject.put("state", "closed");
					}
					orgJSON.add(jsonObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("通过父节点id获取所有子级节点出现异常!");
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: updateOrgById
	 * @Description: 更新组织机构
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 下午04:52:48
	 * @throws
	 */
	public String updateOrgById(){
		
		try {
			orgJSON = new JSONArray();
			this.eptOrgService.modifyEptOrg(eptOrgVo);
			orgJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("根据id更新节点信息出现异常");
			orgJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: insertOrg
	 * @Description: 插入组织机构
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 下午04:53:44
	 * @throws
	 */
	public String insertOrg(){
		try{
			orgJSON = new JSONArray();
			this.eptOrgService.insertEptOrg(eptOrgVo);
			orgJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("插入节点节点出现异常");
			orgJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: deleteOrg
	 * @Description: 删除组织机构
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 下午04:55:51
	 * @throws
	 */
	public String deleteOrg(){
		try {
			orgJSON = new JSONArray();
			this.eptOrgService.deleteEptOrgbyId(eptOrgVo.getId());
			orgJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("删除节点出现异常");
			orgJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * @Title: upMoveOrg
	 * @Description: 上移节点
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 下午04:56:15
	 * @throws
	 */
	public String upMoveOrg(){
		try {
			orgJSON = new JSONArray();
			this.eptOrgService.moveMenu(eptOrgVo.getId(), 1);
			orgJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("上移节点出现异常");
			orgJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: downMoveMenu
	 * @Description:下移节点
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 下午04:56:28
	 * @throws
	 */
	public String downMoveMenu(){
		try {
			orgJSON = new JSONArray();
			this.eptOrgService.moveMenu(eptOrgVo.getId(), 0);
			orgJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("下移节点出现异常");
			orgJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}

}
