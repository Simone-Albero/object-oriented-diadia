package it.uniroma3.diadia.fixture;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

public class Fixture {
	public static IOSimulator creaSimulazioneEGioca(String[] comandi) {
		IOSimulator io = new IOSimulator(comandi);
		new DiaDia(io).gioca();
		return io;
	}
}
