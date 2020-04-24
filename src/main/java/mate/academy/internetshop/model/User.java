package mate.academy.internetshop.model;

import mate.academy.internetshop.db.Storage;

public class User {
    private long id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.id = Storage.userId;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
