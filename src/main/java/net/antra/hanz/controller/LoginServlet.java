package net.antra.hanz.controller;

import net.antra.hanz.util.User;
import net.antra.hanz.service.LoginCheckService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hanzheng on 6/24/17.
 */
@WebServlet(name = "LoginServlet", value = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Post in Login Servlet!");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginCheckService vls = new LoginCheckService(username, password);
        User validUser = vls.service();
        if (validUser != null) {
            request.getSession().setAttribute("user", validUser);
            request.getSession().setAttribute("invalidUser", false);
            response.sendRedirect("home");
        } else {
            // set invalid user to show the error message
            request.getSession().setAttribute("invalidUser", true);
            // remove the already logged in user
            request.getSession().removeAttribute("user");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Get in Login Servlet!");

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }
}
