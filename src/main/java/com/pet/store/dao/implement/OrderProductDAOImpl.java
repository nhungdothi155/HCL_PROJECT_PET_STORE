package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.OrderProductDAO;
import com.pet.store.entity.OrderProduct;
import com.pet.store.entity.Product;

public class OrderProductDAOImpl extends GenericDAO<OrderProduct> implements OrderProductDAO {
	 private static SessionFactory sessionFactory ;
	  private static Session session ;
	@Override
	public List<OrderProduct> listAll() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	    session.beginTransaction();
	    Query<OrderProduct> query= session.createSQLQuery("select * from hcl_project_pet_store.order_product");
	    List<OrderProduct> orderProducts  = query.getResultList();
	    return orderProducts;
	}

	@Override
	public int insert(OrderProduct t) {
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
	public int update(OrderProduct t) {
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
	   OrderProduct orderProduct = getElementById(id);
	    session.delete(orderProduct);
	    session.getTransaction().commit();
		
	}

	@Override
	public OrderProduct getElementById(long id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		 OrderProduct orderproduct = session.find(OrderProduct.class, id);
		 return orderproduct;
	}

}
