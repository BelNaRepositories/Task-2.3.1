package testgroup.filmography.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.filmography.dao.UserDao;
import testgroup.filmography.model.User;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void saveUser(User user){
        userDao.saveUser(user);
    }

    @Override
    public User readUser(Long id) {
        return userDao.readUser(id);
    }

    @Override
    public User delete(Long id){
        return userDao.delete(id);
    }

    @Override
    public void update(User user){
        userDao.update(user);
    }
}