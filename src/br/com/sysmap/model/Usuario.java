package br.com.sysmap.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	@OneToMany(mappedBy = "usuario")
	private List<Compromisso> compromissos;
	
	@ManyToOne
	private Equipe equipe;
	
	@Deprecated
	public Usuario() {
		
	}
	
	public Usuario(String nome, Perfil perfil) {
		this.nome = nome;
		this.perfil = perfil;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	
}
