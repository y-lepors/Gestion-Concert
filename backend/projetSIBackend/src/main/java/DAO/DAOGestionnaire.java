package DAO;

import data.Gestionnaire;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOGestionnaire extends DAO<Gestionnaire> {

	private final EntityManager entityManager;

	public DAOGestionnaire() throws DAOException {
		super();
		entityManager = Persistence.createEntityManagerFactory("ConcertsPU").createEntityManager();
	}

	@Override
	public Gestionnaire find(int id) throws DAOException {
		Query query = entityManager.createNamedQuery("Gestionnaire.findByIdGestionnaire");
		query.setParameter("idGestionnaire", id);
		return (Gestionnaire) query.getSingleResult();
	}

	@Override
	public void create(Gestionnaire data) throws DAOException {
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
	public void update(Gestionnaire data) throws DAOException {
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
	public void delete(Gestionnaire data) throws DAOException {
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
