package com.ceit.ebs.md.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ceit.common.util.PageInfo;
import com.ceit.common.util.Struts2Utils;
import com.ceit.ebs.md.service.IMdFeatService;
import com.ceit.ebs.md.service.IMdFeatValService;
import com.ceit.ebs.md.service.IMdMaterialService;
import com.ceit.ebs.md.vo.MdFeatValVo;
import com.ceit.ebs.md.vo.MdFeatVo;
import com.ceit.ebs.md.vo.MdMaterialVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class MdMaterialAction extends ActionSupport implements ModelDriven {

	
	private static final long serialVersionUID = -1567980351824108710L;
	static Log log=LogFactory.getLog(MdMaterialAction.class);
	//注入service
	private IMdMaterialService mdMaterialService;
	private IMdFeatService mdFeatService;
	private IMdFeatValService mdFeatValService;
	
	
	private JSONArray ebsJsonArray;
	private JSONObject ebsJsonObj;
	private MdMaterialVo mdMaterialVo;
	private List<MdFeatVo> listMdFeatVo;
	private List<MdFeatValVo> listMdFeatValVo;
	private String matIds;//物料id数组[1,2,3]
	

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
	public MdMaterialVo getMdMaterialVo() {
		return mdMaterialVo;
	}
	public void setMdMaterialVo(MdMaterialVo mdMaterialVo) {
		this.mdMaterialVo = mdMaterialVo;
	}
	public IMdMaterialService getMdMaterialService() {
		return mdMaterialService;
	}
	public void setMdMaterialService(IMdMaterialService mdMaterialService) {
		this.mdMaterialService = mdMaterialService;
	}
	
public void setMdFeatService(IMdFeatService mdFeatService) {
		this.mdFeatService = mdFeatService;
	}
public String getMatIds() {
		return matIds;
	}
	public void setMatIds(String matIds) {
		this.matIds = matIds;
	}
	
public List<MdFeatVo> getListMdFeatVo() {
		return listMdFeatVo;
	}
	public void setListMdFeatVo(List<MdFeatVo> listMdFeatVo) {
		this.listMdFeatVo = listMdFeatVo;
	}

	public void setMdFeatValService(IMdFeatValService mdFeatValService) {
		this.mdFeatValService = mdFeatValService;
	}
	
public List<MdFeatValVo> getListMdFeatValVo() {
		return listMdFeatValVo;
	}
	public void setListMdFeatValVo(List<MdFeatValVo> listMdFeatValVo) {
		this.listMdFeatValVo = listMdFeatValVo;
	}
	/*
 * 通过分类Id获取物料列表	
 */
	public String getMaterialList(){
		try {
			if(mdMaterialVo.getCategoryId() != null && !("".equals(mdMaterialVo.getCategoryId()))){
				PageInfo<MdMaterialVo> pageInfo = mdMaterialService.getMdMaterialbyCategoryId(Integer.parseInt(mdMaterialVo.getPage()), Integer.parseInt(mdMaterialVo.getRows()), mdMaterialVo.getCategoryId());
				ebsJsonObj = JSONObject.fromObject(pageInfo.getContentJSon());
			}else{
				log.info("分类ID传入异常!");
			}
		} catch (Exception e) {
			log.info("获取物料列表失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/*
	 * 跳转到查看物料列表
	 */
	public String forMaterialPage(){
		try {
			if(mdMaterialVo.getId() != null && !("".equals(mdMaterialVo.getId()))){
				mdMaterialVo = mdMaterialService.getMdMaterialbyId(mdMaterialVo.getId());
				listMdFeatValVo =  mdFeatValService.getListByMatId(mdMaterialVo.getId());
			}else{
				log.info("获取物料id异常");
			}
		} catch (Exception e) {
			log.info("获取物料VO异常!");
		}
		return "MaterialPage";
	}
	/*
	 * 跳转到修改物料列表
	 */
	public String foreditMaterial(){
		try {
			if(mdMaterialVo.getId() != null && !("".equals(mdMaterialVo.getId()))){
				mdMaterialVo = mdMaterialService.getMdMaterialbyId(mdMaterialVo.getId());
				listMdFeatValVo =  mdFeatValService.getListByMatId(mdMaterialVo.getId());
			}else{
				log.info("获取物料id异常");
			}
		} catch (Exception e) {
			log.info("获取物料VO异常!");
		}
		return "editMaterialPage";
	}
	/*
	 * 修改物料和属性值
	 */
	public String mergeMaterial(){
		HttpServletRequest hsr = Struts2Utils.getRequest();
		List<MdFeatValVo> ListFeatVvo = new ArrayList<MdFeatValVo>();

		try {
			if(mdMaterialService.modifyMdMaterial(mdMaterialVo)){
				ListFeatVvo = mdFeatValService.getListByMatId(mdMaterialVo.getId());
				String[] featVals = hsr.getParameterValues("featVALUE");
				for(int i=0;i<ListFeatVvo.size();i++){
					System.out.println(featVals[i]);
					ListFeatVvo.get(i).setName(featVals[i]);
					mdFeatValService.modifyMdFeatVal(ListFeatVvo.get(i));
				}				
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			}else{
				log.info("修改物料或属性值失败!");
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}
		} catch (Exception e) {
			log.info("修改物料或属性值失败!");
			ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
		}
		return SUCCESS;
	}
/*
 * 新增物料
 */
	public String persistMaterial(){
		HttpServletRequest hsr = Struts2Utils.getRequest();
		List<MdFeatValVo> ListFeatVvo = new ArrayList<MdFeatValVo>();
		
		//插入物料
		try {
			Integer reid = mdMaterialService.insertMdMaterial(this.getMdMaterialVo());
			//插入属性值
			int featValNum = mdFeatService.getListSizeByCategoryId(mdMaterialVo.getCategoryId());
			try {
				for(int i=0;i<featValNum;i++){
					MdFeatValVo mdFeatValVo = new MdFeatValVo();
					mdFeatValVo.setFeatId(Integer.parseInt(hsr.getParameter("featID"+i)));
					mdFeatValVo.setName(hsr.getParameter("featVALUE"+i));
					mdFeatValVo.setAliasName(hsr.getParameter("featNAME"+i));
					mdFeatValVo.setMaterialId(reid);
					ListFeatVvo.add(mdFeatValVo);
				}
				for(MdFeatValVo mdfvo:ListFeatVvo){
					mdFeatValService.insertMdFeatVal(mdfvo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("新增属性值失败!");
			}
			
			if (reid > 0) {
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
				return SUCCESS;
			} else {
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
				log.info("新增物料列表失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("新增物料列表失败!");
		}
		
		return SUCCESS;
	}
/*
 * 通过多个id删除物料
 */
	public String delMatByIds(){
		try {
			if (mdMaterialService.delObjsByIds(matIds)) {
				ebsJsonObj = JSONObject.fromObject("{'result':'true'}");
			} else {
				ebsJsonObj = JSONObject.fromObject("{'result':'false'}");
			}
		} catch (Exception e) {
			log.info("删除物料失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
/*
 * 跳到物料新增页面，根据catetoryId获取到属性Vo对象
 */
	public String forMatInsertPage(){
		try {
			if(mdMaterialVo.getCategoryId() != null && !("".equals(mdMaterialVo.getCategoryId()))){
				mdMaterialVo.setCategoryId(mdMaterialVo.getCategoryId());
				listMdFeatVo =  mdFeatService.getListByCategoryId(mdMaterialVo.getCategoryId());
			}else{
				log.info("分类ID异常!");
			}
		} catch (Exception e) {
			log.info("获取属性列表失败!");
			e.printStackTrace();
		}
		return "addMaterialPage";
	}
	
	public Object getModel() {
		if(mdMaterialVo == null){
	    	   mdMaterialVo = new MdMaterialVo();
	       }
	       return mdMaterialVo;
	}

}