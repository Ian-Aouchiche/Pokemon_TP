package fr.efrei.pokemon.services;

import fr.efrei.pokemon.dto.CreateArena;
import fr.efrei.pokemon.models.Arena;
import fr.efrei.pokemon.repositories.ArenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArenaService {

    @Autowired
    private ArenaRepository arenaRepository;

    public Arena createArena(CreateArena arenaBody) {
        Arena arena = new Arena();
        arena.setName(arenaBody.getName());
        return arenaRepository.save(arena);
    }

    public List<Arena> getAllArenas() {
        return arenaRepository.findAll();
    }

    public Arena getArenaById(Long id) {
        Optional<Arena> arenaOptional = arenaRepository.findById(id);
        return arenaOptional.orElse(null);
    }

    public Arena updateArena(Long id, CreateArena arenaBody) {
        Optional<Arena> arenaOptional = arenaRepository.findById(id);
        if (arenaOptional.isPresent()) {
            Arena arenaToUpdate = arenaOptional.get();
            arenaToUpdate.setName(arenaBody.getName());
            return arenaRepository.save(arenaToUpdate);
        }
        return null;
    }

    public boolean deleteArena(Long id) {
        Optional<Arena> arenaOptional = arenaRepository.findById(id);
        if (arenaOptional.isPresent()) {
            arenaRepository.delete(arenaOptional.get());
            return true;
        }
        return false;
    }
}
