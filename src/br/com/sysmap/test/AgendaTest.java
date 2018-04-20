package br.com.sysmap.test;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.sysmap.model.Compromisso;
import br.com.sysmap.model.Equipe;
import br.com.sysmap.model.Perfil;
import br.com.sysmap.model.Usuario;

public class AgendaTest {

	@Test
	public void deveCriarUmUsuario() {
		Usuario usuario = new Usuario("Bruno Rolim", Perfil.LIDER);
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("agenda-mysql");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(usuario);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	@Test
	public void deveAssociarUmLiderAUmaEquipe() {		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("agenda-mysql");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 1);
		Equipe equipe = new Equipe(usuario, "Equipe 1");
		em.persist(equipe);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	@Test
	public void deveAdicionarUmMembroAUmaEquipe() {
		Usuario usuario = new Usuario("Douglas", Perfil.DESENVOLVEDOR);
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("agenda-mysql");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Equipe equipe = em.find(Equipe.class, 1);
		
		usuario.setEquipe(equipe);
		
		em.persist(usuario);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Test
	public void deveCriarNovoCompromissoParaUmUsuario() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("agenda-mysql");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 2);
		
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.add(Calendar.DAY_OF_WEEK, 2);
		Calendar dataFim = Calendar.getInstance();
		dataFim.add(Calendar.DAY_OF_WEEK, 3);
		
		Compromisso compromisso = new Compromisso(usuario, dataInicio, dataFim, "Comprimisso 1", "Sysmap");
		
		em.persist(compromisso);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
