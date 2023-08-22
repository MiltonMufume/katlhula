import co.mz.gposoft.katlhula.KatlhulaApplication;
import co.mz.gposoft.katlhula.dao.CulturalEventRepository;
import co.mz.gposoft.katlhula.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KatlhulaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CulturalEventTest {


    private CulturalEvent culturalEvent;

    @Autowired
    private CulturalEventRepository culturalEventRepository;


    @BeforeEach
    public void init() {


        Role roles = new Role("normal-user", RoleAccess.NORMAL_USER);
        Utilizador utilizador = new Utilizador("milton", "milton123", roles, "milton@email.co.mz");

        culturalEvent = new CulturalEvent("Panda e os Caricas", LocalDate.now(),
                "Parque dos continuadores", "Das 11h30 - 00h00", "VIVO", utilizador);


    }


    @Test
    public void testInactivarEventoRemovido() {

        culturalEvent.remove();

        assertEquals(Status.INACTIVE, culturalEvent.getStatus());
    }


    @Test
    public void testEventoFuturo() {

        culturalEvent.setEventDate(LocalDate.of(Year.now().getValue(), Month.DECEMBER.getValue(), 25));

        assertEquals(Status.FOR_HAPPEN, culturalEvent.getStatus());
    }

    @Test
    public void testReactivarEvento() {

        culturalEvent.setEventDate(LocalDate.now());

        assertEquals(Status.ACTIVE, culturalEvent.getStatus());
    }

    // @Test
    public void testCreateCulturalEventIntoDb() {

        CulturalEvent eventInDb = culturalEventRepository.save(culturalEvent);

        assertEquals(culturalEvent.getDescription(), eventInDb.getDescription());
    }

}
