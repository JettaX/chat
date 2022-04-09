package repository;

import entity.User;

import java.util.List;

public interface UserRepository {

    public void saveUser(User user);

    public User getUserById(String userName);

    public User getUserByUserLogin(String userLogin);

    public List<User> getUsers();

    public void deleteUserById(String userName);

}
