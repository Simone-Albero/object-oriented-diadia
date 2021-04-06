
package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Attrezzo:
 * Questa classe modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo {
	
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

}