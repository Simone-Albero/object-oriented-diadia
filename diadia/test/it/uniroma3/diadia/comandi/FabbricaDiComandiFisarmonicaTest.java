package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class FabbricaDiComandiFisarmonicaTest {

	private IO console;
	private FabbricaDiComandi factory;

	@Before
	public void setUp() {
		this.console = new IOConsole();
		this.factory = new FabbricaDiComandiFisarmonica();

	}

	@Test
	public void testComandoNonValido() {
		Comando comando = this.factory.costruisciComando("pippo", this.console);
		assertEquals("ComandoNonValido", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoVai() {
		Comando comando = this.factory.costruisciComando("vai nord", this.console);
		assertEquals("ComandoVai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}
	
	@Test
	public void testComandoPrendi() {
		Comando comando = this.factory.costruisciComando("prendi osso", this.console);
		assertEquals("ComandoPrendi", comando.getNome());
		assertEquals("osso", comando.getParametro());
	}
	
	@Test
	public void testComandoPosa() {
		Comando comando = this.factory.costruisciComando("posa osso", this.console);
		assertEquals("ComandoPosa", comando.getNome());
		assertEquals("osso", comando.getParametro());
	}
	
	@Test
	public void testComandoAiuto() {
		Comando comando = this.factory.costruisciComando("aiuto", this.console);
		assertEquals("ComandoAiuto", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoFine() {
		Comando comando = this.factory.costruisciComando("fine", this.console);
		assertEquals("ComandoFine", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoGuarda() {
		Comando comando = this.factory.costruisciComando("guarda", this.console);
		assertEquals("ComandoGuarda", comando.getNome());
		assertNull(comando.getParametro());
	}
}
