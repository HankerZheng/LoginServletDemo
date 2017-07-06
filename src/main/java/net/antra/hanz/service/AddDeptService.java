package net.antra.hanz.service;

import net.antra.hanz.model.Dept;
import net.antra.hanz.util.EMFUtil;
import net.antra.hanz.util.JDBConnect;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hanzheng on 6/26/17.
 */
public class AddDeptService extends AbstractService<Dept>{

    private String deptName;
    private String deptEmail;

    public AddDeptService(String deptName, String deptEmail) {
        this.deptName = deptName;
        this.deptEmail = deptEmail;
    }


    @Override
    public Dept service() {
        EntityManager em = EMFUtil.getEMF().createEntityManager();
        em.getTransaction().begin();

        Dept dept = new Dept();
        dept.setDeptName(deptName);
        dept.setDeptEmail(deptEmail);

        em.persist(dept);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return dept;
    }

    @Deprecated
    private void insert(Dept dept) throws SQLException {
        try(
                Connection conn = JDBConnect.getConnection();
                Statement stmt = conn.createStatement()
        ) {
            String insertSQL = String.format("insert into department(dept_name, dept_email) values ('%s', '%s')",
                    dept.getDeptName(),
                    dept.getDeptEmail());
            stmt.executeUpdate(insertSQL);
            conn.commit();
        }
    }
}
