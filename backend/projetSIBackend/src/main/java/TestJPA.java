import data.Artiste;
import data.Concert;
import data.Sport;
import data.Discipline;

import javax.persistence.*;

public class TestJPA {

    public static void main(String argv[]) throws Exception {

        // charge le gestionnaire d'entités lié à l'unité de persistance "SportsPU"
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertsPU");
        EntityManager em = emf.createEntityManager();
        System.out.println("PU chargée");

        // récupère le sport d'identifiant 1, affiche son intitulé et ses disciplines

        /*Sport sport = em.find(Sport.class, cle);
        System.out.println("Le sport " + cle + " est " + sport.getIntitule());
        for (Discipline disc : sport.getDisciplineSet())
            System.out.println(" -> " + disc.getIntitule());*/

        int cle = 1;
        Artiste artiste = em.find(Artiste.class, cle);
        System.out.println("L'artiste " + cle + " est " + artiste.getNom());
        for (Concert concert : artiste.getConcertSet())
            System.out.println(" -> " + concert.getDateConcert());


    }
}