package sessionFactory;

import entity.Employee;
import entity.Password;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import javax.persistence.Query;


public class SessionFactoryImpl {

    private SessionFactoryImpl() {
    }

    private static SessionFactory sessionFactory;

    private static Session session;

    public static Session createHibernateSession() {
        SessionFactory sf = null;
        try {
            Configuration conf = new Configuration();
            conf.configure("resources/hibernate.cfg.xml");

            sf = conf.buildSessionFactory();
            session = sf.openSession();
            System.out.println("Create session");
            System.out.println("\n\nRead object");
            //-----------SQL---------------
        /*   String sql = "select person_id, price, fname, lname from countsals";
            Query query = session.createSQLQuery(sql);

            List<Object[]> rows = query.list();

            for (Object[] row : rows) {
                Employee employee = new Employee();
                employee.setPersonId(Integer.valueOf(row[0].toString()));
                employee.setPrice(row[1].toString());
                employee.setfName(row[2].toString());
                employee.setlName(row[3].toString());
                System.out.println(employee.toString());
            }*/
            //-----------------------------
            //  System.out.println("\n\nЧтение записей : SQL");
          /*  //--------SQL---------
            // Использование native SQL query
            String sql = "select person_id, price, fname, lname from countsals";
            Query query = session.createSQLQuery(sql).addEntity(Employee.class);

            List<Employee> employeeList = query.list();
            
            for (Iterator<Employee> it = employeeList.iterator(); it.hasNext();) {
                Employee employee = (Employee) it.next();
                System.out.println(employee.toString());}*/
            //--------------------
         /*   //-----CRITERIA-----
            Criteria criteria = session.createCriteria (Password.class);
            criteria.setFirstResult(1);
            criteria.setMaxResults (1000);
            List<Password> passwordList = criteria.list();
            for (Password password : passwordList)
                System.out.println(password);
            //-------------------*/
        } catch (HibernateException exception) {
            System.out.println("Problem creating session factory");
            exception.printStackTrace();
        }
        return session;
    }
    //--------------------------------------------------

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(Password.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception! " + e);
            }
        }
        return sessionFactory;
    }
}
