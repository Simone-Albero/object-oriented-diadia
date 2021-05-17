
package it.uniroma3.diadia;

/**
 * IO:
 * interfaccia che modella la gestione dell’Input e dell’Output.
 * @author Simone
 * @see IOConsole
 * @see IOSimulator
 */
public interface IO {
	/**
	 * Fornisce una rappresentazione dei messaggi ottenuti nel corso del gioco
	 * @param messaggio Oggetto istanza della classe String 
	 */
	 public void mostraMessaggio(String messaggio);
	 
	 /**
	  * Fornisce una rappresentazione Stringa di un Comando
	  * @return Restituisce un Oggetto istanza della classe String
	  */
	 public String leggiRiga();
}
