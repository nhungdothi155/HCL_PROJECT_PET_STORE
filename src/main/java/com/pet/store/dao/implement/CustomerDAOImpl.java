package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.CustomerDAO;
import com.pet.store.dao.GenericDAO;
import com.pet.store.entity.*;

public class CustomerDAOImpl extends GenericDAO<Customer> implements CustomerDAO {
	private SessionFactory sessionFactory;
	private Session session;

	// private static Transaction t;
	public CustomerDAOImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();

	}

	@Override
	public List<Customer> listAll() {

		Query<Customer> query = session.createQuery("select p from Customer p", Customer.class);
		List<Customer> customers = query.getResultList();
		// TODO Auto-generated method stub
		return customers;

	}

	@Override
	public int insert(Customer t) {
		if (t != null) {

			session.save(t);
			session.getTransaction().commit();

			return 1;
		}
		return -1;

	}

	@Override
	public int update(Customer t) {

		session.update(t);
		session.getTransaction().commit();

		return 1;

	}

	@Override
	public void delete(long id) {

		Customer customer = getElementById(id);
		session.delete(customer);
		session.getTransaction().commit();

	}

	@Override
	public Customer getElementById(long id) {

		Customer customer = session.find(Customer.class, id);
		return customer;
	}

	@Override
	public Customer isLogin(String username, String password) {

		Query<Customer> query = session.createQuery(
				"Select s from Customer s where s.username= :username and s.password= :password", Customer.class);
		query.setParameter("username", username);
		query.setParameter("password", password);

		Customer customer = query.uniqueResult();

		return customer;
	}

}
