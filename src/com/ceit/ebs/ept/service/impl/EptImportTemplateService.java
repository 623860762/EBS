package com.ceit.ebs.ept.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptImportTemplate;
import com.ceit.ebs.ept.service.IEptImportTemplateService;
import com.ceit.ebs.ept.vo.EptImportTemplateVo;


/**
 * EptImportTemplate entity. @author MyEclipse Persistence Tools
 */

public class EptImportTemplateService implements IEptImportTemplateService{

	
	
	// Fields

	private EptImportTemplate eptImportTemplate;
	private ITableDao tableDao;

	//测试用
	public EptImportTemplateService(){
	}
	
	// Constructors

	
	
	public EptImportTemplate getEptImportTemplatebyId(int id){
		
		try {
			eptImportTemplate = (EptImportTemplate)(tableDao.getEntitybyId(id, EptImportTemplate.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eptImportTemplate;
	}
	
	public boolean modifyEptImportTemplate(EptImportTemplateVo sv){
		try {
			tableDao.update(sv.adapterToEptImportTemplate());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEptImportTemplatebyId(Integer id){
		try{
			tableDao.delete(id,EptImportTemplate.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEptImportTemplate(EptImportTemplateVo eptImportTemplateVo){
		try {
			EptImportTemplate sr = eptImportTemplateVo.adapterToEptImportTemplate();
			Integer eptImportTemplateId = tableDao.insert(sr);
			//sr.setId(eptImportTemplateId);
			//sr.setDispindex(eptImportTemplateId);
			tableDao.update(sr);
			return eptImportTemplateId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setEptImportTemplate(EptImportTemplate eptImportTemplate) {
		this.eptImportTemplate = eptImportTemplate;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}
	/**
	 * 根据ID,获得数据总数
	 * @param id 
	 * @return 查询到的数据总数，若失败，返回-1
	 */
	@SuppressWarnings("unchecked")
	public Integer getCount(){
		Integer count = 0;  //记录总数
		String sql = null;
		//Map<String,Object> map = new HashMap<String,Object>();
		sql = "SELECT  COUNT(d.id) FROM  EptImportTemplate d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EptImportTemplate> list = tableDao.otherQuery(sql, true, true, null);
			if(list != null && list.size() > 0){
				count = Integer.parseInt((list.get(0)+""));
			}
		}catch(Exception e) {
			count = -1;
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 分页显示数据
	 * @param pageindex 当前页码
	 * @param pagesize 每页显示条数
	 * @return 包含查询到的所有EptImportTemplateVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EptImportTemplateVo> querydata(int pageindex, int pagesize) {
		List<EptImportTemplateVo> eptImportTemplateVoList = new ArrayList<EptImportTemplateVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EptImportTemplate d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EptImportTemplate> eptImportTemplateList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(eptImportTemplateList != null && eptImportTemplateList.size() > 0){
				for(int i = 0 ; i < eptImportTemplateList.size() ; i++){
					EptImportTemplateVo srv = new EptImportTemplateVo(eptImportTemplateList.get(i));//PO -> VO
					eptImportTemplateVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EptImportTemplateVo>(eptImportTemplateVoList,count,pageindex,pagesize);
	}
}