package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class ComandoPrendiTest {
	
	public Partita partita;
	private IO console;
	private Comando comando;
	
	
	@Before
	public void setUp() {
		this.partita = new Partita();
		this.console = new IOConsole();

		this.partita.getStanzaCorrente().addAttrezzo(new Attrezzo("matita", 1));
		
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
	public void testPrendiAttrezzoSuStanzaPiena() {
		borsaPiena();
		comando.setParametro("matita");
		comando.esegui(this.partita);
		assertEquals(false, this.partita.getGiocatore().getBorsa().hasAttrezzo("matita"));
		assertEquals(true, this.partita.getStanzaCorrente().hasAttrezzo("matita"));
	}
}
