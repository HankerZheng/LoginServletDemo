package net.antra.hanz.controller;

import net.antra.hanz.model.Dept;
import net.antra.hanz.model.User;
import net.antra.hanz.service.AbstractService;
import net.antra.hanz.service.AddDeptService;
import net.antra.hanz.service.InvalidLoginStatusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hanzheng on 6/26/17.
 */
@WebServlet(name = "AddDeptServlet", value = {"/adddept"})
public class AddDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Post in Adddept Servlet");
        if ((new InvalidLoginStatusService(request)).service()) {
            response.sendRedirect("/login");
            return;
        }

        String deptId = request.getParameter("dept_id");
        String deptName = request.getParameter("dept_name");
        String deptEmail = request.getParameter("dept_email");

        AddDeptService ads = new AddDeptService(deptId, deptName, deptEmail);
        Dept dept = ads.service();
        if (dept != null) {
            request.getSession().setAttribute("deptError", false);
            response.sendRedirect("/home");
        } else {
            request.getSession().setAttribute("deptError", true);
            request.getRequestDispatcher("/WEB-INF/addDept.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Get in Adddept Servlet");
        if ((new InvalidLoginStatusService(request)).service()) {
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/addDept.jsp").forward(request, response);
    }
}
