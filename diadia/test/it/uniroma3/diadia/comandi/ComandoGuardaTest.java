
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.fixture.Fixture;

import static org.junit.Assert.*;

import org.junit.Test;


public class ComandoGuardaTest {

	@Test
	public void testSimulazioneComandoGuarda() {
		String[] comandi = {"vai sud", "guarda", "fine"};
		IOSimulator io = Fixture.creaSimulazioneEGioca(comandi);		
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO , io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Atrio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Aula N10", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("punteggio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("inventario", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Aula N10", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE , io.nextMessaggio());
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertEquals(true, interaRiga.contains(expected));
	}
}
