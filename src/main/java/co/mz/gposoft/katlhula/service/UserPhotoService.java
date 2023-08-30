package co.mz.gposoft.katlhula.service;

import co.mz.gposoft.katlhula.dao.UserPhotoRepository;
import co.mz.gposoft.katlhula.domain.UserPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("katlhula/userPhoto")
public class UserPhotoService {

    @Autowired
    private UserPhotoRepository userPhotoRepository;

    @PostMapping("/createUserPhoto")
    @ResponseStatus(HttpStatus.CREATED)
    public UserPhoto createUserPhoto(@RequestBody UserPhoto userPhoto) {

        return userPhotoRepository.save(userPhoto);
    }

    @PutMapping("/updateuserPhoto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserPhoto> updateUserPhoto(@PathVariable(value = "id") Long userPhotoId, @Validated @RequestBody UserPhoto userPhotoFeatures) {

        UserPhoto userPhoto = userPhotoRepository.findById(userPhotoId).orElseThrow(() -> new RuntimeException("Foto (ou imagem) não encontrada para o ID :: " + userPhotoId));
        userPhoto.setLocation(userPhotoFeatures.getLocation());
        userPhoto.setPhotoDescription(userPhoto.getPhotoDescription());
        userPhoto.setCreatedBy(userPhotoFeatures.getCreatedBy());


        return ResponseEntity.ok(userPhotoRepository.save(userPhoto));
    }

    @GetMapping("/userPhotoById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserPhoto> getUserPhotoById(@PathVariable(value = "id") Long userPhotoId) {

        UserPhoto userPhoto = userPhotoRepository.findById(userPhotoId).orElseThrow(() -> new RuntimeException("Foto (ou imagem) não encontrada para o ID :: " + userPhotoId));

        return ResponseEntity.ok().body(userPhoto);

    }

    @GetMapping("/alluserPhotos")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPhoto> getAlluserPhotos() {

        return userPhotoRepository.findAll();
    }


    @DeleteMapping("/inactivateuserPhoto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteuserPhoto(@PathVariable(value = "id") Long userPhotoId) {

        UserPhoto userPhoto = userPhotoRepository.findById(userPhotoId).orElseThrow(() -> new RuntimeException("Foto (ou imagem) não encontrada para o ID :: " + userPhotoId));

        userPhotoRepository.delete(userPhoto);

        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Foto removida", Boolean.TRUE);

        return resposta;
    }
}
