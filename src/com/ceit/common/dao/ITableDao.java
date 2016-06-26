package com.ceit.common.dao;

import java.util.List;
import java.util.Map;

import com.ceit.common.dao.entity.Orderby;
import com.ceit.common.dao.entity.Sysfield;
import com.ceit.common.dao.entity.Whereelement;
import com.ceit.ebs.ebp.entity.EbpProject;
import com.ceit.ebs.ept.entity.EptExtractionNameList;
import com.ceit.ebs.ept.entity.EptExtractionProgram;

public interface ITableDao {
	/**
	 * 向数据表新增Object，并返回新增Object的ID
	 * @param  obj 要新增的Object对象
	 * @return 新增Object的ID
	 */
	public Integer insert(Object obj);
	/**
	 * 修改数据表中的Object
	 * @param   obj 要修改的Object对象
	 * @return  成功返回true 失败返回false
	 */
	public boolean update(Object obj);
	/**
	 * 根据实体的ID，删除数据表中的Object
	 * @param id 要删除的Object的ID
	 * @param entityClass  Object对应的实体类
	 * @return  成功返回true 失败返回false
	 */
	public boolean delete(Integer id, Class entityClass);
	/**
	 * 根据实体的ID，及其对应的实体类，获取数据表中的Object
	 * @param id 要获取的Object的ID
	 * @param entityClass  Object对应的实体类
	 * @return  查询到的实体
	 */
	public Object getEntitybyId(Integer id, Class entityClass)throws Exception;
	/**
	 * 根据查询语句，返回查询数据信息，可实现数据分页显示
	 * @param sql 查询语句字符串
	 * @param hql 查询语句是否是hql语句
	 * @param pageindex 分页起始页
	 * @param pagesize 分页大小
	 * @param params sql语句中的参数
	 * @return 查询到的数据集合
	 */
	public List querydata(String sql,boolean hql,int pageindex,int pagesize,Map<String, Object> params)throws Exception;
	/**
	 * 根据查询语句，返回查询数据信息,可实现获取数据的数量
	 * @param sql 查询语句字符串
	 * @param hql 查询语句是否是hql语句
	 * @param returnNot 执行查询语句后是否需要返回数据
	 * @param params sql语句中的参数
	 * @return 查询到的数据集合
	 * 修改时间 20140818
	 * 修改人 梁艾
	 * 修改内容 map对象可以的value值可以是集合型参数list
	 */
	public List otherQuery(String sql, boolean isHql, boolean returnNot,Map<String, Object> params) throws Exception;
	public List getXXdataQuery(List<Sysfield> fieldList,Class entityClass, List<Whereelement> elementList, List<Orderby> orderbyList);

	/**
	 * 位置上移
	 * @param id 要上移的实体ID
	 * @param entityClass 实体的类型
	 * @return 成功返回true 失败返回false
	 */
	public boolean up(Integer id,Class entityClass);
	/**
	 * 位置下移
	 * @param id 要下移的实体ID
	 * @param entityClass 实体的类型
	 * @return 成功返回true 失败返回false
	 */
	public boolean down(Integer id,Class entityClass);
	//*************************专家模块的Dao方法，非共用方法****************************************************************
	/**
	 * 
	 * @Title: getExtractionNameList
	 * @Description: 获得抽取专家列表
	 * @param EbpProject project,EptExtractionProgram program
	 * @return List<EptExtractionNameList>    返回类型
	 * @throws
	 */
	public List<EptExtractionNameList> getExtractionNameList(EbpProject project,EptExtractionProgram program);
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
	public void getExtractionSql(EbpProject project,EptExtractionProgram program, StringBuffer qSql);
	//*************************专家模块的Dao方法结束分割线****************************************************************

}
