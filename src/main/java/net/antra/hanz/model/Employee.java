package net.antra.hanz.model;

import java.util.Date;

/**
 * Created by hanzheng on 6/24/17.
 */
public class Employee {
    private Integer empId;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer deptId;

    public Employee(Integer empId, String firstName, String lastName, Integer age, Integer deptId) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.deptId = deptId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getDeptId() {
        return deptId;
    }
}
