package com.jeremy.service;

import java.util.Map;

import com.jeremy.model.Matricula;

public interface IMatriculaService extends ICRUD<Matricula, Integer>{
	
	Map<String, String> getCursoEstudiante();

}
