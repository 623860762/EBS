package com.ceit.common.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.entity.Orderby;
import com.ceit.common.dao.entity.Sysfield;
import com.ceit.common.dao.entity.Whereelement;
import com.ceit.common.util.CommonUtil;
import com.ceit.common.util.StringUtil;
import com.ceit.ebs.HibernateUtils;
import com.ceit.ebs.ebp.entity.EbpProject;
import com.ceit.ebs.ept.entity.EptExtractionNameList;
import com.ceit.ebs.ept.entity.EptExtractionProgram;
import com.ceit.ebs.ept.service.impl.EptSpecialtyService;


public class TableDao extends HibernateDaoSupport implements ITableDao{
//	public TableDao(){
//		
//	}
	static Logger logger = Logger.getLogger(EptSpecialtyService.class.getName());

	
	public Integer insert(Object obj) {
//		Session session = HibernateUtils.getSession();
		Session session = getSession();
		try {
			if (obj != null) {
//				session.beginTransaction();
				session.save(obj);
				
				Field f = obj.getClass().getDeclaredField("id");
				f.setAccessible(true);
				Integer id = (Integer) f.get(obj);
//				session.getTransaction().commit();
				return id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
//	public Integer insert(Object obj) {
//		Session session = getSession();
//		try {
//			if (obj != null) {
//				session.save(obj);
//				Field f = obj.getClass().getDeclaredField("id");
//				f.setAccessible(true);
//				Integer id = (Integer) f.get(obj);
//				System.out.println("22222tableDaoid==="+id);
//				return id;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
//	}

	public boolean update( Object obj) {
		Session session = getSession();
//		Session session = HibernateUtils.getSession();
		try {
//			session.beginTransaction();
			session.merge(obj);
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean delete(Integer id, Class entityClass) {
		Session session = getSession();
//		Session session = HibernateUtils.getSession();
		try {
//			session.beginTransaction();
			Object obj = session.get(entityClass, Integer.valueOf(id));
			if (obj != null)
				session.delete(obj);
//			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Object getEntitybyId(Integer id, Class entityClass) throws Exception{
		Session session = getSession();
//		Session session = HibernateUtils.getSession();
//		session.beginTransaction();
		Object obj = session.get(entityClass, Integer.valueOf(id));
//		session.getTransaction().commit();
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List querydata(String sql, boolean hql, int pageindex, int pagesize,Map<String, Object> params) throws Exception{
		Session session = getSession();
//		Session session = HibernateUtils.getSession();
//		session.beginTransaction();
		Query query ;
		if(hql){
			 query = session.createQuery(sql);
		}
		else{
			 query = session.createSQLQuery(sql);
		}
		query.setFirstResult((pageindex-1)*pagesize);
		query.setMaxResults(pagesize);
		
		if ((params != null) && (params.size() > 0)) {
			for (String key : params.keySet()) {
				if(Collection.class.isAssignableFrom(params.get(key).getClass()))
					query.setParameterList(key,(List)(params.get(key)));	
					else query.setParameter(key, params.get(key));
			}
		}
//		session.getTransaction().commit();
		List list = query.list();
		return list;
		

	}

	@SuppressWarnings("unchecked")
	public List otherQuery(String sql, boolean isHql, boolean returnNot,Map<String, Object> params) throws Exception{
		Session session = getSession();
//		Session session = HibernateUtils.getSession();
//		session.beginTransaction();
		List list = new ArrayList();
		if(isHql){
			Query query = session.createQuery(sql);
			if ((params != null) && (params.size() > 0)) {
				for (String key : params.keySet()) {
					if(Collection.class.isAssignableFrom(params.get(key).getClass()))
						query.setParameterList(key,(List)(params.get(key)));	
						else query.setParameter(key, params.get(key));
				}
			}
			if(!returnNot){
				query.executeUpdate();
			}
			else{
				list = query.list();
			}
		}
		else {
			Query query = session.createSQLQuery(sql);
			if ((params != null) && (params.size() > 0)) {
				for (String key : params.keySet()) {
					if(Collection.class.isAssignableFrom(params.get(key).getClass()))
						query.setParameterList(key,(List)(params.get(key)));	
						else query.setParameter(key, params.get(key));
				}
			}
			if(!returnNot){
				query.executeUpdate();
			}
			else{
				list = query.list();
			}
		}
//		session.close();
		return list;
	}
	/**
	 * 该方法用于根据权限查询List实体集，返回entityClass类型的实体List。
	 * @author wujinshui
	 */
	@SuppressWarnings("unchecked")
	public List getXXdataQuery(List<Sysfield> fieldList,Class entityClass, List<Whereelement> elementList, List<Orderby> orderbyList){
		Session session = getSession();
//		Session session = HibernateUtils.getSession();
//		session.beginTransaction();
		String hql="select ";
		/**以下为拼写sysfield字段**/
		if(fieldList == null || fieldList.size() == 0){
			return null;
		}else{
			for(int i=0; i<fieldList.size(); i++){		
				hql=hql+"t."+fieldList.get(i).getFieldname()+",";
			}
			hql=hql.substring(0, hql.length()-1);
		}
		/**以下为获得去掉包名后实体（表）的名字，并拼写where子句**/
		hql += " from "+entityClass.getName().substring(entityClass.getName().lastIndexOf(".")+1,entityClass.getName().length())+" t where '1' = '1' ";
		if(elementList != null && elementList.size() > 0){
			for(int i=0; i<elementList.size(); i++){
				if(!"".equals(elementList.get(i).getValue())&&elementList.get(i).getValue()!=null){
					hql += " and t."+elementList.get(i).getFieldname()+" "+elementList.get(i).getType()+" "+elementList.get(i).getValue();
				}
			}
		}
		/**以下为拼order子句 **/
		if(orderbyList != null && orderbyList.size() > 0){
			hql=hql+" order by ";
			for(int k=0; k<orderbyList.size(); k++){		
				hql=hql+"t."+orderbyList.get(k).getName()+" "+orderbyList.get(k).getType()+" ,";
			}
			hql=hql.substring(0, hql.length()-1);
		}
		try{
			/**为了获得表中列的类型，将sql查询结果构成实体类 **/
			SQLQuery query = session.createSQLQuery(hql); 
			for(int i=0; i<fieldList.size(); i++){
				Field f;
				/**获得实体的列。反射机制**/
				f = entityClass.getDeclaredField(fieldList.get(i).getFieldname());	
				query.addScalar(f.getName(), CommonUtil.getNullabletype(f.getType()));
				
			}
			return query.setResultTransformer(Transformers.aliasToBean(entityClass)).list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
//		finally{
//			session.close();
//		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean down(Integer id,Class entityClass) {
		Session session = getSession();
//		Session session = HibernateUtils.getSession();
//		session.beginTransaction();
		Object obj=new Object();
		obj=session.get(entityClass, id);
		
		Field fpid,fid,fdispIndex1,fdispIndex2;
		try {
			fpid = obj.getClass().getDeclaredField("parentId");
			
			if(fpid!=null)
			{
				fpid.setAccessible(true);
				Integer pid = (Integer)fpid.get(obj);
			    List list = new ArrayList();
			
			String sql = "select p from "+entityClass.getName()+" p where p.parentId=:parentId ";
			sql += "order by p.dispIndex desc ";
			Query query = session.createQuery(sql);
			query.setParameter("parentId", pid);
			list = query.list();
			
			if(list.isEmpty()) return false;
			for(int i=0;i<list.size()-1;i++){
				
				Object obj1 = list.get(i);
				fid=obj1.getClass().getDeclaredField("id");
				fid.setAccessible(true);
				Integer id1 = (Integer)fid.get(obj1);
		
				if(id1==id){
					fdispIndex1=obj1.getClass().getDeclaredField("dispIndex");
					fdispIndex1.setAccessible(true);		
					Integer dispIndex1 = (Integer)fdispIndex1.get(obj1);
					
					Object obj2=list.get(i+1);
					fdispIndex2=obj2.getClass().getDeclaredField("dispIndex");
					fdispIndex2.setAccessible(true);
					Integer dispIndex2=(Integer)fdispIndex2.get(obj2);	

					Class[] argsclass=new Class[3];
					argsclass[1]=obj1.getClass();
					argsclass[2]=obj2.getClass();
				
					Method m1=obj1.getClass().getDeclaredMethod("setDispIndex",fdispIndex1.getType());
					Method m2=obj2.getClass().getDeclaredMethod("setDispIndex",fdispIndex2.getType());
					m1.invoke(obj1, dispIndex2);
					m2.invoke(obj2, dispIndex1);
					
					session.update(list.get(i));
					session.update(list.get(i+1));
				}
			}
//			session.close();
			return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean up(Integer id,Class entityClass) {
		Session session = getSession();
		Object obj=new Object();
		obj=session.get(entityClass, id);
		
		Field fpid,fid,fdispIndex1,fdispIndex2;
		try {
			fpid = obj.getClass().getDeclaredField("parentId");
			
			if(fpid!=null)
			{
				fpid.setAccessible(true);
				Integer pid = (Integer)fpid.get(obj);

			    List list = new ArrayList();
			
			String sql = "select p from "+entityClass.getName()+" p where p.parentId=:parentId ";
			sql += "order by p.dispIndex desc ";
			Query query = session.createQuery(sql);
			query.setParameter("parentId", pid);
			list = query.list();
			
			if(list.isEmpty()) return false;
			for(int i=1;i<list.size();i++){
				
				Object obj1 = list.get(i);
				fid=obj1.getClass().getDeclaredField("id");
				fid.setAccessible(true);
				Integer id1 = (Integer)fid.get(obj1);
				
				if(id1==id){
					fdispIndex1=obj1.getClass().getDeclaredField("dispIndex");
					fdispIndex1.setAccessible(true);		
					Integer dispIndex1 = (Integer)fdispIndex1.get(obj1);
					
					Object obj2=list.get(i-1);
					fdispIndex2=obj2.getClass().getDeclaredField("dispIndex");
					fdispIndex2.setAccessible(true);
					Integer dispIndex2=(Integer)fdispIndex2.get(obj2);	

					Class[] argsclass=new Class[3];
					argsclass[1]=obj1.getClass();
					argsclass[2]=obj2.getClass();
				
					Method m1=obj1.getClass().getDeclaredMethod("setDispIndex",fdispIndex1.getType());
					Method m2=obj2.getClass().getDeclaredMethod("setDispIndex",fdispIndex2.getType());
					m1.invoke(obj1, dispIndex2);
					m2.invoke(obj2, dispIndex1);
					
					session.update(list.get(i));
					session.update(list.get(i-1));
				}
			}
			return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		return false;		
	}

	
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
//		qSql.append("select distinct exp.id,");
//		qSql.append("                rownum rn");
//		qSql.append("  from ept_expert_baseinfo exp");
//		qSql.append(" where exp.id not in");
//		qSql.append("       (select enl.expert_id");
//		qSql.append("          from ept_extraction_name_list enl");
//		qSql.append("          left join ebp_PROJECT ep");
//		qSql.append("            on enl.project_id = ep.id");
//		qSql.append("            )");
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
	
	
	//*************************专家模块的Dao方法，非共用方法****************************************************************
	/**
	 * 
	 * @Title: getExtractionNameList
	 * @Description: 获得抽取专家列表
	 * @param EbpProject project,EptExtractionProgram program
	 * @return List<EptExtractionNameList>    返回类型
	 * @throws
	 */
	public List<EptExtractionNameList> getExtractionNameList(EbpProject project,EptExtractionProgram program){
		List<EptExtractionNameList> extractionNameList = new ArrayList<EptExtractionNameList>();
		if(null == program){
			return extractionNameList;
		}
		StringBuffer qSql = new StringBuffer();
		qSql.append("select * from (");
		//获取抽取语句
		getExtractionSql(project, program, qSql);
		qSql.append(")t where 1=1");
		
		//需求人数
		int needNum = Integer.parseInt(String.valueOf(program.getTotalUserNumber()));
		//正选人数
		int gregoryNum = 0;
		//备选人数
		int alternativeNum = 0;
		//获取正备选比例的值
		if(StringUtil.isNotNull(program.getSelectProportion()) 
				&& StringUtil.isNotNull(program.getSelectProportion().split(":"))){
			String[] proportion = program.getSelectProportion().split(":");
			gregoryNum = Integer.parseInt(proportion[0]);
			alternativeNum = Integer.parseInt(proportion[1]);
		}
		if(gregoryNum==0 || alternativeNum==0){
			qSql.append(" and t.rn <= ").append(needNum);
		}else{
			qSql.append(" and t.rn <= ").append(needNum*(gregoryNum+alternativeNum));
		}
		//采用随机排序的方式进行抽取
		qSql.append(" order by dbms_random.value");
		
		//输出sql进行测试
		System.out.println(qSql);
		logger.info(qSql);
		
		Session session = HibernateUtils.getSession();
		Query query = session.createSQLQuery(qSql.toString());
		
		List<Object> expertList = new ArrayList<Object>();
		try {
			expertList = query.list();
		} catch (HibernateException e) {
			System.out.println("查询专家发生HibernateException");
			logger.info("查询专家发生HibernateException");
			e.printStackTrace();
		}
		//构造对象
		if(StringUtil.isNotNull(expertList)){
			int tempGregoryNum = needNum * gregoryNum ;
			for (Iterator iterator = expertList.iterator(); iterator.hasNext();) {
				Object[] obj = (Object[]) iterator.next();

				EptExtractionNameList extrName = new EptExtractionNameList();
				extrName.setProjectId(project.getId());
				System.out.println(obj[0].toString());
				extrName.setExpertId((Integer.parseInt(StringUtil.isNotNull(obj[0]) ? obj[0].toString() : "0")));
				extrName.setExtractionProgramId(program.getId());
				//设置正备选
//				if(tempGregoryNum > 0){
//					extrName.setIsOptional(ExpertConstant.EPT_PROPORTION_GREGORY);
//					tempGregoryNum--;
//				}else{
//					extrName.setIsOptional(ExpertConstant.EPT_PROPORTION_ALTERNATIVE);
//				}
				//extrName.setSelectProportion(program.getSelectProportion());
//				extrName.setExtractionTimes(Integer.parseInt(program.getExtractionTimes())+1+"");
				extrName.setOptionUser(program.getOptionUser());
				extrName.setIsValid("Y");
//				extrName.setLockBeginDate(project.getEvaluationBeginDate());
//				extrName.setLockEndDate(project.getEvaluationEndDate());
//				extrName.setToAttend(ExpertConstant.EPT_ATTEND_NO_NOTIFY);
//				extrName.setIsToNotify(YesNoEnum.N);
//				extrName.setToNotifyTime(System.currentTimeMillis());
//				extrName.setIsToConfirm(YesNoEnum.N);
//				extrName.setToConfirmTime(System.currentTimeMillis());
				
				extractionNameList.add(extrName);
			}
		}
		
		return extractionNameList;
	}
	
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
	public void getExtractionSql(EbpProject project,
			EptExtractionProgram program, StringBuffer qSql){
		qSql.append("select distinct exp.id,");
		qSql.append("                rownum rn");
		qSql.append("  from ept_expert_baseinfo exp");
		qSql.append(" where exp.id not in");
		qSql.append("       (select enl.expert_id");
		qSql.append("          from ept_extraction_name_list enl");
		qSql.append("          left join ebp_PROJECT ep");
		qSql.append("            on enl.project_id = ep.id");
		qSql.append("            )");
//		qSql.append("         where ((").append(project.getEvaluationBeginDate());
//		qSql.append(" 			between enl.lock_begin_date and enl.lock_end_date) or");
//		qSql.append("                (").append(project.getEvaluationEndDate());
//		qSql.append("					between enl.lock_begin_date and enl.lock_end_date)or ");
//		qSql.append("                (").append(project.getEvaluationBeginDate()).append("< enl.lock_begin_date and");
//		qSql.append("                 ").append(project.getEvaluationEndDate()).append(" > enl.lock_end_date))");
		//抽取区域条件
		if(StringUtil.isNotNull(program.getExtractionArea())){
			qSql.append("   and exp.work_units in ('").append(program.getExtractionArea().replace(",", "','")).append("')");
		}
		
		//回避区域条件
		if(StringUtil.isNotNull(program.getOrgAvoid())){
			qSql.append("   and exp.work_units not in ('").append(program.getOrgAvoid().replace(",", "','")).append("')");
		}
		
		//专家所在地条件
		if(StringUtil.isNotNull(program.getExpertArea())){
			qSql.append("   and exp.communication_city in ('").append(program.getExpertArea().replace(",", "','")).append("')");
		}
	}
	
	//*************************专家模块的Dao方法结束分割线****************************************************************

}
