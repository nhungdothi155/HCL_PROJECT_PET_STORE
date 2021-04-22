package com.pet.store.dao.implement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.ProductDAO;
import com.pet.store.entity.Pet;
import com.pet.store.entity.Product;
import com.pet.store.entity.Seller;
public class ProductDAOImpl extends GenericDAO<Product> implements ProductDAO {
	 private static SessionFactory sessionFactory ;
	  private static Session session ;
	 // private static Transaction t;
	@Override
	public List<Product> listAll() {
		//pass
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	    session.beginTransaction();
	    Query<Product> query= session.createQuery("select p from Product p",Product.class);
	    List<Product> products = query.getResultList();
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public int insert(Product t) {
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
	public  int update(Product t) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(t);
		session.getTransaction().commit();
		
		return 1;
		
	}

	@Override
	public void delete(int id) {
		//pass
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	   Product product = getElementById(id);
	    session.delete(product);
	    session.getTransaction().commit();
		
	}

	public List<Product> searchProductByWords(String word){
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Product>query = session.createQuery("select p from Product p where p.petName like %:keyword% or p.petType like %:keyword%",Product.class);
		query.setParameter("keyword", word );
		List<Product> products = query.getResultList();
		return products;
		
		
	}
//	public List<Product> searchOrderPriceProductByWords(String word){
//		sessionFactory = HibernateUtil.getSessionFactory();
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		Query<Product>query = session.createQuery("select p from Product p where p.petName like %:keyword% or p.petType like %:keyword%",Product.class);
//		query.setParameter("keyword", word );
//		List<Product> products = query.getResultList();
//		return products;
//		
//		
//	}
	
	public List<Product> searchProductByCategoryName(String categoryName){
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Product>query = session.createSQLQuery("select product.* from product inner join category on category.category_id = product.category_id where category.category_name = ?");
		query.setParameter(1, categoryName);
		List<Product> products = query.getResultList();
		return products;
		
		
	}

	@Override
	public Product getElementById(long id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = session.find(Product.class, id);
		return product;
	}

}
