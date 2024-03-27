package co.mz.gposoft.katlhula.service;

import co.mz.gposoft.katlhula.dao.ProductToSellRepository;
import co.mz.gposoft.katlhula.domain.ProductToSell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("katlhula/productTosell")
public class ProductToSellService {

    @Autowired
    private ProductToSellRepository productToSellRepository;


    @PostMapping("/createProductToSell")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductToSell createProductToSell(@RequestBody ProductToSell productToSell) {

        return productToSellRepository.save(productToSell);
    }

    @PutMapping("/updateProductToSell/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductToSell> updateProductToSell(@PathVariable(value = "id") Long productToSellId, @Validated @RequestBody ProductToSell productToSellFeatures) {

        ProductToSell productToSell = productToSellRepository.findById(productToSellId).orElseThrow(() -> new RuntimeException("Produto a vender não encontrado para o ID :: " + productToSellId));
        productToSell.setDescription(productToSellFeatures.getDescription());
        productToSell.setCategory(productToSellFeatures.getCategory());
        productToSell.setClassification(productToSellFeatures.getClassification());
        productToSell.setContacts(productToSellFeatures.getContacts());
        productToSell.setLocation(productToSellFeatures.getLocation());
        productToSell.setPhoto(productToSellFeatures.getPhoto());
        productToSell.setStatus(productToSellFeatures.getStatus());

        return ResponseEntity.ok(productToSellRepository.save(productToSell));
    }

    @GetMapping("/productToSellById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductToSell> getProductToSellById(@PathVariable(value = "id") Long productToSellId) {

        ProductToSell ProductToSell = productToSellRepository.findById(productToSellId).orElseThrow(() -> new RuntimeException("Produto a vender não encontrado para o ID :: " + productToSellId));

        return ResponseEntity.ok().body(ProductToSell);

    }

    @GetMapping("/allProductToSells")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductToSell> getAllProductToSells() {

        return productToSellRepository.findAll();
    }


    @DeleteMapping("/inactivateProductToSell/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteProductToSell(@PathVariable(value = "id") Long productToSellId) {

        ProductToSell productToSell = productToSellRepository.findById(productToSellId).orElseThrow(() -> new RuntimeException("Produto a vender não encontrado para o ID :: " + productToSellId));
        productToSell.remove();
        productToSellRepository.save(productToSell);

        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Produto inactivado", Boolean.TRUE);

        return resposta;
    }
}
