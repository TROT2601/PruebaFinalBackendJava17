package com.jeremy.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;
import java.util.stream.Collectors;

import com.jeremy.dto.EstudianteDTO;
import com.jeremy.exception.ModelNotFoundException;
import com.jeremy.model.Estudiante;
import com.jeremy.service.IEstudianteService;

@RestController
@RequestMapping("/estudiante")
@RequiredArgsConstructor
public class EstudianteController {
	
    private final IEstudianteService estudianteService;

    @Autowired
    @Qualifier("estudianteMapper")
    private ModelMapper mapper;
    
    //PETICIONES
    
    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> readAll() throws Exception{
        List<EstudianteDTO> listaEstudiante = estudianteService.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(listaEstudiante, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<EstudianteDTO> create(@Valid @RequestBody EstudianteDTO dto) throws Exception{
    	Estudiante obj = estudianteService.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<EstudianteDTO> update(@Valid @RequestBody EstudianteDTO dto) throws Exception{
    	//Verificar si existe
    	Estudiante obj = estudianteService.readById(dto.getId());
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getId());
        }
        //Actualizar
        Estudiante est = estudianteService.update(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(est), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
    	Estudiante obj = estudianteService.readById(id);
    	//Verificar si existe
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        //Eliminar
        estudianteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    //FILTRADO
    
    @GetMapping("/edaddesc")
    public ResponseEntity<List<EstudianteDTO>> readalldesc(){
    	List<EstudianteDTO> listaEstudiante = estudianteService.getEstudianteDescEdad().stream().map(this::convertToDto).collect(Collectors.toList());
    	return new ResponseEntity<>(listaEstudiante, HttpStatus.OK);
    }
    
    // METODOS DE CONVERSION //
    
    private EstudianteDTO convertToDto(Estudiante obj) {
    	//System.out.println("Entre a convertToDto");
        return mapper.map(obj, EstudianteDTO.class);
    }

    private Estudiante convertToEntity(EstudianteDTO dto){
    	//System.out.println("Entre a convertToEntity");
        return mapper.map(dto, Estudiante.class);
    }

}
