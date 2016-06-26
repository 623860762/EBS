package com.ceit.ebs.cnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.entity.CntContractLine;
import com.ceit.ebs.cnt.service.ICntContractLineService;
import com.ceit.ebs.cnt.vo.CntContractLineVo;

/*
 * @author lcy date : 2014.8.7
 */

public class CntContractLineService implements ICntContractLineService {


	private CntContractLine cntContractLine;
	private ITableDao tableDao;


	public CntContractLineService(){
	}
	
	// Constructors

	
	
	public CntContractLineVo getCntContractLinebyId(int id){
		CntContractLineVo cntContractLineVo=null;
		try {
			cntContractLine = (CntContractLine)(tableDao.getEntitybyId(id, CntContractLine.class));
			cntContractLineVo=new CntContractLineVo(cntContractLine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cntContractLineVo;
	}
	
	public boolean modifyCntContractLine(CntContractLineVo so){
		try {
			CntContractLine s= so.adapterToCntContractLine();
			tableDao.update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteCntContractLinebyId(Integer id){
		try{
			tableDao.delete(id,CntContractLine.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertCntContractLine(CntContractLineVo cntContractLineVo){
		try {
			CntContractLine sr = cntContractLineVo.adapterToCntContractLine();
			Integer cntContractLineId = tableDao.insert(sr);
			//sr.setId(cntContractLineId);
			//sr.setDispindex(cntContractLineId);
			tableDao.update(sr);
			return cntContractLineId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
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
		sql = "SELECT  COUNT(d.id) FROM  CntContractLine d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<CntContractLine> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有CntContractLineVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<CntContractLineVo> querydata(int pageindex, int pagesize) {
		List<CntContractLineVo> cntContractLineVoList = new ArrayList<CntContractLineVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  CntContractLine d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<CntContractLine> cntContractLineList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(cntContractLineList != null && cntContractLineList.size() > 0){
				for(int i = 0 ; i < cntContractLineList.size() ; i++){
					CntContractLineVo srv = new CntContractLineVo(cntContractLineList.get(i));//PO -> VO
					cntContractLineVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<CntContractLineVo>(cntContractLineVoList,count,pageindex,pagesize);

	}
	
	public void setCntContractLine(CntContractLine cntContractLine) {
		this.cntContractLine = cntContractLine;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}
	

}
