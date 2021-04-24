
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;


/**
 * Cerca, se possibile, di posare un attrezzo nella stanza, altrimenti stampa un messaggio di errore
 */
public class ComandoPosa implements Comando {
	
	public static final String MESSAGGIO_DI_CONFERMA = "Attrezzo posato con successo!";
	public static final String MESSAGGIO_DI_ERRORE = "Impossibile posare l'attrezzo!";
	private static final String NOME = "ComandoPosa";
	
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





