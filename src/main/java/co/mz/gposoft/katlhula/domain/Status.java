package co.mz.gposoft.katlhula.domain;

public enum Status {

    ACTIVE("active"), INACTIVE("inactive"), FOR_HAPPEN("for happening");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
