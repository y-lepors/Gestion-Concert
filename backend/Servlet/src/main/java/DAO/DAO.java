package DAO;

public abstract class DAO<D> {

	/**
	 * Retourne à partir du support de persistance un objet en fonction de son identifiant.
	 * @param id identifiant de l'objet
	 * @return l'instance de l'objet
	 * @throws DAOException en cas de problème
	 */
	public abstract D find(int id) throws DAOException;

	/**
	 * Rend persistant un objet qui n'avait pas encore de représentation sur
	 * le support de persistance.
	 * @param data l'objet � rendre persistant
	 * @throws DAOException en cas de problème
	 */
	public abstract void create(D data) throws DAOException;

	/**
	 * Met à jour le contenu correspondant à l'objet sur le support persistant (l'objet
	 * avait déjà une représentation sur le support persistant).
	 * @param data l'objet modifié dont le contenu est à mettre à jour
	 * @throws DAOException en cas de problème
	 */
	public abstract void update(D data) throws DAOException;

	/**
	 * Efface du support persistant le contenu équivalent à l'objet.
	 * @param data l'objet à supprimer
	 * @throws DAOException en cas de problème
	 */
	public abstract void delete(D data) throws DAOException;

	/**
	 * Construit le DAO pour la classe paramétrée.
	 * @throws DAOException en cas de problème
	 */
	public DAO() throws DAOException {}
}