package mate.academy.internetshop.model;

import java.util.HashSet;
import java.util.Set;
import mate.academy.internetshop.db.Storage;

public class User {
    private long id;
    private String name;
    private String password;
    private String login;
    private Set<Role> roles = new HashSet<>();

    public User(String login, String password) {
        this.id = Storage.userId;
        this.password = password;
        this.login = login;
        this.name = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRoles(Role role) {
        roles.add(role);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id
                + ", name='" + name
                + '\'' + ", password='"
                + password + '\'' + ", login='"
                + login + '\'' + ", roles="
                + roles + '}';
    }
}
