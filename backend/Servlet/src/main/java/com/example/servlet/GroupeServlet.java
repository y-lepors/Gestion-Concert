package com.example.servlet;

import data.Groupe;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GroupeServlet", value = "/Groupes")
public class GroupeServlet extends HttpServlet {

    public List<Groupe> getListeGroupes() {
        // requ�te JPQL pour r�cup�rer les sportifs dans la BDD
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConcertsPU");
        EntityManager em = emf.createEntityManager();
        Query requete = em.createQuery("SELECT g FROM Groupe g");
        return (List<Groupe>) requete.getResultList();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if (operation.equals("listeGroupe")) {
            // r�cup�re la liste des groupes et l'associe à la requ�te HTTP
            request.setAttribute("groupes", this.getListeGroupes());
            // forwarde la requ�te � la page JSP
            getServletConfig().getServletContext().getRequestDispatcher("/afficheGroupe.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
