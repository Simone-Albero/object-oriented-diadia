
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Cerca, se possibile, di prendere un attrezzo, altrimenti stampa un messaggio di errore
 */
public class ComandoPrendi extends AbstractComando {

	public static final String MESSAGGIO_DI_ERRORE = "Impossibile prendere l'attrezzo!";
	public static final String MESSAGGIO_DI_CONFERMA = "Attrezzo preso con successo!"; 


	@Override
	public void esegui(Partita partita) {
		if(this.parametro==null) {
			this.console.mostraMessaggio("Ecco gli attrezzi che puoi prendere: ");
			boolean trovatoAttrezzi = false;

			for(Attrezzo attrezzo : partita.getStanzaCorrente().getAttrezzi())
				if(attrezzo != null) {
					this.console.mostraMessaggio("- "+attrezzo.toString());
					trovatoAttrezzi = true;
				}

			if(!trovatoAttrezzi)
				this.console.mostraMessaggio("Non ci sono attrezzi nella stanza!");

			this.console.mostraMessaggio("Cosa vuoi prendere?");
			this.parametro = this.console.leggiRiga();
		}

		boolean flag= partita.getGiocatore().storeAttrezzo(this.parametro, partita.getStanzaCorrente());
		if(flag)
			this.console.mostraMessaggio(MESSAGGIO_DI_CONFERMA);
		else
			this.console.mostraMessaggio(MESSAGGIO_DI_ERRORE);
	}

}
