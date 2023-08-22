package co.mz.gposoft.katlhula.domain;


import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "role_access")
    private RoleAccess access;

    @OneToOne(mappedBy = "roles")
    private Utilizador utilizador;

    public Role(String description, RoleAccess access) {
        this.description = description;
        this.access = access;
    }

    public Role() {

    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public RoleAccess getAccess() {
        return access;
    }

    /*
     * then a set of business and other (CRUD) methods
     * */

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", access=" + access +
                '}';
    }
}
