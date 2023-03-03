package com.example.servlet;

import DAO.DAOArtiste;
import DAO.DAOException;
import DAO.DAOGroupe;
import data.Artiste;
import data.Groupe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet(name = "insertGroupeServlet", value = "/insertGroupe")
public class insertGroupeServlet extends HttpServlet {

    public void insertGroupe(String nom) throws DAOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertsPU");
        EntityManager em = emf.createEntityManager();

        DAOGroupe daoGroupe = new DAOGroupe();
        Groupe g = new Groupe();

        g.setNom(nom);

        daoGroupe.create(g);
        em.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Récupère les données de la requête POST et les stocke dans des variables
        String nom = request.getParameter("nom");

        // Insertion de l'artiste dans la BDD
        try {
            this.insertGroupe(nom);
            System.out.println("Groupe inséré");
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

        response.getWriter().write("{\"nom\":\"" + nom + "\"}");
    }
}
