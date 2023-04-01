package com.jeremy.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeremy.dto.CursoDTO;
import com.jeremy.exception.ModelNotFoundException;
import com.jeremy.model.Curso;
import com.jeremy.service.ICursoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {
	
	private final ICursoService cursoService;

    @Autowired
    @Qualifier("cursoMapper")
    private ModelMapper mapper;
    
//PETICIONES
    
    @GetMapping
    public ResponseEntity<List<CursoDTO>> readAll() throws Exception{
        List<CursoDTO> listaCurso = cursoService.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listaCurso, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<CursoDTO> create(@Valid @RequestBody CursoDTO dto) throws Exception{
    	Curso obj = cursoService.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<CursoDTO> update(@Valid @RequestBody CursoDTO dto) throws Exception{
    	//Verificar si existe
    	Curso obj = cursoService.readById(dto.getId());
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getId());
        }
        //Actualizar
        Curso cur = cursoService.update(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(cur), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
    	Curso obj = cursoService.readById(id);
    	//Verificar si existe
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        //Eliminar
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // METODOS DE CONVERSION //
    
    private CursoDTO convertToDto(Curso obj) {
        return mapper.map(obj, CursoDTO.class);
    }

    private Curso convertToEntity(CursoDTO dto){
        return mapper.map(dto, Curso.class);
    }


}
