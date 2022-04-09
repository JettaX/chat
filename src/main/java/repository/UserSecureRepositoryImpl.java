package repository;

import entity.UserSecure;

import java.util.ArrayList;
import java.util.List;

public class UserSecureRepositoryImpl {
    public static List<UserSecure> list = new ArrayList<>();

    public static void createUserSecure(String login, String password) {
        list.add(new UserSecure(login, password));
    }

    public static void createUserSecure(UserSecure userSecure) {
        list.add(userSecure);
    }

    public static boolean checkAuth(String login, String password) {
        for (UserSecure user : list) {
            if (user.getUserLogin().equals(login)) {
                return user.getUserPassword().equals(password);
            }
        }
        return false;
    }
}
