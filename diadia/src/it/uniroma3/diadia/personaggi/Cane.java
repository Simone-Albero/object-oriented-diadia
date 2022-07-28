package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.CaricaotreCostanti;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {

	private static final String CIBO_PREFERITO = CaricaotreCostanti.getCostante("cane_cibo_preferito");
	private static final String MESSAGGIO_AZIONE = CaricaotreCostanti.getCostante("cane_messaggio_azione");
	private static final String MESSAGGIO_DONO = CaricaotreCostanti.getCostante("cane_messaggio_dono");
	
	public Cane() {
		super();	
	}
	
	public Cane(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.setPresent(attrezzo);
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MESSAGGIO_AZIONE;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			partita.getStanzaCorrente().addAttrezzo(this.getPresent());
			this.setPresent(attrezzo);
		}
		else {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			partita.getStanzaCorrente().addAttrezzo(this.getPresent());
			this.setPresent(attrezzo);
		}
		
		return MESSAGGIO_DONO;
	}

}
