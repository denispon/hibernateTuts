import hibernate.entities.EmpDetails;
import hibernate.entities.Employee;
import hibernate.hibernateUtils.HibernateUtils;
import org.hibernate.Session;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestApp2 {
    public static void main(String[] args) throws ParseException {

        Session session =  HibernateUtils.getSessionFactory().openSession();

        session.beginTransaction();

        Employee newEmp = new Employee();
        newEmp.setName("Abdullah");
        newEmp.setDepartment("Security");
        newEmp.setSalary(20000L);
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        Date date = format.parse("2019-026-04 09:00:00");
        newEmp.setJoinedOn(date);

        EmpDetails newEmpDetails = new EmpDetails();
        newEmpDetails.setAddress("Hyderabad");
        newEmpDetails.setGender("Male");
        newEmpDetails.setYearsOfService(4L);
        newEmpDetails.setBankAccount("0002311");

        newEmpDetails.setEmployee(newEmp);
        session.save(newEmpDetails);
        session.save(newEmp);


        session.getTransaction().commit();
        session.close();
    }
}
