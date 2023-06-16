import co.mz.gposoft.katlhula.dao.CulturalEventRepository;
import co.mz.gposoft.katlhula.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CulturalEventTest {

    private CulturalEvent culturalEvent;

    @Mock
    CulturalEventRepository culturalEventRepository;

    @BeforeEach
    public void init() {

        MockitoAnnotations.initMocks(this);
        Role roles = new Role("normal-user", RoleAccess.NORMAL_USER);
        User user = new User("milton", "milton123", roles);

        culturalEvent = new CulturalEvent("Panda e os Caricas", LocalDate.now(),
                "Parque dos continuadores", "Das 11h30 - 00h00", "VIVO", user, Status.ACTIVE);
    }


    @Test
    public void testInactivarEventoRemovido() {

        culturalEvent.remove();

        assertEquals(Status.INACTIVE, culturalEvent.getStatus());
    }

    @Test
    public void testCreateCulturalEvent() {

        Mockito.when(culturalEventRepository.save(culturalEvent)).thenReturn(culturalEvent);

        Mockito.verify(culturalEventRepository, Mockito.times(1)).save(culturalEvent);

    }
}
