package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Combat;
import fr.efrei.pokemon.repositories.CombatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombatService {

    @Autowired
    private CombatRepository combatRepository;

    public Combat createCombat(Combat combat) {
        if (combat.getPokemon1().getLevel() > combat.getPokemon2().getLevel()) {
            combat.setWinner(combat.getPokemon1());
            combat.setLoser(combat.getPokemon2());
        } else {
            combat.setWinner(combat.getPokemon2());
            combat.setLoser(combat.getPokemon1());
        }
        return combatRepository.save(combat);
    }

    public List<Combat> getAllCombats() {
        return combatRepository.findAll();
    }

    public Combat getCombatById(String id) {
        Optional<Combat> combatOptional = combatRepository.findById(id);
        return combatOptional.orElse(null);
    }

    public Combat updateCombat(String id, Combat combatDetails) {
        Optional<Combat> combatOptional = combatRepository.findById(id);
        if (combatOptional.isPresent()) {
            Combat combatToUpdate = combatOptional.get();
            combatToUpdate.setPokemon1(combatDetails.getPokemon1());
            combatToUpdate.setPokemon2(combatDetails.getPokemon2());
            combatToUpdate.setWinner(combatDetails.getWinner());
            combatToUpdate.setLoser(combatDetails.getLoser());
            return combatRepository.save(combatToUpdate);
        }
        return null;
    }

    public boolean deleteCombat(String id) {
        Optional<Combat> combatOptional = combatRepository.findById(id);
        if (combatOptional.isPresent()) {
            combatRepository.delete(combatOptional.get());
            return true;
        }
        return false;
    }
}
