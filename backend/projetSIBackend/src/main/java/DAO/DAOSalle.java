package DAO;

import data.Salle;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class DAOSalle extends DAO<Salle> {

	private final EntityManager entityManager;

	public DAOSalle() throws DAOException {
		super();
		entityManager = Persistence.createEntityManagerFactory("ConcertsPU").createEntityManager();
	}

	/**
	 * Retourne la salle correspondant à l'identifiant
	 * @param id identifiant de  l'objet
	 * @return Salle objet correspondant à l'identifiant
	 * @throws DAOException si la requête ne peut pas être exécutée
	 */
	@Override
	public Salle find(int id) throws DAOException {
		Query query = entityManager.createNamedQuery("Salle.findByIdSalle");
		query.setParameter("idSalle", id);
		return (Salle) query.getSingleResult();
	}

	/**
	 * Crée une nouvelle salle dans la base de données
	 * @param data l'objet à rendre persistant
	 * @throws DAOException si la requête ne peut pas être exécutée
	 */
	@Override
	public void create(Salle data) throws DAOException {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(data);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
		}
	}

	/**
	 * Met à jour une salle dans la base de données
	 * @param data l'objet modifié dont le contenu est à mettre à jour
	 * @throws DAOException si la requête ne peut pas être exécutée
	 */
	@Override
	public void update(Salle data) throws DAOException {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(data);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
		}
	}

	/**
	 * Supprime une salle de la base de données
	 * @param data Salle à supprimer
	 * @throws DAOException si la requête ne peut pas être exécutée
	 */
	@Override
	public void delete(Salle data) throws DAOException {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.remove(data);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
		}
	}

	/**
	 * Retourne la liste de toutes les salles
	 * @return ArrayList<Salle> liste de toutes les salles
	 * @throws DAOException si la requête ne peut pas être exécutée
	 */
	public ArrayList<Salle> findAll() throws DAOException {
		Query query = entityManager.createNamedQuery("Salle.findAll");
		return (ArrayList<Salle>) query.getResultList();
	}
}
