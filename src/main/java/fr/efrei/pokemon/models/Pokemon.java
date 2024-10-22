package fr.efrei.pokemon.models;

import fr.efrei.pokemon.constants.Type;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID) // AUTO INCREMENT
	private String id;

	private String name;

	private int level;

	@Enumerated(EnumType.STRING)
	private Type type; // SI mon pokemon est type feu -> Type == "FEU"

	// Références aux combats gagnés
	@OneToMany(mappedBy = "winner")
	private Set<Combat> wonCombats = new HashSet<>();

	// Références aux combats perdus
	@OneToMany(mappedBy = "loser")
	private Set<Combat> lostCombats = new HashSet<>();

	// Getters et Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Combat> getWonCombats() {
		return wonCombats;
	}

	public void setWonCombats(Set<Combat> wonCombats) {
		this.wonCombats = wonCombats;
	}

	public Set<Combat> getLostCombats() {
		return lostCombats;
	}

	public void setLostCombats(Set<Combat> lostCombats) {
		this.lostCombats = lostCombats;
	}
}
