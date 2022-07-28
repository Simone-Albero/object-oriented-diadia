package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GiocatoreTest {
	
	private Giocatore giocatore;
	private Stanza stanza;
	
	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
		
		this.stanza = new Stanza("atrio");
		this.stanza.addAttrezzo(new Attrezzo("osso", 3));
		
		this.giocatore.getBorsa().addAttrezzo(new Attrezzo("martello", 1));
	}
	
	@Test
	public void testStoreAttrezzoEsistente() {
		assertEquals(true, this.giocatore.storeAttrezzo("osso", this.stanza));
	}
	
	@Test
	public void testStoreAttrezzoNullo() {
		assertEquals(false, this.giocatore.storeAttrezzo(null, this.stanza));
	}
	
	@Test
	public void testStoreAttrezzoInesistente() {
		assertEquals(false, this.giocatore.storeAttrezzo("pippo", this.stanza));
	}
	
	@Test
	public void testStoreAttrezzoSuStanzaNulla() {
		assertEquals(false, this.giocatore.storeAttrezzo("osso", null));
	}
	
	@Test
	public void testDropAttrezzoEsistente() {
		assertEquals(true, this.giocatore.dropAttrezzo("martello", this.stanza));
	}

	@Test
	public void testDropAttrezzoNullo() {
		assertEquals(false, this.giocatore.dropAttrezzo(null, this.stanza));
	}
	
	@Test
	public void testDropAttrezzoInesistente() {
		assertEquals(false, this.giocatore.dropAttrezzo("pippo", this.stanza));
	}
	
	@Test
	public void testDropAttrezzoSuStanzaNulla() {
		assertEquals(false, this.giocatore.dropAttrezzo("martello", null));
	}
}
