package com.ceit.ebs.ebp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.impl.TableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.entity.EbpPackage;
import com.ceit.ebs.ebp.service.IEbpPackageService;
import com.ceit.ebs.ebp.vo.EbpObjectVo;
import com.ceit.ebs.ebp.vo.EbpPackageVo;
import com.ceit.ebs.ebp.vo.EbpProjectVo;
import com.ceit.ebs.sup.service.impl.SupProjectSupplierService;
/**
 * EbpPackageService 是为系统的招标项目划分包提供服务的类，包括所有相关操作的业务逻辑。
 * @author gr
 * date 2014-8-14
 */
public class EbpPackageService implements IEbpPackageService {
	private EbpPackage ebpPackage;
	private ITableDao tableDao;
	
	public EbpPackageService(){
	}
	/**
	 * 项目下分包
	 * @param projectId
	 * @param num
	 * @return
	 */
	public boolean dividePackageInProject(Integer projectId, Integer num){
		EbpProjectService ebpProjectService = new EbpProjectService();
		EbpProjectVo ebpProjectVo = new EbpProjectVo();
		
		
		Calendar c=Calendar.getInstance();//获得系统当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			ebpProjectService.setTableDao(tableDao);
			ebpProjectVo = ebpProjectService.getEbpProjectbyId(projectId);
			List<EbpPackageVo> epbvo = this.getEbpPackageListbyProjectId(projectId);
			if(epbvo.size()!=0){
				
			}
			for (int i = 0; i < num; i++) {
				EbpPackageVo ebpPackageVo = new EbpPackageVo();
				ebpPackageVo.setIsValid("1");//默认设为1
				ebpPackageVo.setProjectId(projectId);
				ebpPackageVo.setUpdateTime(sdf.format(c.getTime()));
				int ebpPackageId = this.insertEbpPackage(ebpPackageVo);
				ebpPackageVo = this.getEbpPackagebyId(ebpPackageId);
				
				ebpPackageVo.setPackageName("分包"+ebpPackageVo.getDispIndex());
				boolean result = this.modifyEbpPackage(ebpPackageVo);
				ebpPackageVo = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 根据项目ID把项目下所有包设置为开标
	 * @author czg
	 * @param  projectId 文件对应的包ID
	 * @return 设置成功返回true，否则返回false
	 * date 2014-8-21  已测试
	 */
	@SuppressWarnings("unchecked")
	public boolean openPacBid(Integer projectId){
		try{
			List<EbpPackage> epList = new ArrayList<EbpPackage>();
			String sql=null;
			Map<String, Object> map = new HashMap<String, Object>();
			sql="from EbpPackage d where d.projectId=:projectId";
			map.put("projectId", projectId);
			epList = tableDao.querydata(sql, true, 0, 50, map);
			EbpPackageVo epv;
			for(int i=0;i<epList.size();i++){
				epv=new EbpPackageVo(epList.get(i));
				epv.setIsOpenBid("1");
				this.modifyEbpPackage(epv);							
			}
			System.out.println("设置完成");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 根据包ID设置该标状态为不开标
	 * @author czg
	 * @param  packageId 文件对应的包ID
	 * @return 设置成功返回true，否则返回false
	 * date 2014-8-21  已测试
	 */
	public boolean noOpenBid(Integer packageId){
		try{
			SupProjectSupplierService supProjectSupplierService=new SupProjectSupplierService();
			supProjectSupplierService.setTableDao(tableDao);
			Integer count=supProjectSupplierService.getSupNum(packageId);
			EbpPackageVo epv=this.getEbpPackagebyId(packageId);		
			Calendar c=Calendar.getInstance();//获得系统当前日期			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(count<3){
				epv.setIsOpenBid("0");
				epv.setUpdateTime(sdf.format(c.getTime()));
				this.modifyEbpPackage(epv);
				return true;
			}
			else{
				System.out.println("投标供应商不少于3家，不能进行此项设置");
				return false;
			}			
			         
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	//标下分包
	public boolean dividePackageInObject(Integer projectId,Integer objectId, Integer num){
		EbpObjectService ebpObjectService = new EbpObjectService();
		ebpObjectService.setTableDao(tableDao);
		EbpObjectVo ebpObjectVo = ebpObjectService.getEbpObjectbyId(objectId);
		
		Calendar c=Calendar.getInstance();//获得系统当前日期
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try{
			for(int i = 0; i<num; i++){
				EbpPackageVo ebpPackageVo = new EbpPackageVo();
				
				ebpPackageVo.setIsValid("1");//默认设为1
				ebpPackageVo.setProjectId(projectId);
				ebpPackageVo.setObjectId(objectId);
				ebpPackageVo.setUpdateTime(sdf.format(c.getTime()));
				int ebpPackageId = this.insertEbpPackage(ebpPackageVo);
				ebpPackageVo = this.getEbpPackagebyId(ebpPackageId);
				ebpPackageVo.setPackageName("分包"+ebpPackageVo.getDispIndex());
				this.modifyEbpPackage(ebpPackageVo);
				ebpPackageVo = null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 通过标id来获取相应标id下所有的包
	 * @param ebpObjectId
	 * @return 2014-8-14 下午02:46:22 测试通过
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbpPackageVo> getEbpPackagebyObjectId(Integer ebpObjectId,Integer pageindex, Integer pagesize){
		
		List<EbpPackageVo> list= new ArrayList<EbpPackageVo>();
		String sql = "FROM  EbpPackage d where '1' = '1' and objectId=:objectId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("objectId", ebpObjectId);
		try {
			List<EbpPackage> ebpPackageList =tableDao.querydata(sql, true, pageindex, pagesize, map);
			if(ebpPackageList != null && ebpPackageList.size() > 0){
				for(int i = 0 ; i < ebpPackageList.size() ; i++){
					EbpPackageVo epv = new EbpPackageVo(ebpPackageList.get(i));//PO -> VO
					list.add(epv);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		PageInfo<EbpPackageVo> pif = new PageInfo<EbpPackageVo>(list,this.getEbpPackageCountbyObjectId(ebpObjectId, pageindex, pagesize),pageindex,pagesize);
		return pif;
	}
	/**
	 * 通过标id来获取相应标id下所有的包
	 * @param ebpObjectId
	 * @return 2014-8-14 下午02:46:22 测试通过
	 */
	@SuppressWarnings("unchecked")
	public List<EbpPackageVo> getEbpPackagevobyObjectId(Integer ebpObjectId){
		
		List<EbpPackageVo> list= new ArrayList<EbpPackageVo>();
		String sql = "FROM  EbpPackage d where '1' = '1' and objectId=:objectId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("objectId", ebpObjectId);
		try {
			List<EbpPackage> ebpPackageList =tableDao.otherQuery(sql, true, true, map);
			if(ebpPackageList != null && ebpPackageList.size() > 0){
				for(int i = 0 ; i < ebpPackageList.size() ; i++){
					EbpPackageVo epv = new EbpPackageVo(ebpPackageList.get(i));//PO -> VO
					list.add(epv);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 取得projctid下的包的数目
	 * @param ebpProjectId
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Integer getEbpPackageCountbyProjectId(Integer ebpProjectId, Integer pageindex, Integer pagesize){
		Integer count = 0;//记录总数
		String sql = null;
		sql="SELECT COUNT(d.id) FROM EbpPackage d "+"where '1'='1' and projectId=:ebpProjectId";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ebpProjectId", ebpProjectId);
		try {
			List<EbpPackage> list = tableDao.otherQuery(sql, true, true, param);
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
	 * 标下的包的记录数
	 * @param ebpProjectId
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Integer getEbpPackageCountbyObjectId(Integer ebpObjectId, Integer pageindex, Integer pagesize){
		Integer count = 0;//记录总数
		String sql = null;
		sql="SELECT COUNT(d.id) FROM EbpPackage d "+"where '1'='1' and objectId=:objectId";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("objectId", ebpObjectId);
		try {
			List<EbpPackage> list = tableDao.otherQuery(sql, true, true, param);
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
	 * 查询project下的所有包
	 * @param ebpProjectId
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbpPackageVo> getEbpPackagebyProjectId(Integer ebpProjectId, Integer pageindex, Integer pagesize){
		List<EbpPackageVo> list= new ArrayList<EbpPackageVo>();
		String sql = "FROM  EbpPackage d where '1' = '1' and projectId=:projectId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("projectId", ebpProjectId);
		try {
			List<EbpPackage> ebpPackageList =tableDao.querydata(sql, true, pageindex, pagesize, map);
			if(ebpPackageList != null && ebpPackageList.size() > 0){
				for(int i = 0 ; i < ebpPackageList.size() ; i++){
					EbpPackageVo epv = new EbpPackageVo(ebpPackageList.get(i));//PO -> VO
					list.add(epv);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		PageInfo<EbpPackageVo> pif = new PageInfo<EbpPackageVo>(list,this.getEbpPackageCountbyProjectId(ebpProjectId, pageindex, pagesize),pageindex,pagesize);
		return pif;
	}
	/**
	 * 查询project下的所有包
	 * @param ebpProjectId
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<EbpPackageVo> getEbpPackageListbyProjectId(Integer ebpProjectId){
		List<EbpPackageVo> list= new ArrayList<EbpPackageVo>();
		String sql = "FROM  EbpPackage d where '1' = '1' and projectId=:projectId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("projectId", ebpProjectId);
		try {
			List<EbpPackage> ebpPackageList =tableDao.otherQuery(sql, true, true, map);
			if(ebpPackageList != null && ebpPackageList.size() > 0){
				for(int i = 0 ; i < ebpPackageList.size() ; i++){
					EbpPackageVo epv = new EbpPackageVo(ebpPackageList.get(i));//PO -> VO
					list.add(epv);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 项目下分包
	 * @param projectId
	 * @param num
	 * @return
	 * @author gr
	 */
	public boolean dividePackage(Integer projectId, int num){
		ITableDao td = new TableDao();
		EbpProjectService ebpProjectService = new EbpProjectService();
		ebpProjectService.setTableDao(td);
		EbpProjectVo ebpProjectVo = ebpProjectService.getEbpProjectbyId(projectId);
		
		EbpPackageService ebpPackageService = new EbpPackageService();
		ebpPackageService.setTableDao(td);
		Calendar c=Calendar.getInstance();//获得系统当前日期
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try{
			for(int i = 0; i<num; i++){
				EbpPackageVo ebpPackageVo = new EbpPackageVo();
				ebpPackageVo.setIsValid("1");//默认设为1
				String projectName = ebpProjectVo.getProjectName();
				if(ebpProjectVo.getProjectName()!=null&&projectName.length()>0){
					ebpPackageVo.setPackageName(projectName+i);
				}
				ebpPackageVo.setProjectId(projectId);
				ebpPackageVo.setUpdateTime(sdf.format(c.getTime()));
				int ebpPackageId = ebpPackageService.insertEbpPackage(ebpPackageVo);
				ebpPackageVo = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 批量删除分包
	 *@author gr
	 *@date 2014-8-14 下午03:45:24 测试成功
	 */
	public boolean deleteEbpPackageBatch(String packageId){
		String[] list = packageId.split(",");
		try{
			for(int i = 0; i<list.length;i++){
				tableDao.delete(Integer.parseInt(list[i]), EbpPackage.class);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 通过objectid号来删除与之相关的所有分包
	 * 即删除标下所有分包
	 * @param ebpObjectId
	 * @return
	 * @author gr
	 * @date 2014-8-14 下午02:54:41 测试通过
	 */
	public boolean deleteEbpPackagebyObjectId(Integer ebpObjectId){
		String sql = "delete from EbpPackage where objectId=:objectId";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("objectId", ebpObjectId);
		try{
			tableDao.otherQuery(sql, true, false, map);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 删除项目下所有分包
	 *@author gr
	 *@date 2014-8-14 下午03:49:51 测试通过
	 */
	public boolean deleteEbpPackagebyProjectId(Integer ebpProjectId){
		String sql = "delete from EbpPackage where projectId=:projectId";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("projectId", ebpProjectId);
		try{
			tableDao.otherQuery(sql, true, false, map);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 根据主键ID,获得数据总数
	 * @return 查询到的数据总数，若失败，返回-1
	 */
	@SuppressWarnings("unchecked")
	public Integer getCount() {
		Integer count = 0;//记录总数
		String sql = null;
		sql="SELECT COUNT(d.id) FROM EbpPackage d "+"where '1'='1'";
		try {
			List<EbpPackage> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbpPackageVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbpPackageVo> querydata(int pageindex, int pagesize) {
		List<EbpPackageVo> ebpPackageVoList = new ArrayList<EbpPackageVo>(); //VO集合
		String sql = "from EbpPackage";
		int count = 0;
		try {
			List<EbpPackage> ebpPackageList =tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebpPackageList != null && ebpPackageList.size() > 0){
				for(int i = 0 ; i < ebpPackageList.size() ; i++){
					EbpPackageVo epv = new EbpPackageVo(ebpPackageList.get(i));//PO -> VO
					ebpPackageVoList.add(epv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EbpPackageVo>(ebpPackageVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据招标项目划分包的ID查找招标项目划分包
	 * @param  ebpPackageId 要查询的招标项目划分包ID值
	 * @return 查询到的EbpPackage实例
	 */
	public EbpPackageVo getEbpPackagebyId(Integer ebpPackageId) {
		EbpPackageVo ebpPackageVo=null;
		try {
			ebpPackage = (EbpPackage)tableDao.getEntitybyId(ebpPackageId, EbpPackage.class);
			if(ebpPackage!=null && !(ebpPackage.equals(""))){
				ebpPackageVo = new EbpPackageVo(ebpPackage);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebpPackageVo;
	}
	/**
	 * 修改招标项目划分包实例
	 * @param  ebpPackage 要修改的招标项目划分包
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbpPackage(EbpPackageVo ebpPackageVo) {
		try {
			boolean result = tableDao.update(ebpPackageVo.adapterToEbpPackage());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据招标项目划分包的ID删除招标项目划分包
	 * @param  ebpPackageId 要删除的招标项目划分包ID值
	 * @return 删除成功， 返回 true，若失败，返回 false
	 */
	public boolean deleteEbpPackagebyId(Integer ebpPackageId) {
		try {
			tableDao.delete(ebpPackageId, EbpPackage.class);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 新增一个招标项目划分包
	 * @param ebpPackageVo 要添加的EbpPackageVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbpPackage(EbpPackageVo ebpPackageVo) {
		try {
			EbpPackage ep = ebpPackageVo.adapterToEbpPackage();
			Integer ebpPackageId = tableDao.insert(ep);
			ep.setId(ebpPackageId);
			ep.setDispIndex(ebpPackageId);
			tableDao.update(ep);
			return ebpPackageId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbpPackage(EbpPackage ebpPackage) {
		this.ebpPackage=ebpPackage;
	}
	
	public void setTableDao(ITableDao tableDao) {
		this.tableDao=tableDao;
	}
	
	
	/**
	 * 修改权重
	 * @param id 包信息的主键id
	 * @param tech 技术权重值
	 * @param busi 商业权重值
	 * @param price 价格权重值
	 * @author hgl
	 * @return 成功返回true，失败返回false
	 * 2014/08/15
	 */
	public Boolean changeWeight(Integer id, Integer tech, Integer busi, Integer price){
		setTableDao(new TableDao());
		EbpPackageVo ebpPackageVo= getEbpPackagebyId(id);
		ebpPackageVo.setBusinessWeight(busi);
		ebpPackageVo.setTechnicalWeight(tech);
		ebpPackageVo.setPriceWeight(price);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		ebpPackageVo.setUpdateTime(df.format(new Date()));
		if(modifyEbpPackage(ebpPackageVo) == false){
			return false;
		}
		return true;
	}

	public EbpPackage getEbpPackage() {
		return ebpPackage;
	}

	public ITableDao getTableDao() {
		return tableDao;
	}


}
