
package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Partita:
 * Questa classe modella una partita del gioco.
 * Partita è caratterizzara da un "Labirinto" in cui sono situate le stanze del gioco,
 * da un Giocatore responasbile della gestione del punteggio e dell'inventario,
 * una "stanzaVincente" considerata come la stanza finale del gioco
 * una "stanzaCorrente" considerata come la stanza di partenza in cui è situato il giocatore
 * e una variabile booleana "finita" che dichiara la fine del gioco
 * 
 * @author  docente di POO
 * @see Stanza
 * @see Labirinto
 * @version 0.1
 */

public class Partita {

	private Labirinto labirinto;
	private Giocatore giocatore;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	
	/**
	 * Genera la Partita inizializzando il Giocatore e il Labirinto
	 * @see Labirinto
	 * @see Giocatore
	 */
	public Partita(){
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		this.setStanzaCorrente(this.labirinto.getEntrata());  
		this.setStanzaVincente(this.labirinto.getUscita());
		this.finita = false;
	}

	/**
	 * Imposta la stanza che decreta la fine del gioco
	 * @param stanzaVincente Oggetto istanza della classe Stanza che identifica la stanza vincente
	 * @see Stanza
	 */
	private void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente= stanzaVincente;
	}
	
	/**
	 * Riporta la stanza finale del gioco
	 * @return Restituisce un oggetto istanza della classe Stanza
	 * @see Stanza
	 */
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	/**
	 * Imposta la stanza in cui si trova il giocatore
	 * @param stanzaCorrente Oggetto istanza della classe stanza che identifica la stanza in cui si trvoa il giocatore
	 * @see Stanza
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	/**
	 * Riporta la stanza in cui si trova il giocatore
	 * @return Restituisce un oggetto istanza della classe Stanza
	 * @see Stanza
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	/**
	 * Verifica se la partita è stata vinta
	 * @return Restituisce il booleano TRUE se il giocatore e' nella stanza vincente, altrimenti FALSE
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.getStanzaVincente();
	}

	/**
	 * Verifica se la partita è finita
	 * @return Restituisce il booleano TRUE se la partita e' terminata, altrimenti FALSE
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	/**
	 * Riporta il giocatore
	 * @return Restituisce un oggetto istanza della classe Giocatore
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	
}
