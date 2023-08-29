import co.mz.gposoft.katlhula.KatlhulaApplication;
import co.mz.gposoft.katlhula.dao.RoleRepository;
import co.mz.gposoft.katlhula.dao.UserRepository;
import co.mz.gposoft.katlhula.domain.Role;
import co.mz.gposoft.katlhula.domain.RoleAccess;

import co.mz.gposoft.katlhula.domain.Utilizador;
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
public class UtilizadorTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private Utilizador utilizador;

    private Role role;

    @BeforeEach
    public void init() {


        role = new Role("Acessos de administrador", RoleAccess.SERVICE_ADMIN);
        roleRepository.save(role);

        utilizador = new Utilizador("milton-mufume", "pass@123Quatro", role, "miltonmufume@gmail.com");
    }

    @Test
    public void testCreateUtilizadorOnDatabase() {

        userRepository.save(utilizador);
        Assertions.assertThat(utilizador.getId()).isNotNull();
        Assertions.assertThat(utilizador.getUsername()).isEqualToIgnoringCase("milton-mufume");

    }

    @Test
    public void testReadUtilizadorOnDatabase() {

        userRepository.save(utilizador);

        Optional<Utilizador> utilizador1 = userRepository.findById(utilizador.getId());

        Assertions.assertThat(utilizador.getUsername()).isEqualToIgnoringCase("milton-mufume");


    }

    @Test
    public void testUpdateUtilizadorOnDatabase() {

        userRepository.save(utilizador);
        utilizador.setPassword("tudoEmMaiusculas");
        userRepository.save(utilizador);
        Assertions.assertThat(utilizador.getId()).isNotNull();
        Assertions.assertThat(utilizador.getPassword()).isEqualTo("tudoEmMaiusculas");


    }

    @Test
    public void testDeleteUtilizadorOnDatabase() {


        List<String> utilizadorList = Arrays.asList(new String("825168041"), new String("845168041"), new String("875168041"));
        Utilizador utilizadorToDel = new Utilizador("milton-mufume", "pass@123Quatro", role, "miltonmufume@gmail.com");

        userRepository.save(utilizadorToDel);
        userRepository.delete(utilizadorToDel);
        Assertions.assertThat(utilizadorToDel.getId()).isNotNull();


    }
}
