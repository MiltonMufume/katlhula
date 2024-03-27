import co.mz.gposoft.katlhula.KatlhulaApplication;
import co.mz.gposoft.katlhula.dao.RoleRepository;
import co.mz.gposoft.katlhula.domain.Role;

import co.mz.gposoft.katlhula.domain.RoleAccess;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KatlhulaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleTest {

    @Autowired
    RoleRepository roleRepository;

    Role role;

    @BeforeEach
    public void init() {


        role = new Role("Acessos de administrador", RoleAccess.SERVICE_ADMIN);

    }

    @Test
    public void testCreateRoleOnDatabase() {

        roleRepository.save(role);
        Assertions.assertThat(role.getId()).isNotNull();
        Assertions.assertThat(role.getAccess()).isEqualTo(RoleAccess.SERVICE_ADMIN);

    }

    @Test
    public void testReadRoleOnDatabase() {

        roleRepository.save(role);

        Role role1 = roleRepository.findById(role.getId()).get();
        Assertions.assertThat(role.getAccess()).isEqualTo(RoleAccess.SERVICE_ADMIN);


    }

    @Test
    public void testUpdateRoleOnDatabase() {

        roleRepository.save(role);
        role.setAccess(RoleAccess.NORMAL_USER);
        roleRepository.save(role);
        Assertions.assertThat(role.getId()).isNotNull();
        Assertions.assertThat(role.getAccess()).isEqualTo(RoleAccess.NORMAL_USER);

    }

    @Test
    public void testDeleteRoleOnDatabase() {

        Role roleToDelete = new Role("Acessos de administrador", RoleAccess.SERVICE_ADMIN);
        roleRepository.save(roleToDelete);
        roleRepository.delete(roleToDelete);
        Assertions.assertThat(roleToDelete.getId()).isNotNull();


    }


}
