package DAO;

public abstract class DAO<D> {

	public abstract D find(int id) throws DAOException;
	public abstract void create(D data) throws DAOException;
	public abstract void update(D data) throws DAOException;
	public abstract void delete(D data) throws DAOException;
	public DAO() throws DAOException {}
}