
package it.uniroma3.diadia;

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
	 * @param pesoMax Limite di peso relativo alla quantità di oggetti trasportabili
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * Aggiunge, se possibile, un Attrezzo all'interno della Borsa
	 * @param attrezzo
	 * @return Restituisce la variabile booleana TRUE se l'operazione è andata a buon fine, 
	 * 		   altrimenti FALSE 
	 * @see Attrezzo
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		
		if (this.numeroAttrezzi==10)
			return false;
		
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	/**
	 * Restituisce il peso massimo che può contenere la borsa
	 * @return Restituisce un intero: pesoMax
	 */
	public int getPesoMax() {
		return this.pesoMax;
	}
	
	/**
	 * Cerca un attrezzo all'interno della borsa e lo restituisce, 
	 * se non lo trova restituisce NULL
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
	 * Restituisce il peso totale degli attrezzi contenuti nella borsa
	 * @return Restituisce un intero: peso
	 */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		
		return peso;
	}
	
	/**
	 * Verifica se la borsa non contiene attrezzi
	 * @return Restituisce una variabile booleana TRUE se è vuota, altrimenti FALSE
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/**
	 * Verifica che all'interno della borsa sia presente un attrezzo con un determinato nome
	 * @param nomeAttrezzo Stringa che rappresenta il nome di un attrezzo
	 * @return Restituisce la variabile booleana TRUE se l'attrezzo è contenuto nella borsa, 
	 *         altrimenti FALSE
	 * @see Attrezzo
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		// ---> TODO (implementare questo metodo) <---
		return a;
	}
	
	/**
	 * Rappresentazione in striga del contenuto della borsa
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