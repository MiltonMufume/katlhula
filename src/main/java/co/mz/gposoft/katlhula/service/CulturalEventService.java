package co.mz.gposoft.katlhula.service;

import co.mz.gposoft.katlhula.dao.CulturalEventRepository;
import co.mz.gposoft.katlhula.domain.CulturalEvent;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("katlhula/culturalEvent")
public class CulturalEventService {

    @Autowired
    private CulturalEventRepository culturalEventRepository;


    @PostMapping("/createCulturalEvent")
    @ResponseStatus(HttpStatus.CREATED)
    public CulturalEvent createCulturalEvent(@RequestBody CulturalEvent culturalEvent) {

        return culturalEventRepository.save(culturalEvent);
    }

    @PutMapping("/updateCulturalEvent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CulturalEvent> updateCulturalEvent(@PathVariable(value = "id") Long culturalEventId, @Validated @RequestBody CulturalEvent culturalEventFeatures) {

        CulturalEvent culturalEvent = culturalEventRepository.findById(culturalEventId).orElseThrow(() -> new RuntimeException("Evento Cultural não encontrado para o ID :: " + culturalEventId));
        culturalEvent.setEventDate(culturalEventFeatures.getEventDate());
        culturalEvent.setDescription(culturalEventFeatures.getDescription());
        culturalEvent.setOrganizer(culturalEventFeatures.getOrganizer());
        culturalEvent.setEventPlace(culturalEventFeatures.getEventPlace());
        culturalEvent.setCreatedBy(culturalEventFeatures.getCreatedBy());

        return ResponseEntity.ok(culturalEventRepository.save(culturalEvent));
    }

    @GetMapping("/culturalEventById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CulturalEvent> getCulturalEventById(@PathVariable(value = "id") Long culturalEventId) {

        CulturalEvent culturalEvent = culturalEventRepository.findById(culturalEventId).orElseThrow(() -> new RuntimeException("Evento cultural não encontrado para o ID :: " + culturalEventId));

        return ResponseEntity.ok().body(culturalEvent);

    }

    @GetMapping("/allCulturalEvents")
    @ResponseStatus(HttpStatus.OK)
    public List<CulturalEvent> getAllCulturalEvents() {

        return culturalEventRepository.findAll();
    }


    @DeleteMapping("/inactivateCulturalEvent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteCulturalEvent(@PathVariable(value = "id") Long culturalEventId) {

        CulturalEvent culturalEvent = culturalEventRepository.findById(culturalEventId).orElseThrow(() -> new RuntimeException("Evento Cultural não encontrado para o ID :: " + culturalEventId));
        culturalEvent.remove();
        culturalEventRepository.save(culturalEvent);

        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Evento inactivado", Boolean.TRUE);

        return resposta;
    }

}
