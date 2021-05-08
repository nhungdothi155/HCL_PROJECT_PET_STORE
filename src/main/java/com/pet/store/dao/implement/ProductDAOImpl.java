package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.ProductDAO;
import com.pet.store.entity.Category;
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
		session.update(t);
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

	public List<Product> searchProductByWords(String word, String require, int offset,int limit) {
		 System.out.println("require" + require);
	     System.out.println("word" + word);
	     System.out.println("offset" + offset);
	     System.out.println("limit" + limit);
		Query<Product> query = null;
		switch (require) {
		case "feature":
			 System.out.println("require" + require);
		     System.out.println("word" + word);
		     System.out.println("offset" + offset);
		     System.out.println("limit" + limit);
			query =session.createQuery(
					"select p from Product p where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ " or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%')",
					Product.class);
			break;
		case "lowprice":
		
			query =session.createQuery(
					"select p from Product p where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ " or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%') ORDER BY p.price ASC",
					Product.class);
			break;
		case "highprice":
			query =session.createQuery(
					"select p from Product p where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ " or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%') ORDER BY p.price DESC",
					Product.class);
			break;
		case "newest":
			query =session.createQuery(
					"select p from Product p where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ " or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%') ORDER BY p.dateCreated ASC",
					Product.class);
			break;
		default:
			break;
			
			
		}
		query.setParameter("name", word)
		.setFirstResult(offset).setMaxResults(limit);

		List<Product> products = query.getResultList();
		return products;

	}
	public List<Product> searchProductByWords(String word,int limit) {

		Query<Product> query = session.createQuery(
				"select p from Product p where p.productName LIKE CONCAT('%',:name,'%') "
				+ "or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
				+ "or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%')",
				Product.class);
		query.setParameter("name", word).setMaxResults(limit);

		List<Product> products = query.getResultList();
		return products;

	}
	public List<Product> searchProductByRequire(String search, String require) {
		Query<Product> query = null;
		System.out.println(search);
		System.out.println(require);
		switch (require) {
		case "feature":
			query = session.createQuery(
					"select p from Product p "
//					+ " inner join OrderProduct o on p.productId = o.product.productId"
					+ " where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ " or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%')" ,
					Product.class);
			break;
		case "lowprice":
			query = session.createQuery(
					"select p from Product p "
					+ "where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ "  or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%') "
					+ " ORDER BY p.price ASC",
					Product.class);
			break;
		case "highprice":
			query = session.createQuery(
					"select p from Product p "
					+ " where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ " or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%')"
					+ " ORDER BY p.price DESC",
					Product.class);
			break;
		case "newest":
			query = session.createQuery(
					"select p from Product p"
					+ " where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ " or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%')"
					+ " ORDER BY p.dateCreated DESC",
					Product.class);
			break;
		default:
			break;

		}
		query.setParameter("name", search);

		List<Product> products = query.getResultList();
		return products;

	}

	public List<Product> searchProductByRequire(String search, String require,int offset, int limit) {
		Query<Product> query = null;
		switch (require) {
		case "feature":
			query = session.createQuery(
					"select  p from Product p "
//					+ " inner join OrderProduct o on p.productId = o.product.productId"
					+ " where lower(p.productName) LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ " or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%')",
					Product.class);
			break;
		case "lowprice":
			query = session.createQuery(
					"select p from Product p "
					+ "where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ "  or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%')"
					+ " ORDER BY p.price ASC",
					Product.class);
			break;
		case "highprice":
			query = session.createQuery(
					"select p from Product p "
					+ " where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ " or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%')"
					+ " ORDER BY p.price DESC",
					Product.class);
			break;
		case "newest":
			query = session.createQuery(
					"select p from Product p"
					+ " where p.productName LIKE CONCAT('%',:name,'%') "
					+ " or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
					+ " or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%')"
					+ " ORDER BY p.dateCreated DESC",
					Product.class);
			break;
		default:
			break;

		}
		System.out.println("search" + limit);
		query.setParameter("name", search).setFirstResult(offset).setMaxResults(limit);

		List<Product> products = query.getResultList();
		return products;

	}

	@Override
	public List<Product> searchProductByCategoryName(String categoryName) {

		Query<Product> query = session.createQuery(
				"select p from Product inner join Category c on p.categoryId = c.categoryId where c.categoryName= : categoryName",
				Product.class);
		query.setParameter("categoryName", categoryName);
		List<Product> products = query.getResultList();
		return products;

	}

	@Override
	public List<Product> searchProductByCategoryNameAndSubCategory(String categoryName, String subCategoryName) {

		Query<Product> query = session.createQuery(
				"select p from Product inner join Category c on p.categoryId = c.categoryId where c.categoryName= :categoryName or c.subCategories= :subCategories",
				Product.class);
		query.setParameter("categoryName", categoryName);
		query.setParameter("subCategories", subCategoryName);
		List<Product> products = query.getResultList();
		return products;

	}

	@Override
	public Product getElementById(long id) {

		Product product = session.find(Product.class, id);
		return product;
	}

	@Override
	public List<Product> searchProductByWords(String word) {
		Query<Product> query = session.createQuery(
				"select p from Product p where p.productName LIKE CONCAT('%',:name,'%') "
				+ "or lower(p.category.categoryName) LIKE CONCAT('%',:name,'%')"
				+ "or lower(p.category.subCategories) LIKE CONCAT('%',:name,'%')",
				Product.class);
		query.setParameter("name", word);

		List<Product> products = query.getResultList();
		return products;
	}


}
