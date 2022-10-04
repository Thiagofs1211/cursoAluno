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

import com.escola.curso.model.Aluno;
import com.escola.curso.model.AlunoPK;
import com.escola.curso.model.Curso;
import com.escola.curso.service.AlunoService;

@SpringBootTest
public class AlunoControllerTest {

	@InjectMocks
	private AlunoController controller;
	
	@Mock
	AlunoService service;
	
	@Test
	public void listarAlunos() {
		
		Aluno aluno = preencherAluno();
		
		List<Aluno> lista = new ArrayList<>();
		lista.add(aluno);
		
		Mockito.when(service.listarAlunos()).thenReturn(lista);
		
		List<Aluno> resultado = controller.listarAlunos();
		
		assertThat(resultado.size()).isEqualTo(1);
		assertThat(resultado.get(0).getNome()).isEqualTo("Thiago");
	}
	
	@Test
	public void salvarAluno() {
		HttpStatus response = controller.adicionarAluno(Mockito.any());
		assertThat(response).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void atualizarAluno() {
		HttpStatus response = controller.atualizarAluno(Mockito.any());
		assertThat(response).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void excluirAluno() {
		HttpStatus response = controller.excluirAluno(Mockito.any());
		assertThat(response).isEqualTo(HttpStatus.OK);
	}
	
	private Aluno preencherAluno() {
		Aluno aluno = new Aluno();
		aluno.setAlunoPk(new AlunoPK());
		aluno.getAlunoPk().setCpf("111111111");
		aluno.getAlunoPk().setMatricula("1");
		aluno.setCurso(new Curso());
		aluno.setNome("Thiago");
		return aluno;
	}
}
