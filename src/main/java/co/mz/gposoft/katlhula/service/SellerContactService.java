package co.mz.gposoft.katlhula.service;

import co.mz.gposoft.katlhula.dao.SellerContactRepository;
import co.mz.gposoft.katlhula.domain.SellerContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("katlhula/sellerContact")
public class SellerContactService {

    @Autowired
    private SellerContactRepository sellerContactRepository;


    @PostMapping("/createSellerContact")
    @ResponseStatus(HttpStatus.CREATED)
    public SellerContact createSellerContact(@RequestBody SellerContact sellerContact) {

        return sellerContactRepository.save(sellerContact);
    }

    @PutMapping("/updateSellerContact/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SellerContact> updateSellerContact(@PathVariable(value = "id") Long sellerContactId, @Validated @RequestBody SellerContact sellerContactFeatures) {

        SellerContact sellerContact = sellerContactRepository.findById(sellerContactId).orElseThrow(() -> new RuntimeException("Contacto não encontrado para o ID :: " + sellerContactId));
        sellerContact.setEmail(sellerContactFeatures.getEmail());
        sellerContact.setName(sellerContactFeatures.getName());
        sellerContact.setCellphones(sellerContactFeatures.getCellphones());

        return ResponseEntity.ok(sellerContactRepository.save(sellerContact));
    }

    @GetMapping("/sellerContactById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SellerContact> getSellerContactById(@PathVariable(value = "id") Long sellerContactId) {

        SellerContact sellerContact = sellerContactRepository.findById(sellerContactId).orElseThrow(() -> new RuntimeException("Contacto não encontrado para o ID :: " + sellerContactId));

        return ResponseEntity.ok().body(sellerContact);

    }

    @GetMapping("/allSellerContacts")
    @ResponseStatus(HttpStatus.OK)
    public List<SellerContact> getAllSellerContacts() {

        return sellerContactRepository.findAll();
    }


    @DeleteMapping("/removeSellerContact/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteSellerContact(@PathVariable(value = "id") Long sellerContactId) {

        SellerContact sellerContact = sellerContactRepository.findById(sellerContactId).orElseThrow(() -> new RuntimeException("Contacto não encontrado para o ID :: " + sellerContactId));

        sellerContactRepository.delete(sellerContact);

        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Contacto removido", Boolean.TRUE);

        return resposta;
    }
}
