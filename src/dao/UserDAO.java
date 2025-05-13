package dao;

import model.User;
import java.io.*;
import java.util.*;

public class UserDAO {
    private static final String USER_FILE = "data/users.txt";

    public User getUser(String userId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equalsIgnoreCase(userId)) {
                    return new User(parts[0], parts[2], parts[3], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users.");
            e.printStackTrace();
        }
        return null;
    }
}
