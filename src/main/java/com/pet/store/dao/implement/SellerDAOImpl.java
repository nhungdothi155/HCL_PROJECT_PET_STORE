package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.SellerDAO;
import com.pet.store.entity.Seller;

public class SellerDAOImpl extends GenericDAO<Seller> implements SellerDAO {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction t;

	public SellerDAOImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();

	}

	@Override
	public Seller isLogin(String username, String password) {

		Query<Seller> query = session.createQuery(
				"Select s from Seller s where s.username= :username and s.password= :password", Seller.class);
		query.setParameter("username", username);
		query.setParameter("password", password);

		Seller seller = query.uniqueResult();

		if (seller != null) {

			return seller;

		} else {

			return null;
		}

	}

	@Override
	public List<Seller> listAll() {

		Query<Seller> query = session.createQuery("Select s from Seller s", Seller.class);
		List<Seller> sellers = query.getResultList();

		return sellers;
	}

	@Override
	public int insert(Seller t) {

		if (t != null) {

			session.save(t);
			session.getTransaction().commit();

			return 1;
		}
		return -1;

	}

	@Override
	public int update(Seller t) {

		session.update(t);
		session.getTransaction().commit();

		return 1;

	}

	@Override
	public void delete(long id) {

		Seller seller = getElementById(id);
		session.delete(seller);
		session.getTransaction().commit();

	}

	@Override
	public Seller getElementById(long id) {
		
		Seller seller = session.find(Seller.class, id);
		return seller;
	}

}
