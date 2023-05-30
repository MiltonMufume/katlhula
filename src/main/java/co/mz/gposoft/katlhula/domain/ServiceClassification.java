package co.mz.gposoft.katlhula.domain;

public enum ServiceClassification {

    ONE_STAR(1),
    TWO_STARS(2),
    THREE_STARS(3),
    FOUR_STARS(4),
    FIVE_STARS(5);
    private int classification;

    private ServiceClassification(int classification) {

        this.classification = classification;
    }

    public int getClassification() {
        return this.classification;
    }
}
