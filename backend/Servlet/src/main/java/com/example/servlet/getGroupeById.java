package com.example.servlet;

import data.Groupe;
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

@WebServlet(name = "getGroupeById", value = "/getGroupeById")
public class getGroupeById extends HttpServlet {

    public Groupe getGroupeById(int id) {
        // requ�te JPQL pour r�cup�rer les sportifs dans la BDD
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertsPU");
        EntityManager em = emf.createEntityManager();
        Query requete = em.createQuery("SELECT DISTINCT g FROM Groupe g WHERE g.idGroupe = :id");
        requete.setParameter("id", id);
        return (Groupe) requete.getSingleResult();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        if(id == 0){
            response.sendError(400, "L'id ne peut pas être 0");
        }

        Groupe groupe = this.getGroupeById(id);

        // Renvoi des données au format JSON
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers",
                "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONObject obj = new JSONObject();
        obj.put("id", groupe.getIdGroupe());
        obj.put("nom", groupe.getNom());

        // Ajoute le SetArtiste dans le JSON
        JSONArray jsonArrayArtiste = new JSONArray();
        for (data.Artiste a : groupe.getArtisteSet()) {
            JSONObject objArtiste = new JSONObject();
            objArtiste.put("id", a.getIdArtiste());
            jsonArrayArtiste.put(objArtiste);
        }

        obj.put("artisteSet", jsonArrayArtiste);

        // Ajoute le SetConcert dans le JSON
        JSONArray jsonArrayConcert = new JSONArray();
        for (data.Concert c : groupe.getConcertSet()) {
            JSONObject objConcert = new JSONObject();
            objConcert.put("id", c.getIdConcert());
            jsonArrayConcert.put(objConcert);
        }

        obj.put("concertSet", jsonArrayConcert);

        response.getWriter().write(obj.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
