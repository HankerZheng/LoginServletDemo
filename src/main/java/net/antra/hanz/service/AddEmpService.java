package net.antra.hanz.service;

import net.antra.hanz.model.Dept;
import net.antra.hanz.model.Employee;
import net.antra.hanz.util.EMFUtil;
import net.antra.hanz.util.JDBConnect;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.WeakHashMap;

/**
 * Created by hanzheng on 6/26/17.
 */
public class AddEmpService extends AbstractService<Employee>{

    private String firstName;
    private String lastName;
    private String age;
    private String deptId;

    public AddEmpService(String firstName, String lastName, String age, String deptId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.deptId = deptId;
    }


    @Override
    public Employee service() throws PersistenceException{
        Integer parsedAge, parsedDeptId;
        try {
            parsedDeptId = Integer.parseInt(deptId);
            parsedAge = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
        EntityManager em = EMFUtil.getEMF().createEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(parsedAge);
        Dept department = em.find(Dept.class, parsedDeptId);
        employee.setDept(department);
        employee.setDeptId(department.getDeptId());

        em.persist(employee);
        em.flush();
        em.getTransaction().commit();
        em.close();

        return employee;

    }

    @Deprecated
    private void insert(Employee emp) throws SQLException {
        try (
                Connection conn = JDBConnect.getConnection();
                Statement stmt = conn.createStatement()
        ) {
            System.out.println("Successfully connected to Database");
            String insertSQL = String.format(
                    "insert into employee(first_name, last_name, age, dept_id) values ('%s', '%s', %d, %d)",
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getAge(),
                    emp.getDeptId());
            stmt.executeUpdate(insertSQL);
            conn.commit();
        }
    }
}
