package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	
	private Stanza stanze[];
	private Stanza stanza;
	private Attrezzo attrezo;
	
	@Before
	public void setUp() {
		this.stanze = new Stanza[2];
		this.stanze[0] = new Stanza("atrio"); 
		this.stanze[1] = new Stanza("biblioteca");
		this.stanze[0].impostaStanzaAdiacente("nord", stanze[1]);
		
		this.stanza = new Stanza("atrio");
		this.attrezo = new Attrezzo("osso", 10); 
		stanza.addAttrezzo(this.attrezo); 
		
	}
	
	
	@Test
	public void testGetStanzaAdiacenteNonNulla() { 
		assertEquals(this.stanze[1], this.stanze[0].getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteNulla() {
		assertEquals(null, this.stanze[0].getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneInesistente() {
		assertEquals(null, this.stanze[0].getStanzaAdiacente("pippo"));
	}
	
	@Test
	public void testGetAttrezzoNonNullo() {
		assertEquals(this.attrezo , this.stanza.getAttrezzo("osso"));
	}
	
	@Test
	public void testGetAttrezzoNullo() {
		assertEquals(null , this.stanza.getAttrezzo(null));
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		assertEquals(null , this.stanza.getAttrezzo("pippo"));
	}

}
