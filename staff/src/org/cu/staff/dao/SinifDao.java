package org.cu.staff.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.cu.staff.model.Sinif;

public class SinifDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("staff");
	EntityManager em = emf.createEntityManager();
	Sinif Sinif = new Sinif();

	public void insert(Sinif sinif) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(sinif);
		em.getTransaction().commit();
		em.close();
	}

	public void update(Sinif sinif) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(sinif);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(Sinif sinif) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(sinif));
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Sinif> select() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query;
		query = em.createQuery("select a from Sinif a");
		List<Sinif> list = query.getResultList();
		em.close();
		return list;
	}

}
