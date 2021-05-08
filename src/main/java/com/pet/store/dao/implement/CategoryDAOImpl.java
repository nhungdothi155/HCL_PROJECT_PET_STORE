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
	private SessionFactory sessionFactory;
	private Session session;

	// private static Transaction t;
	public CategoryDAOImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();

	}

	@Override
	public List<Category> listAll() {

		Query<Category> query = session.createQuery("select c from Category c", Category.class);
		List<Category> categories = query.getResultList();
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public int insert(Category t) {
		if (t != null) {

			session.save(t);
			session.getTransaction().commit();

			return 1;
		}
		return -1;

	}

	@Override
	public int update(Category t) {

		session.update(t);
		session.getTransaction().commit();

		return 1;

	}

	@Override
	public Category getElementById(long id) {

		Category category = session.find(Category.class, id);
		return category;
	}

	@Override
	public Category getSubCategory(String categoryName, String subCategory) {

		Query<Category> query = session.createQuery(
				"select c from Category c where c.categoryName= : categoryName and c.subCategories= : subCategory",
				Category.class);
		query.setParameter("categoryName", categoryName);
		query.setParameter("subCategories", subCategory);
		Category cat = query.getSingleResult();
		return cat;

	}

	@Override
	public List<Category> getCategoryByName(String categoryName) {

		Query<Category> query = session.createQuery("select c from Category c where c.categoryName= : categoryName ",
				Category.class);
		query.setParameter("categoryName", categoryName);
		List<Category> cat = query.getResultList();
		return cat;

	}

	@Override
	public void delete(long id) {
		session.beginTransaction();
		Category c = getElementById(id);
		session.delete(c);
		session.getTransaction().commit();

	}

}
