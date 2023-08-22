package co.mz.gposoft.katlhula.dao;

import co.mz.gposoft.katlhula.domain.RestaurantMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantMenuRepository  extends JpaRepository<RestaurantMenu, Long> {
}
