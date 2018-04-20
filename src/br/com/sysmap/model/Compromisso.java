package br.com.sysmap.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compromisso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Usuario usuario;
	private Calendar inicio;
	private Calendar fim;
	private String descricao;
	private String local;
	
	public Compromisso(Usuario usuario, Calendar inicio, Calendar fim, String descricao, String local) {
		super();
		this.usuario = usuario;
		this.inicio = inicio;
		this.fim = fim;
		this.descricao = descricao;
		this.local = local;
	}
	
}
