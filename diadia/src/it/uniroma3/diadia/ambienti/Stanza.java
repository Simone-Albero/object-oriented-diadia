
package it.uniroma3.diadia.ambienti;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Stanza:
 * Questa classe modella una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * La stanza può contenere degli attrezzi 
 * Si assume che due attrezzi non possono avere lo stesso Nome
 * 
 * @author Simone 
 * @see Attrezzo
 * @version base
 */
public class Stanza {

	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	
	private String nome;
	private List<Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti;


	/**
	 * Crea una stanza a partire da un nome. 
	 * Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome Oggetto istanza della classe String che identifica il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new TreeMap<String, Stanza>();
		this.attrezzi = new LinkedList<Attrezzo>();
	}

	
	/**
	 * Imposta una stanza adiacente.
	 * @param direzione Stringa che identifica la direzione della stanza adiacente.
	 * @param stanza Stringa che identifica la stanza adiacente.
	 */
	public void setStanzaAdiacente(String direzione, Stanza stanza) {	
		if(direzione == null || stanza == null)
			return;
		
		this.stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Riporta la stanza nella direzione specificata
	 * @param direzione Stringa che identifica la direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
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
	 * @return Restituisce una Lista di oggetti istanza della classe Attrezzo
	 * @see Attrezzo
	 */
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo Oggetto istanza della classe Attrezzo che identifica l'attrezzo da mettere nella stanza.
	 * @return Restituisce TRUE se riesce ad aggiungere l'attrezzo, altrimenti FALSE
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!=null && this.attrezzi.size()<NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi.add(attrezzo);
			return true;
		}
		
		return false;
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return Restituisce TRUE se l'attrezzo esiste nella stanza, altrimenti FALSE 
	 * @see Attrezzo
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.contains(new Attrezzo(nomeAttrezzo, 1));
	}

	/**
	 * Riporta, se presente nella stanza, un attrezzo a partire da un nome.
	 * @param nomeAttrezzo Stringa che identifica il nome dell'attrezzo
	 * @return Restituisce un oggetto istanza della classe Attrezzo, NULL se l'attrezzo non esiste.
	 * @see Attrezzo
	 */	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		int index = this.attrezzi.indexOf(new Attrezzo(nomeAttrezzo, 1));
		
		if(index != -1) {
			return this.attrezzi.get(index);
		}
		
		return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param attrezzo Oggetto istanza della classe Attrezzo
	 * @return Restituisce il booleano TRUE se l'attrezzo e' stato rimosso, altrimenti FALSE
	 * @see Attrezzo
	 */	
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		int index = this.attrezzi.indexOf(attrezzo);
		
		if(index != -1) {
			this.attrezzi.remove(index);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Riporta una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return Restituisce un oggetto istanza della classe String
	 */
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		risultato.append(this.stanzeAdiacenti.keySet().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		if(this.attrezzi.isEmpty())
			risultato.append("Nessun Oggetto");
		else 
			risultato.append(this.attrezzi.toString());
		
		return risultato.toString();
	}

	/**
	 * Riporta le direzioni in cui ci si può muovere a partire da una stanza
	 * @return Restituisce una Lista di oggetti istanza della classe String
	 */
	public List<String> getDirezioni() {
		return new LinkedList<String>(this.stanzeAdiacenti.keySet());
	}
	
	/**
	 * Verifica l'uguaglianza tra due oggetti istanza della classe Stanza
	 * Il criterio di uguaglianza è basato esclusivamente sul nome della Stanza
	 * 
	 * @return Restituisce il booleano TRUE se le dua stanze hanno lo stesso nome, altrimenti False
	 */
	@Override
	public boolean equals(Object o) {
		Stanza stanza = (Stanza)o;
		if(this == stanza)
			return true;
			
		if(stanza.getNome().equals(this.getNome()))
			return true;
		
		return false;
	}
	
	/**
	 * Riporta una rappresentazione intera del Nome della Stanza
	 * 
	 * @return Restituisce un intero che rappresenta il Nome della Stanza
	 */
	@Override 
	public int hashCode() {
		return this.nome.hashCode();
		
	}

}