package com.ceit.ebs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;
	
	static {
		try {
			//读取hibernate.cfg.xml文件
			Configuration cfg = new Configuration().configure();
			
			//建立SessionFactory
			factory = cfg.buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		return factory.openSession();
	} 
	
	public static void closeSession(Session session) {
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
