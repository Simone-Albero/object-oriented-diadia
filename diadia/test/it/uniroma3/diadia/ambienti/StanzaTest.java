package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	
	private Stanza stanze[];
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.stanze = new Stanza[2];
		this.stanze[0] = new Stanza("atrio"); 
		this.stanze[1] = new Stanza("biblioteca");
		this.stanze[0].impostaStanzaAdiacente("nord", stanze[1]);
		
		this.stanza = new Stanza("atrio");
		this.attrezzo = new Attrezzo("osso", 10);
		stanza.addAttrezzo(this.attrezzo);
	}
	
	@Test
	public void testAddAttrezzoNonNullo() {
		assertEquals(true , stanze[0].addAttrezzo(new Attrezzo("lanterna", 1)));
	}
	
	@Test
	public void testAddAttrezzoNullo() {
		assertEquals(false , stanze[0].addAttrezzo(null));
	}
	
	void stanzaPiena() {
		for(int i=0; i<10; i++) 
			this.stanze[0].addAttrezzo(new Attrezzo("piccone", 5));
	}
	
	@Test
	public void testAddAttrezzoSuStanzaPiena() {
		stanzaPiena();
		assertEquals(false , stanze[0].addAttrezzo(new Attrezzo("lanterna", 1)));
	}
	
	@Test
	public void testGetStanzaAdiacenteEsistente() { 
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
	public void testGetAttrezzoEsistente() {
		assertEquals(this.attrezzo , this.stanza.getAttrezzo("osso"));
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
		assertEquals(true , this.stanza.hasAttrezzo("osso"));
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
		assertEquals(true , this.stanza.removeAttrezzo(this.attrezzo));
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
