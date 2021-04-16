package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

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
		String direzione = this.partita.getStanzaCorrente().getDirezioni()[0];
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

}
