import DAO.DAOArtiste;
import DAO.DAOFactory;
import DAO.DAOGroupe;
import DAO.DAOSoiree;
import data.Artiste;
import data.Groupe;

public class TestJPA {

	public static void aff(Artiste a) {
		System.out.println(a.getPrenom() + ' ' + a.getNom() + " aka " + a.getPseudo() + " (" + a.getAge() + " ans) " + " de " + a.getVille());
	}

	public static void main(String[] argv) throws Exception {
		try {
			DAOFactory factory = new DAOFactory();
			DAOArtiste daoArtiste = factory.getDAOArtiste();

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


			// Create a new Groupe
			DAOGroupe daoGroupe = factory.getDAOGroupe();
			Groupe g1 = new Groupe();
			g1.setNom("Groupe 1");

			Groupe g2 = new Groupe();
			g2.setNom("Groupe 2");

			Groupe g3 = new Groupe();
			g3.setNom("Groupe 3");

			// Add the new Groupe to the database
			daoGroupe.create(g1);
			daoGroupe.create(g2);
			daoGroupe.create(g3);

			// FindAll Groupe
			System.out.println("---findAll Groupe---");
			for (Groupe g : daoGroupe.findAll()) {
				System.out.println(g.getNom());
			}

			DAOSoiree daoSoiree = factory.getDAOSoiree();

			// Select Artiste by Soiree
			System.out.println("---Select Artiste by Soiree---");
			for (Artiste a : daoSoiree.selectArtisteBySoiree(1)) {
				System.out.println(a.getPrenom() + ' ' + a.getNom() + " aka " + a.getPseudo() + " (" + a.getAge() + " ans) " + " de " + a.getVille());
			}




		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}