package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;


/**
 * Stampa informazioni di aiuto.
 */
public class ComandoAiuto implements Comando {
	
	private static final String NOME = "ComandoAiuto";

	static final private String[] elencoComandi = {
			   "- vai: Permette di cambiare stanza inserendo la direzione in cui ci si vuole spostare", 
			   "- aiuto: Lista dei comandi diponibili", 
			   "- fine: Termina la partita", 
			   "- prendi: Permette se possibile di prendere un oggetto da una stanza", 
			   "- posa: Permette se possibile di posare un oggetto in una stanza",
			   "- guarda: Da informazioni sullo stato della partita (stanza corrente e punteggio)"};
	
	private IO console;
	
	
	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("Ecco i comandi che hai a disposizione:");
		for(int i=0; i< elencoComandi.length; i++) 
			this.console.mostraMessaggio(elencoComandi[i]+" ");
	}

	@Override
	public void setParametro(String parametro) {
		//nessun parametro
		return;
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
		return null;
	}

}

