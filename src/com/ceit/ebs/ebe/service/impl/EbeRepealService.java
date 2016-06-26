package com.ceit.ebs.ebe.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebe.entity.EbeRepeal;
import com.ceit.ebs.ebe.service.IEbeRepealService;
import com.ceit.ebs.ebe.vo.EbeRepealVo;
import com.ceit.ebs.ebp.service.impl.EbpPackageService;
/**
 * EbeRepealService 是为系统的评标废标提供服务的的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-7
 */
public class EbeRepealService implements IEbeRepealService{
	private EbeRepeal ebeRepeal;
	private ITableDao tableDao;
	
	
	public EbeRepealService(){
		
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
		sql="SELECT COUNT(d.id) FROM EbeRepeal d "+"where '1'='1'";
		try {
			List<EbeRepeal> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbeRepealVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbeRepealVo> querydata(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		List<EbeRepealVo> ebeRepealVoList = new ArrayList<EbeRepealVo>(); //VO集合
		int count=0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbeRepeal d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbeRepeal> ebeRepealList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebeRepealList != null && ebeRepealList.size() > 0){
				for(int i = 0 ; i < ebeRepealList.size() ; i++){
					EbeRepealVo erv = new EbeRepealVo(ebeRepealList.get(i));//PO -> VO
//					EbpPackageService eps = new EbpPackageService();
//					eps.setTableDao(tableDao);
//					//eps.setTableDao(new TableDao());
//					System.out.println("2123123");
//					System.out.println(eps.getEbpPackagebyId(erv.getPackageId()).getId());
//					String packageName = eps.getEbpPackagebyId(erv.getPackageId()).getPackageName();
//					erv.setPackageName(packageName);
					
					ebeRepealVoList.add(erv);
				}
			}
			count=this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  new PageInfo<EbeRepealVo>(ebeRepealVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据评标废标ID查找评标废标
	 * @param  ebeRepealId 要查询的评标废标ID值
	 * @return 查询到的EbeRepeal实例
	 */
	public EbeRepealVo getEbeRepealbyId(Integer ebeRepealId) {
		// TODO Auto-generated method stub
		EbeRepealVo ebeRepealVo=null;
		try {
			ebeRepeal = (EbeRepeal)tableDao.getEntitybyId(ebeRepealId, EbeRepeal.class);
			ebeRepealVo=new EbeRepealVo(ebeRepeal);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebeRepealVo;	
	}
	/**
	 * 修改评标废标实例
	 * @param  EbeRepeal 要修改的评标废标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbeRepeal(EbeRepealVo ebeRepealVo) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ebeRepealVo.setOpTime(df.format(new Date()));
			tableDao.update(ebeRepealVo.adapterToEbeRepeal());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据评标废标的ID删除评标废标
	 * @param  ebeRepealId 要删除的评标废标的ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteEbeRepealbyId(Integer ebeRepealId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(ebeRepealId, EbeRepeal.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个评标废标
	 * @param ebeRepealVo 要添加的EbeRepealVo实例
	 * @return 添加的评标废标在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbeRepeal(EbeRepealVo ebeRepealVo) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ebeRepealVo.setOpTime(df.format(new Date()));
			EbeRepeal er = ebeRepealVo.adapterToEbeRepeal();
			Integer ebeRepealId = tableDao.insert(er);
			er.setId(ebeRepealId);
			er.setDispIndex(ebeRepealId);
			tableDao.update(er);
			return ebeRepealId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbeRepeal(EbeRepeal ebeRepeal) {
		// TODO Auto-generated method stub
		this.ebeRepeal=ebeRepeal;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
	/**
	 * 批量删除废标信息
	 * @param ids 废标信息id集合
	 * @return 成功返回true，失败返回false
	 * @author hgl
	 * 2014/08/15
	 */
	public Boolean deleteEbeRepealbyIds(List<Integer> ids)
	{
		setTableDao(new TableDao());
		for(int i = 0; i < ids.size(); i++)	{
			if(deleteEbeRepealbyId(ids.get(i)) == false)	{
				return false;
			}
		}
		return true;	
	}
	
	/**
	 * 按包查看废标信息
	 * @param packageId
	 * @return EbeRepeal对象列表
	 * @author hgl
	 * 2014/08/16
	 */
	@SuppressWarnings("unchecked")
	public List<EbeRepeal> showRepealByPackageId(Integer packageId){
		setTableDao(this.getTableDao());
//		EbeRepeal ebeRepeal = new EbeRepeal();
		//判断是否已经加入过其他评审小组
		String sql=" FROM  EbeRepeal d where d.packageId = :packageId";
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("packageId", packageId);
			List<EbeRepeal> list = tableDao.otherQuery(sql,true,true, params);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	public EbeRepeal getEbeRepeal() {
		return ebeRepeal;
	}

	public ITableDao getTableDao() {
		return tableDao;
	}
	
}
