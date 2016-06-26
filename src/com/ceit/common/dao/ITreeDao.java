package com.ceit.common.dao;

import java.util.List;
import java.util.Map;

/**
 * TreeDao 是系统树结构接口，包含树的相关操作的业务逻辑。
 * @author wujinshui
 */

public interface ITreeDao {
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
	public boolean delete(Integer id,Class entityClass);
	/**
	 * 根据实体的PARENTID，及其对应的实体类，获取数据表中的Object
	 * @param id 要获取的Object的ID
	 * @param entityClass  Object对应的实体类
	 * @return  查询到的实体
	 */
	public List getEntitybyParentId(Integer id,Class entityClass);
	/**
	 * 根据实体的ID，及其对应的实体类，获取数据表中的Object
	 * @param id 要获取的Object的ID
	 * @param entityClass  Object对应的实体类
	 * @return  查询到的实体
	 */
	public Object getEntitybyId(Integer id,Class entityClass);
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
	
	/**
	 * 根据查询语句，返回查询数据信息,可实现获取数据的数量
	 * @param sql 查询语句字符串
	 * @param hql 查询语句是否是hql语句
	 * @param returnNot 执行查询语句后是否需要返回数据
	 * @param params sql语句中的参数
	 * @return 查询到的数据集合
	 */
	public List otherQuery(String sql, boolean isHql, boolean returnNot,Map<String, Object> params);
}
