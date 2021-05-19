
package it.uniroma3.diadia.fixture;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class Fixture {
	public static IOSimulator creaSimulazioneEGioca(String[] comandi, Labirinto lab) {
		IOSimulator io = new IOSimulator(comandi);
		Labirinto labirinto = lab;
		new DiaDia(io, labirinto).gioca();
		return io;
	}
	
	public static Labirinto labirintoDefault() {
		return new LabirintoBuilder()
				.addEntrata("Atrio")
				.addAttrezzo("osso",1)
				.addUscita("Biblioteca")
				.addStanza("Aula N10")
				.addAttrezzo("lanterna", 3)
				.addStanza("Aula N11")
				.addStanza("Laboratorio Campus")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Atrio", "Aula N10", "sud")
				.addAdiacenza("Atrio", "Aula N11", "est")
				.addAdiacenza("Atrio", "Laboratorio Campus", "ovest")
				.addAdiacenza("Aula N11", "Laboratorio Campus", "est")
				.addAdiacenza("Aula N10", "Aula N11", "est")
				.addAdiacenza("Aula N10", "Laboratorio Campus", "ovest")
				.getLabirinto();
	}
}
