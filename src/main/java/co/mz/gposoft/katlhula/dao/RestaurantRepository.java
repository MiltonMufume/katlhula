package co.mz.gposoft.katlhula.dao;

import co.mz.gposoft.katlhula.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
