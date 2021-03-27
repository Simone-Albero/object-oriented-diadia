
package it.uniroma3.diadia;

/**
 * Partita:
 * Questa classe modella una partita del gioco.
 * Partita è caratterizzara da un "Labirinto" in cui sono situate le stanze del gioco,
 * una "stanzaVincente" considerata come la stanza finale del gioco
 * una "stanzaCorrente" considerata come la stanza in cui è situato il giocatore
 * e una variabile bolleana "finita" che dichiara la fine del gioco
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
	 * Genere la Partita a partire da un labirinto ed imposta il punteggio iniziale
	 * @see Labirinto
	 */
	public Partita(){
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		this.setStanzaCorrente(this.labirinto.getEntrata());  
		this.setStanzaVincente(this.labirinto.getUscita());
		this.finita = false;
	}

	/**
	 * Imposta la stanza finale del gioco 
	 * @param stanzaVincente Oggetto della classe stanza
	 * @see Stanza
	 */
	private void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente= stanzaVincente;
	}
	
	/**
	 * Restituisce la stanza finale del gioco
	 * @return Restituisce un oggetto della classe stanza: stanzaVincente
	 * @see Stanza
	 */
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	/**
	 * Imposta la stanza in cui è situato il giocatore
	 * @param stanzaCorrente Oggetto della classe stanza
	 * @see Stanza
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	/**
	 * Restituisce la stanza in cui è situato il giocatore
	 * @return Restituisce un oggetto della classe stanza: stanzaCorrente
	 * @see Stanza
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	/**
	 * Restituisce TRUE se e solo se il giocatore e' nella stanza vincente
	 * @return Restituisce il booleano TRUE se il giocatore e' nella stanza vincente, altrimenti FALSE
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce TURE se e solo se la partita e' finita
	 * @return Restituisce il booleano TRUE se la partita e' stata vinta, altrimenti FALSE
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
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	
}
