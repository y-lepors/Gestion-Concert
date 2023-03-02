package com.example.servlet;

import DAO.DAOArtiste;
import DAO.DAOException;
import data.Artiste;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet(name = "insertArtisteServlet", value = "/insertArtiste")
public class insertArtisteServlet extends HttpServlet {

    public void insertArtiste(String nom, String prenom, String pseudo, String ville, int age) throws DAOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertsPU");
        EntityManager em = emf.createEntityManager();

        DAOArtiste daoArtiste = new DAOArtiste();
        Artiste a = new Artiste();
        a.setNom(nom);
        a.setPrenom(prenom);
        a.setPseudo(pseudo);
        a.setVille(ville);
        a.setAge(age);

        daoArtiste.create(a);



        em.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Récupère les données de la requête POST et les stocke dans des variables
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String pseudo = request.getParameter("pseudo");
        String ville = request.getParameter("ville");
        int age = Integer.parseInt(request.getParameter("age"));

        // Insertion de l'artiste dans la BDD
        try {
            this.insertArtiste(nom, prenom, pseudo, ville, age);
            System.out.println("Artiste inséré");
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        // Renvoi des données au format JSON
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers",
                "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write("{\"nom\":\"" + nom + "\",\"prenom\":\"" + prenom + "\",\"pseudo\":\"" + pseudo + "\",\"ville\":\"" + ville + "\",\"age\":\"" + age + "\"}");
    }
}
