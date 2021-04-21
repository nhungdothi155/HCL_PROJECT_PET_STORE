package com.pet.store.dao.implement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.OrderDAO;
import com.pet.store.entity.Order;
import com.pet.store.entity.Product;
public class OrderDAOImpl extends GenericDAO<Order> implements OrderDAO {
	 private static SessionFactory sessionFactory ;
	  private static Session session ;
	@Override
	public List<Order> listAll() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	    session.beginTransaction();
	    Query<Order> query= session.createSQLQuery("select * from hcl_project_pet_store.order");
	    List<Order> orders = query.getResultList();
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public int insert(Order t) {
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
	public int update(Order t) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(t);
		session.getTransaction().commit();
		
		return 1;
		
	}

	@Override
	public void delete(int id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	   Order order = getElementById(id);
	    session.delete(order);
	    session.getTransaction().commit();
		
	}

	@Override
	public Order getElementById(long id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		 Order order = session.find(Order.class, id);
		 return order;
	}

}
