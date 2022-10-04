package com.escola.curso.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_ALUNO")
public class Aluno {
	
	@EmbeddedId
	private AlunoPK alunoPk;
	
	@Column(name="NOME", length = 60)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "ID_CURSO", referencedColumnName = "ID")
	private Curso curso;
}
