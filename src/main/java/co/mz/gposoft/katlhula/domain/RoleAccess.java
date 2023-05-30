package co.mz.gposoft.katlhula.domain;

public enum RoleAccess {
    SERVICE_ADMIN("admin"), NORMAL_USER("normal_access");

    private String access;

    private RoleAccess(String access) {
        this.access = access;
    }

    public String getAccess() {
        return access;
    }
}
