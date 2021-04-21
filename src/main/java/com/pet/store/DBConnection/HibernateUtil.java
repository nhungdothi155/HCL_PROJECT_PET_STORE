package com.pet.store.DBConnection;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pet.store.entity.Category;
import com.pet.store.entity.Pet;
import com.pet.store.entity.Product;
import com.pet.store.entity.*;



public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	 static {   
	        try 
	        {
	        	Logger log = Logger.getLogger("org.hibernate");
	        	log.setLevel(Level.OFF);
	        	System.setProperty("org.apache.commons.logging.Log",
	        	"org.apache.commons.logging.impl.NoOpLog");
	            Configuration cfg = new Configuration();
	            cfg.configure("com/pet/store/DBConnection/hibernate_mysql.cfg.xml");
                cfg.addAnnotatedClass(Pet.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Seller.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(CartItem.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderProduct.class)
                .addAnnotatedClass(Pet.class)
                .addAnnotatedClass(Customer.class);
                
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
