package com.jeremy.model;

import jakarta.persistence.*;
import lombok.*;;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	@Column(length = 10, nullable = false)
	private String siglas;
	
	@Column(nullable = false)
	private boolean estado;
	
}
