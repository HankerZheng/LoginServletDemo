package net.antra.hanz.service;

import net.antra.hanz.model.Employee;
import net.antra.hanz.util.JDBConnect;

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

    private String empId;
    private String firstName;
    private String lastName;
    private String age;
    private String deptId;

    public AddEmpService(String empId, String firstName, String lastName, String age, String deptId) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.deptId = deptId;
    }


    @Override
    public Employee service() {
        Employee emp;
        try {
            Integer parsedEmpId = Integer.parseInt(empId);
            Integer parsedDeptId = Integer.parseInt(deptId);
            Integer parsedAge = Integer.parseInt(age);
            emp = new Employee(parsedEmpId, firstName, lastName, parsedAge, parsedDeptId);
            insert(emp);
        } catch (NumberFormatException|SQLException e) {
            e.printStackTrace();
            return null;
        }
        return emp;
    }

    private void insert(Employee emp) throws SQLException {
        try (
                Connection conn = JDBConnect.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            System.out.println("Successfully connected to Database");
            String insertSQL = String.format("insert into employee values (%d, '%s', '%s', %d, %d)",
                    emp.getEmpId(),
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getAge(),
                    emp.getDeptId());
            stmt.executeUpdate(insertSQL);
            conn.commit();
        }
    }
}
