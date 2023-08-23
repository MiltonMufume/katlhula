package co.mz.gposoft.katlhula.dao;

import co.mz.gposoft.katlhula.domain.CulturalEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CulturalEventRepository extends JpaRepository<CulturalEvent, Long> {
}
