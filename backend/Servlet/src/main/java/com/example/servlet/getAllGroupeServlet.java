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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "getAllGroupe", value = "/getAllGroupe")
public class getAllGroupeServlet extends HttpServlet {

    public List<Groupe> getListeGroupes() {
        // requ�te JPQL pour r�cup�rer les sportifs dans la BDD
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertsPU");
        EntityManager em = emf.createEntityManager();
        Query requete = em.createQuery("SELECT DISTINCT g FROM Groupe g");
        return (List<Groupe>) requete.getResultList();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Groupe> groupes = this.getListeGroupes();

            // Renvoi des données au format JSON
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
            response.addHeader("Access-Control-Allow-Headers",
                    "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
            response.addHeader("Access-Control-Max-Age", "1728000");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            JSONArray jsonArray = new JSONArray();

            for(Groupe g : groupes){
                JSONObject obj = new JSONObject();
                obj.put("id", g.getIdGroupe());
                obj.put("nom", g.getNom());

                // Ajoute le SetArtiste dans le JSON
                JSONArray jsonArrayArtiste = new JSONArray();
                for (data.Artiste a : g.getArtisteSet()) {
                    JSONObject objArtiste = new JSONObject();
                    objArtiste.put("id", a.getIdArtiste());
                    jsonArrayArtiste.put(objArtiste);
                }

                obj.put("artisteSet", jsonArrayArtiste);


                jsonArray.put(obj);
            }

            PrintWriter out = response.getWriter();
            out.write(jsonArray.toString());
            out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
