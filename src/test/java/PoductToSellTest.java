import co.mz.gposoft.katlhula.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoductToSellTest {


    private ProductToSell productToSell;

    @BeforeEach
    public void init() {

        SellerContact sellerContacts = new SellerContact("miltonmufume@gmail.com", Arrays.asList("825168041", "826955291", "875168041"), "Milton Mufume");
        productToSell = new ProductToSell("iPhone14", "Malhangalene", sellerContacts, ProductClassification.GOOD, ProductCategory.TECHNOLOGY, null, ProductStatus.DISPONIVEL);
    }


    @Test
    public void testInactivateRemovedProduct() {

        productToSell.remove();

        assertEquals(ProductStatus.INACTIVO, productToSell.getStatus());

    }

    @Test
    public void testProdutoDisponivel() {

        assertEquals(ProductStatus.DISPONIVEL, productToSell.getStatus());

    }


    @Test
    public void testProdutoVendido() {

        productToSell.productSold();

        assertEquals(ProductStatus.VENDIDO, productToSell.getStatus());

    }


}
