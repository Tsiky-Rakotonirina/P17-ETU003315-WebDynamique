package controller;

import jakarta.servlet.http.*;
import model.entites.*;

import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import java.io.IOException;

public class CreditServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        try{
            String libelle = (String)req.getParameter("libelle");
            double montant = Double.parseDouble(req.getParameter("montant"));
            Credit credit = new Credit(libelle, montant);
            credit.save();
            res.sendRedirect("index.jsp");
        } catch(Exception e) {
            out.println("Erreur lors de l'ajout du departement");
            out.println(e.getMessage());
        }
    }
    
} 