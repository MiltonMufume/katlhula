package co.mz.gposoft.katlhula.domain;

import java.util.List;

public class ArticleForSale {

    private long id;

    private List<ProductToSell> products;

    private User createdBy;

    public ArticleForSale(List<ProductToSell> products, User createdBy) {
        this.products = products;
        this.createdBy = createdBy;
    }

    public long getId() {
        return id;
    }

    public List<ProductToSell> getProducts() {
        return products;
    }

    public User getCreatedBy() {
        return createdBy;
    }


    /*
     * then a set of business and other (CRUD) methods
     * */

    @Override
    public String toString() {
        return "ArticleForSale{" +
                "id=" + id +
                ", products=" + products +
                ", createdBy=" + createdBy +
                '}';
    }


}
