package com.escola.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.curso.model.Aluno;
import com.escola.curso.model.AlunoPK;

public interface AlunoRepository extends JpaRepository<Aluno, AlunoPK>{

}
