package com.escola.curso.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.escola.curso.model.Curso;
import com.escola.curso.service.CursoService;

@SpringBootTest
public class CursoControllerTest {

	@InjectMocks
	private CursoController controller;
	
	@Mock
	CursoService service;
	
	@Test
	public void listarCursos() {
		
		Curso curso = preencherCurso();
		
		List<Curso> lista = new ArrayList<>();
		lista.add(curso);
		
		Mockito.when(service.listarCursos()).thenReturn(lista);
		
		List<Curso> resultado = controller.listarCursos();
		
		assertThat(resultado.size()).isEqualTo(1);
		assertThat(resultado.get(0).getNome()).isEqualTo("curso_teste");
	}
	
	@Test
	public void salvarCurso() {
		HttpStatus response = controller.adicionarCurso(Mockito.any());
		assertThat(response).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void atualizarCurso() {
		HttpStatus response = controller.alterarCurso(Mockito.any());
		assertThat(response).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void excluirCurso() {
		HttpStatus response = controller.excluirCurso(Mockito.any());
		assertThat(response).isEqualTo(HttpStatus.OK);
	}
	
	private Curso preencherCurso() {
		Curso curso = new Curso();
		curso.setId(1L);
		curso.setNome("curso_teste");
		return curso;
	}
}
