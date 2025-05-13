package service;

import model.User;
import java.util.Map;

public class AuthService {
    private Map<String, User> users;

    public AuthService(Map<String, User> users) {
        this.users = users;
    }

    public User login(String id, String password) {
        User user = users.get(id);
        if (user != null && user.authenticate(password)) {
            return user;
        }
        return null;
    }
}
