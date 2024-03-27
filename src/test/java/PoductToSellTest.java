import co.mz.gposoft.katlhula.KatlhulaApplication;
import co.mz.gposoft.katlhula.dao.ProductToSellRepository;
import co.mz.gposoft.katlhula.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

 @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KatlhulaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PoductToSellTest {


    private ProductToSell productToSell;

    private ProductToSell productToSellWithoutContact;

    @Autowired
    ProductToSellRepository productToSellRepository;

    @BeforeEach
    public void init() {

        SellerContact sellerContacts = new SellerContact("miltonmufume@gmail.com", Arrays.asList("825168041", "826955291", "875168041"), "Milton Mufume");
        productToSell = new ProductToSell("iPhone14", "Malhangalene", sellerContacts, ProductClassification.GOOD, ProductCategory.TECHNOLOGY, null, ProductStatus.DISPONIVEL);

        productToSellWithoutContact = new ProductToSell("android11", "Malhangalene", null, ProductClassification.GOOD, ProductCategory.TECHNOLOGY, null, ProductStatus.DISPONIVEL);
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


    @Test
    public void testCreateProductToSellOnDatabase() {

        productToSellRepository.save(productToSellWithoutContact);
        Assertions.assertThat(productToSellWithoutContact.getId()).isNotNull();
        Assertions.assertThat(productToSellWithoutContact.getDescription()).isEqualToIgnoringCase("android11");

    }

    @Test
    public void testReadProductToSellOnDatabase() {

        productToSellRepository.save(productToSellWithoutContact);

        Optional<ProductToSell> productToSell = productToSellRepository.findById(productToSellWithoutContact.getId());

        Assertions.assertThat(productToSell.get().getDescription()).isEqualToIgnoringCase("android11");


    }

    @Test
    public void testUpdateProductToSellOnDatabase() {

        productToSellRepository.save(productToSellWithoutContact);
        productToSellWithoutContact.setDescription("TV Smart");
        productToSellRepository.save(productToSellWithoutContact);
        Assertions.assertThat(productToSellWithoutContact.getId()).isNotNull();
        Assertions.assertThat(productToSellWithoutContact.getDescription()).isEqualToIgnoringCase("TV Smart");

    }

    @Test
    public void testDeleteProductToSellOnDatabase() {

        ProductToSell product = new ProductToSell("android11", "Malhangalene", null, ProductClassification.GOOD, ProductCategory.TECHNOLOGY, null, ProductStatus.DISPONIVEL);
        productToSellRepository.save(product);
        productToSellRepository.delete(product);
        Assertions.assertThat(product.getId()).isNotNull();


    }

}
