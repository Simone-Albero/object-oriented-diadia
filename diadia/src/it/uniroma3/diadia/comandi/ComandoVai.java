
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore 
 */
public class ComandoVai extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;

		if(this.parametro==null) {
			this.console.mostraMessaggio("Ecco le direzioni in cui puoi andare:");
			for(Direzione currDirezione : stanzaCorrente.getDirezioni())
				this.console.mostraMessaggio("- "+currDirezione.toString());

			this.console.mostraMessaggio("Dove vuoi andare?");
			this.parametro = this.console.leggiRiga();
		}

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.parametro);
		if (prossimaStanza == null)
			this.console.mostraMessaggio("Direzione inesistente!\n");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}

		this.console.mostraMessaggio("Attualmente ti trovi qui:\n"+partita.getStanzaCorrente().getDescrizione());

	}
}
