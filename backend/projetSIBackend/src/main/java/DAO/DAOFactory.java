package DAO;

import data.*;

public class DAOFactory {

	private DAOArtiste daoArtiste = null;
	private DAOConcert daoConcert = null;
	private DAOGestionnaire daoGestionnaire = null;
	private DAOGroupe daoGroupe = null;
	private DAOSalle daoSalle = null;
	private DAOSoiree daoSoiree = null;


	public DAO<Artiste> getDAOArtiste() throws DAOException {
		if (daoArtiste == null) daoArtiste = new DAOArtiste();
		return daoArtiste;
	}

	public DAO<Concert> getDAOConcert() throws DAOException {
		if (daoConcert == null) daoConcert = new DAOConcert();
		return daoConcert;
	}

	public DAO<Gestionnaire> getDAOGestionnaire() throws DAOException {
		if (daoGestionnaire == null) daoGestionnaire = new DAOGestionnaire();
		return daoGestionnaire;
	}

	public DAO<Groupe> getDAOGroupe() throws DAOException {
		if (daoGroupe == null) daoGroupe = new DAOGroupe();
		return daoGroupe;
	}

	public DAO<Salle> getDAOSalle() throws DAOException {
		if (daoSalle == null) daoSalle = new DAOSalle();
		return daoSalle;
	}

	public DAO<Soiree> getDAOSoiree() throws DAOException {
		if (daoSoiree == null) daoSoiree = new DAOSoiree();
		return daoSoiree;
	}
}
