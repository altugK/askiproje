package org.cu.staff.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.cu.staff.model.Ogrenci;

public class OgrenciDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("staff");
	EntityManager em = emf.createEntityManager();
	Ogrenci Ogrenci = new Ogrenci();

	public void insert(Ogrenci ogrenci) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(ogrenci);
		em.getTransaction().commit();
		em.close();

	}

	public void update(Ogrenci ogrenci) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(ogrenci);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(Ogrenci ogrenci) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(ogrenci));
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Ogrenci> select() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query;
		query = em.createQuery("select o from Ogrenci o");
		List<Ogrenci> list = query.getResultList();
		em.close();
		return list;
	}

}
