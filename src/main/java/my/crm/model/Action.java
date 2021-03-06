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

    public void addContact(String contactName,
                           String contactPosition,
                           String contactPhoneNumber,
                           String contactEmail,
                           String companyId) {

        int setCompanyId = Integer.parseInt(companyId);

        if (contactName != null && contactPosition != null && contactPhoneNumber != null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            SessionFactory factory = null;
            try {

                factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                Company company = (Company) session.createQuery("FROM Company WHERE id = :companyId")
                        .setParameter("companyId", setCompanyId)
                        .getSingleResult();

                ContactPerson contactPerson = new ContactPerson(contactName,
                        contactPosition,
                        contactPhoneNumber,
                        contactEmail,
                        company);

                session.persist(contactPerson);
                session.getTransaction().commit();

            } finally {
                if (factory != null) {
                    factory.close();
                }
            }
        }
    }

    public void addDeal(String dealName,
                           String dealBudget,
                           String dealStatus,
                           String dealStage,
                           String contactPersonId) {

        int setPersonId = Integer.parseInt(contactPersonId);

        if (dealName != null && dealBudget != null && dealStatus != null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            SessionFactory factory = null;
            try {

                factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                ContactPerson contactPerson = (ContactPerson) session.createQuery("FROM ContactPerson WHERE id = :contactId")
                        .setParameter("contactId", setPersonId)
                        .getSingleResult();

                Dealings dealings = new Dealings(dealName,
                        dealBudget,
                        dealStatus,
                        dealStage,
                        contactPerson);

                session.persist(dealings);
                session.getTransaction().commit();

            } finally {
                if (factory != null) {
                    factory.close();
                }
            }
        }
    }

    public void addTask(String taskName,
                        String deadline,
                        String taskStatus,
                        String DealId) {

        int setDealId = Integer.parseInt(DealId);

        if (taskName != null && deadline != null && taskStatus != null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            SessionFactory factory = null;
            try {

                factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                Dealings deal = (Dealings) session.createQuery("FROM Dealings WHERE id = :dealId")
                        .setParameter("dealId", setDealId)
                        .getSingleResult();

                Tasks tasks = new Tasks(taskName,
                        deadline,
                        taskStatus,
                        deal);

                session.persist(tasks);
                session.getTransaction().commit();

            } finally {
                if (factory != null) {
                    factory.close();
                }
            }
        }
    }
}
