package controller;

import jakarta.servlet.http.*;
import model.entites.*;

import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String name= req.getParameter("username");
        String password= req.getParameter("password");
        Login user=new Login(0, name, password);
        try {
            if (user.checkLogin()) {
                HttpSession session = req.getSession();
                session.setAttribute("connected", true);
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, res);
            } else {
                res.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            out.println("Erreur lors du login");
            out.println(e.getMessage());
        }
    }
}
