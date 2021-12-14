package testgroup.filmography.service;

import testgroup.filmography.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User readUser(Long id);
    User delete(Long id);
    void update(User user);
}
