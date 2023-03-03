package com.example.servlet;

import DAO.DAOArtiste;
import DAO.DAOException;
import DAO.DAOGroupe;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet(name = "lierGroupeArtisteServlet", value = "/lierGroupeArtiste")
public class lierGroupeArtisteServlet extends HttpServlet {

    public void lierArtisteGroupe(int idArtiste, int idGroupe) throws DAOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertsPU");
        EntityManager em = emf.createEntityManager();

        DAOArtiste daoArtiste = new DAOArtiste();
        DAOGroupe daoGroupe = new DAOGroupe();

        daoArtiste.find(idArtiste).getGroupeSet().add(daoGroupe.find(idGroupe));
        daoGroupe.find(idGroupe).getArtisteSet().add(daoArtiste.find(idArtiste));

        em.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Récupère les données de la requête POST et les stocke dans des variables
        int idArtiste = Integer.parseInt(request.getParameter("idArtiste"));
        int idGroupe = Integer.parseInt(request.getParameter("idGroupe"));

        // Insertion de l'artiste dans la BDD
        try {
            this.lierArtisteGroupe(idArtiste, idGroupe);
            System.out.println("Artiste lié au groupe");
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

        response.getWriter().write("Artiste lié au groupe");
    }
}
