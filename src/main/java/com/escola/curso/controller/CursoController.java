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

import com.escola.curso.model.Curso;
import com.escola.curso.service.CursoService;

@RestController
@RequestMapping(path="/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;

	@GetMapping(path="/listar")
	public @ResponseBody List<Curso> listarCursos() {
		return cursoService.listarCursos();
	}
	
	@PostMapping
	public HttpStatus adicionarCurso(Curso curso) {
		cursoService.salvarCurso(curso);
		return HttpStatus.OK;
	}
	
	@PutMapping
	public HttpStatus alterarCurso(Curso curso) {
		cursoService.alterarCurso(curso);
		return HttpStatus.OK;
	}
	
	@DeleteMapping
	public HttpStatus excluirCurso(Curso curso) {
		cursoService.excluirCurso(curso);
		return HttpStatus.OK;
	}
}
