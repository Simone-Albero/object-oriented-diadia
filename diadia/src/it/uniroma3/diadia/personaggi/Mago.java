package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {

	private static final String MESSAGGIO_REGALO = "Ho apprezzato il tuo regalo, permettimi di ricompensarti!";

	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.setPresent(attrezzo);
	}
	
	public Mago() {
		super();
	}
	
	@Override
	public String agisci(Partita partita) {
		String messaggio;
	
		if (this.getPresent()!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.getPresent());
			this.setPresent(null);
			messaggio = MESSAGGIO_DONO;
		}
		else {
			messaggio = MESSAGGIO_SCUSE;
		}
		return messaggio;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder nome = new StringBuilder(attrezzo.getNome());
		nome.reverse();
		Attrezzo regalo = new Attrezzo (nome.toString(), attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(regalo);
		return MESSAGGIO_REGALO;
	}

}
