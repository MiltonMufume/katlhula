package co.mz.gposoft.katlhula.domain;

public enum ProductStatus {

    DISPONIVEL("Disponível"), VENDIDO("Vendido"), RETIDO("Retido para aquisição"), INACTIVO("Inactivo");

    private String description;

    ProductStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
