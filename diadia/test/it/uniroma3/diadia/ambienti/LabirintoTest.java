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
		this.monolocale = Labirinto.newBuilder().addEntrata("atrio").addUscita("atrio").getLabirinto();
		this.bilocale = Labirinto.newBuilder().addEntrata("atrio").addUscita("atrio").getLabirinto();
	}
	
}
