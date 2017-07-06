package net.antra.hanz.service;

import net.antra.hanz.model.Dept;
import net.antra.hanz.model.Employee;
import net.antra.hanz.service.AbstractService;
import net.antra.hanz.util.EMFUtil;
import net.antra.hanz.util.JDBConnect;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanzheng on 6/29/17.
 */
public class FetchEmpService extends AbstractService<List<Employee>>{
    @Override
    public List<Employee> service() {
        EntityManager em = EMFUtil.getEMF().createEntityManager();
        String jpql = "select c from Employee c";
        List<Employee> empList = em.createQuery(jpql).getResultList();
        return empList;
    }

//    @Override
//    public List<Employee> service() {
//        List<Employee> empList = new ArrayList<>();
//        try(
//                Connection conn = JDBConnect.getConnection();
//                Statement stmt = conn.createStatement();
//        ) {
//            System.out.println("Successfully connected to Database");
//            String selectSQL = "select emp_id, first_name, last_name, age, dept_id from employee";
//            ResultSet rset = stmt.executeQuery(selectSQL);
//            while(rset.next()){
//                Employee emp = new Employee(
//                        rset.getInt("emp_id"),
//                        rset.getString("first_name"),
//                        rset.getString("last_name"),
//                        rset.getInt("age"),
//                        rset.getInt("dept_id")
//                );
//                empList.add(emp);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return empList;
//    }
}
