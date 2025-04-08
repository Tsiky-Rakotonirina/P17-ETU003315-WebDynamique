package controller;

import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import java.io.IOException;

public class FormCreditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        res.sendRedirect("form-credit.jsp");
    }
    
} 