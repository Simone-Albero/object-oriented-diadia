package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LabirintoTest {
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.labirinto = new Labirinto(6,3);
	}
	
	
	@Test
	public void testAddStanzaNonNulla() {
		assertEquals(true, this.labirinto.addStanza(new Stanza("bagno")));
	}
	
	@Test
	public void testAddStanzaNulla() {
		assertEquals(false, this.labirinto.addStanza(null));
	}
	
	@Test
	public void testAddStanzaSuLabirintoPieno() {
		this.labirinto.addStanza(new Stanza("cucina"));
		assertEquals(false, this.labirinto.addStanza(new Stanza("bagno")));
	}
	
	@Test
	public void testAddAttrezzoNonNullo() {
		assertEquals(true, this.labirinto.addAttrezzo(new Attrezzo("osso", 1)));
	}
	
	@Test
	public void testAddAttrezzoNullo() {
		assertEquals(false, this.labirinto.addAttrezzo(null));
	}
	
	@Test
	public void testAddAttrezzoSuLabirintoPieno() {
		this.labirinto.addAttrezzo(new Attrezzo("martello", 1));
		assertEquals(false, this.labirinto.addAttrezzo(new Attrezzo("osso", 1)));
	}

}
