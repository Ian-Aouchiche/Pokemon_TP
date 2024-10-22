package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.dto.CreateArena;
import fr.efrei.pokemon.models.Arena;
import fr.efrei.pokemon.services.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arenas")
public class ArenaController {

    @Autowired
    private ArenaService arenaService;

    @PostMapping
    public ResponseEntity<Arena> createArena(@RequestBody CreateArena arenaBody) {
        Arena newArena = arenaService.createArena(arenaBody);
        return new ResponseEntity<>(newArena, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Arena>> getAllArenas() {
        List<Arena> arenas = arenaService.getAllArenas();
        return new ResponseEntity<>(arenas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arena> getArenaById(@PathVariable Long id) {
        Arena arena = arenaService.getArenaById(id);
        return arena != null ? new ResponseEntity<>(arena, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Arena> updateArena(@PathVariable Long id, @RequestBody CreateArena arenaBody) {
        Arena updatedArena = arenaService.updateArena(id, arenaBody);
        return updatedArena != null ? new ResponseEntity<>(updatedArena, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArena(@PathVariable Long id) {
        boolean isDeleted = arenaService.deleteArena(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
