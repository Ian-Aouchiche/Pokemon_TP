package fr.efrei.pokemon.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String name;

	@OneToMany
	private List<Pokemon> team;

	// Ajout d'une collection pour les combats
	@OneToMany(mappedBy = "trainer")
	private Set<Combat> combats; // Relation avec les combats

	// Getters et Setters existants
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getTeam() {
		return team;
	}

	public void setTeam(List<Pokemon> team) {
		this.team = team;
	}

	// Ajout des getters et setters pour combats
	public Set<Combat> getCombats() {
		return combats;
	}

	public void setCombats(Set<Combat> combats) {
		this.combats = combats;
	}
}
