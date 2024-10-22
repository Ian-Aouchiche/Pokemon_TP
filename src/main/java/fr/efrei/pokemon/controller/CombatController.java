package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Combat;
import fr.efrei.pokemon.services.CombatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combat")
public class CombatController {

    @Autowired
    private CombatService combatService;

    @PostMapping
    public ResponseEntity<Combat> createCombat(@Valid @RequestBody Combat combat) {
        Combat createdCombat = combatService.createCombat(combat);
        return new ResponseEntity<>(createdCombat, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Combat>> getAllCombats() {
        List<Combat> combats = combatService.getAllCombats();
        return new ResponseEntity<>(combats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combat> getCombatById(@PathVariable String id) {
        Combat combat = combatService.getCombatById(id);
        if (combat != null) {
            return new ResponseEntity<>(combat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Combat> updateCombat(@PathVariable String id, @Valid @RequestBody Combat combat) {
        Combat updatedCombat = combatService.updateCombat(id, combat);
        if (updatedCombat != null) {
            return new ResponseEntity<>(updatedCombat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCombat(@PathVariable String id) {
        if (combatService.deleteCombat(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
