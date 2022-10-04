package com.escola.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.curso.model.Aluno;
import com.escola.curso.service.AlunoService;

@RestController
@RequestMapping(path="/aluno")
public class AlunoController {
	
	@Autowired
	AlunoService service;

	@GetMapping(path="/listar")
	public @ResponseBody List<Aluno> listarAlunos() {
		return service.listarAlunos();
	}
	
	@PostMapping
	public HttpStatus adicionarAluno(Aluno aluno) {
		service.adicionarAluno(aluno);
		return HttpStatus.OK;
	}
	
	@PutMapping
	public HttpStatus atualizarAluno(Aluno aluno) {
		service.alterarAluno(aluno);
		return HttpStatus.OK;
	}
	
	@DeleteMapping
	public HttpStatus excluirAluno(Aluno aluno) {
		service.excluirAluno(aluno);
		return HttpStatus.OK;
	}
}
