package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.SellerDAO;
import com.pet.store.entity.Seller;

public class SellerDAOImpl extends GenericDAO<Seller> implements SellerDAO {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;


	@Override
	public boolean isLogin(String username, String password) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Seller> query = session.createQuery(
				"Select s from Seller where Seller.username= :username and Seller.password= :password", Seller.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		Seller seller = (Seller) query.getSingleResult();

		return seller != null ? true : false;
	}

	@Override
	public List<Seller> listAll() {
		session = sessionFactory.openSession();
	    session.beginTransaction();
		Query<Seller> query = session.createQuery("from seller", Seller.class);
		List<Seller> sellers = query.getResultList();

		return sellers;
	}

	@Override
	public int insert(Seller t) {
		if(t!=null) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		return 1;
		}
		return -1;

	}

	@Override
	public int update(Seller t) {
		if(t==null) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(t);;
		session.getTransaction().commit();
		return 1;
		}
		return -1;
		

	}

	@Override
	public void delete(int id) {
		session = sessionFactory.openSession();
		session.beginTransaction();
	    Seller seller = getElementById(id);
	    session.delete(seller);
	    session.getTransaction().commit();

	}

	@Override
	public Seller getElementById(long id) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Seller> query = session.createQuery("select s from Seller s where Seller.sellerId= :sellerId",Seller.class);
		query.setParameter("sellerId", id);
		Seller seller = query.getSingleResult();
		return seller;
	}

}
