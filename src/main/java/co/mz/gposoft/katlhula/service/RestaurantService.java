package co.mz.gposoft.katlhula.service;

import co.mz.gposoft.katlhula.dao.RestaurantRepository;
import co.mz.gposoft.katlhula.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("katlhula/restaurant")
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    @PostMapping("/createRestaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {

        return restaurantRepository.save(restaurant);
    }

    @PutMapping("/updateRestaurant/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(value = "id") Long restaurantId, @Validated @RequestBody Restaurant restaurantFeatures) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Restaurante não encontrado para o ID :: " + restaurantId));
        restaurant.setDescription(restaurantFeatures.getDescription());
        restaurant.setCategory(restaurantFeatures.getCategory());
        restaurant.setClassification(restaurantFeatures.getClassification());
        restaurant.setLocation(restaurantFeatures.getLocation());
        restaurant.setLocation(restaurantFeatures.getLocation());
        restaurant.setPhoto(restaurantFeatures.getPhoto());
        restaurant.setCreatedBy(restaurantFeatures.getCreatedBy());
        restaurant.setAttendanceTime(restaurantFeatures.getAttendanceTime());
        restaurant.setMenu(restaurantFeatures.getMenu());

        return ResponseEntity.ok(restaurantRepository.save(restaurant));
    }

    @GetMapping("/restaurantById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable(value = "id") Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Restaurante não encontrado para o ID :: " + restaurantId));

        return ResponseEntity.ok().body(restaurant);

    }

    @GetMapping("/allRestaurants")
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> getAllRestaurants() {

        return restaurantRepository.findAll();
    }


    @DeleteMapping("/inactivateRestaurant/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteRestaurant(@PathVariable(value = "id") Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Restaurante não encontrado para o ID :: " + restaurantId));

        restaurantRepository.delete(restaurant);

        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Produto inactivado", Boolean.TRUE);

        return resposta;
    }

}
