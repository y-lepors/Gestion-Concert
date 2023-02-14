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

	/**
	 * Retourne un artiste à partir de son identifiant
	 * @param id identifiant de l'objet
	 * @return Artiste l'objet trouvé
	 * @throws DAOException si la requête échoue
	 */
	@Override
	public Artiste find(int id) throws DAOException {
		Query query = entityManager.createNamedQuery("Artiste.findByIdArtiste");
		query.setParameter("idArtiste", id);
		return (Artiste) query.getSingleResult();
	}

	/**
	 * Crée un nouveau artiste dans la base de données
	 * @param data l'objet à rendre persistant
	 * @throws DAOException si la requête échoue
	 */
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

	/**
	 * Met à jour un artiste dans la base de données
	 * @param data l'objet modifié dont le contenu est à mettre à jour
	 * @throws DAOException si la requête échoue
	 */
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

	/**
	 * Supprime un artiste de la base de données
	 * @param data l'objet à supprimer
	 * @throws DAOException si la requête échoue
	 */
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
