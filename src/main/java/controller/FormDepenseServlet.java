package controller;

import jakarta.servlet.http.*;
import model.entites.*;
import model.utils.BaseObject;

import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import java.io.IOException;

public class FormDepenseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        try{
            Credit credit = new Credit();
            ArrayList<BaseObject> credits = credit.getAll();
            req.setAttribute("credits", credits);
            if(req.getParameter("updateId") != null && req.getParameter("updateId") != "") {
                int id = Integer.parseInt(req.getParameter("updateId"));
                Depense depense = new Depense(id);
                BaseObject baseobject = depense.getById();
                req.setAttribute("depense", baseobject);
                RequestDispatcher dispatcher = req.getRequestDispatcher("fiche-depense.jsp");
                dispatcher.forward(req, res);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("form-depense.jsp");
                dispatcher.forward(req, res);
            }
        } catch(Exception e) {
            PrintWriter out = res.getWriter();
            out.println("Erreur lors de la preparation de formulaire des depenses");
            out.println(e.getMessage());
        }
    }

} 