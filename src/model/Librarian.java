package model;

public class Librarian extends User {
    public Librarian(String id, String name, String password) {
        super(id, name, password);
    }

    @Override
    public String getRole() {
        return "LIBRARIAN";
    }
}
