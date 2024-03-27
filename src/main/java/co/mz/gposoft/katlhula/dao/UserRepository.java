package co.mz.gposoft.katlhula.dao;


import co.mz.gposoft.katlhula.domain.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilizador, Long> {
}
