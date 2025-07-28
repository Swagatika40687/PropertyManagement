package com.propertyManagement_configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernatecfg {
	private static final SessionFactory sessionFactory;
	static {
		try {
			 sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		catch (Throwable ex) {
			// TODO: handle exception
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
