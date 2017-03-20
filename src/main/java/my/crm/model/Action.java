package my.crm.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;;
import java.util.List;

public class Action {
    private String url = "jdbc:mysql://127.0.0.1:3306?useSSL=false";
    private String loginDB = "root";
    private String passwordDB = "root";


    public List<Companies> companies() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Companies.class)
                .buildSessionFactory();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //noinspection JpaQlInspection
            List<Companies> listOfCompanies = session.createQuery("FROM Companies").getResultList();
            session.getTransaction().commit();
            return listOfCompanies;

        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    public List<ContactPerson> persons() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ContactPerson.class)
                .buildSessionFactory();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //noinspection JpaQlInspection
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
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dealings.class)
                .buildSessionFactory();
        try {
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
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dealings.class)
                .buildSessionFactory();
        try {
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

    public boolean login(String login, String password) {
        if (login != null) {
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, loginDB, passwordDB);
                conn.setCatalog("crm_database");
                String query = "SELECT password FROM user WHERE login =?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, login);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if (password.equals(rs.getString("password"))) {
                        return true;
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    public String register(String login, String password, String email) {
        if (login != null && password != null && email != null) {
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, loginDB, passwordDB);
                conn.setCatalog("crm_database");
                String verifyLogin = "SELECT login FROM user WHERE login=?";

                PreparedStatement psLogin = conn.prepareStatement(verifyLogin);
                psLogin.setString(1, login);
                ResultSet rsLogin = psLogin.executeQuery();
                if (rsLogin.next()) {
                    return "Login is already in use";
                }
                String verifyEmail = "SELECT email FROM user WHERE email=?";
                PreparedStatement psEmail = conn.prepareStatement(verifyEmail);
                psEmail.setString(1, email);
                ResultSet rsEmail = psEmail.executeQuery();
                if (rsEmail.next()) {
                    return "Email is already in use";
                } else {
                    String addUser = "INSERT INTO user(login, password, email) VALUES(?,?,?);";
                    PreparedStatement psAddUser = conn.prepareStatement(addUser);
                    psAddUser.setString(1, login);
                    psAddUser.setString(2, password);
                    psAddUser.setString(3, email);
                    psAddUser.executeUpdate();
                    return "Your registration has been successful!";
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "An unknown error has occured during registration. Please try again.";
    }
}
