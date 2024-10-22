package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.dto.CreateObjetBoutique;
import fr.efrei.pokemon.models.ObjetBoutique;
import fr.efrei.pokemon.services.ObjetBoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boutique")
public class ObjetBoutiqueController {
    private final ObjetBoutiqueService service;

    @Autowired
    public ObjetBoutiqueController(ObjetBoutiqueService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ObjetBoutique>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjetBoutique> getById(@PathVariable String id) {
        ObjetBoutique objetBoutique = service.findById(id);
        return objetBoutique != null ? ResponseEntity.ok(objetBoutique) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateObjetBoutique objetBoutiqueBody) {
        service.save(objetBoutiqueBody);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody CreateObjetBoutique objetBoutiqueBody) {
        service.update(id, objetBoutiqueBody);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
