package dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import conf.JPAUtil;
import models.Donor;
import models.Institution;

public class InstitutionDao implements Dao<Institution>{
	
	
	private EntityManager em;
	
	public InstitutionDao() {
		em = JPAUtil.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public Institution get(int id) {
		return em.find(Institution.class,id);
	}

	@Override
	public List<Institution> getAll() {
		return em.createQuery("FROM Institution").getResultList();
	}

	@Override
	public void save(Institution instance) {
		 executeInsideTransaction(em -> em.persist(instance));	
	}

	@Override
	public void update(Institution instance) {
		 executeInsideTransaction(em -> em.merge(instance));	
	}

	@Override
	public void delete(Institution instance) {
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
