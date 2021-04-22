
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaMagicaTest {

	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo;

	@Before
	public void setUp() {
		this.attrezzo = new Attrezzo("osso",1);
	}

	@Test
	public void testAddAttrezzoSottoLaSoglia() {
		this.stanzaMagica = new StanzaMagica("atrio", 1);
		assertEquals(true, this.stanzaMagica.addAttrezzo(this.attrezzo));
		assertEquals(this.attrezzo.toString(), this.stanzaMagica.getAttrezzo(this.attrezzo.getNome()).toString());
	}
	
	@Test
	public void testAddAttrezzoSopraLaSoglia() {
		this.stanzaMagica = new StanzaMagica("atrio", 0);
		assertEquals(true, this.stanzaMagica.addAttrezzo(this.attrezzo));
		assertEquals(this.stanzaMagica.modificaAttrezzoTest(this.attrezzo).toString(), this.stanzaMagica.getAttrezzo(this.attrezzo.getNome()).toString());
	}
	
	@Test
	public void testAddAttrezzoNullo() {
		this.stanzaMagica = new StanzaMagica("atrio", 0);
		assertEquals(false, this.stanzaMagica.addAttrezzo(null));
	}

}
