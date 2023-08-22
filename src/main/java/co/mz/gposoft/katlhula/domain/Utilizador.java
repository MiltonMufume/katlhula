package co.mz.gposoft.katlhula.domain;

import javax.persistence.*;

@Entity
@Table(name = "utilizador")
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilizador")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    @OneToOne
    @JoinColumn(name = "role_id")
    private Role roles;

    @Column(name = "email")
    private String email;


    @OneToOne(mappedBy = "createdBy")
    private UserPhoto userPhoto;

    @OneToOne(mappedBy = "createdBy")
    private CulturalEvent culturalEvent;

    @OneToOne(mappedBy = "createdBy")
    Restaurant restaurant;

    public Utilizador(String username, String password, Role roles, String email) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }

    public Utilizador() {

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
