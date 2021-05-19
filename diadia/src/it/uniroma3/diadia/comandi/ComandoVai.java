
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore 
 */
public class ComandoVai implements Comando {
	
	private static final String NOME = "ComandoVai";
	private String direzione;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(this.direzione==null) {
			this.console.mostraMessaggio("Ecco le direzioni in cui puoi andare:");
			for(Direzione currDirezione : stanzaCorrente.getDirezioni())
				this.console.mostraMessaggio("- "+currDirezione.toString());
			
			this.console.mostraMessaggio("Dove vuoi andare?");
			direzione = this.console.leggiRiga();
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null)
			this.console.mostraMessaggio("Direzione inesistente!\n");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		
		this.console.mostraMessaggio("Attualmente ti trovi qui:\n"+partita.getStanzaCorrente().getDescrizione());

	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;

	}
	
	@Override
	public void setIO(IO console) {
		this.console = console;
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}

}
