
package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Giocatore:
 * Questa classe modella il giocatore di in un gioco di ruolo.
 * Gestisce il punteggio del giocatore rappresentato dalla variabile cfu
 * e l'inventario creato come istanza della classe Borsa
 * 
 * @author Simone
 * @see Borsa
 * @version base
 */
public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private Borsa borsa;
	private int cfu;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa(); 
	}
	
	/**
	 * Restituisce il punteggio del giocatore 
	 * @return Restituisce un intero: cfu
	 */
	public int getCfu() {
		return this.cfu;
	}
	
	/**
	 * Imposta il punteggio del giocatore
	 * @param cfu Intero che rappresenta il punteggio del giocatore
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
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
