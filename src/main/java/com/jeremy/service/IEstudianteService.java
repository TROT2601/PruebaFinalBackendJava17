package com.jeremy.service;

import java.util.List;

import com.jeremy.model.Estudiante;

public interface IEstudianteService extends ICRUD<Estudiante, Integer>{
	
	List<Estudiante> getEstudianteDescEdad();
}
