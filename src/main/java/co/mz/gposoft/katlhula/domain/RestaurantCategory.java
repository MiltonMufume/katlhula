package co.mz.gposoft.katlhula.domain;

public enum RestaurantCategory {
    GOURMET(1), FAST_FOOD(2), BARBEQUE(3);
    private int description;

    private RestaurantCategory(int description) {
        this.description = description;
    }

    public int getDescription() {

        return this.description;
    }
}
