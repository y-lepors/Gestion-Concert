package com.entities;

import javax.persistence.*;

import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Concert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConcert;

	private LocalDate dateConcert;

	private int duree;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSoiree")
	private Soiree soiree;
}

