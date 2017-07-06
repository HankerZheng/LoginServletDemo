package net.antra.hanz.model;


import javax.persistence.*;
import java.util.List;

/**
 * Created by hanzheng on 6/24/17.
 */
@Entity
@Table(name = "department")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "dept_email")
    private String deptEmail;

    @OneToMany(
            targetEntity = Employee.class,
            fetch = FetchType.LAZY,
            mappedBy = "dept")
    private List<Employee> empList;

    public Dept() {
    }


    public Integer getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptEmail() {
        return deptEmail;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDeptEmail(String deptEmail) {
        this.deptEmail = deptEmail;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }
}
