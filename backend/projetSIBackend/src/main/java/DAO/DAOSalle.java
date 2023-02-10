package DAO;

import data.Groupe;
import data.Salle;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOSalle extends DAO<Salle> {

    private final EntityManager entityManager;

    public DAOSalle() throws DAOException {
        super();
        entityManager = Persistence.createEntityManagerFactory("ConcertsPU").createEntityManager();
    }

    @Override
    public Salle find(int id) throws DAOException {


        Query query = entityManager.createNamedQuery("Salle.findByIdSalle");
        query.setParameter("idSalle", id);
        return (Salle) query.getSingleResult();

    }

    @Override
    public void create(Salle data) throws DAOException {

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
    public void update(Salle data) throws DAOException {

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
    public void delete(Salle data) throws DAOException {

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
