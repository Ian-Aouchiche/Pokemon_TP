package fr.efrei.pokemon.models;

import jakarta.persistence.*;

@Entity
public class Combat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "pokemon1_id", nullable = false)
    private Pokemon pokemon1;

    @ManyToOne
    @JoinColumn(name = "pokemon2_id", nullable = false)
    private Pokemon pokemon2;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Pokemon winner;

    @ManyToOne
    @JoinColumn(name = "loser_id")
    private Pokemon loser;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Trainer getTrainer() { return trainer; }
    public void setTrainer(Trainer trainer) { this.trainer = trainer; }

    public Pokemon getPokemon1() { return pokemon1; }
    public void setPokemon1(Pokemon pokemon1) { this.pokemon1 = pokemon1; }

    public Pokemon getPokemon2() { return pokemon2; }
    public void setPokemon2(Pokemon pokemon2) { this.pokemon2 = pokemon2; }

    public Pokemon getWinner() { return winner; }
    public void setWinner(Pokemon winner) { this.winner = winner; }

    public Pokemon getLoser() { return loser; }
    public void setLoser(Pokemon loser) { this.loser = loser; }
}
