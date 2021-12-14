package testgroup.filmography.dao;

import org.springframework.stereotype.Repository;
import testgroup.filmography.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select  user from User user", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) { entityManager.persist(user); }

    @Override
    public User readUser(Long id) { return entityManager.find(User.class, id); }

    @Override
    public User delete(Long id) {
        User user = readUser(id);
        entityManager.remove(user);
        return  user;
    }

    @Override
    public void update(User user) { entityManager.merge(user); }
}



