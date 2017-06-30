package net.antra.hanz.controller;

import net.antra.hanz.service.InvalidLoginStatusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Index servlet
 *
 * If the user is already logged in, redirect to main page,
 * Else, redirect to the login page.
 *
 * Created by hanzheng on 6/23/17.
 */
@WebServlet(
        name = "IndexServlet",
        value = {"/", ""})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Post in Index Servlet");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Get in Index Servlet");
        if ((new InvalidLoginStatusService(request)).service()) {
            response.sendRedirect("/login");
            return;
        }

        response.sendRedirect("/home");
    }
}
