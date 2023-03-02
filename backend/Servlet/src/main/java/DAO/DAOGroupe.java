package DAO;

import data.Groupe;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * DAO pour la classe Groupe avec implémentation en JPA
 */
public class DAOGroupe extends DAO<Groupe>{

    private final EntityManager entityManager;

    public DAOGroupe() throws DAOException {
        super();
        entityManager = Persistence.createEntityManagerFactory("ConcertsPU").createEntityManager();
    }

    /**
     * Retourne un groupe à partir de son identifiant
     * @param id identifiant de l'objet
     * @return Groupe l'objet trouvé
     * @throws DAOException si la requête échoue
     */
    @Override
    public Groupe find(int id) throws DAOException {
        Query query = entityManager.createNamedQuery("Groupe.findByIdGroupe");
        query.setParameter("idGroupe", id);
        return (Groupe) query.getSingleResult();
    }

    /**
     * Crée un nouveau groupe dans la base de données
     * @param data l'objet à rendre persistant
     * @throws DAOException si la requête échoue
     */
    @Override
    public void create(Groupe data) throws DAOException {
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
     * Met à jour un groupe dans la base de données
     * @param data l'objet modifié dont le contenu est à mettre à jour
     * @throws DAOException si la requête échoue
     */
    @Override
    public void update(Groupe data) throws DAOException {
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
     * Supprime un groupe de la base de données
     * @param data l'objet à supprimer
     * @throws DAOException si la requête échoue
     */
    @Override
    public void delete(Groupe data) throws DAOException {
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
     * Retourne la liste de tous les groupes
     * @return List<Groupe> liste de tous les groupes
     * @throws DAOException si la requête échoue
     */
    public List<Groupe> findAll() throws DAOException {
        Query query = entityManager.createNamedQuery("Groupe.findAll");
        return (List<Groupe>) query.getResultList();
    }
}
