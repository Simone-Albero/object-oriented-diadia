package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractPersonaggioTest {

	private AbstractPersonaggio personaggio;
	private String messaggio;
	
	@Before
	public void setUp() {
		this.personaggio = new FakePersonaggio();
		this.messaggio = this.personaggio.saluta();
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertEquals(true, interaRiga.contains(expected));
	}
	
	@Test
	public void testSalutaPrimaEsecuzione() {
		assertContains(FakePersonaggio.NOME, this.messaggio);
		assertContains(FakePersonaggio.PRESENTAZIONE, this.messaggio);
	}
	
	@Test
	public void testSalutaSecondaEsecuzione() {
		this.messaggio = this.personaggio.saluta();
		assertContains(FakePersonaggio.NOME, this.messaggio);
		assertContains("Ci siamo gia' presentati!", this.messaggio);
	}

	@Test
	public void testAgisci() {
		assertEquals(FakePersonaggio.MESSAGGIO_AGISCI, this.personaggio.agisci(null));
	}

	@Test
	public void testRiceviRegalo() {
		assertEquals(FakePersonaggio.MESSAGGIO_RICEVI_REGALO, this.personaggio.riceviRegalo(null, null));
	}

}
