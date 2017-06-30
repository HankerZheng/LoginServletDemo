package net.antra.hanz.service;

import net.antra.hanz.model.Dept;
import net.antra.hanz.util.JDBConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

/**
 * Created by hanzheng on 6/26/17.
 */
public class AddDeptService extends AbstractService<Dept>{

    private String deptId;
    private String deptName;
    private String deptEmail;

    public AddDeptService(String deptId, String deptName, String deptEmail) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptEmail = deptEmail;
    }


    @Override
    public Dept service() {
        Dept dept;
        try {
            Integer parsedDeptId = Integer.parseInt(deptId);
            dept = new Dept(parsedDeptId, deptName, deptEmail);
            insert(dept);
        } catch (NumberFormatException|SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dept;
    }

    private void insert(Dept dept) throws SQLException {
        try(
                Connection conn = JDBConnect.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            System.out.println("Successfully connected to Database");
            String insertSQL = String.format("insert into department values (%d, '%s', '%s')",
                    dept.getDeptId(),
                    dept.getDeptName(),
                    dept.getDeptEmail());
            stmt.executeUpdate(insertSQL);
            conn.commit();
        }
    }
}
