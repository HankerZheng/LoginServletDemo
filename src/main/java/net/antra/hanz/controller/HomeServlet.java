package net.antra.hanz.controller;

import net.antra.hanz.model.Dept;
import net.antra.hanz.model.Employee;
import net.antra.hanz.service.FetchDeptService;
import net.antra.hanz.service.FetchEmpService;
import net.antra.hanz.service.InvalidLoginStatusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hanzheng on 6/24/17.
 */
@WebServlet(name = "HomeServlet", value = {"/home"})
public class HomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Post in Home Servlet");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Get in Home Servlet");
        if ((new InvalidLoginStatusService(request)).service()) {
            response.sendRedirect("/login");
            return;
        }

        List<Employee> empList = (new FetchEmpService()).service();
        List<Dept> deptList = (new FetchDeptService()).service();
        getServletContext().setAttribute("empList", empList);
        getServletContext().setAttribute("deptList", deptList);

        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
    }
}
