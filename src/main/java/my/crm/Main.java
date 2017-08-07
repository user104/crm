package my.crm;

import my.crm.entity.Authority;
import my.crm.entity.Company;
import my.crm.entity.ContactPerson;
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


//            PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
//            String pass = passwordEncoder.encode("12");
//            User customer = new User("mike", pass,"somemail@.com");
//            Authority authority = (Authority) session.createQuery("FROM Authority WHERE role='ROLE_USER'").getSingleResult();
//            customer.getAuthority().add(authority);
//            session.persist(customer);


//            Company company0 = new Company("Smcmp Ltd.", "some address 1", "smcmp.com", "+380999999999", "somemail@qwemail.com", "client");
//            Company company1 = new Company("one more company Ltd.", "one more address", "somewebsite.net", "+1231231230", "somemail@mail.com", "client");
//            Company company2 = new Company("qwerty", "qwerty", "website.net", "+3801231212", "mail@mail.com", "client");
//            Company company3 = new Company("TestCompany", "adress qwerty", "website.com", "+380123456", "mail", "client");
//            session.persist(company0);
//            session.persist(company1);
//            session.persist(company2);
//            session.persist(company3);

//            int setId = 3;
//            Company company = (Company) session.createQuery("FROM Company WHERE id = :companyId").setParameter("companyId", setId).getSingleResult();
//            ContactPerson contactPerson = new ContactPerson("Alexei", "Lawyer", "+222222", "petyaL@mail.ru", company);
//            session.persist(contactPerson);

            session.getTransaction().commit();


        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}
