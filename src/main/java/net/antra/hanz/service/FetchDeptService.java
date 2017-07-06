package net.antra.hanz.service;

import net.antra.hanz.model.Dept;
import net.antra.hanz.util.EMFUtil;
import net.antra.hanz.util.JDBConnect;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanzheng on 6/29/17.
 */
public class FetchDeptService extends AbstractService<List<Dept>>{
    @Override
    public List<Dept> service() throws PersistenceException{
        EntityManager em = EMFUtil.getEMF().createEntityManager();
        String jpql = "select c from Dept c";
        List<Dept> deptList = em.createQuery(jpql).getResultList();
        return deptList;
    }
//    @Override
//    public List<Dept> service() {
//        List<Dept> deptList = new ArrayList<>();
//        try (
//                Connection conn = JDBConnect.getConnection();
//                Statement stmt = conn.createStatement();
//        ) {
//            System.out.println("Successfully connected to Database");
//            String selectSQL = "select dept_id, dept_name, dept_email from department";
//            ResultSet rset = stmt.executeQuery(selectSQL);
//            while (rset.next()) {
//                System.out.println("Get one dept from DB: " + rset.getString("dept_name"));
//                Dept dept = new Dept(
//                        rset.getInt("dept_id"),
//                        rset.getString("dept_name"),
//                        rset.getString("dept_email")
//                );
//                deptList.add(dept);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return deptList;
//    }
}
