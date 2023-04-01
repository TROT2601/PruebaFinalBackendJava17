package com.jeremy.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {
	
	private Integer id_matricula;	
	
	//@JsonFormat(pattern = "yyyy-MM-dd")
	//@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]", shape = JsonFormat.Shape.STRING)
	//@JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDateTime fecha_matricula;
	
	@NotNull
	private boolean estado;
	
	@NotNull
    @JsonIncludeProperties(value = {"id"})
	private EstudianteDTO estudiante;
	
	@NotNull
    @JsonManagedReference
	private List<MatriculaDetalleDTO> detalle;

}
