package com.jeremy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeremy.model.Curso;
import com.jeremy.model.Estudiante;
import com.jeremy.model.Matricula;
import com.jeremy.model.MatriculaDetalle;
import com.jeremy.repository.IBaseRepository;
import com.jeremy.repository.IMatriculaRepository;
import com.jeremy.service.IMatriculaService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
@Service
public class MatriculaServiceImpl extends CRUDImpl<Matricula, Integer> implements IMatriculaService{
	
	//@Autowired
    private final IMatriculaRepository matriculaRepo;


    @Override
    protected IBaseRepository<Matricula, Integer> getRepo() {
        return matriculaRepo;
    }


	@Override
	public Map<String, String> getCursoEstudiante() {
		
		Map<String, Double> byEstudiante = matriculaRepo.findAll()
                .stream()
                .collect(groupingBy(s -> s.getEstudiante().getNombres(),summingDouble(Matricula::getId_matricula)));
		
		Stream<List<MatriculaDetalle>> stream = matriculaRepo.findAll().stream().map(Matricula::getDetalle);
        Stream<MatriculaDetalle> streamDetail = stream.flatMap(Collection::stream);

       Map<String, Double> byCurso = streamDetail
                .collect(groupingBy(d -> d.getCurso().getNombre(),
                		
                		summingDouble(MatriculaDetalle::getId_matdetalle)));
		return null;
		
	}
}
