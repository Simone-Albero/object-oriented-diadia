package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.fixture.Fixture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class ComandoPrendiTest {
	
	public Partita partita;
	private IO console;
	private Comando comando;
	
	
	@Before
	public void setUp() {
		Labirinto labirinto = new LabirintoBuilder().addEntrata("Atrio").addAttrezzo("matita", 1).getLabirinto();
		this.partita = new Partita(labirinto);
		this.console = new IOConsole();
		
		comando = new ComandoPrendi();
		comando.setIO(console);
	}

	@Test
	public void testPrendiAttrezzoEsistente() {
		comando.setParametro("matita");
		comando.esegui(this.partita);
		assertEquals(true , this.partita.getGiocatore().getBorsa().hasAttrezzo("matita"));
		assertEquals(false, this.partita.getStanzaCorrente().hasAttrezzo("matita"));
	}
	
	@Test
	public void testPrendiAttrezzoInesistente() {
		comando.setParametro("martello");
		comando.esegui(this.partita);
		assertEquals(false, this.partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
		assertEquals(false, this.partita.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	private void borsaPiena() {
		boolean flag;
		do {
			flag = this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("martello", 1));
		}
		while(flag);
	}
	
	@Test
	public void testPrendiAttrezzoSuBorsaPiena() {
		borsaPiena();
		comando.setParametro("matita");
		comando.esegui(this.partita);
		assertEquals(false, this.partita.getGiocatore().getBorsa().hasAttrezzo("matita"));
		assertEquals(true, this.partita.getStanzaCorrente().hasAttrezzo("matita"));
	}
	
	@Test
	public void testSimulazioneComandoPrendi() {
		String[] comandi = {"vai sud", "prendi osso", "prendi lanterna", "posa lanterna", "fine"};
		IOSimulator io = Fixture.creaSimulazioneEGioca(comandi, Fixture.labirintoDefault());		
		assertTrue(io.hasMessaggio(IOSimulator.BENVENUTO));
		assertContains(DiaDia.MESSAGGIO_BENVENUTO , io.getMessaggio(IOSimulator.BENVENUTO));
		assertContains("Atrio", io.getMessaggio(IOSimulator.BENVENUTO));
		assertTrue(io.hasMessaggio(comandi[0]));
		assertContains("Aula N10", io.getMessaggio(comandi[0]));
		assertTrue(io.hasMessaggio(comandi[1]));
		assertContains(ComandoPrendi.MESSAGGIO_DI_ERRORE , io.getMessaggio(comandi[1]));
		assertTrue(io.hasMessaggio(comandi[2]));
		assertContains(ComandoPrendi.MESSAGGIO_DI_CONFERMA , io.getMessaggio(comandi[2]));
		assertTrue(io.hasMessaggio(comandi[3]));
		assertContains(ComandoPosa.MESSAGGIO_DI_CONFERMA, io.getMessaggio(comandi[3]));
		assertTrue(io.hasMessaggio(comandi[4]));
		assertEquals(ComandoFine.MESSAGGIO_FINE , io.getMessaggio(comandi[4]));
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertEquals(true, interaRiga.contains(expected));
	}
}
