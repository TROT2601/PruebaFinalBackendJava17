package com.jeremy.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jeremy.dto.MatriculaDTO;
import com.jeremy.model.Matricula;
import com.jeremy.service.IMatriculaService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matricula")
@RequiredArgsConstructor
public class MatriculaController {
	
	private final IMatriculaService matriculaService;
	
	@Autowired
    @Qualifier("matriculaMapper")
    private ModelMapper mapper;
	
	@GetMapping
    public ResponseEntity<List<MatriculaDTO>> readAll() throws Exception{
        List<MatriculaDTO> listaMatricula = matriculaService.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listaMatricula, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> create(@Valid @RequestBody MatriculaDTO dto) throws Exception{
    	Matricula obj = matriculaService.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    
    @GetMapping("/cursoestudiante")
    public ResponseEntity<Map<String, String>> getCursoEstudiante(){
        Map<String, String> map = matriculaService.getCursoEstudiante();
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
	
	private MatriculaDTO convertToDto(Matricula obj) {
        return mapper.map(obj, MatriculaDTO.class);
    }

    private Matricula convertToEntity(MatriculaDTO dto){
        return mapper.map(dto, Matricula.class);
    }
}
