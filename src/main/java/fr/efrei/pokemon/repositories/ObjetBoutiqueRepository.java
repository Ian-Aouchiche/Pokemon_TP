package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.ObjetBoutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetBoutiqueRepository extends JpaRepository<ObjetBoutique, String> {
}
