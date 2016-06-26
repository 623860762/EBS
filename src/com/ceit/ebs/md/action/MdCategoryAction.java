package com.ceit.ebs.md.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.vo.EbpProjectVo;
import com.ceit.ebs.md.entity.MdCategory;
import com.ceit.ebs.md.service.IMdCategoryService;
import com.ceit.ebs.md.vo.MdCategoryVo;
import com.ceit.ebs.sys.vo.SysMenuVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class MdCategoryAction extends ActionSupport implements ModelDriven{


	private static final long serialVersionUID = 6199140006469363968L;
	static Log log=LogFactory.getLog(MdCategoryAction.class);
	private JSONArray ebsJsonArray;
	private JSONObject ebsJsonObj;
	private MdCategoryVo mdCategoryVo;
	private IMdCategoryService mdCategoryService;

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
	public IMdCategoryService getMdCategoryService() {
		return mdCategoryService;
	}
	public void setMdCategoryService(IMdCategoryService mdCategoryService) {
		this.mdCategoryService = mdCategoryService;
	}

	public MdCategoryVo getMdCategoryVo() {
		return mdCategoryVo;
	}

	public void setMdCategoryVo(MdCategoryVo mdCategoryVo) {
		this.mdCategoryVo = mdCategoryVo;
	}

	public String viewCategory(){
		MdCategoryVo mdCategoryVo = mdCategoryService.getMdCategorybyId(1);
		ebsJsonArray = JSONArray.fromObject(mdCategoryVo.adapterToMdCategory());
		return SUCCESS;
	}
/*
 * 删除分类通过ID	
 */
	public String delCategory(){
		try {
			if(mdCategoryService.deleteMdCategorybyId(mdCategoryVo.getId())){
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			}else{
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("删除分类失败！");
		}
		return SUCCESS;
	}
/*
 * 修改分类	
 */
	public String editCategory(){
		try {
			if(mdCategoryService.modifyMdCategory(mdCategoryVo)){
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			}else{
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("修改分类失败！");
		}
		return SUCCESS;
	}
/*
 * 新增分类	
 */
	public String persistCategory(){
		try {
			Integer reid = mdCategoryService.insertMdCategory(mdCategoryVo);
			if(reid>0){
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			}else{
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("增加分类失败！");
		}
		return SUCCESS;
	}
/*
* 跳转到修改分类
*/
	public String editCatPage(){
		try {
			if(mdCategoryVo.getId() != null && !("".equals(mdCategoryVo.getId()))){
			   mdCategoryVo = mdCategoryService.getMdCategorybyId(mdCategoryVo.getId());
			}
		} catch (Exception e) {
			log.info("获取分类VO异常!");
		}
		return "editCatPage";
	}
/*
 * 通过分类ID修改分类
 */
	public String mergeCat(){
		try {
			if (mdCategoryService.modifyMdCategory(mdCategoryVo)) {
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			} else {
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}
		} catch (Exception e) {
			log.info("删除分类失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 根据parentId获取子级菜单,tree JSON形式
	 * @author zn
	 */
	public String getCateForTree(){
		ebsJsonArray = new JSONArray();
		try {
			if(mdCategoryVo.getParentId() != null && !("".equals(mdCategoryVo.getParentId()))){
				List<MdCategoryVo> list = mdCategoryService.getListByParentId(mdCategoryVo.getParentId());
				for(int i=0; i<list.size(); i++){
					JSONObject jsonObject = new JSONObject();
					JSONObject jsonAttribute = new JSONObject();
					jsonObject.put("id", list.get(i).getId()+"");
					jsonObject.put("text", list.get(i).getName());
					jsonAttribute.put("parentId", list.get(i).getParentId());
					jsonObject.put("attributes", jsonAttribute);
					if(this.mdCategoryService.getListSizeByParentId(list.get(i).getId()) > 0){
						jsonObject.put("state", "closed");
					}
					ebsJsonArray.add(jsonObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("生成树失败！");
		}
		return SUCCESS;
	}	
	
	
	public Object getModel() {
	       if(mdCategoryVo == null){
	    	   mdCategoryVo = new MdCategoryVo();
	       }
	       return mdCategoryVo;
	}
	
}