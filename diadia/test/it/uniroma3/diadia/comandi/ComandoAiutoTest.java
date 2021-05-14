
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
		assertTrue(io.hasMessaggio(IOSimulator.BENVENUTO));
		assertContains(DiaDia.MESSAGGIO_BENVENUTO , io.getMessaggio(IOSimulator.BENVENUTO));
		assertContains("Atrio", io.getMessaggio(IOSimulator.BENVENUTO));
		assertTrue(io.hasMessaggio(comandi[0]));
		assertContains("Aula N10", io.getMessaggio(comandi[0]));
		assertTrue(io.hasMessaggio(comandi[1]));
		assertContains(ComandoAiuto.MESSAGGIO_DI_CONFERMA, io.getMessaggio(comandi[1]));
		assertTrue(io.hasMessaggio(comandi[2]));
		assertEquals(ComandoFine.MESSAGGIO_FINE , io.getMessaggio(comandi[2]));
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertEquals(true, interaRiga.contains(expected));
	}

}
