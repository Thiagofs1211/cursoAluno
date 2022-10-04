package com.escola.curso.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AlunoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="CPF", length = 12)
	private String cpf;	//Não fiz como number para conseguir salvar cpf que comecem com 0
	
	@Column(name="MATRICULA", length = 20)
	private String matricula;
}
