package com.jeremy.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDetalleDTO {
	
	private Integer id_matdetalle;
	
	@JsonBackReference
	private MatriculaDTO matricula;
	
	@NotNull
	private CursoDTO curso;
	
	@NotNull
	private String aula;
}
