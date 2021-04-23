
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {
	
	StanzaBuia stanzaLuminosa;
	StanzaBuia stanzaBuia;
	
	@Before
	public void setUp() {
		this.stanzaLuminosa = new StanzaBuia("palestra", "lanterna");
		this.stanzaLuminosa.addAttrezzo(new Attrezzo("lanterna", 1));
		this.stanzaBuia = new StanzaBuia("cucina", "lanterna");
		this.stanzaLuminosa.addAttrezzo(new Attrezzo("osso", 1));
	}

	@Test
	public void testGetDescrizioneSuStanzaLuminosa() {
		Stanza stanzaTest = (Stanza)this.stanzaLuminosa;
		assertEquals(stanzaTest.getDescrizione(), this.stanzaLuminosa.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSuStanzaBuia() {
		assertEquals(StanzaBuia.Buio , this.stanzaBuia.getDescrizione());
	}

}
