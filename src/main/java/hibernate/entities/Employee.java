package hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="EMPLOYEES")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="EMP_ID", unique = true, nullable = false)
    private Long empId;

    private String name;

    private String department;

    private Long salary;

    @Column(name="JOINED_ON")
    private Date joinedOn;

    @OneToOne(mappedBy = "employee")
    private EmpDetails empDetails;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Date getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(Date joinedOn) {
        this.joinedOn = joinedOn;
    }

    public EmpDetails getEmpDetails() {
        return empDetails;
    }

    public void setEmpDetails(EmpDetails empDetails) {
        this.empDetails = empDetails;
    }



    @Override
    public String toString() {

        String resp = this.empId+" | "+this.name+" | "+this.department+" | "+this.salary+" | "+this.joinedOn;
        if(this.empDetails != null) {
            resp += "|"+this.empDetails.toString();
        }

        return resp;
    }
}