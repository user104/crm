package my.crm.dao;

import my.crm.entity.Authority;
import my.crm.entity.Company;
import my.crm.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 * Created by 2540p on 13.04.2017.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createNewUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Authority authority = (Authority) session.createQuery("FROM Authority WHERE role='ROLE_USER'").getSingleResult();
        user.getAuthority().add(authority);
        session.persist(user);
    }

    @Override
    public void saveCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(company);
    }
}
