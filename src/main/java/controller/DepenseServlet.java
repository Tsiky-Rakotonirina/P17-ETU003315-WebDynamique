package controller;

import jakarta.servlet.http.*;
import model.entites.*;
import service.*;
import model.utils.BaseObject;

import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class DepenseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        int id_credit = Integer.parseInt(req.getParameter("credit"));
        String stringDate = req.getParameter("date");
        java.sql.Date date_ajout = null;
        if(stringDate != null && stringDate !=  "") {
            date_ajout = java.sql.Date.valueOf(stringDate);
        }
        double montant = Double.parseDouble(req.getParameter("montant"));
        Depense depense = new Depense(id_credit,  date_ajout, montant);
        if(req.getParameter("updateId") != null && req.getParameter("updateId") != "") {
            try{
                int id = Integer.parseInt(req.getParameter("updateId"));
                depense.setId(id);
                depense.updateById(); 
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, res);
            } catch(Exception e) {
                out.println("Erreur lors de la modification de depense");
                out.println(e.getMessage());
            }
        } else {
            try{
                Depenser.faireDepense(depense);
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, res);
            } catch(Exception e) {
                out.println("Erreur lors de l'ajout de depense");
                out.println(e.getMessage());
            }
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        Depense depense = new Depense();
        if(req.getParameter("deleteId") != null && req.getParameter("deleteId") != "") {
            try{
                int id = Integer.parseInt(req.getParameter("deleteId"));
                depense.setId(id);
                depense.deleteById();
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, res);
            } catch(Exception e) {
                out.println("Erreur lors de la suppression de depense");
                out.println(e.getMessage());
            }
        } else {
            try{
                ArrayList<BaseObject> depenses = depense.getAll();
                req.setAttribute("depenses", depenses);
                RequestDispatcher dispatcher = req.getRequestDispatcher("list-depense.jsp");
                dispatcher.forward(req, res);
            } catch(Exception e) {
                out.println("Erreur lors de la liste des depenses");
                out.println(e.getMessage());
            }
        }
    }
    
} 