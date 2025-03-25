package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getAll();

    void updateUser(User user);

    void removeUserById(long id);

    User getUserById(long id);

}
