package co.mz.gposoft.katlhula.domain;

public enum ProductClassification {

    VERY_GOOD(1), GOOD(2), BAD(3);
    private int description;

    private ProductClassification(int description) {
        this.description = description;
    }

    public int getDescription() {

        return this.description;
    }
}
