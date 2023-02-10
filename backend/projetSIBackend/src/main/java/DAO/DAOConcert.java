package DAO;

import data.Concert;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOConcert extends DAO<Concert> {

	private final EntityManager entityManager;
	
	public DAOConcert() throws DAOException {
		super();
		entityManager = Persistence.createEntityManagerFactory("SportsPU").createEntityManager();
	}

	@Override
	public Concert find(int id) throws DAOException {
		Query query = entityManager.createNamedQuery("Concert.findByIdConcert");
		query.setParameter("idConcert",(short)id);
		return (Concert) query.getSingleResult();
	}

	@Override
	public void create(Concert data) throws DAOException {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(data);
			trans.commit();
		} catch (Exception e) {
			if (trans != null) trans.rollback();
		}
	}

	@Override
	public void update(Concert data) throws DAOException {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(data);
			trans.commit();
		} catch (Exception e) {
			if (trans != null) trans.rollback();
		}
	}

	@Override
	public void delete(Concert data) throws DAOException {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.remove(data);
			trans.commit();
		} catch (Exception e) {
			if (trans != null) trans.rollback();
		}
	}
}
