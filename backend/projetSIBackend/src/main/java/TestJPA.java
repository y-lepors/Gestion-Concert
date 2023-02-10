import DAO.DAO;
import DAO.DAOFactory;
import data.Artiste;

public class TestJPA {

	public static void aff(Artiste a) {
		System.out.println(a.getPrenom() + ' ' + a.getNom() + " aka " + a.getPseudo() + " (" + a.getAge() + " ans) " + " de " + a.getVille());
	}

	public static void main(String[] argv) throws Exception {
		try {
			DAOFactory factory = new DAOFactory();
			DAO<Artiste> daoArtiste = factory.getDAOArtiste();

			// create
			System.out.println("---create---");
			Artiste a1 = new Artiste();
			a1.setNom("MICHEL");
			a1.setPrenom("David");
			a1.setPseudo("Bebou");
			a1.setVille("Toulouse");
			a1.setAge(67);
			aff(a1);
			daoArtiste.create(a1);

			// recup id objet
			int aId = a1.getIdArtiste();

			// find
			System.out.println("---find id="+aId+"---");
			aff(daoArtiste.find(aId));

			// update
			System.out.println("---update pseudo=Captain Planet---");
			a1.setPseudo("Captain Planet");
			daoArtiste.update(a1);
			aff(daoArtiste.find(aId));

			// delete
			System.out.println("---delete---");
			daoArtiste.delete(a1);

		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}