package co.mz.gposoft.katlhula.service;

import co.mz.gposoft.katlhula.domain.ProductToSell;

public interface KatlhulaNotification {

    public String notifyProductSearch(String productName);

    public String notifyProductFound(ProductToSell productToSell);
}
