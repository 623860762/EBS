package com.ceit.ebs.ebp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.ebs.ebp.entity.EbpProject;
import com.ceit.ebs.ebp.service.IEbpProjectService;
import com.ceit.ebs.ebp.vo.EbpProjectVo;

public class EbpProjectService implements IEbpProjectService {

	private EbpProject ebpProject;
	private ITableDao tableDao;

	public EbpProjectService(){
		
	}

	/**
	 * @param projectid: 项目id号
	 * @param bigStatus: 下一步的大状态
	 * @param smallStatus: 下一步的小状态
	 * @author gr
	 * 2014-08-14 20:21:58 测试通过
	 */
	public boolean statusTransformed(Integer projectId, String bigStatus, String smallStatus){
		try{
			EbpProjectVo ebpProjectVo = this.getEbpProjectbyId(projectId);
			ebpProjectVo.setProjectStatus(bigStatus);
			ebpProjectVo.setSmallStatus(smallStatus);
			boolean result = this.modifyEbpProject(ebpProjectVo);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 通过状态获取页面显示的数据
	 * @param userId:用户ID
	 * @param bigStatus：大状态
	 * @param smallStatus小状态
	 * @param currentPageNumber：当前页码
	 * @param perPageCount：每页显示条数
	 * @return 页面显示内容
	 * @author gr  2014-08-14 21:32:12
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbpProjectVo>  getProjectByStatus(String userId, String bigStatus, String smallStatus, Integer currentPageNumber, Integer perPageCount){
		PageInfo<EbpProjectVo> pif = null;
		String sql = "From EbpProject where userId=:userId and projectStatus=:bigStatus and smallStatus=:smallStatus";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userId", userId);
		param.put("bigStatus", bigStatus);
		param.put("smallStatus", smallStatus);
		try{
			List<EbpProject> list = tableDao.otherQuery(sql, true, true, param);
			List<EbpProjectVo> listVo = new ArrayList<EbpProjectVo>();
			for(int i = 0; i<list.size();i++){
				EbpProjectVo epv = new EbpProjectVo(list.get(i));
				listVo.add(epv);
			}
			pif = new PageInfo<EbpProjectVo>(listVo, this.countProjectByStatus(userId, bigStatus, smallStatus), currentPageNumber, perPageCount);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pif;
	}
	/**
	 * 跟据用户id,大状态，小状态获取满足条件的project个数
	 * @param userId:用户Id
	 * @param bigStatus：大状态
	 * @param smallStatus：小状态
	 * @return project个数
	 * gr 2014-08-14 21:12:49  测试通过
	 */
	@SuppressWarnings("unchecked")
	public Integer countProjectByStatus(String userId, String bigStatus, String smallStatus){
		String sql = "Select count(id) From EbpProject where userId=:userId and projectStatus=:bigStatus and smallStatus=:smallStatus";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userId", userId);
		param.put("bigStatus", bigStatus);
		param.put("smallStatus", smallStatus);
		try{
			List<Integer> list = tableDao.otherQuery(sql, true, true, param);
			Number num = (Number)list.get(0);
			return num.intValue();
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * 获取要分包的项目
	 * @param isObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EbpProjectVo> getEbpProjectVobyIsObject(String isObject, Integer currentPageNumber, Integer perPageCount){
		
		PageInfo<EbpProjectVo> pif = null;
		String sql = "From EbpProject where isObject=:isObject";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("isObject", isObject);
		try{
			List<EbpProject> list = tableDao.otherQuery(sql, true, true, param);
			List<EbpProjectVo> listVo = new ArrayList<EbpProjectVo>();
			for(int i = 0; i<list.size();i++){
				EbpProjectVo epv = new EbpProjectVo(list.get(i));
				listVo.add(epv);
			}
			pif = new PageInfo<EbpProjectVo>(listVo, this.countProjectByIsObject(isObject), currentPageNumber, perPageCount);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pif;
	}
	/**
	 * @param bigstatus
	 * @param smallstatus
	 * @return
	 */
	public Integer getEbpProjectcountVobyStatus(String bigstatus, String smallstatus){
		String sql = "Select count(id) From EbpProject where projectStatus=:bigstatus and smallStatus=:smallstatus";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("bigstatus", bigstatus);
		param.put("smallstatus", smallstatus);
		try{
			List<Integer> list = tableDao.otherQuery(sql, true, true, param);
			Number num = (Number)list.get(0);
			return num.intValue();
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * 获取审核状态下的数据
	 * @param bigstatus
	 * @param smallstatus
	 * @param currentPageNumber
	 * @param perPageCount
	 * @return
	 */
	public PageInfo<EbpProjectVo> getSHEbpProjectVo(Integer currentPageNumber, Integer perPageCount){
		
		PageInfo<EbpProjectVo> pif = null;
		String sql = "From EbpProject where projectStatus=:bigstatus and smallStatus in ('SH','ZB')";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("bigstatus", "EDIT");
		try{
			List<EbpProject> list = tableDao.otherQuery(sql, true, true, param);
			List<EbpProjectVo> listVo = new ArrayList<EbpProjectVo>();
			for(int i = 0; i<list.size();i++){
				EbpProjectVo epv = new EbpProjectVo(list.get(i));
				listVo.add(epv);
			}
			Integer count = this.getEbpProjectcountVobyStatus("EDIT", "ZB")+this.getEbpProjectcountVobyStatus("EDIT", "SH");
			pif = new PageInfo<EbpProjectVo>(listVo, count, currentPageNumber, perPageCount);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pif;
	}
	public boolean returnToLXProject(Integer projectid){
		boolean result = false;
		try {
			EbpProjectVo ebpProjectVo = this.getEbpProjectbyId(projectid);
			ebpProjectVo.setProjectAuditStatus("");
			ebpProjectVo.setSmallStatus("LX");
			result = this.modifyEbpProject(ebpProjectVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 获取满足大状态小状态 的记录
	 */
	public PageInfo<EbpProjectVo> getEbpProjectVobyStatus(String bigstatus, String smallstatus, Integer currentPageNumber, Integer perPageCount){
		
		PageInfo<EbpProjectVo> pif = null;
		String sql = "From EbpProject where projectStatus=:bigstatus and smallStatus=:smallstatus";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("bigstatus", bigstatus);
		param.put("smallstatus", smallstatus);
		try{
			List<EbpProject> list = tableDao.otherQuery(sql, true, true, param);
			List<EbpProjectVo> listVo = new ArrayList<EbpProjectVo>();
			for(int i = 0; i<list.size();i++){
				EbpProjectVo epv = new EbpProjectVo(list.get(i));
				listVo.add(epv);
			}
			pif = new PageInfo<EbpProjectVo>(listVo, this.getEbpProjectcountVobyStatus(bigstatus, smallstatus), currentPageNumber, perPageCount);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pif;
	}
	/**
	 * 获取要分包的项目的总条数
	 * @param isObject
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public Integer countProjectByIsObject(String isObject){
		
		String sql = "Select count(id) From EbpProject where isObject=:isObject";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("isObject", isObject);
		try{
			List list = tableDao.otherQuery(sql, true, true, param);
			Number num = (Number)list.get(0);
			return num.intValue();
			
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}


	/**
	 * 开标
	 * @author czg
	 * @param  projectId 项目ID
	 * @return 已到开标时间，状态转为开标，返回true,未到开标时间false
	 * date 2014-8-21  已测试
	 */
	public Boolean openProBid(Integer projectId){
		Boolean flag = true;//标识当前时间是否到了开标时间
		try{
			EbpProjectVo epv = this.getEbpProjectbyId(projectId);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date open = df.parse(ebpProject.getOpenBidTime());
			Date now =df.parse(getTime());
			flag = now.before(open);
			if(flag){
				System.out.println("未到开标时间");
				return false;				
			}
			else{//到了开标时间，转换项目状态
				this.statusTransformed(projectId, "正在开标", "");
				//把标下所有包设为开标
				EbpPackageService eps = new EbpPackageService();
				eps.setTableDao(tableDao);
				eps.openPacBid(projectId);
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 唱标
	 * @author czg
	 * @param  projectId 项目ID
	 * @return 已到唱标时间，状态转为唱标，返回true,未到唱标时间false
	 * date 2014-8-20  已测试
	 */
	public Boolean singBid(Integer projectId){
		Boolean flag = true;//标识当前时间是否到了唱标时间
		try{
			EbpProjectVo epv = this.getEbpProjectbyId(projectId);
			System.out.println(epv.getProjectId());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(ebpProject.getSingBidTime());
			Date sing = df.parse(ebpProject.getSingBidTime());
			System.out.println(getTime());
			Date now =df.parse(getTime());
			flag = now.before(sing);
			if(flag){
				System.out.println("未到唱标时间");
				return false;				
			}
			else{//到了唱标时间，转换项目状态
				this.statusTransformed(projectId, "正在唱标", "");
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 通过id获取项目视图对象
	 * @author gr
	 */
	public EbpProjectVo getEbpProjectbyId(int id){
		try {
			ebpProject = (EbpProject)(tableDao.getEntitybyId(id, EbpProject.class));
			EbpProjectVo ebpProjectVo = new EbpProjectVo(ebpProject);
			return ebpProjectVo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	/**
	 * 修改项目
	 * @author gr
	 */
	public boolean modifyEbpProject(EbpProjectVo s){
		try {
			tableDao.update(s.adapterToEbpProject());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 根据id删除项目
	 * @author gr
	 */
	public boolean deleteEbpProjectbyId(Integer id){
		try{
			tableDao.delete(id,EbpProject.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * 插入一条记录
	 * @author gr
	 */
	public Integer insertEbpProject(EbpProjectVo ebpProjectVo){
		try {
			EbpProject sr = ebpProjectVo.adapterToEbpProject();
			Integer ebpProjectId = tableDao.insert(sr);
			sr.setId(ebpProjectId);
			sr.setDispIndex(ebpProjectId);
			tableDao.update(sr);
			return ebpProjectId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setEbpProject(EbpProject ebpProject) {
		this.ebpProject = ebpProject;
	}

	
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
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
		sql = "SELECT  COUNT(d.id) FROM  EbpProject d " +
		"where '1' = '1' ";
		try {
			List<EbpProject> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EbpProjectVo实例的List，若失败，返回null
	 */
	
	@SuppressWarnings("unchecked")
	public PageInfo<EbpProjectVo> querydata(int pageindex, int pagesize) {
		List<EbpProjectVo> ebpProjectVoList = new ArrayList<EbpProjectVo>(); //VO集合
		int count = 0;
		String sql = " FROM  EbpProject d where '1' = '1'  ";
		try {
			List<EbpProject> ebpProjectList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(ebpProjectList != null && ebpProjectList.size() > 0){
				for(int i = 0 ; i < ebpProjectList.size() ; i++){
					EbpProjectVo srv = new EbpProjectVo(ebpProjectList.get(i));//PO -> VO
					ebpProjectVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EbpProjectVo>(ebpProjectVoList,count,pageindex,pagesize);
	}
	
	
	/**
	 * 获取系统时间
	 * @author cag
	 * @return 返回时间字符串
	 * date 2014-8-17  已测试
	 */
	public String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}


	/**
	 * 手动截标
	 * @author czg
	 * @param  projectId 项目ID
	 * @return 已经到截标时间并且截标成功返回true,未到截标时间false
	 * date 2014-8-20  已测试
	 */
	public Boolean closeBidByHand(Integer projectId) {
		// TODO Auto-generated method stub
		Boolean flag = true;//标识当前时间是否到了截标时
		try{
			ebpProject = (this.getEbpProjectbyId(projectId)).adapterToEbpProject();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date close = df.parse(ebpProject.getCloseBidTime());
			Date now =df.parse(getTime());
			flag = now.before(close);
			if(flag){
				System.out.println("未到截标时间");
				return false;				
			}
			else{//到了截标时间，转换项目状态
				this.statusTransformed(projectId, "正在开标", "已经截标");
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}


}