package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.CustomerDAO;
import com.pet.store.dao.GenericDAO;
import com.pet.store.entity.*;
public class CustomerDAOImpl extends GenericDAO<Customer> implements CustomerDAO{
	private static SessionFactory sessionFactory ;
	  private static Session session ;
	@Override
	public List<Customer> listAll() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	    session.beginTransaction();
	    Query<Customer> query= session.createQuery("select p from Customer p",Customer.class);
	    List<Customer> customers = query.getResultList();
		// TODO Auto-generated method stub
		return customers;
		
	}

	@Override
	public int insert(Customer t) {
		if(t!=null) {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
			
			return 1;
			}
			return -1;
		
		
	}

	@Override
	public int update(Customer t) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
		
		return 1;
		
	}

	@Override
	public void delete(int id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	   Customer customer = getElementById(id);
	    session.delete(customer);
	    session.getTransaction().commit();
		
	}

	@Override
	public Customer getElementById(long id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = session.find(Customer.class, id);
		 return customer;
	}

	@Override
	public boolean isLogin(String username, String password) {
		 sessionFactory =  HibernateUtil.getSessionFactory();
	 	    sessionFactory.openSession();
	 	     session = sessionFactory.openSession();
         session.beginTransaction();
			Query<Customer> query = session.createQuery(
					"Select s from Customer s where s.username= :username and s.password= :password", Customer.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			Customer customer = query.uniqueResult();

			if(customer==null) {
				
				return false;
		
			}
			else {
				session.close();
				return true;
			}
	}
	

}
