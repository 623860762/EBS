/**
 * @文件名: EptSpecialtyAction.java 
 * @包名: com.ceit.ebs.ept.action  
 * @描述: TODO   
 * @作者: 梁艾   
 * @日期: 2014-8-19 下午09:02:53   
 * @版本: V1.0 
 */
package com.ceit.ebs.ept.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.ceit.ebs.ept.service.IEptSpecialtyService;
import com.ceit.ebs.ept.service.impl.EptSpecialtyService;
import com.ceit.ebs.ept.vo.EptSpecialtyVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @ClassName: EptSpecialtyAction
 * @Description: 专家专业Action
 * @author 梁艾
 * @date 2014-8-19 下午09:02:53
 */
public class EptSpecialtyAction extends ActionSupport implements ModelDriven {

	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = 5115860321303833122L;
	static Logger log = Logger.getLogger(EptSpecialtyService.class.getName());
	private JSONArray speJSON;
	private IEptSpecialtyService eptSpecialtyService;
	private EptSpecialtyVo eptSpecialtyVo;
	
	public JSONArray getSpeJSON() {
		return speJSON;
	}
	
	
 
	/**
	 * @param speJSON the speJSON to set
	 */
	public void setSpeJSON(JSONArray speJSON) {
		this.speJSON = speJSON;
	}



	/**
	 * @param eptSpecialtyService the eptSpecialtyService to set
	 */
	public void setEptSpecialtyService(IEptSpecialtyService eptSpecialtyService) {
		this.eptSpecialtyService = eptSpecialtyService;
	}



	/**
	 * @param eptSpecialtyVo the eptSpecialtyVo to set
	 */
	public void setEptSpecialtyVo(EptSpecialtyVo eptSpecialtyVo) {
		this.eptSpecialtyVo = eptSpecialtyVo;
	}
	


	/**
	 * @return the eptSpecialtyVo
	 */
	public EptSpecialtyVo getEptSpecialtyVo() {
		return eptSpecialtyVo;
	}



	public Object getModel() {
		if(eptSpecialtyVo == null){
			eptSpecialtyVo = new EptSpecialtyVo();
	       }
	       return eptSpecialtyVo;
	}
	/**
	 * 
	 * @Title: getSpecialtyById
	 * @Description: 通过ID获取对象
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-20 上午10:31:13
	 * @throws
	 */
	public String getSpecialtyById(){
		try {
			if(eptSpecialtyVo.getId() != null && !("".equals(eptSpecialtyVo.getId()))){
				eptSpecialtyVo = this.eptSpecialtyService.getEptSpecialtybyId(eptSpecialtyVo.getId());
			}
		} catch (Exception e) {
			log.info("通过id获取菜单节点出现异常!");
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: getSpecialtyForTree
	 * @Description: 获取专业子树
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-20 上午11:28:53
	 * @throws
	 */
	public String getSpecialtyForTree(){
//		if(!speJSON.isEmpty()){
//			speJSON.clear();
//		}
		try {
			speJSON = new JSONArray();
			if(eptSpecialtyVo.getParentId() != null && !("".equals(eptSpecialtyVo.getParentId()))){
				List<EptSpecialtyVo> data = this.eptSpecialtyService.getSpecialtyListByParentId(eptSpecialtyVo.getParentId());
				for(int i=0; i<data.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", data.get(i).getId()+"");
					jsonObject.put("text", data.get(i).getSpecialtyName());
//					jsonAttribute.put("url", menuData.get(i).getLinkValue());
//					jsonAttribute.put("icon", menuData.get(i).getIcon());
					jsonAttribute.put("dispIndex", data.get(i).getDispIndex());
					jsonObject.put("attributes", jsonAttribute);
					if(this.eptSpecialtyService.getSpecialtyListByParentId(data.get(i).getId()).size()>0){
						jsonObject.put("state", "closed");
					}
					speJSON.add(jsonObject);
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
	 * @Title: updateSpecialtyById
	 * @Description:更新专业
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-20 下午05:02:45
	 * @throws
	 */
	public String updateSpecialtyById(){
		
		try {
			speJSON = new JSONArray();
			this.eptSpecialtyService.modifyEptSpecialty(eptSpecialtyVo);
			speJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("根据id更新菜单信息出现异常");
			speJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: insertSpecialty
	 * @Description: 新增专业
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 上午10:46:41
	 * @throws
	 */
	public String insertSpecialty(){
		try{
			speJSON = new JSONArray();
			this.eptSpecialtyService.insertEptSpecialty(eptSpecialtyVo);
			speJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("插入菜单节点出现异常");
			speJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: deleteSpecialty
	 * @Description: 删除专业
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 上午11:15:22
	 * @throws
	 */
	public String deleteSpecialty(){
		try {
			speJSON = new JSONArray();
			this.eptSpecialtyService.deleteEptSpecialtybyId(eptSpecialtyVo.getId());
			speJSON.add(JSONObject.fromObject("{'result':'true'}"));
		}catch(Exception e){
			log.info("删除节点出现异常");
			speJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: upMoveSpecialty
	 * @Description: 上移节点
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 上午11:27:45
	 * @throws
	 */
	
	public String upMoveSpecialty(){
		try {
			speJSON = new JSONArray();
			this.eptSpecialtyService.moveMenu(eptSpecialtyVo.getId(), 1);
			speJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("上移菜单出现异常");
			speJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 
	 * @Title: downMoveMenu
	 * @Description: 下移节点
	 * @param @return    
	 * @return String 
	 * @author ly
	 * @date 2014-8-21 下午02:13:37
	 * @throws
	 */
	public String downMoveMenu(){
		try {
			speJSON = new JSONArray();
			this.eptSpecialtyService.moveMenu(eptSpecialtyVo.getId(), 0);
			speJSON.add(JSONObject.fromObject("{'result':'true'}"));
		} catch (Exception e) {
			log.info("下移菜单出现异常");
			speJSON.add(JSONObject.fromObject("{'result':'false'}"));
			return ERROR;
		}
		return SUCCESS;
	}

}
