package net.antra.hanz.model;

/**
 * Created by hanzheng on 6/24/17.
 */
public class Dept {
    private Integer deptId;
    private String deptName;
    private String deptEmail;

    public Dept(Integer deptId, String deptName, String deptEmail) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptEmail = deptEmail;
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

}
