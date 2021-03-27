
package it.uniroma3.diadia;

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
	
	private Borsa inventario;
	private int cfu;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.inventario = new Borsa(); 
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
		return this.inventario;
	}
	
	public boolean storeAttrezzo(Attrezzo attrezzo) {
		return this.inventario.addAttrezzo(attrezzo);
	}
	
	public void dropAttrezzo(String  nomeAttrezzo) {
		this.inventario.removeAttrezzo(nomeAttrezzo);
	}
	
}
