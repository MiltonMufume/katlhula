import co.mz.gposoft.katlhula.KatlhulaApplication;
import co.mz.gposoft.katlhula.dao.CulturalEventRepository;
import co.mz.gposoft.katlhula.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KatlhulaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CulturalEventTest {


    private CulturalEvent culturalEvent;

    private CulturalEvent culturalEventWithoutUser;

    private CulturalEvent culturalEventWithoutUser2;

    @Autowired
    private CulturalEventRepository culturalEventRepository;


    @BeforeEach
    public void init() {


        Role roles = new Role("normal-user", RoleAccess.NORMAL_USER);
        Utilizador utilizador = new Utilizador("milton", "milton123", roles, "milton@email.co.mz");

        culturalEvent = new CulturalEvent("Panda e os Caricas", LocalDate.now(), "Parque dos continuadores", "Das 11h30 - 00h00", "VIVO", utilizador);

        culturalEventWithoutUser = new CulturalEvent("Panda e os Caricas", LocalDate.now(), "Parque dos continuadores", "Das 11h30 - 00h00", "VIVO", null);
        culturalEventWithoutUser2 = new CulturalEvent("HOT BLAZE", LocalDate.now(), "Campo do Maxaquene", "Das 11h30 - 00h00", "VIVO", null);


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

    @Test
    public void testCreateCulturalEventOnDatabase() {

        culturalEventRepository.save(culturalEventWithoutUser);
        Assertions.assertThat(culturalEventWithoutUser.getId()).isNotNull();
        Assertions.assertThat(culturalEventWithoutUser.getOrganizer()).isEqualToIgnoringCase("VIVO");

    }

    @Test
    public void testReadCulturalEventOnDatabase() {

        culturalEventRepository.save(culturalEventWithoutUser2);

        Optional<CulturalEvent> culturalEventId = culturalEventRepository.findById(culturalEventWithoutUser2.getId());

        Assertions.assertThat(culturalEventId.get().getDescription()).isEqualToIgnoringCase("HOT BLAZE");


    }

    @Test
    public void testUpdateCulturalEventOnDatabase() {

        culturalEventRepository.save(culturalEventWithoutUser);
        culturalEventWithoutUser.setOrganizer("CSV");
        culturalEventRepository.save(culturalEventWithoutUser);
        Assertions.assertThat(culturalEventWithoutUser.getId()).isNotNull();
        Assertions.assertThat(culturalEventWithoutUser.getOrganizer()).isEqualToIgnoringCase("CSV");

    }

    @Test
    public void testDeleteCulturalEventOnDatabase() {

        CulturalEvent cultural = new CulturalEvent("HOT BLAZE", LocalDate.now(), "Campo do Maxaquene", "Das 11h30 - 00h00", "VIVO", null);
        culturalEventRepository.save(cultural);
        culturalEventRepository.delete(cultural);
        Assertions.assertThat(cultural.getId()).isNotNull();


    }
}
