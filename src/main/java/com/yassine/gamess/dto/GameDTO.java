package com.yassine.gamess.dto;

import java.util.Date;

import com.yassine.gamess.entities.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {

	private Long idGame;
	private String nomGame;
	private Double prixGame;
	private Date datedeSortie;
	private Genre genre;
	private String nomGen;

}