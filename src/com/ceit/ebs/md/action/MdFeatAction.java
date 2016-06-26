package com.ceit.ebs.md.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.md.service.IMdFeatService;
import com.ceit.ebs.md.vo.MdFeatVo;
import com.ceit.ebs.md.vo.MdMaterialVo;
import com.ceit.ebs.sys.action.SysMenuAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * MdMaterial entity. @author MyEclipse Persistence Tools
 */

public class MdFeatAction extends ActionSupport implements ModelDriven {

	private static final long serialVersionUID = 3492389124540118101L;
	static Log log=LogFactory.getLog(MdFeatAction.class);
	private JSONArray ebsJsonArray;
	private JSONObject ebsJsonObj;
	private MdFeatVo mdFeatVo;
	private IMdFeatService mdFeatService;
	
	private String featIds;//featId数组[1,2,3]


	public JSONArray getEbsJsonArray() {
		return ebsJsonArray;
	}
	public void setEbsJsonArray(JSONArray ebsJsonArray) {
		this.ebsJsonArray = ebsJsonArray;
	}
	public JSONObject getEbsJsonObj() {
		return ebsJsonObj;
	}
	public void setEbsJsonObj(JSONObject ebsJsonObj) {
		this.ebsJsonObj = ebsJsonObj;
	}
	public MdFeatVo getMdFeatVo() {
		return mdFeatVo;
	}
	public void setMdFeatVo(MdFeatVo mdFeatVo) {
		this.mdFeatVo = mdFeatVo;
	}
	public IMdFeatService getMdFeatService() {
		return mdFeatService;
	}
	public void setMdFeatService(IMdFeatService mdFeatService) {
		this.mdFeatService = mdFeatService;
	}

public String getFeatIds() {
		return featIds;
	}
	public void setFeatIds(String featIds) {
		this.featIds = featIds;
	}
/*
 * 通过分类CategoryId获取属性列表
 */
	public String getFeatList(){
		try {
			if(mdFeatVo.getCategoryId() != null && !("".equals(mdFeatVo.getCategoryId()))){
				PageInfo<MdFeatVo> pageInfo = mdFeatService.getMdFeatbyCategoryId(Integer.parseInt(mdFeatVo.getPage()),Integer.parseInt(mdFeatVo.getRows()),mdFeatVo.getCategoryId());
				ebsJsonObj = JSONObject.fromObject(pageInfo.getContentJSon());
			}else{
				log.info("分类ID传入异常!");
			}
		} catch (Exception e) {
			log.info("获取属性列表失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
/*
 * 通过分类ID新增属性	
 */
	public String persistFeat(){
		try {
			Integer reid = mdFeatService.insertMdFeat(this.getMdFeatVo());
			if (reid > 0) {
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			} else {
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}
		} catch (Exception e) {
			log.info("新增属性失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
/*
 * 通过多个id删除属性	
 */
	public String delFeatsByIds(){
		try {
			if (mdFeatService.delObjsByIds(featIds)) {
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			} else {
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}
		} catch (Exception e) {
			log.info("删除属性失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/*
	 * 通过属性ID修改属性内容
	 */
	public String mergeFeat(){
		try {
			if (mdFeatService.modifyMdFeat(mdFeatVo)) {
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			} else {
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}
		} catch (Exception e) {
			log.info("删除属性失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/*
	 * 跳转到修改属性页面
	 */
	public String editFeatPage(){
		try {
			if(mdFeatVo.getId() != null && !("".equals(mdFeatVo.getId()))){
				mdFeatVo = mdFeatService.getMdFeatbyId(mdFeatVo.getId());
			}else{
				log.info("获取属性id异常");
			}
		} catch (Exception e) {
			log.info("获取属性VO异常!");
		}
		return "editFeatPage";
	}
	
	public Object getModel() {
		if(mdFeatVo == null){
	    	   mdFeatVo = new MdFeatVo();
	       }
	       return mdFeatVo;
	}

}