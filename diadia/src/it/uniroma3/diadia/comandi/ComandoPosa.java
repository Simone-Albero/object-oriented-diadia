
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;


/**
 * Cerca, se possibile, di posare un attrezzo nella stanza, altrimenti stampa un messaggio di errore
 */
public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			this.console.mostraMessaggio("Ecco il tuo inventario:\n"+partita.getGiocatore().getBorsa().toString());
			this.console.mostraMessaggio("Cosa vuoi posare?");
			nomeAttrezzo = this.console.leggiRiga();
		}
		
		boolean flag =  partita.getGiocatore().dropAttrezzo(nomeAttrezzo, partita.getStanzaCorrente());
		
		if(flag)
			this.console.mostraMessaggio("Attrezzo posato con successo!");
		else
			this.console.mostraMessaggio("Impossibile posare l'attrezzo!");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void setIO(IO console) {
		this.console = console;
	}

}





