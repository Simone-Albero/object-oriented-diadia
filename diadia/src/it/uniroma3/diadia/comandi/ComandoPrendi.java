
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Cerca, se possibile, di prendere un attrezzo, altrimenti stampa un messaggio di errore
 */
public class ComandoPrendi implements Comando {

	public static final String MESSAGGIO_DI_ERRORE = "Impossibile prendere l'attrezzo!";
	public static final String MESSAGGIO_DI_CONFERMA = "Attrezzo preso con successo!";
	private static final String NOME = "ComandoPrendi"; 

	private String nomeAttrezzo;
	private IO console;

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
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
			nomeAttrezzo = this.console.leggiRiga();
		}

		boolean flag= partita.getGiocatore().storeAttrezzo(nomeAttrezzo, partita.getStanzaCorrente());
		if(flag)
			this.console.mostraMessaggio(MESSAGGIO_DI_CONFERMA);
		else
			this.console.mostraMessaggio(MESSAGGIO_DI_ERRORE);
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

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
		return this.nomeAttrezzo;
	}

}
