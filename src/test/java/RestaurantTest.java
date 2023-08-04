import co.mz.gposoft.katlhula.domain.*;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class RestaurantTest {


    private Restaurant restaurant;

    private List<Restaurant> restaurantList;

    /***
     * nO FUTURO ESSE TESTE PODERÁ SER UTILIZADO COM CONSULTAS A TABELAS (OU COM MOCKS) ASSIM QUE O JPA FOR IMPMEMENTADO
     */
    @BeforeEach
    public void init() {

        User user = new User("Milton Mufume", "passerrfv", null, "miltonmufume@gmail.com");

        Restaurant restaurant1 = new Restaurant("Bel Piatto", "Av. Marginal", "09h00 - 23h00", ServiceClassification.THREE_STARS, RestaurantCategory.GOURMET, null, null, user);
        Restaurant restaurant2 = new Restaurant("Bom Garfo", "Av. Julius Nyerere", "09h00 - 23h00", ServiceClassification.FOUR_STARS, RestaurantCategory.BARBEQUE, null, null, user);
        Restaurant restaurant3 = new Restaurant("Zambi", "Av. 10 de  Novembro", "09h00 - 23h00", ServiceClassification.FIVE_STARS, RestaurantCategory.GOURMET, null, null, user);
        Restaurant restaurant4 = new Restaurant("kfc-baixa", "Av. 25 de Setembro", "09h00 - 23h00", ServiceClassification.TWO_STARS, RestaurantCategory.FAST_FOOD, null, null, user);
        Restaurant restaurant5 = new Restaurant("Mimmos 24", "Av. 24 de Julho", "09h00 - 23h00", ServiceClassification.THREE_STARS, RestaurantCategory.FAST_FOOD, null, null, user);

        restaurantList = Arrays.asList(restaurant1, restaurant2, restaurant3, restaurant4, restaurant5);


    }

}
