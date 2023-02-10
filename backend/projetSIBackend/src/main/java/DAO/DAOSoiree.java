package DAO;

import data.Salle;
import data.Soiree;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOSoiree extends DAO<Soiree> {

    private final EntityManager entityManager;

    public DAOSoiree() throws DAOException {
        super();
        entityManager = Persistence.createEntityManagerFactory("ConcertsPU").createEntityManager();
    }

    @Override
    public Soiree find(int id) throws DAOException {
        Query query = entityManager.createNamedQuery("Soiree.findByIdSoiree");
        query.setParameter("idSoiree", id);
        return (Soiree) query.getSingleResult();
    }

    @Override
    public void create(Soiree data) throws DAOException {

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
    public void update(Soiree data) throws DAOException {
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
    public void delete(Soiree data) throws DAOException {
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
