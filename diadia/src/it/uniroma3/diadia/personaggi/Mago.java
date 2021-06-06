package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.CaricaotreCostanti;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {

	private static final String MESSAGGIO_AZIONE = CaricaotreCostanti.getCostante("mago_messaggio_azione");
	private static final String MESSAGGIO_SCUSE = CaricaotreCostanti.getCostante("mago_messaggio_scuse");
	private static final String MESSAGGIO_DONO = CaricaotreCostanti.getCostante("mago_messaggio_dono");
	
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
			messaggio = MESSAGGIO_AZIONE;
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
		return MESSAGGIO_DONO;
	}

}
