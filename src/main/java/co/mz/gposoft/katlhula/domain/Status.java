package co.mz.gposoft.katlhula.domain;

public enum Status {

    ACTIVE("active"), INACTIVE("inactive");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
