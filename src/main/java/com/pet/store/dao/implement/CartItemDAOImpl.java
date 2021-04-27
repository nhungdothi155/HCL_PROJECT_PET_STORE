package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.CartItemDAO;
import com.pet.store.dao.GenericDAO;
import com.pet.store.entity.CartItem;

public class CartItemDAOImpl extends GenericDAO<CartItem> implements CartItemDAO {
	private static SessionFactory sessionFactory;
	private Session session;
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	// private static Transaction t;
	public CartItemDAOImpl() {

		session = sessionFactory.openSession();

	}

	@Override
	public List<CartItem> listAll() {
		Query<CartItem> query = session.createQuery("select c from CartItem c", CartItem.class);
		List<CartItem> CartItem = query.getResultList();
		// TODO Auto-generated method stub
		return CartItem;
	}

	@Override
	public int insert(CartItem t) {
		if (t != null) {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();

			return 1;
		}
		return -1;

	}

	@Override
	public int update(CartItem t) {
		session.beginTransaction();
		session.merge(t);

		session.getTransaction().commit();

		return 1;
	}

	@Override
	public void delete(long id) {

		session.beginTransaction();
		session.clear();
		CartItem cartItem = getElementById(id);
		session.delete(cartItem);
		session.flush();
		session.getTransaction().commit();
	}

	@Override
	public CartItem getElementById(long id) {

		CartItem cartItem = session.find(CartItem.class, id);
		return cartItem;
	}

}
