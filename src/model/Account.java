package model;

public class Account {
    private int id;
    private static int idStatic = 1;
    private String username;
    private String password;
    private Role role;

    public Account() {
        this.id = idStatic++;
    }

    public Account(String username, String password, Role role) {
        this.id = idStatic++;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}