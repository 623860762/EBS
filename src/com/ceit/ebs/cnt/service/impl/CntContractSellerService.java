package com.ceit.ebs.cnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.entity.CntContractSeller;
import com.ceit.ebs.cnt.service.ICntContractSellerService;
import com.ceit.ebs.cnt.vo.CntContractPurchaserVo;
import com.ceit.ebs.cnt.vo.CntContractSellerVo;

/*
 * @author lcy date : 2014.8.7
 */

public class CntContractSellerService implements ICntContractSellerService {

	private CntContractSeller cntContractSeller;
	private ITableDao tableDao;


	public CntContractSellerService(){
		
	}
	
	// Constructors

	
	
	public CntContractSellerVo getCntContractSellerbyId(int id){
		CntContractSellerVo cntContractSellerVo=null;
		try {
			cntContractSeller = (CntContractSeller)(tableDao.getEntitybyId(id, CntContractSeller.class));
			cntContractSellerVo=new CntContractSellerVo(cntContractSeller);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cntContractSellerVo;
	}
	
	public boolean modifyCntContractSeller(CntContractSellerVo s){
		try {
			tableDao.update(s.adapterToCntContractSeller());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteCntContractSellerbyId(Integer id){
		try{
			tableDao.delete(id,CntContractSeller.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertCntContractSeller(CntContractSellerVo cntContractSellerVo){
		try {
			CntContractSeller sr = cntContractSellerVo.adapterToCntContractSeller();
			Integer cntContractSellerId = tableDao.insert(sr);
			//sr.setId(cntContractSellerId);
			//sr.setDispindex(cntContractSellerId);
			tableDao.update(sr);
			return cntContractSellerId;
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
		sql = "SELECT  COUNT(d.id) FROM  CntContractSeller d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<CntContractSeller> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有CntContractSellerVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<CntContractSellerVo> querydata(int pageindex, int pagesize) {
		List<CntContractSellerVo> cntContractSellerVoList = new ArrayList<CntContractSellerVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  CntContractSeller d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<CntContractSeller> cntContractSellerList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(cntContractSellerList != null && cntContractSellerList.size() > 0){
				for(int i = 0 ; i < cntContractSellerList.size() ; i++){
					CntContractSellerVo srv = new CntContractSellerVo(cntContractSellerList.get(i));//PO -> VO
					cntContractSellerVoList.add(srv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<CntContractSellerVo>(cntContractSellerVoList,count,pageindex,pagesize);
	}
	
	public void setCntContractSeller(CntContractSeller cntContractSeller) {
		this.cntContractSeller = cntContractSeller;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

}
