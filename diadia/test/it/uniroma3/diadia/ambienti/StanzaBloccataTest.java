
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;

	@Before
	public void setUp() {
		this.stanzaBloccata = new StanzaBloccata("atrio", "ovest", "chiave");
		this.stanzaBloccata.setStanzaAdiacente("nord", new Stanza("cucina"));
	}

	@Test
	public void testGetStanzaAdiacenteSuStanzaBloccataConSblocco() {
		this.stanzaBloccata.addAttrezzo(new Attrezzo("chiave",1));
		Stanza test = (Stanza)this.stanzaBloccata;
		assertEquals(test.getStanzaAdiacente("ovest"), this.stanzaBloccata.getStanzaAdiacente("ovest") );
	}
	
	@Test
	public void testGetStanzaAdiacenteSuStanzaBloccataSenzaSblocco() {
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("ovest") );
	}
	
	@Test
	public void testGetStanzaAdiacenteSuDirezioneNonBloccata() {
		assertEquals("cucina", this.stanzaBloccata.getStanzaAdiacente("nord").getNome() );
	}
	
	@Test
	public void testGetStanzaAdiacenteSuDirezioneInesistente() {
		assertEquals(null, this.stanzaBloccata.getStanzaAdiacente("pippo") );
	}
}
