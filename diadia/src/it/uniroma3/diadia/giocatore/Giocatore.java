
package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Giocatore:
 * Questa classe modella il giocatore di in un gioco di ruolo.
 * Gestisce il punteggio del giocatore rappresentato dalla variabile cfu
 * e l'inventario creato da un istanza della classe Borsa
 * 
 * @author Simone
 * @see Borsa
 * @version base
 */
public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private Borsa borsa;
	private int cfu;
	/**
	 * Crea un Giocatore 
	 */
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa(); 
	}
	
	/**
	 * Riporta il punteggio del giocatore 
	 * @return Restituisce un intero
	 */
	public int getCfu() {
		return this.cfu;
	}
	
	/**
	 * Imposta il punteggio del giocatore
	 * @param cfu Intero che identifica il punteggio del giocatore
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	/**
	 * Verifica che il Giocatore abbia ancora a disposizione dei CFU
	 * @return Resituisce il booleano TRUE se la quantità di CFU è maggiore di zero, altrimenti FALSE
	 */
	public boolean isVivo() {
		if(this.cfu > 0)
			return true;
		return false;
	}
	
	/**
	 * Riporta l'inventario del giocatore
	 * @return Restituisce un oggetto istanza della classe Borsa
	 * @see Borsa
	 */
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	/**
	 * Aggiunge, se possibile, un attrezzo nell'inventario del giocatore 
	 * @param nomeAttrezzo Stringa che identifica il nome dell'attrezzo
	 * @param stanzaCorrente Oggetto istanza della classe Stanza che identifica la stanza in cui si trova il giocatore
	 * @return Restituisce il booleano TRUE se è possibile aggiungere l'attrezzo all'inventario, altrimenti FALSE
	 * @see Borsa
	 * @see Stanza
	 */
	public boolean storeAttrezzo(String nomeAttrezzo, Stanza stanzaCorrente) {
		if(stanzaCorrente == null)
			return false;
		
		Attrezzo a= stanzaCorrente.getAttrezzo(nomeAttrezzo);
		if(a!=null) {
			if(this.borsa.addAttrezzo(a)) {
				stanzaCorrente.removeAttrezzo(a);
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	/**
	 * Lascia, se possibile, un attrezzo nella stanza in cui è situato il giocatore
	 * @param nomeAttrezzo Stringa che identifica il nome dell'attrezzo
	 * @param stanzaCorrente Oggetto istanza della classe Stanza che identifica la stanza in cui si trova il giocatore
	 * @return Restituisce il booleano TRUE se è possibile lasciare l'attrezzo nella stanza, altrimenti FALSE
	 * @see Borsa
	 * @see Stanza
	 */
	public boolean dropAttrezzo(String  nomeAttrezzo, Stanza stanzaCorrente) {
		
		Attrezzo a = this.borsa.getAttrezzo(nomeAttrezzo);
		if(a!=null && stanzaCorrente!=null) {
			if(stanzaCorrente.addAttrezzo(a)) {
				this.borsa.removeAttrezzo(nomeAttrezzo);
				return true;
			}
			else 
				return false;
		}
		else
			return false;
	}

}
