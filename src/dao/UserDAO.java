package dao;

import model.*;

import java.io.*;
import java.util.*;

public class UserDAO {
    public static Map<String, User> loadUsers(String path) {
        Map<String, User> users = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String role = parts[0];
                if (role.equals("LIBRARIAN")) {
                    users.put(parts[1], new Librarian(parts[1], parts[2], parts[3]));
                } else if (role.equals("MEMBER")) {
                    users.put(parts[1], new Member(parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users.");
        }
        return users;
    }
}
