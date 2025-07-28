package com.property.cfg;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PropertyConfiguration {
	private static final SessionFactory sessionFactory;
   static {
	   try{
	sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	   }
	   catch(Throwable ex) {
		   throw new ExceptionInInitializerError(ex);
	   }
   }
   public static SessionFactory getSessionFactory() {
	   return sessionFactory;
   }

}
