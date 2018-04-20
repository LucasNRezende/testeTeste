package br.com.sysmap.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String descricao;
	
	@OneToOne
	private Usuario lider;
	
	@OneToMany(mappedBy = "equipe")
	private List<Usuario> time = new ArrayList<Usuario>();

	@Deprecated
	public Equipe() {
	}
	
	public Equipe(Usuario lider, String descricao) {
		this.lider = lider;
		this.descricao = descricao;
	}
}
