package com.ceit.ebs.cnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.entity.CntContractPurchaser;
import com.ceit.ebs.cnt.service.ICntContractPurchaserService;
import com.ceit.ebs.cnt.vo.CntContractPurchaserVo;

/*
 * @author lcy date : 2014.8.7
 */

public class CntContractPurchaserService implements
		ICntContractPurchaserService {

	private CntContractPurchaser cntContractPurchaser;
	private ITableDao tableDao;


	public CntContractPurchaserService(){
		
	}
	
	// Constructors

	
	
	public CntContractPurchaserVo getCntContractPurchaserbyId(int id){
		CntContractPurchaserVo cntContractPurchaserVo=null;
		try {
			cntContractPurchaser = (CntContractPurchaser)(tableDao.getEntitybyId(id, CntContractPurchaser.class));
			cntContractPurchaserVo=new CntContractPurchaserVo(cntContractPurchaser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cntContractPurchaserVo;
	}
	
	public boolean modifyCntContractPurchaser(CntContractPurchaserVo s){
		try {
			tableDao.update(s.adapterToCntContractPurchaser());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteCntContractPurchaserbyId(Integer id){
		try{
			tableDao.delete(id,CntContractPurchaser.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertCntContractPurchaser(CntContractPurchaserVo cntContractPurchaserVo){
		try {
			CntContractPurchaser sr = cntContractPurchaserVo.adapterToCntContractPurchaser();
			Integer cntContractPurchaserId = tableDao.insert(sr);
			//sr.setId(cntContractPurchaserId);
			//sr.setDispindex(cntContractPurchaserId);
			tableDao.update(sr);
			return cntContractPurchaserId;
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
		sql = "SELECT  COUNT(d.id) FROM  CntContractPurchaser d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<CntContractPurchaser> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有CntContractPurchaserVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<CntContractPurchaserVo> querydata(int pageindex, int pagesize) {
		List<CntContractPurchaserVo> cntContractPurchaserVoList = new ArrayList<CntContractPurchaserVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  CntContractPurchaser d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<CntContractPurchaser> cntContractPurchaserList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(cntContractPurchaserList != null && cntContractPurchaserList.size() > 0){
				for(int i = 0 ; i < cntContractPurchaserList.size() ; i++){
					CntContractPurchaserVo srv = new CntContractPurchaserVo(cntContractPurchaserList.get(i));//PO -> VO
					cntContractPurchaserVoList.add(srv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<CntContractPurchaserVo>(cntContractPurchaserVoList,count,pageindex,pagesize);
	}
	
	public void setCntContractPurchaser(CntContractPurchaser cntContractPurchaser) {
		this.cntContractPurchaser = cntContractPurchaser;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

}
