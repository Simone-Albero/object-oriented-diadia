
package it.uniroma3.diadia.ambienti;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Labirinto:
 * Questa classe modella un labirinto.
 * Un labirinto è caratterizzato da due stanze principali: "entrata" e "uscita"
 * Le altre Stanze ed eventuali Attrezzi contenuti in esse vengono generate e connesse a partire da quelle principali
 * Si assume che non possano esistere due Attrezzi con lo stesso Nome
 * 
 * @author Simone
 * @see Stanza
 * @see Attrezzo
 * @version base
 */
public class Labirinto {
	private final static int DEF_MAX_STANZE = 5;
	private final static int DEF_MAX_ATTREZZI = 5;
	
	private Stanza entrata;
	private Stanza uscita;
	
	private List<Stanza> stanze;
	private int maxStanze;
	private Set<Attrezzo> attrezzi;
	private int maxAttrezzi;
	
	
	/**
	 * Crea un labirinto di dimensione predefinita 
	 */
	public Labirinto(){
		this(DEF_MAX_STANZE, DEF_MAX_ATTREZZI);
	}
	
	/**
	 * Crea un labirinto a partire da dimensioni passate come parametro
	 */
	public Labirinto(int maxStanze, int maxAttrezzi){
		this.stanze = new LinkedList<Stanza>();
		this.maxStanze = maxStanze;
		this.attrezzi = new HashSet<Attrezzo>();
		this.maxAttrezzi = maxAttrezzi;
		this.entrata = null;
		this.uscita = null;
	}
	
	/**
	 * carica un Labirinto da un file
	 * @param nomeFile
	 */
	public Labirinto(String nomeFile) {
		CaricatoreLabirinto c =	new CaricatoreLabirinto(nomeFile);
		Labirinto load = c.carica();
		this.stanze = load.getStanze();
		this.maxStanze = DEF_MAX_STANZE;
		this.attrezzi = load.getAttrezzi();
		this.maxAttrezzi = DEF_MAX_ATTREZZI;
		this.entrata = load.getEntrata();
		this.uscita = load.getUscita();
	}
	
	
	/**
	 * Riporta la stanza iniziale "entrata"
	 * @return Restituisce un oggetto istanza della classe Stanza
	 * @see Stanza
	 */
	public Stanza getEntrata() {
		return this.entrata;
	}
	
	/**
	 * Imposta la stanza iniziale "entrata"
	 * @param entrata Oggetto istanza della classe Stanza 
	 * @see Stanza
	 */
	public void setEntrata(Stanza entrata) {
		this.entrata = entrata;
	}
	
	/**
	 * Riporta la stanza finale "uscita"
	 * @return Restituisce un oggetto istanza della classe Stanza
	 * @see Stanza
	 */
	public Stanza getUscita() {
		return this.uscita;
	}
	
	/**
	 * Imposta la stanza finale "uscita"
	 * @param uscita Oggetto istanza della classe Stanza 
	 * @see stanza
	 */
	public void setUscita(Stanza uscita) {
		this.uscita = uscita;
	}
	
	/**
	 * Aggiunge, se possibile, una stanza al labirinto
	 * @param stanza Oggetto istanza della classe Stanza
	 * @return Restituisce TRUE se è possibile aggiungere la stanza, altrimenti FALSE
	 * @see Stanza
	 */
	public boolean addStanza(Stanza stanza) {
		if (this.stanze.size()<this.maxStanze && stanza != null)
			return this.stanze.add(stanza);
		else
			return false;
	}
	
	/**
	 * Aggiunge, se possibile, un attrezzo al labirinto, 
	 * si assume che il nome degli attrezzi debba essere Univoco
	 * @param attrezzo Oggetto istanza della classe Attrezzo
	 * @return Restituisce TRUE se è possibile aggiungere l'attrezzo, altrimenti FALSE
	 * @see Attrezzo
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.attrezzi.size()<this.maxAttrezzi)
			return this.attrezzi.add(attrezzo);
		else
			return false;
	}
	
	/**
	 * Riporta la collezione di Stanze di cui è composto il Labirinto  
	 * @return Restituisce una Lista di oggetti istanza della classe Stanza
	 * @see Stanza
	 */
	public List<Stanza> getStanze(){
		return this.stanze;
	}
	
	/**
	 * Riporta una collezione di Attrezzi contenuti all'interno del Labirinto
	 * @return Restituisce un Set di oggetti istanza della classe Attrezzo
	 * @see Attrezzo
	 */
	public Set<Attrezzo> getAttrezzi(){
		return this.attrezzi;
	}
}
