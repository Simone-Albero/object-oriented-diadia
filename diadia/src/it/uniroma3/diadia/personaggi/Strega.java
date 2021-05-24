package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.ComparatoreStanzaPerNumeroAttrezzi;
import it.uniroma3.diadia.ambienti.Stanza;

public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_NEGATIVO = "Ma come... non si saluta?! ecco cosa ti meriti... puff!";
	private static final String MESSAGGIO_POSITIVO = "Sei di buone maniere! che la fortuna ti assista... puff!";

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String messaggio;
		
		if(this.haSalutato()) {
			messaggio = MESSAGGIO_POSITIVO;
			partita.setStanzaCorrente(getStanzaMaxAttrezzi(partita.getStanzaCorrente()));
		}
		else {
			messaggio = MESSAGGIO_NEGATIVO;
			partita.setStanzaCorrente(getStanzaMinAttrezzi(partita.getStanzaCorrente()));	
		}
		return messaggio;
	}
	
	private Stanza getStanzaMinAttrezzi(Stanza stanza) {
		List<Stanza> list = stanza.getStanzeAdiacenti();
		list.sort(new ComparatoreStanzaPerNumeroAttrezzi());
		return list.get(0);
	}
	
	private Stanza getStanzaMaxAttrezzi(Stanza stanza) {
		List<Stanza> list = stanza.getStanzeAdiacenti();
		list.sort(new ComparatoreStanzaPerNumeroAttrezzi());
		return list.get(list.size()-1);
	}

}
