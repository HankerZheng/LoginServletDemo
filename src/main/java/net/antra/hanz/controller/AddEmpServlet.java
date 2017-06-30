package net.antra.hanz.controller;

import net.antra.hanz.model.Employee;
import net.antra.hanz.model.User;
import net.antra.hanz.service.AddEmpService;
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
@WebServlet(name = "AddEmpServlet", value = {"/addemp"})
public class AddEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Post in AddEmp Servlet");
        if ((new InvalidLoginStatusService(request)).service()) {
            response.sendRedirect("/login");
            return;
        }

        String empId = request.getParameter("emp_id");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String age = request.getParameter("age");
        String deptId = request.getParameter("dept_id");

        AddEmpService aes = new AddEmpService(empId, firstName, lastName, age, deptId);
        Employee emp = aes.service();
        if (emp != null) {
            request.getSession().setAttribute("empError", false);
            response.sendRedirect("/home");
        } else {
            request.getSession().setAttribute("empError", true);
            request.getRequestDispatcher("/WEB-INF/addEmp.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Get in AddEmp Servlet");
        if ((new InvalidLoginStatusService(request)).service()) {
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/addEmp.jsp").forward(request, response);
    }
}
