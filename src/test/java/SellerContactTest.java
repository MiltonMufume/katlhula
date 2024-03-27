import co.mz.gposoft.katlhula.KatlhulaApplication;
import co.mz.gposoft.katlhula.dao.SellerContactRepository;
import co.mz.gposoft.katlhula.domain.SellerContact;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KatlhulaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SellerContactTest {


    @Autowired
    private SellerContactRepository sellerContactRepository;

    private SellerContact sellerContact;


    @BeforeEach
    public void init() {


        List<String> sellerContactList = Arrays.asList(new String("825168041"), new String("845168041"), new String("875168041"));
        sellerContact = new SellerContact("miltonmufume@gmail.com", sellerContactList, "Milton Mufume");

    }

    @Test
    public void testCreateSellerContactOnDatabase() {

        sellerContactRepository.save(sellerContact);
        Assertions.assertThat(sellerContact.getId()).isNotNull();
        Assertions.assertThat(sellerContact.getName()).isEqualToIgnoringCase("Milton Mufume");

    }

    @Test
    public void testReadSellerContactOnDatabase() {

        sellerContactRepository.save(sellerContact);

        Optional<SellerContact> sellerContact1 = sellerContactRepository.findById(sellerContact.getId());

        Assertions.assertThat(sellerContact.getName()).isEqualToIgnoringCase("Milton Mufume");


    }

    @Test
    public void testUpdateSellerContactOnDatabase() {

        sellerContactRepository.save(sellerContact);
        sellerContact.setEmail("fernando.mufume@gmail.com");
        sellerContactRepository.save(sellerContact);
        Assertions.assertThat(sellerContact.getId()).isNotNull();
        Assertions.assertThat(sellerContact.getEmail()).isEqualToIgnoringCase("fernando.mufume@gmail.com");


    }

    @Test
    public void testDeleteSellerContactOnDatabase() {


        List<String> sellerContactList = Arrays.asList(new String("825168041"), new String("845168041"), new String("875168041"));
        SellerContact sellerContactToDel = new SellerContact("miltonmufume@gmail.com", sellerContactList, "Milton Mufume");

        sellerContactRepository.save(sellerContactToDel);
        sellerContactRepository.delete(sellerContactToDel);
        Assertions.assertThat(sellerContactToDel.getId()).isNotNull();


    }
}
