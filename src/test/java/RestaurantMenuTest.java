import co.mz.gposoft.katlhula.KatlhulaApplication;
import co.mz.gposoft.katlhula.dao.RestaurantMenuRepository;
import co.mz.gposoft.katlhula.domain.RestaurantMenu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

 @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KatlhulaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestaurantMenuTest {

    @Autowired
    RestaurantMenuRepository restaurantMenuRepository;

    RestaurantMenu restaurantMenu;

    @BeforeEach
    public void init() {

        Map<String, Double> menuList = new HashMap<String, Double>();
        menuList.put("Pão de alho", 350d);
        menuList.put("Bitoque", 680d);
        menuList.put("Dose de batas fritas", 200d);
        menuList.put("6 chamussas", 300d);
        menuList.put("Fat Bastard", 1500d);

        restaurantMenu = new RestaurantMenu(null, menuList);

    }

    @Test
    public void testCreateRestaurantMenuOnDatabase() {

        restaurantMenuRepository.save(restaurantMenu);
        Assertions.assertThat(restaurantMenu.getId()).isNotNull();
        Assertions.assertThat(restaurantMenu.getMenu().size()).isEqualTo(5);

    }

    @Test
    public void testReadRestaurantMenuOnDatabase() {

        restaurantMenuRepository.save(restaurantMenu);

        Optional<RestaurantMenu> restaurantMenu1 = restaurantMenuRepository.findById(restaurantMenu.getId());

        Assertions.assertThat(restaurantMenu1.stream().filter(r -> r.getMenu().get("Pão de alho").equals("350")));


    }

    @Test
    public void testUpdateRestaurantMenuOnDatabase() {

        restaurantMenuRepository.save(restaurantMenu);
        restaurantMenu.getMenu().remove("Bitoque");
        restaurantMenu.getMenu().put("Glen Carlou", 2000d);
        restaurantMenuRepository.save(restaurantMenu);
        Assertions.assertThat(restaurantMenu.getId()).isNotNull();
        Assertions.assertThat(restaurantMenu.getMenu().get("Bitoque")).isNull();
        Assertions.assertThat(restaurantMenu.getMenu().get("Glen Carlou")).isEqualTo(2000d);

    }

    @Test
    public void testDeleteRestaurantMenuOnDatabase() {

        Map<String, Double> menuList = new HashMap<String, Double>();
        menuList.put("Pão de alho", 350d);
        menuList.put("Bitoque", 680d);


        RestaurantMenu rstrntMnu = new RestaurantMenu(null, menuList);
        restaurantMenuRepository.save(rstrntMnu);
        restaurantMenuRepository.delete(rstrntMnu);
        Assertions.assertThat(rstrntMnu.getId()).isNotNull();


    }
}
