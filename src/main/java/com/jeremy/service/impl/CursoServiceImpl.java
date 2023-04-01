package com.jeremy.service.impl;

import com.jeremy.model.Curso;
import com.jeremy.repository.IBaseRepository;
import com.jeremy.repository.ICursoRepository;
import com.jeremy.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CursoServiceImpl extends CRUDImpl<Curso, Integer> implements ICursoService{
	
	private final ICursoRepository cursoRepository;
	
	@Override
    protected IBaseRepository<Curso, Integer> getRepo() {
        return cursoRepository;
    }
}
