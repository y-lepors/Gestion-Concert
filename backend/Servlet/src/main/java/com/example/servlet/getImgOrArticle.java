package com.example.servlet;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import data.Artiste;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mongoPojo.ImgOrArticle;
import mongoPojo.Lier;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@WebServlet(name = "getImgOrArticle", value = "/getImgOrArticle")
public class getImgOrArticle extends HttpServlet {

    public MongoCollection<ImgOrArticle> getImgOrArticle() {

        // connexion � la base Mongo et � la base "sports"
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("Concert").withCodecRegistry(pojoCodecRegistry);

        MongoCollection<ImgOrArticle> imgOrArticle = database.getCollection("ImgOrArticle", ImgOrArticle.class);

        return imgOrArticle;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MongoCollection<ImgOrArticle> imgOrArticle = this.getImgOrArticle();

        // Renvoi des donn�es au format JSON
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers",
                "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONArray jsonArray = new JSONArray();

        for (ImgOrArticle imgOrArticle1 : imgOrArticle.find()) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("Titre", imgOrArticle1.getTitre());
            jsonObject.put("Auteur", imgOrArticle1.getAuteur());
            jsonObject.put("Type", imgOrArticle1.getType());
            jsonObject.put("Date", imgOrArticle1.getDate());
            jsonObject.put("Url", imgOrArticle1.getUrl());

            // Ajoute le set Lier au JSON
            Lier lier = imgOrArticle1.getLier();
            JSONObject jsonObjectLier = new JSONObject();
            JSONArray jsonArrayArtiste = new JSONArray();

            if(lier.getArtiste() != null) {
                for (String artiste : lier.getArtiste()) {
                    jsonArrayArtiste.put(artiste);
                }
            }

            System.out.println(lier.getConcert());
            JSONArray jsonArrayConcert = new JSONArray();
            if(lier.getConcert() != null) {
                for (String concert : lier.getConcert()) {
                    jsonArrayConcert.put(concert);
                }
            }

            JSONArray jsonArraySoiree = new JSONArray();
            if(lier.getSoiree() != null) {
                for (String lieu : lier.getSoiree()) {
                    jsonArraySoiree.put(lieu);
                }
            }

            JSONArray jsonArraySalle = new JSONArray();
            if(lier.getSalle() != null) {
                for (String salle : lier.getSalle()) {
                    jsonArraySalle.put(salle);
                }
            }

            JSONArray jsonArrayGroupe = new JSONArray();
            if(lier.getGroupe() != null) {
                for (String groupe : lier.getGroupe()) {
                    jsonArrayGroupe.put(groupe);
                }
            }

            jsonObjectLier.put("Artiste", jsonArrayArtiste);
            jsonObjectLier.put("Concert", jsonArrayConcert);
            jsonObjectLier.put("Soiree", jsonArraySoiree);
            jsonObjectLier.put("Salle", jsonArraySalle);
            jsonObjectLier.put("Groupe", jsonArrayGroupe);

            jsonObject.put("Lier", jsonObjectLier);
            jsonArray.put(jsonObject);
        }

        PrintWriter out = response.getWriter();
        out.write(jsonArray.toString());
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
