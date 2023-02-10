package DAO;

import data.Artiste;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * DAO pour la table Artiste avec implémentation en JPA
 */
public class DAOArtiste extends DAO<Artiste> {

	private final EntityManager entityManager;

	public DAOArtiste() throws DAOException {
		super();
		entityManager = Persistence.createEntityManagerFactory("ConcertsPU").createEntityManager();
	}

	@Override
	public Artiste find(int id) throws DAOException {
		Query query = entityManager.createNamedQuery("Artiste.findByIdArtiste");
		query.setParameter("idArtiste", id);
		return (Artiste) query.getSingleResult();
	}

	@Override
	public void create(Artiste data) throws DAOException {
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
	public void update(Artiste data) throws DAOException {
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
	public void delete(Artiste data) throws DAOException {
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
