
package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Attrezzo:
 * Questa classe modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle Stanze del Labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  Simone
 * @see Stanza
 * @see Labirinto
 * @version base
 */
public class Attrezzo implements Comparable<Attrezzo>{
	
	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome Stringa che identifica il nome dell'attrezzo
	 * @param peso Intero che identifica Il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	/**
	 * Riporta il nome identificatore dell'attrezzo
	 * @return Restituisce una stringa
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Riporta il peso dell'attrezzo
	 * @return Restituisce un intero
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Riporta una rappresentazione stringa di questo attrezzo
	 * @return Restituisce una stringa
	 */
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}
	
	/**
	 * Verifica l'uguaglianza tra due oggetti istanza della classe Attrezzo
	 * Si assume che il nome degli Attrezzi sia univoco
	 * Il criterio di uguaglianza è basato esclusivamente sul nome dell'Attrezzo
	 * 
	 * @return Restituisce il booleano TRUE se le dua stanze hanno lo stesso nome, altrimenti False
	 */
	@Override
	public boolean equals(Object o) {
		Attrezzo attrezzo = (Attrezzo)o;
		if(this == attrezzo)
			return true;
			
		if(attrezzo.getNome().equals(this.getNome()))
			return true;
		
		return false;
	}
	
	/**
	 * Riporta una rappresentazione intera del Nome dell'Attrezzo
	 * Si assume che il nome degli Attrezzi sia univoco
	 * 
	 * @return Restituisce un intero che rappresenta il Nome dell'Attrezzp
	 */
	@Override 
	public int hashCode() {
		return this.nome.hashCode();
		
	}

	/**
	 * Definisce un criterio di ordinamento crescente tra Attrezzi basato esclusivamente sul Nome
	 * Si assume che il nome degli Attrezzi sia univoco
	 * 
	 * @return Restituisce -1 se l'Attrezzo corrente è più piccolo di quello passato come parametro, 0 se sono uguali
	 * 		   ed 1 se l'Attrezzo corrente è più grande
	 */
	@Override
	public int compareTo(Attrezzo o) {
		return this.getNome().compareTo(o.getNome());
	}
}