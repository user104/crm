package my.crm.service;

import my.crm.dao.UserDAO;
import my.crm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 2540p on 13.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void createNewUser(User user) {
        userDAO.createNewUser(user);
    }
}
