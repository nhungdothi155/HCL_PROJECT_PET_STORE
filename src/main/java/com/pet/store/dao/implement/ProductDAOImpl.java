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
	private SessionFactory sessionFactory;
	private Session session;

	// private static Transaction t;
	public ProductDAOImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();

	}

	@Override
	public List<Product> listAll() {
		// pass

		Query<Product> query = session.createQuery("select p from Product p", Product.class);
		List<Product> products = query.getResultList();
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public int insert(Product t) {
		if (t != null) {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();

			return 1;
		}
		return -1;

	}

	@Override
	public int update(Product t) {
		session.beginTransaction();
		session.merge(t);
		session.getTransaction().commit();

		return 1;

	}

	@Override
	public void delete(long id) {
		// pass
		session.beginTransaction();
		Product product = getElementById(id);
		session.delete(product);
		session.getTransaction().commit();

	}

	public List<Product> searchProductByWords(String word) {

		Query<Product> query = session.createQuery(
				"select p from Product p where p.productName LIKE CONCAT('%',:name,'%') or p.category.categoryName LIKE CONCAT('%',:name,'%')",
				Product.class);
		query.setParameter("name", word);

		List<Product> products = query.getResultList();
		return products;

	}

	public List<Product> searchProductByRequire(String search, String require) {
		Query<Product> query = null;
		switch (require) {
		case "feature":
			query = session.createQuery(
					"select distinct p from Product p inner join OrderProduct o on p.productId = o.product.productId where p.productName LIKE CONCAT('%',:name,'%') or p.category.categoryName LIKE CONCAT('%',:name,'%') ORDER BY p.dateCreated DESC",
					Product.class);
			break;
		case "lowprice":
			query = session.createQuery(
					"select p from Product p where p.productName LIKE CONCAT('%',:name,'%') or p.category.categoryName LIKE CONCAT('%',:name,'%') ORDER BY p.price ASC",
					Product.class);
			break;
		case "highprice":
			query = session.createQuery(
					"select p from Product p where p.productName LIKE CONCAT('%',:name,'%') or p.category.categoryName LIKE CONCAT('%',:name,'%') ORDER BY p.price DESC",
					Product.class);
			break;
		case "newest":
			query = session.createQuery(
					"select p from Product p where p.productName LIKE CONCAT('%',:name,'%') or p.category.categoryName LIKE CONCAT('%',:name,'%') ORDER BY p.dateCreated DESC",
					Product.class);
			break;
		default:
			break;

		}
		query.setParameter("name", search);

		List<Product> products = query.getResultList();
		return products;

	}
//	public List<Product> searchOrderPriceProductByWords(String word){
//		sessionFactory = HibernateUtil.getSessionFactory();
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		Query<Product>query = session.createQuery("select p from Product p where p.productName like %:keyword% or p.petType like %:keyword%",Product.class);
//		query.setParameter("keyword", word );
//		List<Product> products = query.getResultList();
//		return products;
//		
//		
//	}

	public List<Product> searchProductByCategoryName(String categoryName) {

		Query<Product> query = session.createSQLQuery(
				"select product.* from product inner join category on category.category_id = product.category_id where category.category_name = ?");
		query.setParameter(1, categoryName);
		List<Product> products = query.getResultList();
		return products;

	}

	public List<Product> searchProductByCategoryNameAndSubCategory(String categoryName, String subCategoryName) {

		Query<Product> query = session.createSQLQuery(
				"select product.* from product inner join category on category.category_id = product.category_id where category.category_name = ? and category.sub_categories = ?");
		query.setParameter(1, categoryName);
		query.setParameter(2, subCategoryName);
		List<Product> products = query.getResultList();
		return products;

	}

	@Override
	public Product getElementById(long id) {

		Product product = session.find(Product.class, id);
		return product;
	}

}
