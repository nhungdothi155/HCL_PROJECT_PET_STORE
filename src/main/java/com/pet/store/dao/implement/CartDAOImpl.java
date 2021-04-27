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
import com.pet.store.entity.Customer;

public class CartDAOImpl extends GenericDAO<Cart> implements CartDAO {
	private SessionFactory sessionFactory;
	private Session session;

	// private static Transaction t;
	public CartDAOImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();

	}

	@Override
	public List<Cart> listAll() {

		Query<Cart> query = session.createQuery("select c from Cart c", Cart.class);
		List<Cart> carts = query.getResultList();
		// TODO Auto-generated method stub
		return carts;
	}

	@Override
	public int insert(Cart t) {
		if (t != null) {

			session.save(t);
			session.getTransaction().commit();

			return 1;
		}
		return -1;
	}

	@Override
	public int update(Cart t) {

		session.update(t);
		session.getTransaction().commit();
	

		return 1;
	}

	@Override
	public void delete(long id) {

		Cart Cart = getElementById(id);
		session.delete(Cart);
		session.getTransaction().commit();

	}

	@Override
	public Cart getElementById(long id) {

		Cart cart = session.find(Cart.class, id);
		return cart;
	}
    @Override
	public Cart findCartByCustomerId(long custId) {
        session.clear();
		Query<Cart> query = session.createQuery("Select c from Cart c where c.customer.id= :customerId ", Cart.class);
		query.setParameter("customerId", custId);
		Cart cart = query.getSingleResult();
		if (cart != null) {
			return cart;
		}
		return null;
	}

}
