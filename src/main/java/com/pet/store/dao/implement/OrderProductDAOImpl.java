package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.OrderProductDAO;
import com.pet.store.entity.OrderProduct;
import com.pet.store.entity.Product;

public class OrderProductDAOImpl extends GenericDAO<OrderProduct> implements OrderProductDAO {
	private SessionFactory sessionFactory;
	private  Session session;

	// private static Transaction t;
	public OrderProductDAOImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session=  sessionFactory.openSession();
		
	}
	@Override
	public List<OrderProduct> listAll() {
		
	    Query<OrderProduct> query= session.createSQLQuery("select * from hcl_project_pet_store.order_product");
	    List<OrderProduct> orderProducts  = query.getResultList();
	    return orderProducts;
	}

	@Override
	public int insert(OrderProduct t) {
		if(t!=null) {
			session.beginTransaction();
		
			session.save(t);
			session.getTransaction().commit();
			
			return 1;
			}
			return -1;
		
		
	}

	@Override
	public int update(OrderProduct t) {
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
		
		return 1;
	}

	@Override
	public void delete(long id) {
		
	   OrderProduct orderProduct = getElementById(id);
	    session.delete(orderProduct);
	    session.getTransaction().commit();
		
	}

	@Override
	public OrderProduct getElementById(long id) {
		
		 OrderProduct orderproduct = session.find(OrderProduct.class, id);
		 return orderproduct;
	}

}
