package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LabirintoTest {
	private Labirinto monolocale;
	private Labirinto bilocale;
	
	@Before
	public void setUp() {
		this.monolocale = new LabirintoBuilder(1,0).addEntrata("atrio").addUscita("atrio").getLabirinto();
		this.bilocale = new LabirintoBuilder(2,5).addEntrata("atrio").addUscita("atrio").getLabirinto();
	}
	
	
	@Test
	public void testAddStanzaNonNulla() {
		assertEquals(true, this.bilocale.addStanza(new Stanza("bagno")));
	}
	
	@Test
	public void testAddStanzaNulla() {
		assertEquals(false, this.bilocale.addStanza(null));
	}
	
	@Test
	public void testAddStanzaSuLabirintoPieno() {
		assertEquals(false, this.monolocale.addStanza(new Stanza("bagno")));
	}
	
	@Test
	public void testAddAttrezzoNonNullo() {
		assertEquals(true, this.bilocale.addAttrezzo(new Attrezzo("osso", 1)));
	}
	
	@Test
	public void testAddAttrezzoNullo() {
		assertEquals(false, this.monolocale.addAttrezzo(null));
	}
	
	@Test
	public void testAddAttrezzoSuLabirintoPieno() {
		assertEquals(false, this.monolocale.addAttrezzo(new Attrezzo("osso", 1)));
	}

}
