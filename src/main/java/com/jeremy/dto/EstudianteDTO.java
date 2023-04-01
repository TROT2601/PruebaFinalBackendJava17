package com.jeremy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {
	
	@Min(value = 1)
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String nombres;
	
	@NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
	private String apellidos;
	
	@NotNull
    @NotEmpty
    @Size(min = 8, max = 8)
	private String dni;
	
	@NotNull
	private Integer edad;

}
