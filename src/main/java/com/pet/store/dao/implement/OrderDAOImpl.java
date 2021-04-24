package com.pet.store.dao.implement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.OrderDAO;
import com.pet.store.entity.Cart;
import com.pet.store.entity.Order;
import com.pet.store.entity.Product;
public class OrderDAOImpl extends GenericDAO<Order> implements OrderDAO {
	private SessionFactory sessionFactory;
	private  Session session;

	// private static Transaction t;
	public OrderDAOImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session=  sessionFactory.openSession();
		
	}
	@Override
	public List<Order> listAll() {
	
	    Query<Order> query= session.createSQLQuery("select * from hcl_project_pet_store.order");
	    List<Order> orders = query.getResultList();
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public int insert(Order t) {
		if(t!=null) {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
			
			return 1;
			}
			return -1;
		
		
		
	}

	@Override
	public int update(Order t) {
		session.beginTransaction();
		session.merge(t);
		session.getTransaction().commit();
		
		return 1;
		
	}

	@Override
	public void delete(long id) {
	
	   Order order = getElementById(id);
	    session.delete(order);
	    session.getTransaction().commit();
		
	}

	@Override
	public Order getElementById(long id) {
		
		 Order order = session.find(Order.class, id);
		 return order;
	}
	public Order findOrderByCustomerId(long custId) {
		
		  Query<Order> query = session.createQuery(
					"Select c from Order c where c.orderId= :orderId ", Order.class);
	     query.setParameter("orderId", custId);
	     Order order= query.getSingleResult();
	     if(order!=null) {
	    	 return order;
	     }
			return null;
		
	}

}
