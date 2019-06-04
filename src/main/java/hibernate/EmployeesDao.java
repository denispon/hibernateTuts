package hibernate;

import hibernate.entities.Employee;
import hibernate.hibernateUtils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    public List<Employee> getEmployeeList(){

        Session session = null;
        List<Employee> empList = new ArrayList<>();
        try {
            session = HibernateUtils.getSessionFactory().getCurrentSession();
            String queryStr = "select emp from Employee emp";
            Query query = session.createQuery(queryStr);
            empList = query.list();
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return empList;
    }

    public static void main(String a[]) {

        EmployeesDao empDao = new EmployeesDao();
        System.out.println("---------------------------");

        List<Employee> empList = empDao.getEmployeeList();
        System.out.println("emp size: "+empList.size());
        empList.stream().forEach(System.out::println);

        System.out.println("---------------------------");
    }
}