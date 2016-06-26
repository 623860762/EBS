package com.ceit.ebs.ept.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptMessageTemplate;
import com.ceit.ebs.ept.service.IEptMessageTemplateService;
import com.ceit.ebs.ept.vo.EptMessageTemplateVo;

/**
 * EptMessageTemplate entity. @author MyEclipse Persistence Tools
 */

public class EptMessageTemplateService implements IEptMessageTemplateService {

	// Fields

	private EptMessageTemplate eptMessageTemplate;
	private ITableDao tableDao;
	
	//测试用
	public EptMessageTemplateService(ITableDao itableDao){
	}
	// Constructors

	
	
	public EptMessageTemplate getEptMessageTemplatebyId(int id){
		
		try {
			eptMessageTemplate = (EptMessageTemplate)(tableDao.getEntitybyId(id, EptMessageTemplate.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eptMessageTemplate;
	}
	
	public boolean modifyEptMessageTemplate(EptMessageTemplateVo sv){
		try {
			tableDao.update(sv.adapterToEptMessageTemplate());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEptMessageTemplatebyId(Integer id){
		try{
			tableDao.delete(id,EptMessageTemplate.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEptMessageTemplate(EptMessageTemplateVo eptMessageTemplateVo){
		try {
			EptMessageTemplate sr = eptMessageTemplateVo.adapterToEptMessageTemplate();
			Integer eptMessageTemplateId = tableDao.insert(sr);
			//sr.setId(eptMessageTemplateId);
			//sr.setDispindex(eptMessageTemplateId);
			tableDao.update(sr);
			return eptMessageTemplateId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setEptMessageTemplate(EptMessageTemplate eptMessageTemplate) {
		this.eptMessageTemplate = eptMessageTemplate;
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
		sql = "SELECT  COUNT(d.id) FROM  EptMessageTemplate d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EptMessageTemplate> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EptMessageTemplateVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EptMessageTemplateVo> querydata(int pageindex, int pagesize) {
		List<EptMessageTemplateVo> eptMessageTemplateVoList = new ArrayList<EptMessageTemplateVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EptMessageTemplate d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EptMessageTemplate> eptMessageTemplateList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(eptMessageTemplateList != null && eptMessageTemplateList.size() > 0){
				for(int i = 0 ; i < eptMessageTemplateList.size() ; i++){
					EptMessageTemplateVo srv = new EptMessageTemplateVo(eptMessageTemplateList.get(i));//PO -> VO
					eptMessageTemplateVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EptMessageTemplateVo>(eptMessageTemplateVoList,count,pageindex,pagesize);
	}
}