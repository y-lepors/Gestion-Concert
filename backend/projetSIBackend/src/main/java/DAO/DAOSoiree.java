package DAO;

import data.Artiste;
import data.Soiree;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DAOSoiree extends DAO<Soiree> {

	private final EntityManager entityManager;

	public DAOSoiree() throws DAOException {
		super();
		entityManager = Persistence.createEntityManagerFactory("ConcertsPU").createEntityManager();
	}

	/**
	 * Retourne la soirée correspondant à l'identifiant
	 * @param id identifiant de l'objet
	 * @return Soiree objet correspondant à l'identifiant
	 * @throws DAOException si la requête ne peut pas être exécutée
	 */
	@Override
	public Soiree find(int id) throws DAOException {
		Query query = entityManager.createNamedQuery("Soiree.findByIdSoiree");
		query.setParameter("idSoiree", id);
		return (Soiree) query.getSingleResult();
	}

	/**
	 * Crée une nouvelle soirée dans la base de données
	 * @param data l'objet à rendre persistant
	 * @throws DAOException si la requête ne peut pas être exécutée
	 */
	@Override
	public void create(Soiree data) throws DAOException {

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
	 * Met à jour une soirée dans la base de données
	 * @param data l'objet modifié dont le contenu est à mettre à jour
	 * @throws DAOException si la requête ne peut pas être exécutée
	 */
	@Override
	public void update(Soiree data) throws DAOException {
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
	 * Supprime une soirée de la base de données
	 * @param data l'objet à supprimer de la base de données
	 * @throws DAOException si la requête ne peut pas être exécutée
	 */
	@Override
	public void delete(Soiree data) throws DAOException {
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
	 * Retourne la liste de toutes les soirées
	 * @return ArrayList<Soiree> liste de toutes les soirées
	 * @throws DAOException si la requête échoue
	 */
	public List<Soiree> findAll() throws DAOException {
		Query query = entityManager.createNamedQuery("Soiree.findAll");
		return (List<Soiree>) query.getResultList();
	}

	/**
	 * Retourne la liste des artistes d'une soirée
	 * @param idSoiree identifiant de la soirée
	 * @return ArrayList<Artiste> liste des artistes de la soirée
	 * @throws DAOException si la requête échoue
	 */
	public List<Artiste> selectArtisteBySoiree(int idSoiree) throws DAOException {
		Query query = entityManager.createNamedQuery("SELECT * From Artiste WHERE Artiste.idArtiste = (SELECT Concert.idArtiste FROM Soiree, Concert WHERE Concert.idSoiree = Soiree.idSoiree AND idSoiree = "+ idSoiree+")");
		return (List<Artiste>) query.getResultList();
	}
}
