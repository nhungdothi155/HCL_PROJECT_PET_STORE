package com.pet.store.dao.implement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.CartDAO;
import com.pet.store.dao.GenericDAO;
import com.pet.store.entity.Cart;
import com.pet.store.entity.Category;
public class CartDAOImpl extends GenericDAO<Cart> implements CartDAO {
	private static SessionFactory sessionFactory ;
	  private static Session session ;
	@Override
	public List<Cart> listAll() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	    session.beginTransaction();
	    Query<Cart> query= session.createQuery("select c from Cart c",Cart.class);
	    List<Cart> carts = query.getResultList();
		// TODO Auto-generated method stub
		return carts;
	}

	@Override
	public int insert(Cart t) {
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
	public int update(Cart t) {
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
		Cart Cart = getElementById(id);
	    session.delete(Cart);
	    session.getTransaction().commit();	
		
	}

	@Override
	public Cart getElementById(long id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Cart cart = session.find(Cart.class, id);
		 return cart;
	}

}
