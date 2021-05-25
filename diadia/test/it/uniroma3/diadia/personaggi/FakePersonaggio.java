package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class FakePersonaggio extends AbstractPersonaggio {
	
	public static final String MESSAGGIO_RICEVI_REGALO = "RiceviRegalo done";
	public static final String MESSAGGIO_AGISCI = "Agisci done";
	public static final String NOME = "FakePersonaggio";
	public static final String PRESENTAZIONE = "Classe di Test";

	public FakePersonaggio() {
		super(NOME, PRESENTAZIONE);
	}
	
	public FakePersonaggio(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		return MESSAGGIO_AGISCI;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return MESSAGGIO_RICEVI_REGALO;
	}

}
