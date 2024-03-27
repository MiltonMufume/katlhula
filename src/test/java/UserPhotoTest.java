import co.mz.gposoft.katlhula.KatlhulaApplication;
import co.mz.gposoft.katlhula.dao.RoleRepository;
import co.mz.gposoft.katlhula.dao.UserPhotoRepository;
import co.mz.gposoft.katlhula.dao.UserRepository;
import co.mz.gposoft.katlhula.domain.Role;
import co.mz.gposoft.katlhula.domain.RoleAccess;
import co.mz.gposoft.katlhula.domain.UserPhoto;
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
public class UserPhotoTest {

    @Autowired
    UserPhotoRepository userPhotoRepository;

    UserPhoto userPhoto;

    Utilizador utilizador;

    @Autowired
    UserRepository userRepository;

    Role role;

    @Autowired
    RoleRepository roleRepository;


    @BeforeEach
    public void init() {


        role = new Role("Acessos de administrador", RoleAccess.SERVICE_ADMIN);
        roleRepository.save(role);

        utilizador = new Utilizador("milton-mufume", "pass@123Quatro", role, "miltonmufume@gmail.com");
        userRepository.save(utilizador);

        userPhoto = new UserPhoto("location", "RestaurantXPTO Photo", utilizador);
    }

    @Test
    public void testCreateUserPhotoOnDatabase() {

        userPhotoRepository.save(userPhoto);
        Assertions.assertThat(userPhoto.getId()).isNotNull();
        Assertions.assertThat(userPhoto.getPhotoDescription()).isEqualToIgnoringCase("RestaurantXPTO Photo");

    }

    @Test
    public void testReadUserPhotoOnDatabase() {

        userPhotoRepository.save(userPhoto);

        Optional<UserPhoto> userPhoto1 = userPhotoRepository.findById(userPhoto.getId());

        Assertions.assertThat(utilizador.getUsername()).isEqualToIgnoringCase("milton-mufume");


    }

    @Test
    public void testUpdateUserPhotoOnDatabase() {

        userPhotoRepository.save(userPhoto);
        userPhoto.setLocation("anotherLocation");
        userPhotoRepository.save(userPhoto);
        Assertions.assertThat(userPhoto.getId()).isNotNull();
        Assertions.assertThat(userPhoto.getLocation()).isEqualTo("anotherLocation");


    }

    @Test
    public void testDeleteUserPhotoOnDatabase() {


        UserPhoto userPhotoToDel = new UserPhoto("location", "RestaurantXPTO Photo", utilizador);

        userPhotoRepository.save(userPhotoToDel);
        userPhotoRepository.delete(userPhotoToDel);
        Assertions.assertThat(userPhotoToDel.getId()).isNotNull();


    }
}
