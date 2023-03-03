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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "getAllArtisteServlet", value = "/getAllArtiste")
public class getAllArtisteServlet extends HttpServlet {

    public List<Artiste> getAllArtiste() {
        // requ�te JPQL pour r�cup�rer les sportifs dans la BDD
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertsPU");
        EntityManager em = emf.createEntityManager();
        Query requete = em.createQuery("SELECT DISTINCT a FROM Artiste a");
        return (List<Artiste>) requete.getResultList();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Artiste> artistes = this.getAllArtiste();

        // Renvoi des données au format JSON
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers",
                "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONArray jsonArray = new JSONArray();

        for (Artiste a : artistes) {
            JSONObject obj = new JSONObject();
            obj.put("id", a.getIdArtiste());
            obj.put("nom", a.getNom());
            obj.put("prenom", a.getPrenom());
            obj.put("pseudo", a.getPseudo());
            obj.put("ville", a.getVille());
            obj.put("age", a.getAge());

            // Ajoute le SetArtiste dans le JSON
            JSONArray jsonArrayGroupe = new JSONArray();
            for (data.Groupe g : a.getGroupeSet()) {
                JSONObject objGroupe = new JSONObject();
                objGroupe.put("id", g.getIdGroupe());
                objGroupe.put("nom", g.getNom());
                jsonArrayGroupe.put(objGroupe);
            }

            obj.put("groupeSet", jsonArrayGroupe);

            // Ajoute le SetConcert dans le JSON
            JSONArray jsonArrayConcert = new JSONArray();
            for (data.Concert c : a.getConcertSet()) {
                JSONObject objConcert = new JSONObject();
                objConcert.put("id", c.getIdConcert());
                jsonArrayConcert.put(objConcert);
            }

            obj.put("concertSet", jsonArrayConcert);

            jsonArray.put(obj);
        }

        PrintWriter out = response.getWriter();
        out.write(jsonArray.toString());
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
