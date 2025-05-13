package service;

import dao.UserDAO;
import model.User;

public class AuthService {
    private UserDAO userDAO = new UserDAO();

    public User authenticate(String userId, String password) {
        return userDAO.getUser(userId, password);
    }
}
