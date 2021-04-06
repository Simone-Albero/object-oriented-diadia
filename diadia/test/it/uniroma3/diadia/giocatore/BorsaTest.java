package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("osso", 1);
		this.borsa.addAttrezzo(this.attrezzo);
	}

	@Test
	public void testAddAttrezzoNonNullo() {
		assertEquals(true, this.borsa.addAttrezzo(new Attrezzo("osso", 5)));
	}
	
	@Test
	public void testAddAttrezzoNonNulloPesoFuoriLimite() {
		assertEquals(false, this.borsa.addAttrezzo(new Attrezzo("osso", 11)));
	}
	
	@Test
	public void testAddAttrezzoNullo() {
		assertEquals(false, this.borsa.addAttrezzo(null));
	}
	
	void borsaPiena() {
		for(int i=0; i<10; i++) 
			this.borsa.addAttrezzo(new Attrezzo("martello", 7));
	}
	
	@Test
	public void testAddAttrezzoBorsaPiena() {
		borsaPiena();
		assertEquals(false, this.borsa.addAttrezzo(new Attrezzo("osso", 10)));
	}
	
	@Test
	public void testGetAttrezzoEsistente() {
		assertEquals(this.attrezzo, this.borsa.getAttrezzo("osso"));
	}
	
	@Test
	public void testGetAttrezzoNullo() {
		assertEquals(null, this.borsa.getAttrezzo(null));
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		assertEquals(null, this.borsa.getAttrezzo("pippo"));
	}
	
	@Test
	public void testRemoveAttrezzoEsistente() {
		assertEquals(this.attrezzo, this.borsa.removeAttrezzo("osso"));
	}
	
	@Test
	public void testRemoveAttrezzoNullo() {
		assertEquals(null, this.borsa.removeAttrezzo(null));
	}
	
	@Test
	public void testRemoveAttrezzoInesistente() {
		assertEquals(null, this.borsa.removeAttrezzo("pippo"));
	}
}
