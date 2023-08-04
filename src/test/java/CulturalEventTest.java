import co.mz.gposoft.katlhula.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CulturalEventTest {

    private CulturalEvent culturalEvent;


    @BeforeEach
    public void init() {


        Role roles = new Role("normal-user", RoleAccess.NORMAL_USER);
        User user = new User("milton", "milton123", roles, "milton@email.co.mz");

        culturalEvent = new CulturalEvent("Panda e os Caricas", LocalDate.now(),
                "Parque dos continuadores", "Das 11h30 - 00h00", "VIVO", user);
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

}
