package com.ceit.ebs.cnt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.entity.CntContract;
import com.ceit.ebs.cnt.service.ICntContractService;
import com.ceit.ebs.cnt.vo.CntContractPurchaserVo;
import com.ceit.ebs.cnt.vo.CntContractVo;

/*
 * @author lcy date : 2014.8.7
 */

public class CntContractService implements ICntContractService {

	// Fields

	private CntContract cntContract;
	private ITableDao tableDao;
	

	public CntContractService(){
		
	}

	// Constructors

	
	
	public CntContractVo getCntContractbyId(int id){
		CntContractVo cntContractVo=null;
		try {
			cntContract = (CntContract)(tableDao.getEntitybyId(id, CntContract.class));
			cntContractVo=new CntContractVo(cntContract);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cntContractVo;
	}
	
	public boolean modifyCntContract(CntContractVo s){
		try {
			tableDao.update(s.adapterToCntContract());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteCntContractbyId(Integer id){
		try{
			tableDao.delete(id,CntContract.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertCntContract(CntContractVo cntContractVo){
		try {
			CntContract sr = cntContractVo.adapterToCntContract();
			Integer cntContractId = tableDao.insert(sr);
			//sr.setId(cntContractId);
			//sr.setDispindex(cntContractId);
			tableDao.update(sr);
			return cntContractId;
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
		sql = "SELECT  COUNT(d.id) FROM  CntContract d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<CntContract> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有CntContractVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<CntContractVo> querydata(int pageindex, int pagesize) {
		List<CntContractVo> cntContractVoList = new ArrayList<CntContractVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  CntContract d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<CntContract> cntContractList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(cntContractList != null && cntContractList.size() > 0){
				for(int i = 0 ; i < cntContractList.size() ; i++){
					CntContractVo srv = new CntContractVo(cntContractList.get(i));//PO -> VO
					cntContractVoList.add(srv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<CntContractVo>(cntContractVoList,count,pageindex,pagesize);
	}
	
	public void setCntContract(CntContract cntContract) {
		this.cntContract = cntContract;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

}