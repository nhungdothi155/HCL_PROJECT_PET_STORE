package com.pet.store.dao.implement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pet.store.DBConnection.HibernateUtil;
import com.pet.store.dao.GenericDAO;
import com.pet.store.dao.PetDAO;
import com.pet.store.entity.Pet;
import com.pet.store.entity.Product;

public class PetDAOImpl extends GenericDAO<Pet> implements PetDAO {
	private static SessionFactory sessionFactory;
	private static Session session;

	@Override
	public List<Pet> listAll() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Pet> query = session.createQuery("select p from Pet p", Pet.class);
		List<Pet> pets = query.getResultList();
		return pets;
	}

	@Override
	public int insert(Pet t) {
		if (t != null) {
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
	public int update(Pet t) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();

		return 1;

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Pet pet = getElementById(id);
		session.delete(pet);
		session.getTransaction().commit();

	}

	@Override
	public Pet getElementById(long id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Pet pet = session.find(Pet.class, id);
		return pet;
	}

	public List<Pet> searchPetByWords(String word) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Pet> query = session.createQuery(
				"select p from Pet p where p.petName like %:keyword% or p.petType like %:keyword%", Pet.class);
		query.setParameter("keyword", word);
		List<Pet> pets = query.getResultList();
		return pets;

	}

}
