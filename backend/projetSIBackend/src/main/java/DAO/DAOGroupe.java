package DAO;

import data.Groupe;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * DAO pour la classe Groupe avec implémentation en JPA
 */
public class DAOGroupe extends DAO<Groupe>{

    private final EntityManager entityManager;
    public DAOGroupe() throws DAOException {
        super();
        entityManager = Persistence.createEntityManagerFactory("ConcertsPU").createEntityManager();
    }

    @Override
    public Groupe find(int id) throws DAOException {

        Query query = entityManager.createNamedQuery("Groupe.findByIdGroupe");
        query.setParameter("idGroupe", id);
        return (Groupe) query.getSingleResult();
    }

    @Override
    public void create(Groupe data) throws DAOException {

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(data);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
        }

    }

    @Override
    public void update(Groupe data) throws DAOException {

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(data);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
        }
    }

    @Override
    public void delete(Groupe data) throws DAOException {

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(data);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
        }

    }
}
