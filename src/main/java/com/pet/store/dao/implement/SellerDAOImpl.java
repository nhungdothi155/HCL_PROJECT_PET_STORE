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
	 private static SessionFactory sessionFactory ;
	  private static Session session ;
	  private static Transaction t;


	@Override
	public boolean isLogin(String username, String password) {
		 sessionFactory =  HibernateUtil.getSessionFactory();
 	    sessionFactory.openSession();
 	     session = sessionFactory.openSession();
 	    t = session.beginTransaction();
		Query<Seller> query = session.createQuery(
				"Select s from Seller s where s.username= :username and s.password= :password", Seller.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		Seller seller = query.uniqueResult();

		if(seller==null) {
			
			return false;
	
		}
		else {
			session.close();
			return true;
		}
	
	}

	@Override
	public List<Seller> listAll() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	    session.beginTransaction();
		Query<Seller> query = session.createQuery("Select s from Seller s", Seller.class);
		List<Seller> sellers = query.getResultList();
		

		return sellers;
	}

	@Override
	public int insert(Seller t) {
		
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
	public int update(Seller t) {
	
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
	    Seller seller = getElementById(id);
	    session.delete(seller);
	   
	    session.getTransaction().commit();
	  

	}

	@Override
	public Seller getElementById(long id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
//		Query<Seller> query = session.createQuery("select s from Seller s where s.sellerId= :sellerId",Seller.class);
//		query.setParameter("sellerId", id);
//		Seller seller = query.getSingleResult();
		 Seller seller = session.find(Seller.class, id);
		
		return seller;
	}

}
