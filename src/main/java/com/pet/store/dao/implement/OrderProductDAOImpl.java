package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.OrderProductDAO;
import com.pet.store.entity.OrderProduct;

public class OrderProductDAOImpl extends GenericDAO<OrderProduct> implements OrderProductDAO {
	private static SessionFactory sessionFactory;
	private Session session;
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	// private static Transaction t;
	public OrderProductDAOImpl() {

		session = sessionFactory.openSession();

	}

	@Override
	public List<OrderProduct> listAll() {

		Query<OrderProduct> query = session.createQuery("select o from OrderProduct o",OrderProduct.class);
		List<OrderProduct> orderProducts = query.getResultList();
		return orderProducts;
	}

	@Override
	public int insert(OrderProduct t) {
		if (t != null) {

			session.beginTransaction();
			session.clear();
			session.save(t);
			session.flush();
			session.getTransaction().commit();

			return 1;
		}

		return -1;

	}

	@Override
	public int update(OrderProduct t) {
		if (session.beginTransaction() == null) {
			session.beginTransaction();
			session.merge(t);
			session.getTransaction().commit();
		}
		return 1;
	}

	@Override
	public void delete(long id) {

		OrderProduct orderProduct = getElementById(id);
		session.delete(orderProduct);
		session.getTransaction().commit();

	}

	@Override
	public OrderProduct getElementById(long id) {

		OrderProduct orderproduct = session.find(OrderProduct.class, id);
		return orderproduct;
	}

	@Override
	public OrderProduct getElementByProductId(long productId) {
		Query<OrderProduct> query = session.createQuery(
				"SELECT o from OrderProduct o where o.Product.productId = : productId", OrderProduct.class);
		query.setParameter("productId", productId);
		OrderProduct op = query.uniqueResult();
		return op;

	}

	
}
