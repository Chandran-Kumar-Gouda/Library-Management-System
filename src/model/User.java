package model;

public class User {
    private String userId;
    private String name;
    private String password;
    private String userType; // "LIBRARIAN" or "MEMBER"
    
    public User(String userId, String name, String password, String userType) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public String getName() {
        return name;
    }
}
