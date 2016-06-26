package com.ceit.ebs.ebp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.entity.EbpObject;
import com.ceit.ebs.ebp.service.IEbpObjectService;
import com.ceit.ebs.ebp.vo.EbpObjectVo;
import com.ceit.ebs.ebp.vo.EbpPackageVo;

public class EbpObjectService implements IEbpObjectService {
	private EbpObject ebpObject;
	private ITableDao tableDao;

	public EbpObjectService(){
		
	}
	
	/**
	 * 项目下分标
	 * @param projectId 项目id
	 * @param num 分标的个数
	 * divideObject: 根据项目号，把项目分成相应数目的标
	 */
	/**
	 *@author gr
	 *@date 2014-8-14 下午02:08:25
	 *测试完成
	 */
	public boolean divideObject(Integer projectId, Integer num){
		EbpProjectService ebpProjectService = new EbpProjectService();
		ebpProjectService.setTableDao(tableDao);
		
		Calendar c=Calendar.getInstance();//获得系统当前日期
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try{
			for(int i = 0; i<num; i++){
				EbpObjectVo ebpObjectVo = new EbpObjectVo();
				ebpObjectVo.setIsValid("Y");//默认设为1
				ebpObjectVo.setProjectId(projectId);
				ebpObjectVo.setUpdateTime(sdf.format(c.getTime()));
				int ebpObjectId = this.insertEbpObject(ebpObjectVo);
				ebpObjectVo = this.getEbpObjectbyId(ebpObjectId);
				ebpObjectVo.setObjectName("分标"+ebpObjectVo.getDispIndex());
				boolean result = this.modifyEbpObject(ebpObjectVo);
				ebpObjectVo = null;
			}
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
		sql="SELECT COUNT(d.id) FROM EbpObject d "+"where '1'='1'";
		try {
			List<EbpObject> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbpObjectVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbpObjectVo> queryData(int pageindex, int pagesize) {
		List<EbpObjectVo> ebpObjectVoList = new ArrayList<EbpObjectVo>(); //VO集合
		String sql = " FROM  EbpObject d where '1' = '1'  ";
		int count = 0;
		try {
			List<EbpObject> ebpObjectList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebpObjectList != null && ebpObjectList.size() > 0){
				for(int i = 0 ; i < ebpObjectList.size() ; i++){
					EbpObjectVo eov = new EbpObjectVo(ebpObjectList.get(i));//PO -> VO
					ebpObjectVoList.add(eov);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EbpObjectVo>(ebpObjectVoList,count,pageindex,pagesize);
	}
	/**
	 * 根据包ID查找项目下的分标
	 * @param  ebpObjectId 要查询的项目下的分标ID值
	 * @return 查询到的EbpObject实例
	 */
	public EbpObjectVo getEbpObjectbyId(Integer ebpObjectId) {
		EbpObjectVo ebpObjectVo=null;
		try {
			ebpObject = (EbpObject)tableDao.getEntitybyId(ebpObjectId, EbpObject.class);
			if(ebpObject!=null && !(ebpObject.equals(""))){
				ebpObjectVo=new EbpObjectVo(ebpObject);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ebpObjectVo;	
	}
	
	@SuppressWarnings("unchecked")
	public Integer getEbpObjectNumbyProjectId(Integer ebpProjectId, Integer currentPageNumber, Integer perPageCount){
		Integer count = 0;//记录总数
		String sql = null;
		sql="SELECT COUNT(d.id) FROM EbpObject d "+"where '1'='1' and projectId=:ebpProjectId";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ebpProjectId", ebpProjectId);
		try {
			List<EbpObject> list = tableDao.otherQuery(sql, true, true, param);
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
	 * 根据包ID查找项目下的分标
	 * @param  ebpProjectId 要查询的项目Id
	 * @return 查询到的EbpObject实例
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbpObjectVo> getEbpObjectbyProjectId(Integer ebpProjectId, Integer currentPageNumber, Integer perPageCount) {
		PageInfo<EbpObjectVo> pif = null;
		String sql = "From EbpObject where projectId=:ebpProjectId";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ebpProjectId", ebpProjectId);
		try{
			List<EbpObject> list = tableDao.querydata(sql, true, currentPageNumber, perPageCount, param);
			List<EbpObjectVo> listVo = new ArrayList<EbpObjectVo>();
			for(int i = 0; i<list.size();i++){
				EbpObjectVo epv = new EbpObjectVo(list.get(i));
				listVo.add(epv);
			}
			pif = new PageInfo<EbpObjectVo>(listVo, this.getEbpObjectNumbyProjectId(ebpProjectId, currentPageNumber, perPageCount), currentPageNumber, perPageCount);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pif;
	}
	/**
	 * 根据包ID查找项目下的分标，用于树结构
	 * @param  ebpProjectId 要查询的项目Id
	 * @return 查询到的EbpObject实例
	 */
	@SuppressWarnings("unchecked")
	public List<EbpObjectVo> getEbpObjectListbyProjectId(Integer ebpProjectId) {
		List<EbpObjectVo> listVo = new ArrayList<EbpObjectVo>();
		String sql = "From EbpObject where projectId=:ebpProjectId";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ebpProjectId", ebpProjectId);
		try{
			List<EbpObject> list = tableDao.otherQuery(sql, true, true, param);
			for(int i = 0; i<list.size();i++){
				EbpObjectVo epv = new EbpObjectVo(list.get(i));
				listVo.add(epv);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return listVo;
	}
	/**
	 * 修改项目下的分标实例
	 * @param  ebpObject 要修改的项目下的分标
	 * @return 修改成功，返回 true，若失败，返回 false
	 */
	public boolean modifyEbpObject(EbpObjectVo ebpObjectVo) {
		try {
			tableDao.update(ebpObjectVo.adapterToEbpObject());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 根据项目下分标的ID删除项目下分标
	 * @param  ebpObjectId 要删除的项目下分标ID值，
	 * 除删除项目下的分票ID值，要首先删除标下分包
	 * @return 删除成功， 返回 true，若失败，返回 false
	 * @author gr
	 * @date 2014-8-14 下午02:59:46     测试成功
	 */
	public boolean deleteEbpObjectbyId(Integer ebpObjectId) {

		EbpPackageService ebpPackageService = new EbpPackageService();
		ebpPackageService.setTableDao(tableDao);
		List<EbpPackageVo> ebpPackageVolist = new ArrayList<EbpPackageVo>();
		
		try {
			ebpPackageVolist = ebpPackageService.getEbpPackagevobyObjectId(ebpObjectId);
			if(ebpPackageVolist.size()>0){
				boolean okornot = ebpPackageService.deleteEbpPackagebyObjectId(ebpObjectId);
				if(okornot){
					tableDao.delete(ebpObjectId, EbpObject.class);
					return true;
				}
			}else{
				tableDao.delete(ebpObjectId, EbpObject.class);
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 批量删除分标
	 *@author gr
	 *@date 2014-8-14 下午03:45:24 测试成功
	 */
	public boolean deleteEbpObjectBatch(String objectId){
		String[] list = objectId.split(",");
		try{
			for(int i = 0; i<list.length;i++){
				tableDao.delete(Integer.parseInt(list[i]), EbpObject.class);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 删除项目下所有分标
	 * @param projectId
	 * @return
	 * @author gr
	 * @date 2014-8-14 下午03:09:19 测试成功
	 */
	public boolean deleteObjectbyProjectId(Integer projectId){
		String sql = "delete from EbpObject where projectId=:projectId";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("projectId", projectId);
		try{
			tableDao.otherQuery(sql, true, false, map);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 新增一个项目下的分标
	 * @param ebpObjectVo 要添加的EbpObjectVo实例
	 * @return 添加的招标项目划分包在数据库中的ID值，若失败返回-1
	 */
	public Integer insertEbpObject(EbpObjectVo ebpObjectVo) {
		try {
			EbpObject eo = ebpObjectVo.adapterToEbpObject();
			Integer ebpObjectId = tableDao.insert(eo);
			eo.setId(ebpObjectId);
			eo.setDispIndex(ebpObjectId);
			tableDao.update(eo);
			return ebpObjectId;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void setEbpObject(EbpObject ebpObject) {
		this.ebpObject=ebpObject;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao=tableDao;
	}

}
