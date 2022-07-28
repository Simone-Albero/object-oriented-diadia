
package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class BorsaTest {
	
	private Borsa borsa;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("libro", 3);
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
	
	private void borsaPiena() {
		boolean flag;
		do {
			flag = this.borsa.addAttrezzo(new Attrezzo("osso", 1));
		}
		while(flag);
	}
	
	@Test
	public void testAddAttrezzoBorsaPiena() {
		borsaPiena();
		assertEquals(false, this.borsa.addAttrezzo(new Attrezzo("osso", 10)));
	}
	
	@Test
	public void testGetAttrezzoEsistente() {
		assertEquals(this.attrezzo, this.borsa.getAttrezzo("libro"));
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
		assertEquals(this.attrezzo, this.borsa.removeAttrezzo("libro"));
	}
	
	@Test
	public void testRemoveAttrezzoNullo() {
		assertEquals(null, this.borsa.removeAttrezzo(null));
	}
	
	@Test
	public void testRemoveAttrezzoInesistente() {
		assertEquals(null, this.borsa.removeAttrezzo("pippo"));
	}
	
	private Borsa borsaNonOrdinata() {
		Borsa borsa = new Borsa ();
		borsa.addAttrezzo(new Attrezzo("martello", 5));
		borsa.addAttrezzo(new Attrezzo("piuma", 1));
		borsa.addAttrezzo(new Attrezzo("libro", 3));
		return borsa;
		
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoSuSequenzaDisordinata() {
		Borsa borsaDisordinata = borsaNonOrdinata();
		List<Attrezzo> sortedList = borsaDisordinata.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> iter = sortedList.iterator();
		assertEquals(1 , iter.next().getPeso());
		assertEquals(3 , iter.next().getPeso());
		assertEquals(5 , iter.next().getPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoSuSequenzaDisordinataConAttrezziStessoPeso() {
		Borsa borsaDisordinata = borsaNonOrdinata();
		borsaDisordinata.addAttrezzo(new Attrezzo("osso", 1));
		List<Attrezzo> sortedList = borsaDisordinata.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> iter = sortedList.iterator();
		assertEquals("osso" , iter.next().getNome());
		assertEquals("piuma" , iter.next().getNome());
		assertEquals(3 , iter.next().getPeso());
		assertEquals(5 , iter.next().getPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoSuSequenzaVuota() {
		Borsa borsaVuota = new Borsa();
		assertTrue(borsaVuota.getContenutoOrdinatoPerPeso().isEmpty());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomeSuSequenzaDisordinata() {
		Borsa borsaDisordinata = borsaNonOrdinata();
		Set<Attrezzo> sortedSet = borsaDisordinata.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> iter = sortedSet.iterator();
		assertEquals("libro" , iter.next().getNome());
		assertEquals("martello" , iter.next().getNome());
		assertEquals("piuma" , iter.next().getNome());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNomeSuSequenzaVuota() {
		Borsa borsaVuota = new Borsa();
		assertTrue(borsaVuota.getContenutoOrdinatoPerNome().isEmpty());
	}
	

	@Test
	public void testgetContenutoRaggruppatoPerPesoSuSequenzaDisordinata() {
		Borsa borsaDisordinata = borsaNonOrdinata();
		Map<Integer,Set<Attrezzo>> map = borsaDisordinata.getContenutoRaggruppatoPerPeso();

		for(Map.Entry<Integer, Set<Attrezzo>> entry: map.entrySet()) 
			for(Attrezzo curr : entry.getValue())
				assertEquals(entry.getKey() , (Integer)curr.getPeso());
	}
	
	@Test
	public void testgetContenutoRaggruppatoPerPesoSuSequenzaVuota() {
		Borsa borsaVuota = new Borsa();
		assertTrue(borsaVuota.getContenutoRaggruppatoPerPeso().isEmpty());
	}
	
	@Test
	public void testgetSortedSetOrdinatoPerPesoSuSequenzaDisordinata() {
		Borsa borsaDisordinata = borsaNonOrdinata();
		Set<Attrezzo> sortedSet = borsaDisordinata.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> iter = sortedSet.iterator();
		assertEquals(1 , iter.next().getPeso());
		assertEquals(3 , iter.next().getPeso());
		assertEquals(5 , iter.next().getPeso());
	}
	
	@Test
	public void testgetSortedSetOrdinatoPerPesoConAttrezziStessoPeso() {
		Borsa borsaDisordinata = borsaNonOrdinata();
		borsaDisordinata.addAttrezzo(new Attrezzo("osso", 1));
		Set<Attrezzo> sortedSet = borsaDisordinata.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> iter = sortedSet.iterator();
		assertEquals("osso" , iter.next().getNome());
		assertEquals("piuma" , iter.next().getNome());
		assertEquals(3 , iter.next().getPeso());
		assertEquals(5 , iter.next().getPeso());
	}
	
	@Test
	public void testgetSortedSetOrdinatoPerPesoSuSequenzaVuota() {
		Borsa borsaVuota = new Borsa();
		assertTrue(borsaVuota.getSortedSetOrdinatoPerPeso().isEmpty());
	}
	
	
}
