package com.pet.store.DBConnection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pet.store.entity.Pet;
import com.pet.store.entity.Product;
import com.pet.store.entity.Seller;



public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	 static {   
	        try 
	        {
	            Configuration cfg = new Configuration();
	            cfg.configure("hibernate_mysql.cfg.xml");
                cfg.addAnnotatedClass(Pet.class);
                cfg.addAnnotatedClass(Product.class);
                cfg.addAnnotatedClass(Seller.class);
	            sessionFactory = cfg.buildSessionFactory();
	            //fill your code here
	        }
	        catch (Throwable ex) 
	        {
	            System.err.println("SessionFactory initial creation error."+ ex);    
	        }
	    }
	    
	    public static SessionFactory getSessionFactory() 
	    {
	        //fill your code here
	    	return sessionFactory;
	    }
	

}
