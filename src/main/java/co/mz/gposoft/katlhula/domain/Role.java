package co.mz.gposoft.katlhula.domain;

public class Role {

    private long id;

    private String description;


    private RoleAccess access;

    public Role(String description, RoleAccess access) {
        this.description = description;
        this.access = access;
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
