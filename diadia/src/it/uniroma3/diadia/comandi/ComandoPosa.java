
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


/**
 * Cerca, se possibile, di posare un attrezzo nella stanza, altrimenti stampa un messaggio di errore
 */
public class ComandoPosa extends AbstractComando {

	public static final String MESSAGGIO_DI_CONFERMA = "Attrezzo posato con successo!";
	public static final String MESSAGGIO_DI_ERRORE = "Impossibile posare l'attrezzo!";

	@Override
	public void esegui(Partita partita) {
		if(this.parametro==null) {
			this.console.mostraMessaggio("Ecco il tuo inventario:\n"+partita.getGiocatore().getBorsa().toString());
			if(partita.getGiocatore().getBorsa().isEmpty())
				return;
			
			this.console.mostraMessaggio("Cosa vuoi posare?");
			this.parametro = this.console.leggiRiga();
		}

		boolean flag =  partita.getGiocatore().dropAttrezzo(this.parametro, partita.getStanzaCorrente());

		if(flag)
			this.console.mostraMessaggio(MESSAGGIO_DI_CONFERMA);
		else
			this.console.mostraMessaggio(MESSAGGIO_DI_ERRORE);
	}
}





