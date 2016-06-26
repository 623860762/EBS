package com.ceit.ebs.ebe.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cnt.vo.CntContractPurchaserVo;
import com.ceit.ebs.ebe.entity.EbeScoreBaisis;
import com.ceit.ebs.ebe.service.IEbeScoreBaisisService;
import com.ceit.ebs.ebe.vo.EbeScoreBaisisVo;
/**
 * EbeScoreBaisisService 是为系统的打分依据提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-7
 */
public class EbeScoreBaisisService implements IEbeScoreBaisisService{
	private EbeScoreBaisis ebeScoreBaisis;
	private ITableDao tableDao;
	
	
	public EbeScoreBaisisService(){
		
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
		sql="SELECT COUNT(d.id) FROM EbeScoreBaisis d "+"where '1'='1'";
		try {
			List<EbeScoreBaisis> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbeScoreBaisisVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbeScoreBaisisVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<EbeScoreBaisisVo> ebeScoreBaisisVoList = new ArrayList<EbeScoreBaisisVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbeScoreBaisis d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbeScoreBaisis> ebeScoreBaisisList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebeScoreBaisisList != null && ebeScoreBaisisList.size() > 0){
				for(int i = 0 ; i < ebeScoreBaisisList.size() ; i++){
					EbeScoreBaisisVo esbv = new EbeScoreBaisisVo(ebeScoreBaisisList.get(i));//PO -> VO
					ebeScoreBaisisVoList.add(esbv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<EbeScoreBaisisVo>(ebeScoreBaisisVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据打分依据ID查找打分依据
	 * @param  ebeScoreBaisisId 要查询的打分依据ID值
	 * @return 查询到的EbeScoreBaisis实例
	 */
	public EbeScoreBaisisVo getEbeScoreBaisisbyId(Integer ebeScoreBaisisId) {
		// TODO Auto-generated method stub
		EbeScoreBaisisVo ebeScoreBaisisVo=null;
		try {
			ebeScoreBaisis = (EbeScoreBaisis)tableDao.getEntitybyId(ebeScoreBaisisId, EbeScoreBaisis.class);
			ebeScoreBaisisVo=new EbeScoreBaisisVo(ebeScoreBaisis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebeScoreBaisisVo;
	}
	/**
	 * 修改打分依据实例
	 * @param  ebeScoreBaisis 要修改的打分依据
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbeScoreBaisis(EbeScoreBaisisVo ebeScoreBaisisVo) {
		// TODO Auto-generated method stub
		try {
			tableDao.update(ebeScoreBaisisVo.adapterToEbeScoreBaisis());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据打分依据的ID删除打分依据
	 * @param  ebeScoreBaisisId 要删除的打分依据ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteEbeScoreBaisisbyId(Integer ebeScoreBaisisId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(ebeScoreBaisisId, EbeScoreBaisis.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个打分依据
	 * @param ebeScoreBaisisVo 要添加的EbeScoreBaisisVo实例
	 * @return 添加的打分依据在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbeScoreBaisis(EbeScoreBaisisVo ebeScoreBaisisVo) {
		// TODO Auto-generated method stub
		try {
			EbeScoreBaisis esb = ebeScoreBaisisVo.adapterToEbeScoreBaisis();
			Integer ebeScoreBaisisId = tableDao.insert(esb);
			//sr.setId(sysRoleId);
			//sr.setDispindex(sysRoleId);
			tableDao.update(esb);
			return ebeScoreBaisisId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbeScoreBaisis(EbeScoreBaisis ebeScoreBaisis) {
		// TODO Auto-generated method stub
		this.ebeScoreBaisis=ebeScoreBaisis;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}

}
