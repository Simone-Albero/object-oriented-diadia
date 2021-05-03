package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class ComandoVaiTest {

	public Partita partita;
	private IO console;
	private Comando comando;

	@Before
	public void setUp() {
		this.partita = new Partita();
		this.console = new IOConsole();
		
		comando = new ComandoVai();
		comando.setIO(this.console);
	}

	@Test
	public void testVaiInDirezioneEsistente() {
		String direzione = this.partita.getStanzaCorrente().getDirezioni().getFirst();
		comando.setParametro(direzione);
		Stanza nuovaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		comando.esegui(this.partita);
		assertEquals(nuovaStanza ,this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testVaiInDirezioneInesistente() {
		comando.setParametro("pippo");
		comando.esegui(this.partita);
		assertEquals(this.partita.getStanzaCorrente() ,this.partita.getStanzaCorrente());
	}
	
	@Test
	public void testSimulazioneComandoVai() {
		String[] comandi = {"vai sud","fine"};
		IOSimulator io = Fixture.creaSimulazioneEGioca(comandi);		
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO , io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Atrio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Aula N10", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE , io.nextMessaggio());
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertEquals(true, interaRiga.contains(expected));
	}

}
