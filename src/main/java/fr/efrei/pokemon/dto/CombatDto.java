package fr.efrei.pokemon.dto;

import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.models.Trainer;

import java.time.LocalDateTime;

public class CombatDto {
    private Long id;
    private Trainer trainer1;
    private Trainer trainer2;
    private Pokemon winner;
    private Pokemon loser;
    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trainer getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(Trainer trainer1) {
        this.trainer1 = trainer1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }

    public Pokemon getWinner() {
        return winner;
    }

    public void setWinner(Pokemon winner) {
        this.winner = winner;
    }

    public Pokemon getLoser() {
        return loser;
    }

    public void setLoser(Pokemon loser) {
        this.loser = loser;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
