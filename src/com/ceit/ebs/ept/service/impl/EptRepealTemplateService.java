package com.ceit.ebs.ept.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptRepealTemplate;
import com.ceit.ebs.ept.service.IEptRepealTemplateService;
import com.ceit.ebs.ept.vo.EptRepealTemplateVo;


public class EptRepealTemplateService implements IEptRepealTemplateService{

	// Fields

	private EptRepealTemplate eptRepealTemplate;
	private ITableDao tableDao;
	
	//测试用
	public EptRepealTemplateService(){
	}

	// Constructors

	
	
	public EptRepealTemplate getEptRepealTemplatebyId(int id){
		
		try {
			eptRepealTemplate = (EptRepealTemplate)(tableDao.getEntitybyId(id, EptRepealTemplate.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eptRepealTemplate;
	}
	
	public boolean modifyEptRepealTemplate(EptRepealTemplateVo sv){
		try {
			tableDao.update(sv.adapterToEptRepealTemplate());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEptRepealTemplatebyId(Integer id){
		try{
			tableDao.delete(id,EptRepealTemplate.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEptRepealTemplate(EptRepealTemplateVo eptRepealTemplateVo){
		try {
			EptRepealTemplate sr = eptRepealTemplateVo.adapterToEptRepealTemplate();
			Integer eptRepealTemplateId = tableDao.insert(sr);
			//sr.setId(eptRepealTemplateId);
			//sr.setDispindex(eptRepealTemplateId);
			tableDao.update(sr);
			return eptRepealTemplateId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setEptRepealTemplate(EptRepealTemplate eptRepealTemplate) {
		this.eptRepealTemplate = eptRepealTemplate;
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
		sql = "SELECT  COUNT(d.id) FROM  EptRepealTemplate d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EptRepealTemplate> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EptRepealTemplateVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EptRepealTemplateVo> querydata(int pageindex, int pagesize) {
		List<EptRepealTemplateVo> eptRepealTemplateVoList = new ArrayList<EptRepealTemplateVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EptRepealTemplate d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EptRepealTemplate> eptRepealTemplateList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(eptRepealTemplateList != null && eptRepealTemplateList.size() > 0){
				for(int i = 0 ; i < eptRepealTemplateList.size() ; i++){
					EptRepealTemplateVo srv = new EptRepealTemplateVo(eptRepealTemplateList.get(i));//PO -> VO
					eptRepealTemplateVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EptRepealTemplateVo>(eptRepealTemplateVoList,count,pageindex,pagesize);
	}

}