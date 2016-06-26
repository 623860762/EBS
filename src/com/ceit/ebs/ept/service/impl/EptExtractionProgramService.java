package com.ceit.ebs.ept.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;
import com.ceit.common.util.StringUtil;
import com.ceit.ebs.ebe.entity.EbeExpertGroup;
import com.ceit.ebs.ebp.entity.EbpProject;
import com.ceit.ebs.ept.entity.EptExpertBaseinfo;
import com.ceit.ebs.ept.entity.EptExtractionNameList;
import com.ceit.ebs.ept.entity.EptExtractionProgram;
import com.ceit.ebs.ept.entity.EptSpecialty;
import com.ceit.ebs.ept.service.IEptExtractionProgramService;
import com.ceit.ebs.ept.vo.EptExtractionProgramVo;


public class EptExtractionProgramService implements IEptExtractionProgramService {

	// Fields
	static Logger logger = Logger.getLogger(EptSpecialtyService.class.getName());
	private EptExtractionProgram eptExtractionProgram;
	private ITableDao tableDao;

	// Constructors

	
	
	public EptExtractionProgramService() {
	}

	public EptExtractionProgram getEptExtractionProgrambyId(int id){
		
		try {
			eptExtractionProgram = (EptExtractionProgram)(tableDao.getEntitybyId(id, EptExtractionProgram.class));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.toString());
		}
		return eptExtractionProgram;
	}
	
	public boolean modifyEptExtractionProgram(EptExtractionProgramVo s){
		try {
			tableDao.update(s.adapterToEptExtractionProgram());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEptExtractionProgrambyId(Integer id){
		try{
			tableDao.delete(id,EptExtractionProgram.class);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Integer insertEptExtractionProgram(EptExtractionProgramVo eptExtractionProgramVo){
		try {
			EptExtractionProgram sr = eptExtractionProgramVo.adapterToEptExtractionProgram();
			Integer eptExtractionProgramId = tableDao.insert(sr);
			sr.setId(eptExtractionProgramId);
			sr.setDispIndex(eptExtractionProgramId);
			tableDao.update(sr);
			return eptExtractionProgramId;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	public void setEptExtractionProgram(EptExtractionProgram eptExtractionProgram) {
		this.eptExtractionProgram = eptExtractionProgram;
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
		//Map<String,Object> map = new HashMap<String,Object>();
		sql = "SELECT  COUNT(d.id) FROM  EptExtractionProgram d " +
		"where '1' = '1' ";
		//sql += " order by p.dispindex desc ";
		try {
			List<EptExtractionProgram> list = tableDao.otherQuery(sql, true, true, null);
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
	 * @return 包含查询到的所有EptExtractionProgramVo实例的List，若失败，返回null
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<EptExtractionProgramVo> querydata(int pageindex, int pagesize) {
		List<EptExtractionProgramVo> eptExtractionProgramVoList = new ArrayList<EptExtractionProgramVo>(); //VO集合
		int count =0;
		//Map<String,Object> map = new HashMap<String,Object>();
		String sql = " FROM  EptExtractionProgram d where '1' = '1'  ";
		//sql += " order by d.dispindex desc "; 
		try {
			//PO集合
			List<EptExtractionProgram> eptExtractionProgramList = tableDao.querydata(sql, true, pageindex, pagesize, null);
			if(eptExtractionProgramList != null && eptExtractionProgramList.size() > 0){
				for(int i = 0 ; i < eptExtractionProgramList.size() ; i++){
					EptExtractionProgramVo srv = new EptExtractionProgramVo(eptExtractionProgramList.get(i));//PO -> VO
					eptExtractionProgramVoList.add(srv);
				}
			}
			count = this.getCount();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new PageInfo<EptExtractionProgramVo>(eptExtractionProgramVoList,count,pageindex,pagesize);
	}
	/**
	 * 
	 * @Title: countProgramByProjectId
	 * @Description: 项目下抽取方案的数目
	 * @param @param projectId
	 * @param @return    
	 * @return Integer 
	 * @author ly
	 * @date 2014-8-22 下午03:36:12
	 * @throws
	 */
	public Integer countProgramByProjectId(Integer projectId){
		String sql = "Select count(id) From EptExtractionProgram where projectId=:projectId";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("projectId", projectId);
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
	 * 
	 * @Title: getProgramByProjectId
	 * @Description: 项目下抽取方案分页
	 * @param @param projectId
	 * @param @param currentPageNumber
	 * @param @param perPageCount
	 * @param @return    
	 * @return PageInfo<EptExtractionProgramVo> 
	 * @author ly
	 * @date 2014-8-22 下午04:14:35
	 * @throws
	 */
	public PageInfo<EptExtractionProgramVo>  getProgramByProjectId(Integer projectId, Integer currentPageNumber, Integer perPageCount){
		PageInfo<EptExtractionProgramVo> pif = null;
		String sql = "From EptExtractionProgram where projectId=:projectId";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("projectId", projectId);
		try{
			List<EptExtractionProgram> list = tableDao.querydata(sql, true, currentPageNumber, perPageCount, param);
			List<EptExtractionProgramVo> listVo = new ArrayList<EptExtractionProgramVo>();
			for(int i = 0; i<list.size();i++){
				EptExtractionProgramVo epv = new EptExtractionProgramVo(list.get(i));
				listVo.add(epv);
			}
			pif = new PageInfo<EptExtractionProgramVo>(listVo, this.countProgramByProjectId(projectId), currentPageNumber, perPageCount);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pif;
	}
	
	/**
	 * 
	 * @Title: getExtractionNameList
	 * @Description: 获得抽取专家列表
	 * @param EbpProject project,EptExtractionProgram program
	 * @return List<EptExtractionNameList>    返回类型
	 * @throws
	 */
//	public List<EptExtractionNameList> getExtractionNameList(EbpProject project,EptExtractionProgram program){
//		List<EptExtractionNameList> extractionNameList = new ArrayList<EptExtractionNameList>();
//		if(null == program){
//			return extractionNameList;
//		}
//		StringBuffer qSql = new StringBuffer();
//		qSql.append("select * from (");
//		//获取抽取语句
//		getExtractionSql(project, program, qSql);
//		qSql.append(")t where 1=1");
//		
//		//需求人数
//		int needNum = Integer.parseInt(String.valueOf(program.getTotalUserNumber()));
//		//正选人数
//		int gregoryNum = 0;
//		//备选人数
//		int alternativeNum = 0;
//		//获取正备选比例的值
//		if(StringUtil.isNotNull(program.getSelectProportion()) 
//				&& StringUtil.isNotNull(program.getSelectProportion().split(":"))){
//			String[] proportion = program.getSelectProportion().split(":");
//			gregoryNum = Integer.parseInt(proportion[0]);
//			alternativeNum = Integer.parseInt(proportion[1]);
//		}
//		if(gregoryNum==0 || alternativeNum==0){
//			qSql.append(" and t.rn <= ").append(needNum);
//		}else{
//			qSql.append(" and t.rn <= ").append(needNum*(gregoryNum+alternativeNum));
//		}
//		//采用随机排序的方式进行抽取
//		qSql.append(" order by dbms_random.value");
//		
//		//输出sql进行测试
//		System.out.println(qSql);
//		
//		
//		return null;
//	}
//	
	/**
	 * 
	 * @Title: getExtractionSql
	 * @Description: 获取抽取语句信息
	 * @param @param project
	 * @param @param program
	 * @param @param qSql    
	 * @return void    
	 * @throws
	 */
//	public void getExtractionSql(EbpProject project,
//			EptExtractionProgram program, StringBuffer qSql){
//		qSql.append("select distinct exp.id_number,");
//		qSql.append("                exp.expert_name,");
//		qSql.append("                exp.work_units,");
//		qSql.append("                exp.expert_rate,");
//		qSql.append("                exp.cell_phone,");
//		qSql.append("                exp.work_phone,");
//		qSql.append("                exp.specialty_id,");
//		qSql.append("                rownum rn");
//		qSql.append("  from ept_expert_baseinfo exp");
//		qSql.append(" where exp.id_number not in");
//		qSql.append("       (select enl.id_number");
//		qSql.append("          from ept_extraction_name_list enl");
//		qSql.append("          left join ebp_PROJECT ep");
//		qSql.append("            on enl.project_id = ep.project_id");
////		qSql.append("         where ((").append(project.getEvaluationBeginDate());
////		qSql.append(" 			between enl.lock_begin_date and enl.lock_end_date) or");
////		qSql.append("                (").append(project.getEvaluationEndDate());
////		qSql.append("					between enl.lock_begin_date and enl.lock_end_date)or ");
////		qSql.append("                (").append(project.getEvaluationBeginDate()).append("< enl.lock_begin_date and");
////		qSql.append("                 ").append(project.getEvaluationEndDate()).append(" > enl.lock_end_date))");
//		//抽取区域条件
//		if(StringUtil.isNotNull(program.getExtractionArea())){
//			qSql.append("   and exp.work_units in ('").append(program.getExtractionArea().replace(",", "','")).append("')");
//		}
//		
//		//回避区域条件
//		if(StringUtil.isNotNull(program.getOrgAvoid())){
//			qSql.append("   and exp.work_units not in ('").append(program.getOrgAvoid().replace(",", "','")).append("')");
//		}
//		
//		//专家所在地条件
//		if(StringUtil.isNotNull(program.getExpertArea())){
//			qSql.append("   and exp.communication_city in ('").append(program.getExpertArea().replace(",", "','")).append("')");
//		}
//	}
	
	/**
	 * 
	 * @Title: autoExtractExpert
	 * @Description: 自动抽取专家
	 * @param extractionProgramId    
	 * @return void    
	 * @throws
	 */
	public boolean autoExtractExpert(Integer extractionProgramId){
		try {
			EptExtractionProgram program =(EptExtractionProgram)(tableDao.getEntitybyId(extractionProgramId,EptExtractionProgram.class));
			logger.info("EptExtractionProgram创建成功.");
			if(program == null){
				return false;
			}
			EbpProject project =(EbpProject)(tableDao.getEntitybyId(program.getProjectId(),EbpProject.class));
			logger.info("EbpProject创建成功.");
			EbeExpertGroup beExpertGroup ;

			List<EptExtractionNameList> experts = tableDao.getExtractionNameList(project,program);
			for(EptExtractionNameList expert:experts){
				tableDao.insert(expert);
				beExpertGroup = new EbeExpertGroup();
				
				//生成名单的时候同时插入专家与小组关系表(暂定解决方案)
				beExpertGroup.setExtractionNameListId(expert.getId());
				beExpertGroup.setProjectId(expert.getProjectId());
				
				//根据专家专业赋予相应打分权限
				EptExpertBaseinfo expertBaseinfo = (EptExpertBaseinfo)(tableDao.getEntitybyId(expert.getExpertId(), EptExpertBaseinfo.class));
				//EptSpecialty spe = (EptSpecialty)(tableDao.getEntitybyId(expertBaseinfo.getSpecialtyId(), EptSpecialty.class));
				String specialCode = expertBaseinfo.getSpecialtyCode() == null ?"" : expertBaseinfo.getSpecialtyCode();
				Integer speSize = specialCode.length();
				
				//根据专业编码判断
				if (specialCode.substring(speSize-2, speSize).equals("01")) {
					beExpertGroup.setIsTechScore(1);
					beExpertGroup.setIsBusiScore(0);
					beExpertGroup.setIsPriceScore(0);
				} else if (specialCode.substring(speSize-2, speSize).equals("02")){
					beExpertGroup.setIsTechScore(0);
					beExpertGroup.setIsBusiScore(1);
					beExpertGroup.setIsPriceScore(0);
				}else if (specialCode.substring(speSize-2, speSize).equals("03")){
					beExpertGroup.setIsTechScore(0);
					beExpertGroup.setIsBusiScore(0);
					beExpertGroup.setIsPriceScore(1);
				}else {//此else为测试方便,实际业务中应该删除
					beExpertGroup.setIsTechScore(1);
					beExpertGroup.setIsBusiScore(1);
					beExpertGroup.setIsPriceScore(1);
				}
				beExpertGroup.setIsHeader(0);
				beExpertGroup.setGroupId(-1);
				beExpertGroup.setIsExpert(1);
				beExpertGroup.setIsValid(1);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				beExpertGroup.setOpTime(df.format(new Date()));
				tableDao.insert(beExpertGroup);
			}
				//设置方案状态为 已抽取
				program.setProgramStatus("YCQ");
				
				//设置实际抽取人数
				if(StringUtil.isNotNull(program.getActualExtractionNum())){
					program.setActualExtractionNum(Integer.parseInt(program.getActualExtractionNum())+experts.size()+"");
				}else{
					program.setActualExtractionNum(experts.size()+"");
				}
				
				//设置方案抽取次数
				if(StringUtil.isNotNull(program.getExtractionTimes())){
					try {
						program.setExtractionTimes((Integer.parseInt(program.getExtractionTimes())+1)+"");
					} catch (Exception e) {
						program.setExtractionTimes(1+"");
					}
					
				}else{
					program.setExtractionTimes(1+"");
				}
				
				//设置是否已抽取  为已抽取
				program.setIsExtraction("Y");	
				boolean result = tableDao.update(program);
				return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("service获得实体异常!");
			return false;
		}
		

	}
	
	
	

}