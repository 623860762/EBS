package com.ceit.common.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ceit.common.dao.ITreeDao;

public class TreeDao extends HibernateDaoSupport implements ITreeDao {
	@SuppressWarnings("unchecked")
	public boolean delete( Integer id, Class entityClass) {
		Session session = getSession();
		try {
			Object obj = session.get(entityClass, Integer.valueOf(id));
			if (obj != null)
				session.delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean down(Integer id, Class entityClass) {
		Session session = getSession();
		Object obj = new Object();
		obj = session.get(entityClass, id);

		Field fpid, fid, fdispindex1, fdispindex2;
		try {
			fpid = obj.getClass().getDeclaredField("parentid");

			if (fpid != null) {
				fpid.setAccessible(true);
				Integer pid = (Integer) fpid.get(obj);
				List list = new ArrayList();

//				String sql = "select p from " + entityClass.getName()
//						+ " p where p.parentid=:parentId ";
//				sql += "order by p.dispindex asc ";
				//把sql修改为hql，实体名和表名并不相同,变量名相应调整。
				String sql = "from " + entityClass.getName() + " p where p.parentId=:parentId ";
				sql += "order by p.dispIndex asc ";
				Query query = session.createQuery(sql);
				query.setParameter("parentId", pid);
				list = query.list();

				if (list.isEmpty()){
					return false;
				}
				for (int i = 0; i < list.size() - 1; i++) {

					Object obj1 = list.get(i);
					fid = obj1.getClass().getDeclaredField("id");
					fid.setAccessible(true);
					Integer id1 = (Integer) fid.get(obj1);

					if (id1 == id) {
						fdispindex1 = obj1.getClass().getDeclaredField("dispIndex");
						fdispindex1.setAccessible(true);
						Integer dispindex1 = (Integer) fdispindex1.get(obj1);

						Object obj2 = list.get(i + 1);
						fdispindex2 = obj2.getClass().getDeclaredField("dispIndex");
						fdispindex2.setAccessible(true);
						Integer dispindex2 = (Integer) fdispindex2.get(obj2);

						Class[] argsclass = new Class[3];
						argsclass[1] = obj1.getClass();
						argsclass[2] = obj2.getClass();

						Method m1 = obj1.getClass().getDeclaredMethod("setDispIndex", fdispindex1.getType());
						Method m2 = obj2.getClass().getDeclaredMethod("setDispIndex", fdispindex2.getType());
						m1.invoke(obj1, dispindex2);
						m2.invoke(obj2, dispindex1);

						session.update(list.get(i));
						session.update(list.get(i + 1));
					}
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public Object getEntitybyId(Integer id, Class entityClass) {
		Session session = getSession();
		Object obj = session.get(entityClass, Integer.valueOf(id));
		return obj;
	}
	
	/* (non-Javadoc)
	 * @see com.ceit.common.dao.ITreeDao#getEntitybyParentId(java.lang.Integer, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public List getEntitybyParentId(Integer id, Class entityClass) {
		Session session = getSession();
//		Object obj = new Object();
//		obj = session.get(entityClass, id);

//		Field fpid, fid, fdispindex1, fdispindex2;
		try {
//			fpid = obj.getClass().getDeclaredField("parentId");

//			if (fpid != null) {
//				fpid.setAccessible(true);
//				Integer pid = (Integer) fpid.get(obj);

				//List list = new ArrayList();

				//String sql = "select p from " + entityClass.getName() + " p where p.parentid=:parentId ";
				//sql += "order by p.dispindex asc ";
				//把sql修改为hql，实体名和表名并不相同。
				String sql = "from " + entityClass.getName() + " p where p.parentId=:parentId ";
				sql += "order by p.dispIndex asc ";
				
				Query query = session.createQuery(sql);
				query.setParameter("parentId", id);
				return query.list();
				
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer insert(Object obj) {
		Session session = getSession();
		try {
			if (obj != null) {
				session.save(obj);
				Field f = obj.getClass().getDeclaredField("id");
				f.setAccessible(true);
				Integer id = (Integer) f.get(obj);
				return id;
			} else
				return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@SuppressWarnings("unchecked")
	public boolean up(Integer id, Class entityClass) {
		Session session = getSession();
		Object obj = new Object();
		obj = session.get(entityClass, id);

		Field fpid, fid, fdispindex1, fdispindex2;
		try {
			fpid = obj.getClass().getDeclaredField("parentId");

			if (fpid != null) {
				fpid.setAccessible(true);
				Integer pid = (Integer) fpid.get(obj);

				List list = new ArrayList();

				//String sql = "select p from " + entityClass.getName() + " p where p.parentid=:parentId ";
				//sql += "order by p.dispindex asc ";
				//把sql修改为hql，实体名和表名并不相同。
				String sql = "from " + entityClass.getName() + " p where p.parentId=:parentId ";
				sql += "order by p.dispIndex asc ";
				
				Query query = session.createQuery(sql);
				query.setParameter("parentId", pid);
				list = query.list();

				if (list.isEmpty()){
					return false;
				}
					
				for (int i = 1; i < list.size(); i++) {

					Object obj1 = list.get(i);
					fid = obj1.getClass().getDeclaredField("id");
					fid.setAccessible(true);
					Integer id1 = (Integer) fid.get(obj1);

					if (id1 == id) {
						fdispindex1 = obj1.getClass().getDeclaredField("dispIndex");
						fdispindex1.setAccessible(true);
						Integer dispindex1 = (Integer) fdispindex1.get(obj1);

						Object obj2 = list.get(i - 1);
						fdispindex2 = obj2.getClass().getDeclaredField("dispIndex");
						fdispindex2.setAccessible(true);
						Integer dispindex2 = (Integer) fdispindex2.get(obj2);

						Class[] argsclass = new Class[3];
						argsclass[1] = obj1.getClass();
						argsclass[2] = obj2.getClass();

						Method m1 = obj1.getClass().getDeclaredMethod("setDispIndex", fdispindex1.getType());
						Method m2 = obj2.getClass().getDeclaredMethod("setDispIndex", fdispindex2.getType());
						m1.invoke(obj1, dispindex2);
						m2.invoke(obj2, dispindex1);

						session.update(list.get(i));
						session.update(list.get(i - 1));
					}
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Object obj) {
		Session session = getSession();
		try {
			session.merge(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List otherQuery(String sql, boolean isHql,
			boolean returnNot, Map<String, Object> params) {
		Session session = getSession();
		List list = new ArrayList();
		if (isHql) {
			Query query = session.createQuery(sql);
			if ((params != null) && (params.size() > 0)) {
				for (String key : params.keySet()) {
					query.setParameter(key, params.get(key));
				}
			}
			if (!returnNot) {
				query.executeUpdate();
			} else {
				list = query.list();
			}
		} else {
			Query query = session.createSQLQuery(sql);
			if ((params != null) && (params.size() > 0)) {
				for (String key : params.keySet()) {
					query.setParameter(key, params.get(key));
				}
			}
			if (!returnNot) {
				query.executeUpdate();
			} else {
				list = query.list();
			}
		}
		return list;
	}

	
}
