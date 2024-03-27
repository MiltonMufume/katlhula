package co.mz.gposoft.katlhula.dao;

import co.mz.gposoft.katlhula.domain.UserPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPhotoRepository extends JpaRepository<UserPhoto, Long> {
}
