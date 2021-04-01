package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	
	private Stanza stanze[];
	private Stanza stanza;
	private Attrezzo attrezzi[];
	
	@Before
	public void setUp() {
		this.stanze = new Stanza[2];
		this.stanze[0] = new Stanza("atrio"); 
		this.stanze[1] = new Stanza("biblioteca");
		this.stanze[0].impostaStanzaAdiacente("nord", stanze[1]);
		
		this.stanza = new Stanza("atrio");
		this.attrezzi = new Attrezzo[3];
		this.attrezzi[0] = new Attrezzo("osso", 10);
		this.attrezzi[1] = new Attrezzo("martello", 10); 
		this.attrezzi[2] = new Attrezzo("libro", 10); 
		stanza.addAttrezzo(this.attrezzi[0]); 
		stanza.addAttrezzo(this.attrezzi[1]); 
		stanza.addAttrezzo(this.attrezzi[2]); 
	}
	
	
	@Test
	public void testGetStanzaAdiacenteEsistente() { 
		assertEquals(this.stanze[1], this.stanze[0].getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteInesistente() {
		assertEquals(null, this.stanze[0].getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneInesistente() {
		assertEquals(null, this.stanze[0].getStanzaAdiacente("pippo"));
	}
	
	@Test
	public void testGetAttrezzoEsistente() {
		assertEquals(this.attrezzi[1] , this.stanza.getAttrezzo("martello"));
	}
	
	@Test
	public void testGetAttrezzoNullo() {
		assertEquals(null , this.stanza.getAttrezzo(null));
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		assertEquals(null , this.stanza.getAttrezzo("pippo"));
	}
	
	@Test
	public void testHasAttrezzoEsistente() {
		assertEquals(true , this.stanza.hasAttrezzo("libro"));
	}
	
	@Test
	public void testHasAttrezzoNullo() {
		assertEquals(false , this.stanza.hasAttrezzo(null));
	}
	
	@Test
	public void testHasAttrezzoInesistente() {
		assertEquals(false , this.stanza.hasAttrezzo("pippo"));
	}
	
	@Test
	public void testRemoveAttrezzoEsistente() {
		assertEquals(true , this.stanza.removeAttrezzo(this.attrezzi[2]));
	}
	
	@Test
	public void testRemoveAttrezzoNullo() {
		assertEquals(false , this.stanza.removeAttrezzo(null));
	}
	
	@Test
	public void testRemoveAttrezzoInesistente() {
		assertEquals(false , this.stanza.removeAttrezzo(new Attrezzo("pippo", 1)));
	}
	
	
}
