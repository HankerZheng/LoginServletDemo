package net.antra.hanz.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Logout servlet.
 *
 * Delete the "user" attribute in the session if exists, and then redirect
 * to Login page.
 *
 * Created by hanzheng on 6/24/17.
 */
@WebServlet(name = "LogoutServlet", value = {"/logout"})
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Post in Logout Servlet!");

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Get in Logout Servlet!");

        request.getSession().removeAttribute("user");
        response.sendRedirect("login");
    }
}
