package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.CartItemDAO;
import com.pet.store.dao.GenericDAO;

import com.pet.store.entity.CartItem;
import com.pet.store.entity.Category;

public class CartItemDAOImpl extends GenericDAO<CartItem> implements CartItemDAO{
	private static SessionFactory sessionFactory ;
	  private static Session session ;
	@Override
	public List<CartItem> listAll() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	    session.beginTransaction();
	    Query<CartItem> query= session.createQuery("select c from CartItem c",CartItem.class);
	    List<CartItem> CartItem = query.getResultList();
		// TODO Auto-generated method stub
		return CartItem;
	}

	@Override
	public int insert(CartItem t) {
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
	public int update(CartItem t) {
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
		CartItem cartItem = getElementById(id);
	    session.delete(cartItem);
	    session.getTransaction().commit();	
	}

	@Override
	public CartItem getElementById(long id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		CartItem cartItem = session.find(CartItem.class, id);
		 return cartItem;
	}

}
