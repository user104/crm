package my.crm.model;

import my.crm.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Action {


    //TODO wild card generics
    public List<Company> companies() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = null;
        try {

            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<Company> listOfCompanies = session.createQuery("FROM Company").getResultList();
            session.getTransaction().commit();
            return listOfCompanies;

        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public List<ContactPerson> persons() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<ContactPerson> listOfPersosns = session.createQuery("FROM ContactPerson").getResultList();
            session.getTransaction().commit();
            return listOfPersosns;

        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public List<Dealings> dealings() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //noinspection JpaQlInspection
            List<Dealings> listOfDealings = session.createQuery("FROM Dealings").getResultList();
            session.getTransaction().commit();
            return listOfDealings;

        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public List<Tasks> tasks() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //noinspection JpaQlInspection
            List<Tasks> listOfTasks = session.createQuery("FROM Tasks").getResultList();
            session.getTransaction().commit();
            return listOfTasks;

        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public boolean checkLogin(String login) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            //noinspection JpaQlInspection
            List<User> users = session.createQuery("FROM User").getResultList();
            session.getTransaction().commit();

            for (User user : users) {
                if (user.getUsername().equals(login)) {
                    return false;
                }
            }
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        return true;
    }

    public boolean checkEmail(String email) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = null;
        try {
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            //noinspection JpaQlInspection
            List<User> users = session.createQuery("FROM User").getResultList();
            session.getTransaction().commit();

            for (User user : users) {
                if (user.getEmail().equals(email)) {
                    return false;
                }
            }
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        return true;
    }

    public void register(String login, String password, String email) {
        if (login != null && password != null && email != null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            SessionFactory factory = null;
            try {

                factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                User user = new User(login, password, email);
                session.persist(user);
                session.getTransaction().commit();

            } finally {
                if (factory != null) {
                    factory.close();
                }
            }
        }
    }

    public void addCompany(String companyName,
                           String companyAddress,
                           String companyWebsite,
                           String companyPhoneNumber,
                           String companyEmail,
                           String contactType) {

        if (companyName != null && companyPhoneNumber != null && contactType != null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            SessionFactory factory = null;
            try {

                factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                Company companie = new Company(companyName,
                        companyAddress,
                        companyWebsite,
                        companyPhoneNumber,
                        companyEmail,
                        contactType);
                session.persist(companie);
                session.getTransaction().commit();

            } finally {
                if (factory != null) {
                    factory.close();
                }
            }
        }
    }

    public void addContact(String conactName,
                           String conactPosition,
                           String conactPhoneNumber,
                           String conactEmail,
                           Company companies) {

        if (conactName != null && conactPosition != null && conactPhoneNumber != null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            SessionFactory factory = null;
            try {

                factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                ContactPerson contactPerson = new ContactPerson(conactName,
                        conactPosition,
                        conactPhoneNumber,
                        conactEmail,
                        companies);
                session.persist(contactPerson);
                session.getTransaction().commit();

            } finally {
                if (factory != null) {
                    factory.close();
                }
            }
        }
    }
}
