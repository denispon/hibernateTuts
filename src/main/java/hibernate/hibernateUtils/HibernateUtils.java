package hibernate.hibernateUtils;


import hibernate.entities.EmpDetails;
import hibernate.entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/hibernate_tut1?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(EmpDetails.class);


        configuration.setProperty("hibernate.connection.driver_class",
                "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url",
                CONNECTION_URL);
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "password");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.connection.pool_size", "10");




        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        ServiceRegistry registry = builder.build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        return sessionFactory;
    }
}
