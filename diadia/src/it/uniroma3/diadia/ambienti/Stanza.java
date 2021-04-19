
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Stanza:
 * Questa classe modella una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private Stanza[] stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private String[] direzioni;

	/**
	 * Crea una stanza a partire da un nome. 
	 * Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome Stringa che identifica il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
	}

	/**
	 * Imposta una stanza adiacente.
	 * @param direzione Stringa che identifica la direzione della stanza adiacente.
	 * @param stanza Stringa che identifica la stanza adiacente.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean aggiornato = false;
		for(int i=0; i<this.direzioni.length; i++)
			if (direzione.equals(this.direzioni[i])) {
				this.stanzeAdiacenti[i] = stanza;
				aggiornato = true;
			}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni[numeroStanzeAdiacenti] = direzione;
				this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
				this.numeroStanzeAdiacenti++;
			}
	}

	/**
	 * Riporta la stanza nella direzione specificata
	 * @param direzione Stringa che identifica la direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			if (this.direzioni[i].equals(direzione))
				stanza = this.stanzeAdiacenti[i];
		return stanza;
	}

	/**
	 * Riporta il nome della stanza.
	 * @return Restituisce una stringa 
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Riporta la descrizione della stanza.
	 * @return Restituisce una stringa 
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Riporta la collezione di attrezzi presenti nella stanza.
	 * @return Restituisce un array di oggetti istanza della classe Attrezzo
	 * @see Attrezzo
	 */
	public Attrezzo[] getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo Oggetto istanza della classe Attrezzo che identifica l'attrezzo da mettere nella stanza.
	 * @return Restituisce TRUE se riesce ad aggiungere l'attrezzo, altrimenti FALSE
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI && attrezzo!=null) {
			this.attrezzi[numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Riporta una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return Restituisce una stringa
	 */
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.direzioni)
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");

		if(this.attrezzi[0]==null)
			risultato.append("Nessun Oggetto");
		else {
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo!=null)  
					risultato.append(attrezzo.toString()+" ");
			}
		}
		
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return Restituisce TRUE se l'attrezzo esiste nella stanza, altrimenti FALSE 
	 * @see Attrezzo
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null)
				if (attrezzo.getNome().equals(nomeAttrezzo))
					trovato = true;
		}
		return trovato;
	}

	/**
	 * Riporta, se presente nella stanza, un attrezzo a partire da un nome.
	 * @param nomeAttrezzo Stringa che identifica il nome dell'attrezzo
	 * @return Restituisce un oggetto istanza della classe Attrezzo, NULL se l'attrezzo non esiste.
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
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param attrezzo Oggetto istanza della classe Attrezzo
	 * @return Restituisce il booleano TRUE se l'attrezzo e' stato rimosso, altrimenti FALSE
	 * @see Attrezzo
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null)
			return false;
		
		for(int i=0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i].getNome().equals(attrezzo.getNome())) {
				this.attrezzi[i] = this.attrezzi[this.numeroAttrezzi-1];
				this.attrezzi[this.numeroAttrezzi-1] = null;
				this.numeroAttrezzi--;
				return true;
			}		
		}		
		return false;
	}

	/**
	 * Riporta le direzioni in cui ci si può muovere a partire da una stanza
	 * @return Restituisce un array di stringhe
	 */
	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			direzioni[i] = this.direzioni[i];
		return direzioni;
	}

}