package com.ceit.ebs.ebe.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.vo.CntContractPurchaserVo;
import com.ceit.ebs.ebe.entity.EbePackageInfo;
import com.ceit.ebs.ebe.service.IEbePackageInfoService;
import com.ceit.ebs.ebe.vo.EbePackageInfoVo;
/**
 * EbePackageInfoService 是为系统的评审产品提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-7
 */
public class EbePackageInfoService implements IEbePackageInfoService{
	private EbePackageInfo ebePackageInfo;
	private ITableDao tableDao;
	
	
	public EbePackageInfoService(){
		
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
		sql="SELECT COUNT(d.id) FROM EbePackageInfo d "+"where '1'='1'";
		try {
			List<EbePackageInfo> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbePackageInfoVo实例的List，若失败，返回null
	 */
	
	@SuppressWarnings("unchecked")
	public PageInfo<EbePackageInfoVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<EbePackageInfoVo> ebePackageInfoVoList = new ArrayList<EbePackageInfoVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbePackageInfo d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbePackageInfo> ebePackageInfoList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebePackageInfoList != null && ebePackageInfoList.size() > 0){
				for(int i = 0 ; i < ebePackageInfoList.size() ; i++){
					EbePackageInfoVo egpv = new EbePackageInfoVo(ebePackageInfoList.get(i));//PO -> VO
					ebePackageInfoVoList.add(egpv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<EbePackageInfoVo>(ebePackageInfoVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据评审产品ID查找评审产品
	 * @param  ebePackageInfoId 要查询的评审产品ID值
	 * @return 查询到的EbePackageInfo实例
	 */
	public EbePackageInfoVo getEbePackageInfobyId(Integer ebePackageInfoId) {
		// TODO Auto-generated method stub
		EbePackageInfoVo ebePackageInfoVo=null;
		try {
			ebePackageInfo = (EbePackageInfo)tableDao.getEntitybyId(ebePackageInfoId, EbePackageInfo.class);
			ebePackageInfoVo=new EbePackageInfoVo(ebePackageInfo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebePackageInfoVo;	
	}
	/**
	 * 修改评审产品实例
	 * @param  ebePackageInfo 要修改的评审产品
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbePackageInfo(EbePackageInfoVo ebePackageInfoVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(ebePackageInfoVo.adapterToEbePackageInfo());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据评审产品的ID删除评审产品
	 * @param  ebePackageInfoId 要删除的评审产品ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteEbePackageInfobyId(Integer ebePackageInfoId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(ebePackageInfoId, EbePackageInfo.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个评审产品
	 * @param ebePackageInfoVo 要添加的EbePackageInfoVo实例
	 * @return 添加的评审产品在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbePackageInfo(EbePackageInfoVo ebePackageInfoVo) {
		// TODO Auto-generated method stub
		try {
			EbePackageInfo egi = ebePackageInfoVo.adapterToEbePackageInfo();
			Integer ebePackageInfoId = tableDao.insert(egi);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(egi);
			return ebePackageInfoId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbePackageInfo(EbePackageInfo ebePackageInfo) {
		// TODO Auto-generated method stub
		this.ebePackageInfo=ebePackageInfo;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
}
