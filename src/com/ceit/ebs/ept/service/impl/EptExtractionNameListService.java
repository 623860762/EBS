package com.ceit.ebs.ept.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ept.entity.EptExpertBaseinfo;
import com.ceit.ebs.ept.entity.EptExtractionNameList;
import com.ceit.ebs.ept.service.IEptExtractionNameListService;
import com.ceit.ebs.ept.vo.EptExpertBaseinfoVo;
import com.ceit.ebs.ept.vo.EptExtractionNameListVo;

/**
 * EptExtractionNameList entity. @author MyEclipse Persistence Tools
 */

public class EptExtractionNameListService implements IEptExtractionNameListService {

	// Fields

	private EptExtractionNameList eptExtractionNameList;
	private ITableDao tableDao;
	static Logger logger = Logger.getLogger(EptSpecialtyService.class.getName());
	// Constructors

	
	
	public EptExtractionNameListService() {
	}

	public EptExtractionNameList getEptExtractionNameListbyId(int id){
		
		try {
			eptExtractionNameList = (EptExtractionNameList)(tableDao.getEntitybyId(id, EptExtractionNameList.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eptExtractionNameList;
	}
	
	public boolean modifyEptExtractionNameList(EptExtractionNameListVo s){
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			s.setOpTime(df.format(new Date()));
			tableDao.update(s.adapterToEptExtractionNameList());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEptExtractionNameListbyId(Integer id){
		try{
			tableDao.delete(id,EptExtractionNameList.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEptExtractionNameList(EptExtractionNameListVo eptExtractionNameListVo){
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			eptExtractionNameListVo.setOpTime(df.format(new Date()));
			EptExtractionNameList sr = eptExtractionNameListVo.adapterToEptExtractionNameList();
			Integer eptExtractionNameListId = tableDao.insert(sr);
			//sr.setId(eptExtractionNameListId);
			//sr.setDispindex(eptExtractionNameListId);
			tableDao.update(sr);
			return eptExtractionNameListId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setEptExtractionNameList(EptExtractionNameList eptExtractionNameList) {
		this.eptExtractionNameList = eptExtractionNameList;
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
		sql = "SELECT  COUNT(d.id) FROM  EptExtractionNameList d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EptExtractionNameList> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EptExtractionNameListVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EptExtractionNameListVo> querydata(int pageindex, int pagesize) {
		List<EptExtractionNameListVo> eptExtractionNameListVoList = new ArrayList<EptExtractionNameListVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EptExtractionNameList d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EptExtractionNameList> eptExtractionNameListList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(eptExtractionNameListList != null && eptExtractionNameListList.size() > 0){
				for(int i = 0 ; i < eptExtractionNameListList.size() ; i++){
					EptExtractionNameListVo srv = new EptExtractionNameListVo(eptExtractionNameListList.get(i));//PO -> VO
					eptExtractionNameListVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EptExtractionNameListVo>(eptExtractionNameListVoList,count,pageindex,pagesize);
	}
	
	/**
	 * 
	 * @Title: getExpertIdsByProjectId
	 * @Description: 根据项目Id获得名单表的专家Id,在由专家Id查专家基本信息表,获得分页
	 * @param @param projectId
	 * @param @param currentPageNumber
	 * @param @param perPageCount
	 * @param @return    
	 * @return PageInfo<EptExpertBaseinfoVo> 
	 * @author ly
	 * @date 2014-8-18 下午09:17:02
	 * @throws
	 */
	public PageInfo<EptExpertBaseinfoVo>  getExpertIdsByProjectId(Integer projectId, Integer currentPageNumber, Integer perPageCount){
		PageInfo<EptExpertBaseinfoVo> pif = null;
		String sql = "select l.expertId from EptExtractionNameList l where projectId=:projectId";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("projectId", projectId);
		try{
			List<Integer> list = tableDao.otherQuery(sql, true, true, param);
			if (list != null && list.size() > 0) {
				String sql2 = "from EptExpertBaseinfo e where e.id in(:expertIdList)";
				Map<String,Object> param2 = new HashMap<String,Object>();
				param2.put("expertIdList", list);
				List<EptExpertBaseinfo> infoList = tableDao.querydata(sql2, true, currentPageNumber, perPageCount, param2);
				List<EptExpertBaseinfoVo> listVo = new ArrayList<EptExpertBaseinfoVo>();
				for (Iterator iterator = infoList.iterator(); iterator.hasNext();) {
					EptExpertBaseinfoVo eptExpertBaseinfoVo = new EptExpertBaseinfoVo((EptExpertBaseinfo) iterator.next());
					listVo.add(eptExpertBaseinfoVo);
					
				}
				pif = new PageInfo<EptExpertBaseinfoVo>(listVo, this.countExpertIdsByProjectId(projectId), currentPageNumber, perPageCount);
				
			} else {
				logger.info("没有专家名单ID!");
				return null;
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			logger.info(e.toString());
		}
		return pif;
	}

	/**
	 * 
	 * @Title: countExpertIdsByProjectId
	 * @Description: 项目抽取的专家的数目
	 * @param @param projectId
	 * @param @return    
	 * @return Integer    
	 * @throws
	 */
	public Integer countExpertIdsByProjectId(Integer projectId){
		String sql = "select count(id) from EptExtractionNameList where projectId=:projectId";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("projectId", projectId);
		try {
			List<Integer> list = tableDao.otherQuery(sql, true, true, param);
			return Integer.parseInt((list.get(0)+""));
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.toString());
			return -1;
		}
	}

}