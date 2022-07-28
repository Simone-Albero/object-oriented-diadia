
package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {

	private LabirintoBuilder builder;

	@Before
	public void setUp() {
		this.builder = new Labirinto.LabirintoBuilder(2,2);
		this.builder.addStanza("Atrio").addAttrezzo("chiave", 1, "Atrio");
	}

	@Test
	public void testAddEntrataSuStanzaPresenteInLabirinto() {
		assertEquals(new Stanza("Atrio"), this.builder.addEntrata("Atrio").getLabirinto().getEntrata());
		assertEquals(1, this.builder.getStanze().size());
	}
	
	@Test
	public void testAddEntrataSuStanzaNonPresenteInLabirinto() {
		assertEquals(new Stanza("Segreteria"), this.builder.addEntrata("Segreteria").getLabirinto().getEntrata());
		assertEquals(2, this.builder.getStanze().size());
	}
	
	@Test
	public void testAddEntrataSuStanzaNulla() {
		assertNull(this.builder.addEntrata(null).getLabirinto().getEntrata());
		assertEquals(1, this.builder.getStanze().size());
	}

	@Test
	public void testAddUscitaSuStanzaPresenteInLabirinto() {
		assertEquals(new Stanza("Atrio"), this.builder.addUscita("Atrio").getLabirinto().getUscita());
		assertEquals(1, this.builder.getStanze().size());
	
	}

	@Test
	public void testAddUscitaSuStanzaNonPresenteInLabirinto() {
		assertEquals(new Stanza("Segreteria"), this.builder.addUscita("Segreteria").getLabirinto().getUscita());
		assertEquals(2, this.builder.getStanze().size());
	}
	
	@Test
	public void testAddUscitaSuStanzaNulla() {
		assertNull(this.builder.addUscita(null).getLabirinto().getUscita());
		assertEquals(1, this.builder.getStanze().size());
	}
	
	@Test
	public void testAddAttrezzoSuLabirintoNonPieno() {
		assertTrue(this.builder.addAttrezzo("osso", 0, "Atrio").getAttrezzi().contains(new Attrezzo("osso", 0)));
		assertEquals(2, this.builder.getAttrezzi().size());
	}
	
	@Test
	public void testAddAttrezzoSuLabirintoPieno() {
		assertFalse(this.builder.addAttrezzo("osso", 0, "Atrio").addAttrezzo("martello", 3, "Atrio").getAttrezzi().contains(new Attrezzo("martello", 3)));
		assertEquals(2, this.builder.getAttrezzi().size());
	}
	
	@Test
	public void testAddAttrezzoConNomeNonUnivoco() {
		assertEquals(1, this.builder.addAttrezzo("chiave", 1, "Atrio").getAttrezzi().size());
	}
	
	@Test
	public void testAddAttrezzoNullo() {
		assertEquals(1, this.builder.addAttrezzo(null, 1, "Atrio").getAttrezzi().size());
	}

	@Test
	public void testAddStanzaSuLabirintoNonPieno() {
		assertTrue(this.builder.addStanza("Bagno").getStanze().containsKey("Bagno"));
		assertEquals(2, this.builder.getStanze().size());
	}
	
	@Test
	public void testAddStanzaSuLabirintoPieno() {
		assertFalse(this.builder.addStanza("Cucina").addStanza("Bagno").getStanze().containsKey("Bagno"));
		assertEquals(2, this.builder.getStanze().size());
	}

	@Test
	public void testAddAdiacenzaSuStanzeEsistenti() {
		assertEquals("Atrio", this.builder.addEntrata("Cucina").addAdiacenza("Cucina", "Atrio", "nord").getLabirinto().getEntrata().getStanzaAdiacente("nord").getNome());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddAdiacenzaSuStanzeInesistenti() {
		this.builder.addEntrata("Cucina").addAdiacenza("Cucina", "Bagno", "nord").getLabirinto();
	}

}
