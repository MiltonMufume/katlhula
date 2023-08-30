package co.mz.gposoft.katlhula.service;

import co.mz.gposoft.katlhula.dao.UserRepository;
import co.mz.gposoft.katlhula.domain.Utilizador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("katlhula/utilizador")
public class UtilizadorService {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/createUtilizador")
    @ResponseStatus(HttpStatus.CREATED)
    public Utilizador createUtilizador(@RequestBody Utilizador utilizador) {

        return userRepository.save(utilizador);
    }

    @PutMapping("/updateUtilizador/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Utilizador> updateUtilizador(@PathVariable(value = "id") Long utilizadorId, @Validated @RequestBody Utilizador utilizadorFeatures) {

        Utilizador utilizador = userRepository.findById(utilizadorId).orElseThrow(() -> new RuntimeException("Utilizador não encontrado para o ID :: " + utilizadorId));
        utilizador.setPassword(utilizadorFeatures.getPassword());
        utilizador.setEmail(utilizadorFeatures.getEmail());
        utilizador.setRoles(utilizadorFeatures.getRoles());

        return ResponseEntity.ok(userRepository.save(utilizador));
    }

    @GetMapping("/utilizadorById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Utilizador> getUtilizadorById(@PathVariable(value = "id") Long utilizadorId) {

        Utilizador utilizador = userRepository.findById(utilizadorId).orElseThrow(() -> new RuntimeException("Utilizador não encontrado para o ID :: " + utilizadorId));

        return ResponseEntity.ok().body(utilizador);

    }

    @GetMapping("/allutilizadors")
    @ResponseStatus(HttpStatus.OK)
    public List<Utilizador> getAllUtilizadores() {

        return userRepository.findAll();
    }


    @DeleteMapping("/removerUtilizador/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteUtilizador(@PathVariable(value = "id") Long utilizadorId) {

        Utilizador utilizador = userRepository.findById(utilizadorId).orElseThrow(() -> new RuntimeException("Utilizador não encontrado para o ID :: " + utilizadorId));

        userRepository.delete(utilizador);

        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Conta do utilizador removida", Boolean.TRUE);

        return resposta;
    }
}
