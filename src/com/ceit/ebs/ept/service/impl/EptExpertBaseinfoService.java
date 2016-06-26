package com.ceit.ebs.ept.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptExpertBaseinfo;
import com.ceit.ebs.ept.service.IEptExpertBaseinfoService;
import com.ceit.ebs.ept.vo.EptExpertBaseinfoVo;

/**
 * EptExpertBaseinfo entity. @author MyEclipse Persistence Tools
 */

public class EptExpertBaseinfoService implements IEptExpertBaseinfoService {

	// Fields

	private EptExpertBaseinfo eptExpertBaseinfo;
	private ITableDao tableDao;

	// Constructors

	public EptExpertBaseinfoService(){
	}
	
	public EptExpertBaseinfo getEptExpertBaseinfobyId(int id){
		
		try {
			eptExpertBaseinfo = (EptExpertBaseinfo)(tableDao.getEntitybyId(id, EptExpertBaseinfo.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eptExpertBaseinfo;
	}
	
	public boolean modifyEptExpertBaseinfo(EptExpertBaseinfoVo s){
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			s.setOpTime(df.format(new Date()));
			tableDao.update(s.adapterToEptExpertBaseinfo());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEptExpertBaseinfobyId(Integer id){
		try{
			tableDao.delete(id,EptExpertBaseinfo.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEptExpertBaseinfo(EptExpertBaseinfoVo eptExpertBaseinfoVo){
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			eptExpertBaseinfoVo.setOpTime(df.format(new Date()));
			EptExpertBaseinfo sr = eptExpertBaseinfoVo.adapterToEptExpertBaseinfo();
			Integer eptExpertBaseinfoId = tableDao.insert(sr);
			sr.setId(eptExpertBaseinfoId);
			sr.setDispIndex(eptExpertBaseinfoId);
			tableDao.update(sr);
			return eptExpertBaseinfoId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setEptExpertBaseinfo(EptExpertBaseinfo eptExpertBaseinfo) {
		this.eptExpertBaseinfo = eptExpertBaseinfo;
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
		sql = "SELECT  COUNT(d.id) FROM  EptExpertBaseinfo d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EptExpertBaseinfo> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EptExpertBaseinfoVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EptExpertBaseinfoVo> querydata(int pageindex, int pagesize) {
		List<EptExpertBaseinfoVo> eptExpertBaseinfoVoList = new ArrayList<EptExpertBaseinfoVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EptExpertBaseinfo d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EptExpertBaseinfo> eptExpertBaseinfoList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(eptExpertBaseinfoList != null && eptExpertBaseinfoList.size() > 0){
				for(int i = 0 ; i < eptExpertBaseinfoList.size() ; i++){
					EptExpertBaseinfoVo srv = new EptExpertBaseinfoVo(eptExpertBaseinfoList.get(i));//PO -> VO
					eptExpertBaseinfoVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EptExpertBaseinfoVo>(eptExpertBaseinfoVoList,count,pageindex,pagesize);
	}
}