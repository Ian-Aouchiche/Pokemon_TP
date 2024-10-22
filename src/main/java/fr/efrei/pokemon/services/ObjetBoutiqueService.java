package fr.efrei.pokemon.services;

import fr.efrei.pokemon.dto.CreateObjetBoutique;
import fr.efrei.pokemon.models.ObjetBoutique;
import fr.efrei.pokemon.repositories.ObjetBoutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetBoutiqueService {
    private final ObjetBoutiqueRepository repository;

    @Autowired
    public ObjetBoutiqueService(ObjetBoutiqueRepository repository) {
        this.repository = repository;
    }

    public List<ObjetBoutique> findAll() {
        return repository.findAll();
    }

    public ObjetBoutique findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void save(CreateObjetBoutique objetBoutiqueBody) {
        ObjetBoutique objetBoutique = new ObjetBoutique();
        objetBoutique.setName(objetBoutiqueBody.getName());
        objetBoutique.setPrice(objetBoutiqueBody.getPrice());
        objetBoutique.setSpecialEffect(objetBoutiqueBody.getSpecialEffect());
        repository.save(objetBoutique);
    }

    public void update(String id, CreateObjetBoutique objetBoutiqueBody) {
        ObjetBoutique objetBoutique = findById(id);
        if (objetBoutique != null) {
            objetBoutique.setName(objetBoutiqueBody.getName());
            objetBoutique.setPrice(objetBoutiqueBody.getPrice());
            objetBoutique.setSpecialEffect(objetBoutiqueBody.getSpecialEffect());
            repository.save(objetBoutique);
        }
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
