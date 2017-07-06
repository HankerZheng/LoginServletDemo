package net.antra.hanz.controller;

import net.antra.hanz.model.Dept;
import net.antra.hanz.service.*;

import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hanzheng on 6/26/17.
 */
@WebServlet(name = "AddDeptServlet", value = {"/adddept"})
public class AddDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check login Status
        System.out.println("Post in Adddept Servlet");
        if ((new InvalidLoginStatusService(request)).service()) {
            response.sendRedirect("/login");
            return;
        }
        // Fetch HTTP request parameter
        String deptName = request.getParameter("dept_name");
        String deptEmail = request.getParameter("dept_email");
        // Create a new dept based on the user input
        AddDeptService ads = new AddDeptService(deptName, deptEmail);
        try {
            ads.service();
            request.getSession().setAttribute("deptError", false);
            request.getRequestDispatcher("/WEB-INF/addDept.jsp").forward(request, response);
        } catch (PersistenceException e) {
            e.printStackTrace();
            request.getSession().setAttribute("deptError", true);
            response.sendRedirect("/adddept");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Get in Adddept Servlet");
        if ((new InvalidLoginStatusService(request)).service()) {
            response.sendRedirect("/login");
            return;
        }
        // Fetch department list
        try {
            List<Dept> deptList = (new FetchDeptService()).service();
            getServletContext().setAttribute("deptList", deptList);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/addDept.jsp").forward(request, response);
    }
}
