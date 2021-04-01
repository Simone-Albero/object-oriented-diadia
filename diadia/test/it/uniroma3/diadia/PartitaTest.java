package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	private Partita partita;
	
	@Before
	public void setUp() {
		this.partita = new Partita();
	}
	
	
	@Test
	public void testVintaPartitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertEquals(true, this.partita.vinta());
	}
	
	@Test
	public void testVintaPartitaNonVinta() {
		this.partita.setStanzaCorrente(new Stanza("Bagno"));
		assertEquals(false, this.partita.vinta());
	}
	
	@Test
	public void testVintaStanzaCorrenteNulla() {
		this.partita.setStanzaCorrente(null);
		assertEquals(false, this.partita.vinta());
	}
	
	@Test
	public void testIsFinitaPartitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertEquals(true, this.partita.isFinita());
	}
	
	@Test
	public void testIsFinitaPartitaFinita() {
		this.partita.setFinita();
		assertEquals(true, this.partita.isFinita());
	}
	
	@Test
	public void testIsFinitaZeroCFU() {
		this.partita.getGiocatore().setCfu(0);
		assertEquals(true, this.partita.isFinita());
	}
	
	@Test
	public void testIsFinitaPartitaNonFinita() {
		assertEquals(false, this.partita.isFinita());
	}

}
