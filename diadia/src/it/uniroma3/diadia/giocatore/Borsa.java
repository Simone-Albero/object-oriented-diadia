
package it.uniroma3.diadia.giocatore;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparaAttrezzoPerPeso;

/**
 * Borsa:
 * Questa classe modella l'inventario del giocatore.
 * Borsa contiene un array di attrezzi.
 * Il limite relativo alla quantit� di attrezzi trasportabili
 * � dettato dalla vaiebile pesoMax 
 * 
 * @author Simone
 * @see Attrezzo
 * @version base
 */
public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	
	private LinkedList<Attrezzo> attrezzi;
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
		this.attrezzi = new LinkedList<Attrezzo>();
	}
	
	/**
	 * Aggiunge, se possibile, un Attrezzo all'interno della Borsa
	 * @param attrezzo Oggetto istanza della classe Attrezzo
	 * @return Restituisce la variabile booleana TRUE se l'operazione � andata a buon fine, altrimenti FALSE 
	 * @see Attrezzo
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null)
			return false;
		
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		
		this.attrezzi.add(attrezzo);
		return true;
	}
	
	/**
	 * Riporta il peso massimo che pu� contenere la borsa
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
		int index = this.attrezzi.indexOf(new Attrezzo(nomeAttrezzo, 1));
		
		if(index != -1)
			return this.attrezzi.get(index);
		
		return null;
	}
	
	/**
	 * Riporta il peso totale degli attrezzi contenuti nella borsa
	 * @return Restituisce un intero
	 */
	public int getPeso() {
		int peso = 0;
		
		Iterator<Attrezzo> p_a = this.attrezzi.iterator();
		while(p_a.hasNext()) {
			peso += p_a.next().getPeso();
		}
		return peso;
	}
	
	/**
	 * Verifica che la borsa non contenga attrezzi
	 * @return Restituisce una variabile booleana TRUE se � vuota, altrimenti FALSE
	 */
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	/**
	 * Verifica che all'interno della borsa sia presente un attrezzo con un determinato nome
	 * @param nomeAttrezzo Stringa che identifica il nome di un attrezzo
	 * @return Restituisce la variabile booleana TRUE se l'attrezzo � contenuto nella borsa, altrimenti FALSE
	 * @see Attrezzo
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.contains(new Attrezzo(nomeAttrezzo, 1));
	}
	
	/**
	 * Rimuove e restituisce un attrezzo dalla borsa (ricerca in base al nome).
	 * @param nomeAttrezzo Stringa che identifica il nome dell'attrezzo
	 * @return Restituisce un oggetto instanza della classe Attrezzo
	 * @see Attrezzo
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		int index = this.attrezzi.indexOf(new Attrezzo(nomeAttrezzo, 1));
		
		if(index != -1) {
			Attrezzo attrezzo = this.attrezzi.get(index);
			this.attrezzi.remove(index);
			return attrezzo;
		}
		
		return null;
	}
	
	/**
	 * Riporta una rappresentazione in striga del contenuto della borsa
	 * @return Restituisce una stringa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.getSortedSetOrdinatoPerPeso().toString());
		}
		else 
			s.append("Borsa vuota");
		
		return s.toString();
	}
	
	 List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> sortedList = new LinkedList<Attrezzo>(this.attrezzi);
		Collections.sort(sortedList, new ComparaAttrezzoPerPeso());
		return sortedList;
	 }
	 
	 SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		 SortedSet<Attrezzo> sortedSet = new TreeSet<Attrezzo>(this.attrezzi);
		 return sortedSet;
	 }
	 
	 SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		 SortedSet<Attrezzo> sortedSet = new TreeSet<Attrezzo>(new ComparaAttrezzoPerPeso());
		 sortedSet.addAll(this.attrezzi);
		 return sortedSet;
	 }

}