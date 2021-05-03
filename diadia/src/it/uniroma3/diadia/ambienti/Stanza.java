
package it.uniroma3.diadia.ambienti;

import java.util.Iterator;
import java.util.LinkedList;

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
	private LinkedList<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private LinkedList<Stanza> stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private LinkedList<String> direzioni;


	/**
	 * Crea una stanza a partire da un nome. 
	 * Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome Stringa che identifica il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni = new LinkedList<String>();
		this.stanzeAdiacenti = new LinkedList<Stanza>();
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
		
		boolean aggiornato = false;
		
		int index = this.direzioni.indexOf(direzione);
		if(index != -1) {
			this.stanzeAdiacenti.set(index, stanza);
			aggiornato = true;
		}
			
		if(!aggiornato)
			if(this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni.add(direzione);
				this.stanzeAdiacenti.add(stanza);
				this.numeroStanzeAdiacenti++;
			}
	}

	/**
	 * Riporta la stanza nella direzione specificata
	 * @param direzione Stringa che identifica la direzione
	 */
//	public Stanza getStanzaAdiacente(String direzione) {
//		Iterator<String> p_d = this.direzioni.iterator();
//		Iterator<Stanza> p_s = this.stanzeAdiacenti.iterator();
//		while(p_d.hasNext()) {
//			Stanza currStanza = p_s.next();
//			if(p_d.next().equals(direzione))
//				return currStanza;	
//		}
//		
//		return null;
//	}
	
	public Stanza getStanzaAdiacente(String direzione) {
		int index = this.direzioni.indexOf(direzione);
		
		if(index != -1)
			return this.stanzeAdiacenti.get(index);
		
		return null;
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
	public LinkedList<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo Oggetto istanza della classe Attrezzo che identifica l'attrezzo da mettere nella stanza.
	 * @return Restituisce TRUE se riesce ad aggiungere l'attrezzo, altrimenti FALSE
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!=null && this.numeroAttrezzi<NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi.add(attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
		
		return false;
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return Restituisce TRUE se l'attrezzo esiste nella stanza, altrimenti FALSE 
	 * @see Attrezzo
	 */
//	public boolean hasAttrezzo(String nomeAttrezzo) {
//		Iterator<Attrezzo> p_a = this.attrezzi.iterator();
//		
//		while(p_a.hasNext()) {
//			Attrezzo attrezzo = p_a.next();
//			if(attrezzo.getNome().equals(nomeAttrezzo))
//				return true;
//		}
//		
//		return  false;
//	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.contains(new Attrezzo(nomeAttrezzo, 1));
	}

	/**
	 * Riporta, se presente nella stanza, un attrezzo a partire da un nome.
	 * @param nomeAttrezzo Stringa che identifica il nome dell'attrezzo
	 * @return Restituisce un oggetto istanza della classe Attrezzo, NULL se l'attrezzo non esiste.
	 * @see Attrezzo
	 */
//	public Attrezzo getAttrezzo(String nomeAttrezzo) {
//		Iterator<Attrezzo> p_a = this.attrezzi.iterator();
//		
//		while(p_a.hasNext()) {
//			Attrezzo attrezzo = p_a.next();
//			if(attrezzo.getNome().equals(nomeAttrezzo))
//				return attrezzo;
//		}
//		return null;
//	}
	
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
//	public boolean removeAttrezzo(Attrezzo attrezzo) {
//		Iterator<Attrezzo> p_a = this.attrezzi.iterator();
//		
//		if(attrezzo == null)
//			return false;
//		
//		while(p_a.hasNext()) {
//			if(p_a.next().getNome().equals(attrezzo.getNome())) {
//				p_a.remove();
//				this.numeroAttrezzi--;
//				return true;
//			}
//		}
//		return false;
//	}
	
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
	 * @return Restituisce una stringa
	 */
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		Iterator<String> p_d = this.direzioni.iterator(); 
		while(p_d.hasNext()) {
			risultato.append(p_d.next()+" ");
		}
		risultato.append("\nAttrezzi nella stanza: ");

		if(this.attrezzi.isEmpty())
			risultato.append("Nessun Oggetto");
		else {
			Iterator<Attrezzo> p_a = this.attrezzi.iterator(); 
			while(p_a.hasNext()) {
				risultato.append(p_a.next().toString()+" ");
			}
		}
		
		return risultato.toString();
	}

	/**
	 * Riporta le direzioni in cui ci si può muovere a partire da una stanza
	 * @return Restituisce un array di stringhe
	 */
	public LinkedList<String> getDirezioni() {
		return this.direzioni;
	}

}