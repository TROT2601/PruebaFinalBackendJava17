package com.jeremy.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Matricula {
	
	@EqualsAndHashCode.Include
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_matricula;
	
	@Column(nullable = false)
	//@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]", shape = JsonFormat.Shape.STRING)
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime fecha_matricula;
	
	@Column(nullable = false)
	private boolean estado;
	
	@ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name= "FK_Matricula_Estudiante"))
	private Estudiante estudiante;
	
	@OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
	private List<MatriculaDetalle> detalle;

}
