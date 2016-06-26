package com.ceit.ebs.bsdata.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.bsdata.entity.BsdataSerialNumber;
import com.ceit.ebs.bsdata.vo.BsdataSerialNumberVo;

public class BsdataSerialNumberService {
	private BsdataSerialNumber bsdataSerialNumber;
	private ITableDao tableDao;
	
	public BsdataSerialNumberService()
	{
	}
	/**
	 * 根据主键ID,获得数据总数
	 * @return 查询到的数据总数，若失败，返回-1
	 */
	@SuppressWarnings("unchecked")
	public Integer getCount() {
		// TODO Auto-generated method stub
		Integer count = 0;//记录总数
		String sql = null;
		//Map<String,Object> map = new HashMap<String,Object>();
		sql="SELECT COUNT(d.id) FROM BsdataSerialNumber d "+"where '1'='1'";
		try {
			List<BsdataSerialNumber> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有BsdataSerialNumberVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<BsdataSerialNumberVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<BsdataSerialNumberVo> bsdataSerialNumberVoList = new ArrayList<BsdataSerialNumberVo>(); //VO集合
		int count = 0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  BsdataSerialNumber d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<BsdataSerialNumber> bsdataSerialNumberList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(bsdataSerialNumberList != null && bsdataSerialNumberList.size() > 0){
				for(int i = 0 ; i < bsdataSerialNumberList.size() ; i++){
					BsdataSerialNumberVo eov = new BsdataSerialNumberVo(bsdataSerialNumberList.get(i));//PO -> VO
					bsdataSerialNumberVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<BsdataSerialNumberVo>(bsdataSerialNumberVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据项目下的分标的ID查找项目下的分标
	 * @param  bsdataSerialNumberId 要查询的项目下的分标ID值
	 * @return 查询到的BsdataSerialNumber实例
	 */
	public BsdataSerialNumberVo getBsdataSerialNumberbyId(Integer bsdataSerialNumberId) {
		// TODO Auto-generated method stub
		BsdataSerialNumberVo bsdataSerialNumberVo=null;
		try {
			bsdataSerialNumber = (BsdataSerialNumber)tableDao.getEntitybyId(bsdataSerialNumberId, BsdataSerialNumber.class);
			bsdataSerialNumberVo=new BsdataSerialNumberVo(bsdataSerialNumber);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bsdataSerialNumberVo;	
	}
	/**
	 * 修改项目下的分标实例
	 * @param  bsdataSerialNumber 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyBsdataSerialNumber(BsdataSerialNumberVo bsdataSerialNumberVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(bsdataSerialNumberVo.adapterToBsdataSerialNumber());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  bsdataSerialNumberId 要删除的项目下分标ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteBsdataSerialNumberbyId(Integer bsdataSerialNumberId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(bsdataSerialNumberId, BsdataSerialNumber.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个项目下的分标
	 * @param bsdataSerialNumberVo 要添加的BsdataSerialNumberVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertBsdataSerialNumber(BsdataSerialNumberVo bsdataSerialNumberVo) {
		// TODO Auto-generated method stub
		try {
			BsdataSerialNumber eo = bsdataSerialNumberVo.adapterToBsdataSerialNumber();
			Integer bsdataSerialNumberId = tableDao.insert(eo);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(eo);
			return bsdataSerialNumberId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setBsdataSerialNumber(BsdataSerialNumber bsdataSerialNumber) {
		// TODO Auto-generated method stub
		this.bsdataSerialNumber=bsdataSerialNumber;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
}
