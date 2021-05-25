package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.fixture.Fixture;

public class AbstractComandoTest {
	
	private AbstractComando comando;
	
	@Before
	public void setUp() {
		this.comando = new ComandoFake();
	}

	@Test
	public void testGetNomeSuComandoValido() {
		assertEquals("fake", this.comando.getNome());
	}
	
	@Test
	public void testSimulazioneEsegui() {
		String[] comandi = {"fake", "fine"};
		IOSimulator io = Fixture.creaSimulazioneEGioca(comandi, Fixture.labirintoDefault());		
		assertTrue(io.hasMessaggio(IOSimulator.BENVENUTO));
		assertContains(DiaDia.MESSAGGIO_BENVENUTO , io.getMessaggio(IOSimulator.BENVENUTO));
		assertContains("Atrio", io.getMessaggio(IOSimulator.BENVENUTO));
		assertTrue(io.hasMessaggio(comandi[0]));
		assertContains(ComandoFake.DONE, io.getMessaggio(comandi[0]));
		assertTrue(io.hasMessaggio(comandi[1]));
		assertEquals(ComandoFine.MESSAGGIO_FINE , io.getMessaggio(comandi[1]));
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertEquals(true, interaRiga.contains(expected));
	}
}
