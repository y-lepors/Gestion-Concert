package DAO;

import data.Gestionnaire;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DAOGestionnaire extends DAO<Gestionnaire> {

	private final EntityManager entityManager;

	public DAOGestionnaire() throws DAOException {
		super();
		entityManager = Persistence.createEntityManagerFactory("ConcertsPU").createEntityManager();
	}

	/**
	 * Récupère un objet à partir de sa clé primaire
	 * @param id identifiant de l'objet
	 * @return l'objet correspondant à la clé primaire
	 * @throws DAOException si une erreur survient
	 */
	@Override
	public Gestionnaire find(int id) throws DAOException {
		Query query = entityManager.createNamedQuery("Gestionnaire.findByIdGestionnaire");
		query.setParameter("idGestionnaire", id);
		return (Gestionnaire) query.getSingleResult();
	}

	/**
	 * Crée un nouvel objet dans la base de données
	 * @param data l'objet à rendre persistant
	 * @throws DAOException si une erreur survient
	 */
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

	/**
	 * Met à jour un objet dans la base de données
	 * @param data l'objet modifié dont le contenu est à mettre à jour
	 * @throws DAOException si une erreur survient
	 */
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

	/**
	 * Supprime un objet de la base de données
	 * @param data l'objet à supprimer
	 * @throws DAOException si une erreur survient
	 */
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

	/**
	 * Retourne la liste de tous les gestionnaires de la base de données
	 * @return la liste de tous les gestionnaires de la base de données
	 * @throws DAOException si une erreur survient
	 */
	public List<Gestionnaire> findAll() throws DAOException {
		Query query = entityManager.createNamedQuery("Gestionnaire.findAll");
		return query.getResultList();
	}
}
