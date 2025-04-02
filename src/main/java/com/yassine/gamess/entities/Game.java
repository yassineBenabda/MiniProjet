package com.yassine.gamess.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGame;
	private String nomGame;
	private Double prixGame;
	private Date datedeSortie;
	
	public Game() {
		super();
	}
	
	public Game(String nomGame, Double prixGame, Date datedeSortie) {
		super();
		this.nomGame = nomGame;
		this.prixGame = prixGame;
		this.datedeSortie = datedeSortie;
	}
	
	public Long getIdGame() {
		return idGame;
	}
	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}
	public String getNomGame() {
		return nomGame;
	}
	public void setNomGame(String nomGame) {
		this.nomGame = nomGame;
	}
	public Double getPrixGame() {
		return prixGame;
	}
	public void setPrixGame(Double prixGame) {
		this.prixGame = prixGame;
	}
	public Date getDatedeSortie() {
		return datedeSortie;
	}
	public void setDatedeSortie(Date datedeSortie) {
		this.datedeSortie = datedeSortie;
	}

	@Override
	public String toString() {
		return "Game [idGame=" + idGame + ", nomGame=" + nomGame + ", prixGame=" + prixGame + ", datedeSortie="
				+ datedeSortie + "]";
	}
	
}
