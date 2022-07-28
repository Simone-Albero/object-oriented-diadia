package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {

	private static final String MESSAGGIO_CHI = "Chi dovrei salutare?...";

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();

		if (personaggio!=null) {	
			this.console.mostraMessaggio(personaggio.saluta());
		} 

		else 
			this.console.mostraMessaggio(MESSAGGIO_CHI);
	}

}
