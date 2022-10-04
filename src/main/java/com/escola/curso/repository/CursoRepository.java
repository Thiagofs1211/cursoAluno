package com.escola.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.curso.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
