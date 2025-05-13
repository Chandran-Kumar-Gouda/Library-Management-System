package service;

import model.User;
import dao.UserDAO;

public class AuthService {
    private UserDAO userDAO;

    public AuthService() {
        userDAO = new UserDAO();
    }

    public User authenticate(String userId, String password) {
        User user = userDAO.getUser(userId);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
