package DAO;

import data.*;

public abstract class ConcertDAOFactory {

	public abstract DAO<Artiste> getDAOArtiste() throws DAOException;
	public abstract DAO<Concert> getDAOConcert() throws DAOException;
	public abstract DAO<Gestionnaire> getDAOGestionnaire() throws DAOException;
	public abstract DAO<Groupe> getDAOGroupe() throws DAOException;
	public abstract DAO<Salle> getDAOSalle() throws DAOException;
	public abstract DAO<Soiree> getDAOSoiree() throws DAOException;
}
