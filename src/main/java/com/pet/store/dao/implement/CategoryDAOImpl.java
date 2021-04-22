package com.pet.store.dao.implement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.CategoryDAO;
import com.pet.store.dao.GenericDAO;
import com.pet.store.entity.*;
public class CategoryDAOImpl extends GenericDAO<Category> implements CategoryDAO {
	private static SessionFactory sessionFactory ;
	  private static Session session ;
	@Override
	public List<Category> listAll() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	    session.beginTransaction();
	    Query<Category> query= session.createQuery("select c from Category c",Category.class);
	    List<Category> categories = query.getResultList();
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public int insert(Category t) {
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
	public int update(Category t) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(t);
		session.getTransaction().commit();
		
		return 1;
		
		
	}

	@Override
	public void delete(int id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	   Category category = getElementById(id);
	    session.delete(category);
	    session.getTransaction().commit();	
	}

	@Override
	public Category getElementById(long id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = session.find(Category.class, id);
		 return category;
	}
	public Category getSubCategory(String categoryName, String subCategory){
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Category> query = session.createQuery("select c from Category c where c.categoryName= : categoryName and c.subCategories= : subCategory",Category.class);
		query.setParameter("categoryName", categoryName);
		query.setParameter("subCategories", subCategory);
		Category cat = query.getSingleResult();
		return cat;
		
		
	}
	public List<Category> getCategoryByName(String categoryName){
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Category> query = session.createQuery("select c from Category c where c.categoryName= : categoryName ",Category.class);
		query.setParameter("categoryName", categoryName);
		List<Category> cat = query.getResultList();
		return cat;
		
		
	}
	
	

}
