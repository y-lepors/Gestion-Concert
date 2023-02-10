package DAO;

import data.*;

public class DAOFactory extends ConcertDAOFactory {

	private DAOArtiste daoArtiste = null;
	private DAOConcert daoConcert = null;
	private DAOGestionnaire daoGestionnaire = null;
	private DAOGroupe daoGroupe = null;
	private DAOSalle daoSalle = null;
	private DAOSoiree daoSoiree = null;


	@Override
	public DAO<Artiste> getDAOArtiste() throws DAOException {
		if (daoArtiste == null) daoArtiste = new DAOArtiste();
		return daoArtiste;
	}

	@Override
	public DAO<Concert> getDAOConcert() throws DAOException {
		if (daoConcert == null) daoConcert = new DAOConcert();
		return daoConcert;
	}

	@Override
	public DAO<Gestionnaire> getDAOGestionnaire() throws DAOException {
		if (daoGestionnaire == null) daoGestionnaire = new DAOGestionnaire();
		return daoGestionnaire;
	}

	@Override
	public DAO<Groupe> getDAOGroupe() throws DAOException {
		if (daoGroupe == null) daoGroupe = new DAOGroupe();
		return daoGroupe;
	}

	@Override
	public DAO<Salle> getDAOSalle() throws DAOException {
		if (daoSalle == null) daoSalle = new DAOSalle();
		return daoSalle;
	}

	@Override
	public DAO<Soiree> getDAOSoiree() throws DAOException {
		if (daoSoiree == null) daoSoiree = new DAOSoiree();
		return daoSoiree;
	}
}
