package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.OrderDAO;
import com.pet.store.entity.Order;

public class OrderDAOImpl extends GenericDAO<Order> implements OrderDAO {
	private static SessionFactory sessionFactory;
	private Session session;
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	// private static Transaction t;
	public OrderDAOImpl() {

		session = sessionFactory.openSession();

	}

	@Override
	public List<Order> listAll() {

		Query<Order> query = session.createSQLQuery("select * from hcl_project_pet_store.order");
		List<Order> orders = query.getResultList();
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public int insert(Order o) {
		Transaction t = session.beginTransaction();
		if (o != null) {
			System.out.println(o.getOrderId() + "orderid in orderDAOMIMPL");
			session.save(o);

			t.commit();

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

		Query<Order> query = session
				.createQuery("Select c from Order c where c.customer.id= :cusId ORDER BY c.orderId DESC", Order.class);
		query.setParameter("cusId", custId);
		query.setMaxResults(1);
		Order order = query.uniqueResult();

		if (order != null) {
			return order;
		}
		return null;

	}

}
