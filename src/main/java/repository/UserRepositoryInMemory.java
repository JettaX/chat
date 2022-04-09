package repository;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryInMemory {

    public static List<User> list = new ArrayList<>();

    public static void saveUser(User user) {
        list.add(user);
    }

    public static User getUserById(String userName) {
        for (User user : list) {
            if (user.getUserLogin().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public static User getUserByUserLogin(String userLogin) {
        for (User user : list) {
            if (user.getUserLogin().toLowerCase().equals(userLogin.toLowerCase())) {
                return user;
            }
        }
        return null;
    }

    public static List<User> getUsers() {
        return list;
    }

    public static void deleteUserById(String userName) {
        list.removeIf(user -> user.getUserLogin().equals(userName));
    }
}
