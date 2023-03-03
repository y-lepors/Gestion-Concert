package com.example.servlet;

import data.Artiste;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;

@WebServlet(name = "getArtisteById", value = "/getArtisteById")
public class getArtisteById extends HttpServlet {

    public Artiste getArtisteById(int id) {
        // requ�te JPQL pour r�cup�rer les sportifs dans la BDD
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertsPU");
        EntityManager em = emf.createEntityManager();
        Query requete = em.createQuery("SELECT DISTINCT a FROM Artiste a WHERE a.idArtiste = :id");
        requete.setParameter("id", id);
        return (Artiste) requete.getSingleResult();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        if(id == 0){
            response.sendError(400, "L'id ne peut pas être 0");
        }

        Artiste artiste = this.getArtisteById(id);

        // Renvoi des données au format JSON
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers",
                "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONObject obj = new JSONObject();
        obj.put("id", artiste.getIdArtiste());
        obj.put("nom", artiste.getNom());
        obj.put("prenom", artiste.getPrenom());
        obj.put("pseudo", artiste.getPseudo());
        obj.put("ville", artiste.getVille());
        obj.put("age", artiste.getAge());

        // Ajoute le SetGroupe dans le JSON
        JSONArray jsonArrayGroupe = new JSONArray();
        for (data.Groupe g : artiste.getGroupeSet()) {
            JSONObject objGroupe = new JSONObject();
            objGroupe.put("id", g.getIdGroupe());
            jsonArrayGroupe.put(objGroupe);
        }

        // Ajoute le SetConcert dans le JSON
        JSONArray jsonArrayConcert = new JSONArray();
        for (data.Concert c : artiste.getConcertSet()) {
            JSONObject objConcert = new JSONObject();
            objConcert.put("id", c.getIdConcert());
            jsonArrayConcert.put(objConcert);
        }

        obj.put("concertSet", jsonArrayConcert);

        obj.put("groupeSet", jsonArrayGroupe);

        response.getWriter().write(obj.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
