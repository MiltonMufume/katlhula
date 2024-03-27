import co.mz.gposoft.katlhula.KatlhulaApplication;
import co.mz.gposoft.katlhula.dao.RestaurantRepository;
import co.mz.gposoft.katlhula.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KatlhulaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestaurantTest {


    private Restaurant restaurant;

    private List<Restaurant> restaurantList;

    @Autowired
    RestaurantRepository restaurantRepository;


    @BeforeEach
    public void init() {

        Utilizador utilizador = new Utilizador("Milton Mufume", "passerrfv", null, "miltonmufume@gmail.com");

        Restaurant restaurant1 = new Restaurant("Bel Piatto", "Av. Marginal", "09h00 - 23h00", ServiceClassification.THREE_STARS, RestaurantCategory.GOURMET, null, null, utilizador);
        Restaurant restaurant2 = new Restaurant("Bom Garfo", "Av. Julius Nyerere", "09h00 - 23h00", ServiceClassification.FOUR_STARS, RestaurantCategory.BARBEQUE, null, null, utilizador);
        Restaurant restaurant3 = new Restaurant("Zambi", "Av. 10 de  Novembro", "09h00 - 23h00", ServiceClassification.FIVE_STARS, RestaurantCategory.GOURMET, null, null, utilizador);
        Restaurant restaurant4 = new Restaurant("kfc-baixa", "Av. 25 de Setembro", "09h00 - 23h00", ServiceClassification.TWO_STARS, RestaurantCategory.FAST_FOOD, null, null, utilizador);
        Restaurant restaurant5 = new Restaurant("Mimmos 24", "Av. 24 de Julho", "09h00 - 23h00", ServiceClassification.THREE_STARS, RestaurantCategory.FAST_FOOD, null, null, utilizador);

        restaurant = new Restaurant("Mimmos 24", "Av. 24 de Julho", "09h00 - 23h00", ServiceClassification.THREE_STARS, RestaurantCategory.FAST_FOOD, null, null, null);

        restaurantList = Arrays.asList(restaurant1, restaurant2, restaurant3, restaurant4, restaurant5);


    }

    @Test
    public void testCreateRestaurantOnDatabase() {

        restaurantRepository.save(restaurant);
        Assertions.assertThat(restaurant.getId()).isNotNull();
        Assertions.assertThat(restaurant.getDescription()).isEqualToIgnoringCase("Mimmos 24");

    }

    @Test
    public void testReadRestaurantOnDatabase() {

        restaurantRepository.save(restaurant);

        Optional<Restaurant> restaurant1 = restaurantRepository.findById(restaurant.getId());

        Assertions.assertThat(restaurant1.get().getDescription()).isEqualToIgnoringCase("Mimmos 24");


    }

    @Test
    public void testUpdateRestaurantOnDatabase() {

        restaurantRepository.save(restaurant);
        restaurant.setDescription("Takdir");
        restaurantRepository.save(restaurant);
        Assertions.assertThat(restaurant.getId()).isNotNull();
        Assertions.assertThat(restaurant.getDescription()).isEqualToIgnoringCase("Takdir");

    }

    @Test
    public void testDeleteRestaurantOnDatabase() {

        Restaurant rstrnt = new Restaurant("Mimmos 24", "Av. 24 de Julho", "09h00 - 23h00", ServiceClassification.THREE_STARS, RestaurantCategory.FAST_FOOD, null, null, null);
        restaurantRepository.save(rstrnt);
        restaurantRepository.delete(rstrnt);
        Assertions.assertThat(rstrnt.getId()).isNotNull();


    }

}
