package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;



public class FabbricaDiComandiFisarmonicaTest {

	private IO console;
	private FabbricaDiComandi factory;

	@Before
	public void setUp() {
		Scanner scanner = new Scanner(System.in);
		this.console = new IOConsole(scanner);
		this.factory = new FabbricaDiComandiFisarmonica();

	}

	@Test
	public void testComandoNonValido() {
		AbstractComando comando = this.factory.costruisciComando("pippo", this.console);
		assertEquals("nonvalido", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoVai() {
		AbstractComando comando = this.factory.costruisciComando("vai nord", this.console);
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}
	
	@Test
	public void testComandoPrendi() {
		AbstractComando comando = this.factory.costruisciComando("prendi osso", this.console);
		assertEquals("prendi", comando.getNome());
		assertEquals("osso", comando.getParametro());
	}
	
	@Test
	public void testComandoPosa() {
		AbstractComando comando = this.factory.costruisciComando("posa osso", this.console);
		assertEquals("posa", comando.getNome());
		assertEquals("osso", comando.getParametro());
	}
	
	@Test
	public void testComandoAiuto() {
		AbstractComando comando = this.factory.costruisciComando("aiuto", this.console);
		assertEquals("aiuto", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoFine() {
		AbstractComando comando = this.factory.costruisciComando("fine", this.console);
		assertEquals("fine", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoGuarda() {
		AbstractComando comando = this.factory.costruisciComando("guarda", this.console);
		assertEquals("guarda", comando.getNome());
		assertNull(comando.getParametro());
	}
}
