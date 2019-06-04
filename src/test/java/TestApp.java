import hibernate.entities.EmpDetails;
import hibernate.entities.Employee;
import hibernate.hibernateUtils.HibernateUtils;
import org.hibernate.Session;

public class TestApp {

    public static void main(String[] args){

        Session session = null;
        session = HibernateUtils.getSessionFactory().openSession();

        session.beginTransaction();

        Employee emp = (Employee) session.load(Employee.class, 1L);
        //EmpDetails empDetails = (EmpDetails) session.load(EmpDetails.class, 1L);
        System.out.println(emp);
        //System.out.println(empDetails.getEmployee());
    }
}
