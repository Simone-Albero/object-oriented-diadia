
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


/**
 * Stampa informazioni di aiuto.
 */
public class ComandoAiuto extends AbstractComando {

	public static final String MESSAGGIO_DI_CONFERMA = "Ecco i comandi che hai a disposizione:";

	//TODO rendi automatizzato l'elenco dei comandi
	static final private String[] elencoComandi = {
			"- vai: Permette di cambiare stanza inserendo la direzione in cui ci si vuole spostare", 
			"- aiuto: Lista dei comandi diponibili", 
			"- fine: Termina la partita", 
			"- prendi: Permette se possibile di prendere un oggetto da una stanza", 
			"- posa: Permette se possibile di posare un oggetto in una stanza",
			"- interagisci: Permette di interagire con un personaggio presente nella stanza",
			"- saluta: permette di salutare un personaggio presente nella stanza",
	"- guarda: Da informazioni sullo stato della partita (stanza corrente e punteggio)"};

 
	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio(MESSAGGIO_DI_CONFERMA);
		for(int i=0; i< elencoComandi.length; i++) 
			this.console.mostraMessaggio(elencoComandi[i]+" ");
	}
}

