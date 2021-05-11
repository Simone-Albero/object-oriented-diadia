
package it.uniroma3.diadia.fixture;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class Fixture {
	public static IOSimulator creaSimulazioneEGioca(String[] comandi) {
		IOSimulator io = new IOSimulator(comandi);
		Labirinto labirinto = new LabirintoBuilder()
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
			.addAdiacenza("Aula N11", "Atrio", "ovest")
			.addAdiacenza("Aula N10", "Atrio", "nord")
			.addAdiacenza("Aula N10", "Aula N11", "est")
			.addAdiacenza("Aula N10", "Laboratorio Campus", "ovest")
			.addAdiacenza("Laboratorio Campus", "Atrio", "est")
			.addAdiacenza("Laboratorio Campus", "Aula N11", "ovest")
			.addAdiacenza("Biblioteca", "Atrio", "sud")
			.getLabirinto();
		new DiaDia(io, labirinto).gioca();
		return io;
	}
}
