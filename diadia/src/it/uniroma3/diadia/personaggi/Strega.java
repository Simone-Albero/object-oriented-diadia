package it.uniroma3.diadia.personaggi;

import java.util.Collections;
import java.util.List;

import it.uniroma3.diadia.CaricaotreCostanti;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.ComparatoreStanzaPerNumeroAttrezzi;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_AZIONE_NEGATIVA = CaricaotreCostanti.getCostante("strega_messaggio_azione_negativa");
	private static final String MESSAGGIO_AZIONE_POSITIVA = CaricaotreCostanti.getCostante("strega_messaggio_azione_positiva");
	private static final String MESSAGGIO_DONO = CaricaotreCostanti.getCostante("strega_messaggio_dono");
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	public Strega() {
		super();
	}

	@Override
	public String agisci(Partita partita) {
		String messaggio;
		
		if(this.haSalutato()) {
			messaggio = MESSAGGIO_AZIONE_POSITIVA;
			partita.setStanzaCorrente(getStanzaMaxAttrezzi(partita.getStanzaCorrente()));
		}
		else {
			messaggio = MESSAGGIO_AZIONE_NEGATIVA;
			partita.setStanzaCorrente(getStanzaMinAttrezzi(partita.getStanzaCorrente()));	
		}
		return messaggio;
	}
	
	private Stanza getStanzaMinAttrezzi(Stanza stanza) {
		List<Stanza> list = stanza.getStanzeAdiacenti();
		return Collections.min(list, new ComparatoreStanzaPerNumeroAttrezzi());
		
	}
	
	private Stanza getStanzaMaxAttrezzi(Stanza stanza) {
		List<Stanza> list = stanza.getStanzeAdiacenti();
		return Collections.max(list, new ComparatoreStanzaPerNumeroAttrezzi());
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return MESSAGGIO_DONO;
	}

}
