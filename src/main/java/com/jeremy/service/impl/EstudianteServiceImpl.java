package com.jeremy.service.impl;

import com.jeremy.model.Estudiante;
import com.jeremy.repository.IBaseRepository;
import com.jeremy.repository.IEstudianteRepository;
import com.jeremy.service.IEstudianteService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, Integer> implements IEstudianteService{
	
	private final IEstudianteRepository estudianteRepo;
	
	@Override
    protected IBaseRepository<Estudiante, Integer> getRepo() {
        return estudianteRepo;
    }
	
	@Override
    public List<Estudiante> getEstudianteDescEdad() {
		
		//List<Estudiante> lista = estudianteRepo.findAll();
		
		//Comparator<Estudiante> inverse =  (x1, x2) -> x2.getEdad() - x1.getEdad();
		
		return estudianteRepo.findAll().stream().sorted((e1, e2) -> e2.getEdad().compareTo(e1.getEdad()))
			      .collect(Collectors.toList());
        //return (List<Estudiante>) lista.stream().sorted(inverse);
        //sorted((x1, x2) -> x2.getEdad() - x1.getEdad(),Estudiante::);
    }
}
