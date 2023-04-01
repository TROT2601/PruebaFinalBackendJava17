package com.jeremy.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MatriculaDetalle {
	
	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_matdetalle;
	
	@ManyToOne
    @JoinColumn(name = "id_matricula", nullable = false, foreignKey = @ForeignKey(name= "FK_Detalle_Matricula"))
	private Matricula matricula;
	
	@ManyToOne
    @JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name= "FK_Detalle_Curso"))
	private Curso curso;
	
	@Column(nullable = false)
	private String aula;

}
