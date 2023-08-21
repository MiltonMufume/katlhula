package co.mz.gposoft.katlhula.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    private Role roles;

    private String email;

    public User(String username, String password, Role roles, String email) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRoles() {
        return roles;
    }

    public String getEmail() {
        return email;
    }

    public boolean integratedAuthentication() {
        return false;
    }

    /*
     * then a set of business and other (CRUD) methods
     * */

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", email='" + email + '\'' +
                '}';
    }
}
