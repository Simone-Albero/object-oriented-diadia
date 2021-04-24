
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.fixture.Fixture;

import static org.junit.Assert.*;

import org.junit.Test;



public class ComandoAiutoTest {

	@Test
	public void testSimulazioneComandoAiuto() {
		String[] comandi = {"vai sud", "aiuto", "fine"};
		IOSimulator io = Fixture.creaSimulazioneEGioca(comandi);		
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO , io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Atrio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Aula N10", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoAiuto.MESSAGGIO_DI_CONFERMA, io.nextMessaggio());
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertEquals(true, interaRiga.contains(expected));
	}

}
