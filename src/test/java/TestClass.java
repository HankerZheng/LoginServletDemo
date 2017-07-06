import net.antra.hanz.model.Dept;
import net.antra.hanz.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by hanzheng on 7/5/17.
 */
public class TestClass {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoginServletDemo");

        EntityManager em = emf.createEntityManager();

        List<Employee> empList = em.createQuery("select c from Employee c").getResultList();

        for(Employee emp: empList){
            System.out.println(emp.getFirstName());
            System.out.println(emp.getDept().getDeptName());
        }

        List<Dept> deptList = em.createQuery("select c from Dept c").getResultList();
        for(Dept dept: deptList){
            System.out.println(dept.getDeptName());
        }

    }
}
