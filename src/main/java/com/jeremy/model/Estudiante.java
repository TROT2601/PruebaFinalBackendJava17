package com.jeremy.model;

import jakarta.persistence.*;
import lombok.*;;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "estudiantes")
public class Estudiante {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String nombres;
	
	@Column(length = 100, nullable = false)
	private String apellidos;
	
	@Column(length = 8, nullable = false)
	private String dni;
	
	@Column(length = 2, nullable = false)
	private Integer edad;
	
}
