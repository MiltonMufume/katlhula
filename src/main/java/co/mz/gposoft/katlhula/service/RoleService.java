package co.mz.gposoft.katlhula.service;

import co.mz.gposoft.katlhula.dao.RoleRepository;
import co.mz.gposoft.katlhula.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("katlhula/role")
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/createRole")
    @ResponseStatus(HttpStatus.CREATED)
    public Role createRole(@RequestBody Role role) {

        return roleRepository.save(role);
    }

    @PutMapping("/updateRole/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Role> updateRole(@PathVariable(value = "id") Long roleId, @Validated @RequestBody Role roleFeatures) {

        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role não encontrada para o ID :: " + roleId));
        role.setDescription(roleFeatures.getDescription());
        role.setAccess(roleFeatures.getAccess());
        role.setDescription(roleFeatures.getDescription());


        return ResponseEntity.ok(roleRepository.save(role));
    }

    @GetMapping("/roleById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Role> getroleById(@PathVariable(value = "id") Long roleId) {

        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role não encontrada para o ID :: " + roleId));

        return ResponseEntity.ok().body(role);

    }

    @GetMapping("/allRoles")
    @ResponseStatus(HttpStatus.OK)
    public List<Role> getAllRoles() {

        return roleRepository.findAll();
    }


    @DeleteMapping("/inactivateRole/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteRole(@PathVariable(value = "id") Long roleId) {

        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role não encontrada para o ID :: " + roleId));

        roleRepository.delete(role);

        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Role removida", Boolean.TRUE);

        return resposta;
    }

}
