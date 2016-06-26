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
import com.ceit.ebs.ebe.entity.EbeGroup;
import com.ceit.ebs.ebe.entity.EbeGroupPackage;
import com.ceit.ebs.ebe.service.IEbeGroupPackageService;
import com.ceit.ebs.ebe.vo.EbeGroupPackageVo;
import com.ceit.ebs.ebe.vo.EbeGroupVo;
import com.ceit.ebs.ebp.service.impl.EbpPackageService;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
/**
 * IEbeGroupPackageService 是为系统的评标小组与包关系提供服务的类，包括所有相关操作的业务逻辑。
 * @author czg
 * date 2014-8-7
 */
public class EbeGroupPackageService implements IEbeGroupPackageService{
	
	private EbeGroupPackage ebeGroupPackage;
	private ITableDao tableDao;
	
	public EbeGroupPackageService(){
	}
	/**
	 * 根据主键ID,获得数据总数
	 * @return 查询到的数据总数，若失败，返回-1
	 */
	@SuppressWarnings("unchecked")
	public Integer getCount(String sql,Map<String, Object> params) {
		// TODO Auto-generated method stub
		Integer count = 0;//记录总数
		if("".equals(sql)){
			sql="FROM EbeGroupPackage d "+"where '1'='1'";
		}
		try {
			List<EbeGroupPackage> list = tableDao.otherQuery(sql, true, true, params);
			if(list != null && list.size() > 0){
				count =list.size();
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
	 * @return 包含查询到的所有EbeGroupPackageVo实例的List，若失败，返回null
	 */
	
	@SuppressWarnings("unchecked")
	public PageInfo<EbeGroupPackageVo> querydata(int pageindex, int pagesize) {
		List<EbeGroupPackageVo> ebeGroupPackageVoList = new ArrayList<EbeGroupPackageVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EbeGroupPackage d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EbeGroupPackage> ebeGroupPackageList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebeGroupPackageList != null && ebeGroupPackageList.size() > 0){
				for(int i = 0 ; i < ebeGroupPackageList.size() ; i++){
					EbeGroupPackageVo srv = new EbeGroupPackageVo(ebeGroupPackageList.get(i));//PO -> VO
					ebeGroupPackageVoList.add(srv);
				}
			}
			count = this.getCount("",null);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EbeGroupPackageVo>(ebeGroupPackageVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据评标小组与包关系ID查找评标小组与包关系
	 * @param  ebeGroupPackageId 要查询的评标小组与包关系ID值
	 * @return 查询到的EbeGroupPackage实例
	 */
	public EbeGroupPackageVo getEbeGroupPackagebyId(Integer ebeGroupPackageId) {
		// TODO Auto-generated method stub
		EbeGroupPackageVo ebeGroupPackageVo=null;
		try {
			ebeGroupPackage = (EbeGroupPackage)tableDao.getEntitybyId(ebeGroupPackageId, EbeGroupPackage.class);
			ebeGroupPackageVo=new EbeGroupPackageVo(ebeGroupPackage);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebeGroupPackageVo;		
	}
	/**
	 * 修改评标小组与包关系实例
	 * @param  ebeGroupPackage 要修改的评标小组与包关系
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbeGroupPackage(EbeGroupPackageVo ebeGroupPackageVo) {
		// TODO Auto-generated method stub
		try {
			//ebeGroupPackageVo.setIsValid("ppp");
			tableDao.update(ebeGroupPackageVo.adapterToEbeGroupPackage());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据评标小组与包关系的ID删除评标小组与包关系
	 * @param  ebeGroupPackageId 要删除的评标小组与包关系ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteEbeGroupPackagebyId(Integer ebeGroupPackageId) {
		// TODO Auto-generated method stub
		try {
			tableDao.delete(ebeGroupPackageId, EbeGroupPackage.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * 新增一个评标小组与包关系
	 * @param ebeGroupPackageVo 要添加的EbeGroupPackageVo实例
	 * @return 添加的评标小组与包关系在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbeGroupPackage(EbeGroupPackageVo ebeGroupPackageVo) {
		// TODO Auto-generated method stub
		try {
			EbeGroupPackage egp = ebeGroupPackageVo.adapterToEbeGroupPackage();
			Integer ebeGroupPackageId = tableDao.insert(egp);
			egp.setDispIndex(ebeGroupPackageId);
			egp.setId(ebeGroupPackageId);
			tableDao.update(egp);
			return ebeGroupPackageId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbeGroupPackage(EbeGroupPackage ebeGroupPackage) {
		// TODO Auto-generated method stub
		this.ebeGroupPackage=ebeGroupPackage;
	}

	public void setTableDao(ITableDao tableDao) {
		// TODO Auto-generated method stub
		this.tableDao=tableDao;
	}
	
	/**
	 * 初始化组包关系表
	 * @author hgl
	 * @return 添加成功返回true，失败返回false
	 * date 2014/08/15 测试通过
	 */
	public Boolean initGroupPackage(EbpPackageVo epv)
	{
			EbeGroupPackageVo ebeGroupPackageVo = new EbeGroupPackageVo();
			//判断是否已经初始化过,查询表里是否有packageID的记录
			String sql=" FROM  EbeGroupPackage d where d.packageId = :packageId";
			try {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("packageId", epv.getId());
				List list = tableDao.querydata(sql, true, 1, 1, params);

				if(list == null || list.size() == 0){
					//设置除了评审小组以外的字段
					ebeGroupPackageVo.setIsValid("Y");
					ebeGroupPackageVo.setPackageId(epv.getId());
					ebeGroupPackageVo.setProjectId(epv.getProjectId());
					ebeGroupPackageVo.setOpTime(getTime());
					ebeGroupPackageVo.setOperUser("还不知道怎么获得");
					if(insertEbeGroupPackage(ebeGroupPackageVo) == -1){
						return false;
					}
				  }
				}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
	}
	
	/**
	 * 组下关联包
	 * @author hgl
	 * @param packageIds 包ID表
	 * @param groupId 评审小组ID
	 * @return 添加成功返回true，失败返回false
	 * date 2014-8-15 已测试
	 */
	public Boolean groupAttachPackage(Integer groupId, String type, String myPackageIds){
		String[] packageIds = myPackageIds.split(",");
		for (int i = 0; i < packageIds.length; i++){
			int packageId = Integer.parseInt(packageIds[i]);
			//通过packageID获取vo对象
			String sql=" FROM  EbeGroupPackage d where d.packageId = :packageId";
			try {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("packageId", packageId);
				List list = tableDao.querydata(sql, true, 1, 1, params);
				EbeGroupPackageVo ebeGroupPackageVo=new EbeGroupPackageVo((EbeGroupPackage)list.get(0));
			if("TECH".equals(type)){
				ebeGroupPackageVo.setTechGroupId(groupId);
			}
			else if("BUSI".equals(type)){
				ebeGroupPackageVo.setBusiGroupId(groupId);
			}
			else if("PRICE".equals(type)){
				ebeGroupPackageVo.setPriceGroupId(groupId);
			}
			//修改数据库
			ebeGroupPackageVo.setOpTime(getTime());
			if(modifyEbeGroupPackage(ebeGroupPackageVo) == false){
				return false;
			}
		}catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		return true;
	}
	
	//组下取消关联包
	public Boolean removePackageFromGroup(Integer groupId, String type, String myPackageIds){
		String[] packageIds = myPackageIds.split(",");
		for (int i = 0; i < packageIds.length; i++){
			int packageId = Integer.parseInt(packageIds[i]);
			//通过packageID获取vo对象
			String sql=" FROM  EbeGroupPackage d where d.packageId = :packageId";
			try {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("packageId", packageId);
				List list = tableDao.querydata(sql, true, 1, 1, params);
				EbeGroupPackageVo ebeGroupPackageVo=new EbeGroupPackageVo((EbeGroupPackage)list.get(0));
			if("TECH".equals(type)){
				ebeGroupPackageVo.setTechGroupId(null);
			}
			else if("BUSI".equals(type)){
				ebeGroupPackageVo.setBusiGroupId(null);
			}
			else if("PRICE".equals(type)){
				ebeGroupPackageVo.setPriceGroupId(null);
			}
			//修改数据库
			ebeGroupPackageVo.setOpTime(getTime());
			if(modifyEbeGroupPackage(ebeGroupPackageVo) == false){
				return false;
			}
		}catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		return true;
	}
	/**
	 * 显示组内关联的包
	 * @author hgl
	 * @return 组内关联的包列表
	 * date 2014/08/15
	 */
	@SuppressWarnings("finally")
	public PageInfo<EbeGroupPackageVo> showGroupPackageList(int groupId, String type, int pageindex, int pagesize){
		List<EbeGroupPackageVo> list=new ArrayList<EbeGroupPackageVo>();
		int count=0;
		//不同的类型的小组查询不同的字段
		String sql = "";
		if("TECH".equals(type)){
			sql = " FROM  EbeGroupPackage d where d.techGroupId = :groupId";
		}
		else if("BUSI".equals(type)){
			sql = " FROM  EbeGroupPackage d where d.busiGroupId = :groupId";
		}
		else if("PRICE".equals(type)){
			sql = " FROM  EbeGroupPackage d where d.priceGroupId = :groupId";
		}
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("groupId", groupId);
			List<EbeGroupPackage> queryList = tableDao.querydata(sql, true, pageindex, pagesize, params);
			for (int i = 0; i < queryList.size(); i++){	
				list.add(new EbeGroupPackageVo(queryList.get(i)));
			}
			count = this.getCount(sql,params);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return new PageInfo<EbeGroupPackageVo>(list, count,pageindex, pagesize);
		}
	}
	
	/**
	 * 显示未分入任何组的包
	 * @author hgl
	 * date 2014/08/15
	 */
	
	public PageInfo<EbeGroupPackageVo> showPackageNotInGroupList(String type, int pageindex, int pagesize){
		List<EbeGroupPackageVo> list=new ArrayList<EbeGroupPackageVo>();
		int count=0;
		//不同的类型的小组查询不同的字段
		String sql = "";
		if("TECH".equals(type)){
			sql = " FROM  EbeGroupPackage d where d.techGroupId is null";
		}
		else if("BUSI".equals(type)){
			sql = " FROM  EbeGroupPackage d where d.busiGroupId is null";
		}
		else if("PRICE".equals(type)){
			sql = " FROM  EbeGroupPackage d where d.priceGroupId is null";
		}
		try {
			List<EbeGroupPackage> queryList = tableDao.querydata(sql, true, pageindex, pagesize,null);
			for (int i = 0; i < queryList.size(); i++){	
				list.add(new EbeGroupPackageVo(queryList.get(i)));
			}
			count = this.getCount(sql,null);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return new PageInfo<EbeGroupPackageVo>(list, count,pageindex, pagesize );
		}

	}
	/**
	 * 获取系统时间
	 * @author hgl
	 * @return 返回时间字符串
	 * date 2014-8-14 已测试
	 */
	public String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}
	public EbeGroupPackage getEbeGroupPackage() {
		return ebeGroupPackage;
	}
	public ITableDao getTableDao() {
		return tableDao;
	}
}
