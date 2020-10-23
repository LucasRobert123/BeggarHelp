package dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import conf.JPAUtil;
import models.Donor;


public class DonorDao implements Dao<Donor>{

	private EntityManager em;

	public DonorDao() {
		em = JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	
	@Override
	public Donor get(int id) {
		return em.find(Donor.class,id);
	}

	@Override
	public List<Donor> getAll() {
		return em.createQuery("FROM Donor").getResultList();
	}

	@Override
	public void save(Donor instance) {
		 executeInsideTransaction(em -> em.persist(instance));	
	}

	@Override
	public void update(Donor instance) {
		 executeInsideTransaction(em -> em.merge(instance));	
	}

	@Override
	public void delete(Donor instance) {
		 executeInsideTransaction(em -> em.remove(instance));	
	}
	
	private void executeInsideTransaction(Consumer<EntityManager> action ) {
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			action.accept(em);
			tx.commit();
		}
		catch(RuntimeException e){
			tx.rollback();
			throw e;
		}
	}
	
}
