package com.jeremy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoDTO {
	
	@Min(value = 1)
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 100)
	private String siglas;
	
	@NotNull
	private boolean estado;

}
