package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {

	private static final String CIBO_PREFERITO = "osso";
	private static final String MESSAGGIO = "Woff-Woff!";
	
	private Attrezzo present;
	
	public Cane(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.present = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MESSAGGIO;
	}
	
	public void setPresent(Attrezzo present) {
		this.present = present;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			partita.getStanzaCorrente().addAttrezzo(this.present);
		}
		else
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
		return MESSAGGIO;
	}

}
