package DAO;

import data.*;

public class DAOFactory {

	private DAOArtiste daoArtiste = null;
	private DAOConcert daoConcert = null;
	private DAOGestionnaire daoGestionnaire = null;
	private DAOGroupe daoGroupe = null;
	private DAOSalle daoSalle = null;
	private DAOSoiree daoSoiree = null;


	public DAOArtiste getDAOArtiste() throws DAOException {
		if (daoArtiste == null) daoArtiste = new DAOArtiste();
		return daoArtiste;
	}

	public DAOConcert getDAOConcert() throws DAOException {
		if (daoConcert == null) daoConcert = new DAOConcert();
		return daoConcert;
	}

	public DAOGestionnaire getDAOGestionnaire() throws DAOException {
		if (daoGestionnaire == null) daoGestionnaire = new DAOGestionnaire();
		return daoGestionnaire;
	}

	public DAOGroupe getDAOGroupe() throws DAOException {
		if (daoGroupe == null) daoGroupe = new DAOGroupe();
		return daoGroupe;
	}

	public DAOSalle getDAOSalle() throws DAOException {
		if (daoSalle == null) daoSalle = new DAOSalle();
		return daoSalle;
	}

	public DAOSoiree getDAOSoiree() throws DAOException {
		if (daoSoiree == null) daoSoiree = new DAOSoiree();
		return daoSoiree;
	}
}
