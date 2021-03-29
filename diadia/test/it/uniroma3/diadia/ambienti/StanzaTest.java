package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Test;

public class StanzaTest {
	
	private Stanza[] stanzeAdiacenti(String s1, String s2, String direzione) {
		Stanza stanze[] = {new Stanza(s1), new Stanza(s2)};
		stanze[0].impostaStanzaAdiacente(direzione, stanze[1]);
		return stanze;
	}
	
	
	@Test
	public void testGetStanzaAdiacenteNonNulla() {
		Stanza stanza[] = stanzeAdiacenti("atrio", "biblioteca", "nord"); 
		assertEquals(stanza[1], stanza[0].getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteNulla() {
		Stanza stanza[] = stanzeAdiacenti("atrio", "biblioteca", "nord"); 
		assertEquals(null, stanza[0].getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneInesistente() {
		Stanza stanza[] = stanzeAdiacenti("atrio", "biblioteca", "nord"); 
		assertEquals(null, stanza[0].getStanzaAdiacente("pippo"));
	}
	
	@Test
	public void testGetAttrezzoNonNullo() {
		Stanza stanza = new Stanza("atrio");
		Attrezzo a = new Attrezzo("osso", 10); 
		stanza.addAttrezzo(a); 
		assertEquals(a, stanza.getAttrezzo("osso"));
	}
	
	@Test
	public void testGetAttrezzoNullo() {
		Stanza stanza = new Stanza("atrio");
		Attrezzo a = new Attrezzo("osso", 10); 
		stanza.addAttrezzo(a); 
		assertEquals(null, stanza.getAttrezzo(null));
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		Stanza stanza = new Stanza("atrio");
		Attrezzo a = new Attrezzo("osso", 10); 
		stanza.addAttrezzo(a); 
		assertEquals(null, stanza.getAttrezzo("pippo"));
	}

}
