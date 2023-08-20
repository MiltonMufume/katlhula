package co.mz.gposoft.katlhula.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "article_for_sale")
public class ArticleForSale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_to_sell_id", nullable = false)
    private List<ProductToSell> products;

    @Column(name = "user_id", nullable = false)
    private User createdBy;

    public ArticleForSale(List<ProductToSell> products, User createdBy) {
        this.products = products;
        this.createdBy = createdBy;
    }

    public ArticleForSale() {

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
