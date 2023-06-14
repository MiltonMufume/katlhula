import co.mz.gposoft.katlhula.domain.*;
import junit.framework.TestCase;

import java.time.LocalDate;

public class CulturalEventTest extends TestCase {

    public void testInactivarEventoRemovido() {

        Role roles = new Role("normal-user", RoleAccess.NORMAL_USER);
        User user = new User("milton", "milton123", roles);

        CulturalEvent culturalEvent = new CulturalEvent("Panda e os Caricas", LocalDate.now(),
                "Parque dos continuadores", "Das 11h30 - 00h00", "VIVO", user, Status.ACTIVE);

        culturalEvent.remove();
        assertEquals(Status.INACTIVE, culturalEvent.getStatus());
    }
}
