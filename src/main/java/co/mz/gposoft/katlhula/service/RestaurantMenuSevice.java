package co.mz.gposoft.katlhula.service;


import co.mz.gposoft.katlhula.dao.RestaurantMenuRepository;
import co.mz.gposoft.katlhula.domain.RestaurantMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("katlhula/restaurantMenu")
public class RestaurantMenuSevice {

    @Autowired
    RestaurantMenuRepository restaurantMenuRepository;

    @PostMapping("/createRestaurantMenu")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantMenu createrestaurantMenu(@RequestBody RestaurantMenu restaurantMenu) {

        return restaurantMenuRepository.save(restaurantMenu);
    }

    @PutMapping("/updateRestaurantMenu/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RestaurantMenu> updaterestaurantMenu(@PathVariable(value = "id") Long restaurantMenuId, @Validated @RequestBody RestaurantMenu restaurantMenuFeatures) {

        RestaurantMenu restaurantMenu = restaurantMenuRepository.findById(restaurantMenuId).orElseThrow(() -> new RuntimeException("Menu não encontrado para o ID :: " + restaurantMenuId));
        restaurantMenu.setMenu(restaurantMenuFeatures.getMenu());
        restaurantMenu.setPhoto(restaurantMenuFeatures.getPhoto());

        return ResponseEntity.ok(restaurantMenuRepository.save(restaurantMenu));
    }

    @GetMapping("/restaurantMenuById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<RestaurantMenu> getrestaurantMenuById(@PathVariable(value = "id") Long restaurantMenuId) {

        RestaurantMenu restaurantMenu = restaurantMenuRepository.findById(restaurantMenuId).orElseThrow(() -> new RuntimeException("Menu não encontrado para o ID :: " + restaurantMenuId));

        return ResponseEntity.ok().body(restaurantMenu);

    }

    @GetMapping("/allRestaurantMenus")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantMenu> getAllrestaurantMenus() {

        return restaurantMenuRepository.findAll();
    }


    @DeleteMapping("/removeRestaurantMenu/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteRestaurantMenu(@PathVariable(value = "id") Long restaurantMenuId) {

        RestaurantMenu restaurantMenu = restaurantMenuRepository.findById(restaurantMenuId).orElseThrow(() -> new RuntimeException("Menu não encontrado para o ID :: " + restaurantMenuId));

        restaurantMenuRepository.delete(restaurantMenu);

        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Menu removido", Boolean.TRUE);

        return resposta;
    }
}
