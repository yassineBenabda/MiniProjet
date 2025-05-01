package com.yassine.gamess.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.yassine.gamess.entities.Genre;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGame;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomGame;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixGame;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date datedeSortie;

	@ManyToOne
	private Genre genre;

}