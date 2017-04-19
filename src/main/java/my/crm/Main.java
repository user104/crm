package my.crm;

import my.crm.entity.Authority;
import my.crm.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by 2540p on 15.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        try {

            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();


            PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
            String pass = passwordEncoder.encode("12");
            User customer = new User("mike", pass,"somemail@.com");
            Authority authority = (Authority) session.createQuery("FROM Authority WHERE role='ROLE_USER'").getSingleResult();
            customer.getAuthority().add(authority);
            session.persist(customer);

            session.getTransaction().commit();


        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}
