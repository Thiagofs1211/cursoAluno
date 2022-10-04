package com.escola.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.escola.curso.model.Curso;
import com.escola.curso.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CursoService.class);
	
	public List<Curso> listarCursos() {
		return cursoRepository.findAll();
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void salvarCurso(Curso curso){
		cursoRepository.save(curso);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void alterarCurso(Curso curso) {
		if(curso.getId() != null && cursoRepository.findById(curso.getId()) != null) {
			cursoRepository.save(curso);
		} else {
			logger.error("Curso não encontrado: "+curso);
		}
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void excluirCurso(Curso curso) {
		if(curso.getId() != null && cursoRepository.findById(curso.getId()) != null) {
			cursoRepository.deleteById(curso.getId());
		} else {
			logger.error("Curso não encontrado: "+curso);
		}
	}
}
