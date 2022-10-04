package com.escola.curso.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.escola.curso.model.Aluno;
import com.escola.curso.model.AlunoPK;
import com.escola.curso.model.Curso;
import com.escola.curso.repository.AlunoRepository;

@SpringBootTest
public class AlunoServiceTest {

	@InjectMocks
	AlunoService service;
	
	@Mock
	AlunoRepository dao;
	
	@Test
	public void listarAlunos() {
		Aluno aluno = preencherAluno();
		List<Aluno> lista = new ArrayList<>();
		lista.add(aluno);
		
		Mockito.when(dao.findAll()).thenReturn(lista);
		
		List<Aluno> resultadoDtos = service.listarAlunos();
		
		assertThat(resultadoDtos.size()).isEqualTo(1);
		assertThat(resultadoDtos.get(0).getNome()).isEqualTo("Thiago");
	}
	
	@Test
	public void salvarAluno() {
		service.adicionarAluno(Mockito.any());
	}
	
	@Test
	public void atualizarAluno() {
		service.alterarAluno(Mockito.any());
	}
	
	@Test
	public void excluirAluno() {
		service.excluirAluno(Mockito.any());
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
