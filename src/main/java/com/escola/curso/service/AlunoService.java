package com.escola.curso.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.escola.curso.model.Aluno;
import com.escola.curso.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AlunoService.class);

	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void adicionarAluno(Aluno aluno) {
		alunoRepository.save(aluno);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void alterarAluno(Aluno aluno) {
		if(aluno.getAlunoPk() != null && alunoRepository.findById(aluno.getAlunoPk()) != null) {
			alunoRepository.save(aluno);
		} else {
			logger.error("Aluno não encontrado: "+aluno);
		}
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void excluirAluno(Aluno aluno) {
		if(aluno.getAlunoPk() != null && alunoRepository.findById(aluno.getAlunoPk()) != null) {
			alunoRepository.delete(aluno);
		} else {
			logger.error("Aluno não encontrado: "+aluno);
		}
	}
}
