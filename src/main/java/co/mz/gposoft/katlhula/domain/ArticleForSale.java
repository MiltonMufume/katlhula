package co.mz.gposoft.katlhula.domain;

import java.util.List;

public class ArticleForSale {

    private long id;

    private List<ProductToSell> products;

    private User createdBy;


    public String notifyProductSearch(String productName) {

        return "";
    }

    public String notifyProductFound(ProductToSell productToSell) {

        return "";
    }

    /*
     * then a set of business and other (CRUD) methods
     * */
}
