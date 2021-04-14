package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class ComandoPosaTest {
	
	public Partita partita;
	private IO console;
	private Comando comando;
	
	
	@Before
	public void setUp() {
		this.partita = new Partita();
		this.console = new IOConsole();
		
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("matita", 1));
		
		comando = new ComandoPosa();
		comando.setIO(console);
	}

	@Test
	public void testPosaAttrezzoEsistente() {
		comando.setParametro("matita");
		comando.esegui(this.partita);
		assertEquals(true , this.partita.getStanzaCorrente().hasAttrezzo("matita"));
		assertEquals(false, this.partita.getGiocatore().getBorsa().hasAttrezzo("matita"));
	}
	
	@Test
	public void testPosaAttrezzoInesistente() {
		comando.setParametro("martello");
		comando.esegui(this.partita);
		assertEquals(false ,this.partita.getStanzaCorrente().hasAttrezzo("martello"));
		assertEquals(true, this.partita.getGiocatore().getBorsa().hasAttrezzo("matita"));
	}
	
	private void stanzaPiena() {
		boolean flag;
		do {
			flag = this.partita.getStanzaCorrente().addAttrezzo(new Attrezzo("martello", 1));
		}
		while(flag);
	}
	
	@Test
	public void testPosaAttrezzoSuStanzaPiena() {
		stanzaPiena();
		comando.setParametro("matita");
		comando.esegui(this.partita);
		assertEquals(false, this.partita.getStanzaCorrente().hasAttrezzo("matita"));
		assertEquals(true, this.partita.getGiocatore().getBorsa().hasAttrezzo("matita"));
	}
}
