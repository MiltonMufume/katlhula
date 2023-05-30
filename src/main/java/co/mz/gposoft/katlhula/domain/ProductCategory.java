package co.mz.gposoft.katlhula.domain;

public enum ProductCategory {

    FOOD(1), CLEANING(2), CLOTHES(3), HARDWARE(4), TECHNOLOGY(5);

    private int category;

    private ProductCategory(int category) {

        this.category = category;

    }

    public int getCategory() {
        return this.category;
    }
}
