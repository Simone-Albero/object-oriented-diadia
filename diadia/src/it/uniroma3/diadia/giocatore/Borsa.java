
package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Borsa:
 * Questa classe modella l'inventario del giocatore.
 * Borsa contiene un array di attrezzi.
 * Il limite relativo alla quantità di attrezzi trasportabili
 * è dettato dalla vaiebile pesoMax 
 * 
 * @author Simone
 * @see Attrezzo
 * @version base
 */
public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	/**
	 * Genera una borsa a partire da un pesoMax di default
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	/**
	 * Genera una borsa a partire da un pesoMax passato in input
	 * @param pesoMax Intero che identifica il limite di peso della borsa
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; 
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * Aggiunge, se possibile, un Attrezzo all'interno della Borsa
	 * @param attrezzo Oggetto istanza della classe Attrezzo
	 * @return Restituisce la variabile booleana TRUE se l'operazione è andata a buon fine, altrimenti FALSE 
	 * @see Attrezzo
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null)
			return false;
		
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		
		if (this.numeroAttrezzi == 10 || attrezzo == null)
			return false;
		
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	/**
	 * Riporta il peso massimo che può contenere la borsa
	 * @return Restituisce un intero
	 */
	public int getPesoMax() {
		return this.pesoMax;
	}
	
	/**
	 * Cerca un attrezzo all'interno della borsa, se non esiste restituisce NULL
	 * @param nomeAttrezzo Stringa che identifica il nome di un Attrezzo
	 * @return Restituisce un oggetto della classe Attrezzo, altrimenti NULL
	 * @see Attrezzo
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		
		return a;
	}
	
	/**
	 * Riporta il peso totale degli attrezzi contenuti nella borsa
	 * @return Restituisce un intero
	 */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		
		return peso;
	}
	
	/**
	 * Verifica che la borsa non contenga attrezzi
	 * @return Restituisce una variabile booleana TRUE se è vuota, altrimenti FALSE
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/**
	 * Verifica che all'interno della borsa sia presente un attrezzo con un determinato nome
	 * @param nomeAttrezzo Stringa che identifica il nome di un attrezzo
	 * @return Restituisce la variabile booleana TRUE se l'attrezzo è contenuto nella borsa, altrimenti FALSE
	 * @see Attrezzo
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/**
	 * Rimuove e restituisce un attrezzo dalla borsa (ricerca in base al nome).
	 * @param nomeAttrezzo Stringa che identifica il nome dell'attrezzo
	 * @return Restituisce un oggetto instanza della classe Attrezzo
	 * @see Attrezzo
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for(int i=0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = this.attrezzi[i];
				this.attrezzi[i] = this.attrezzi[this.numeroAttrezzi-1];
				this.attrezzi[this.numeroAttrezzi-1] = null;
				this.numeroAttrezzi--;
				return a;
			}		
		}		
		return a;
	}
	
	/**
	 * Riporta una rappresentazione in striga del contenuto della borsa
	 * @return Restituisce una stringa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else 
			s.append("Borsa vuota");
		
		return s.toString();
	}
}