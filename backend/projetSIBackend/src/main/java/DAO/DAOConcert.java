package DAO;

import data.Concert;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * DAO pour la table concert avec implémentation en JPA
 */
public class DAOConcert extends DAO<Concert> {

	private final EntityManager entityManager;

	public DAOConcert() throws DAOException {
		super();
		entityManager = Persistence.createEntityManagerFactory("ConcertsPU").createEntityManager();
	}

	/**
	 * Retourne un concert à partir de son identifiant
	 * @param id identifiant de l'objet
	 * @return Concert l'objet trouvé
	 * @throws DAOException si la requête échoue
	 */
	@Override
	public Concert find(int id) throws DAOException {
		Query query = entityManager.createNamedQuery("Concert.findByIdConcert");
		query.setParameter("idConcert", id);
		return (Concert) query.getSingleResult();
	}

	/**
	 * Crée un nouveau concert dans la base de données
	 * @param data l'objet à rendre persistant
	 * @throws DAOException si la requête échoue
	 */
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

	/**
	 * Met à jour un concert dans la base de données
	 * @param data l'objet modifié dont le contenu est à mettre à jour
	 * @throws DAOException si la requête échoue
	 */
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

	/**
	 * Supprime un concert de la base de données
	 * @param data l'objet à supprimer
	 * @throws DAOException si la requête échoue
	 */
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
