
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("Ecco il tuo punteggio: "+partita.getGiocatore().getCfu()+"\n");
		this.console.mostraMessaggio("Ecco il tuo inventario:\n"+partita.getGiocatore().getBorsa().toString()+"\n");
		this.console.mostraMessaggio("Attualmente ti trovi in questa stanza:\n"+partita.getStanzaCorrente().getDescrizione());	
	}

}
