
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * LabirintoBuilder:
 * Questa si occupa esclusivamente della creazione di oggetti Labirinto
 * Sfrutta la tecnica del method-chaining per la costruzione incrementale di tale oggetto
 * 
 * @author Simone
 * @see Labirinto
 * @version base
 */
public class LabirintoBuilder {

	private Labirinto labirinto;
	
	/**
	 * Crea un LabirintoBuilder che si occupa della costruzione di un Labirinto si dimensioni standard
	 */
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
	}
	
	/**
	 * Crea un LabirintoBuilder che si occupa della costruzione di un Labirinto con dimensioni passate tramite parametro
	 * @param maxStanze Intero che rappresenta il numero massimo di Stanze di cui può essere composto il labirinto
	 * @param maxAttrezzi Inetro che rappresenta il numero massimo di Attrezzi che può contenere il Labirinto
	 * @see Stanza
	 * @see Attrezzo 
	 */
	public LabirintoBuilder(int maxStanze, int maxAttrezzi) {
		this.labirinto = new Labirinto(maxStanze, maxAttrezzi);
	}
	
	/**
	 * Aggiunge, se possibile, un'entrata (stanza iniziale) al Labirinto,
	 * Se la stanza è già presente nel Labirinto la identifica come tale
	 * Altrimenti ne crea una a tale scopo
	 * @param stanza
	 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
	 */
	public LabirintoBuilder addEntrata(String stanza) {
		if(stanza != null) {
			Stanza that = new Stanza(stanza);
			if(!this.labirinto.getStanze().contains(that)) {
				if(this.labirinto.addStanza(that))
					this.labirinto.setEntrata(that);
			}

			else {
				Stanza entrata = this.labirinto.getStanze().get(this.labirinto.getStanze().indexOf(that));
				this.labirinto.setUscita(entrata);
			}
		}
		return this;
	}
	
	/**
	 * Aggiunge, se possibile, un'uscita (stanza finale) al Labirinto,
	 * Se la stanza è già presente nel Labirinto la identifica come tale
	 * Altrimenti ne crea una a tale scopo
	 * @param stanza
	 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
	 */
	public LabirintoBuilder addUscita(String stanza) {
		if(stanza != null) {
			Stanza that = new Stanza(stanza);
			if(!this.labirinto.getStanze().contains(that)) {
				if(this.labirinto.addStanza(that))	
					this.labirinto.setUscita(that);
			}
			else {
				Stanza uscita = this.labirinto.getStanze().get(this.labirinto.getStanze().indexOf(that));
				this.labirinto.setUscita(uscita);
			}
		}
		return this;	
	}
	
	/**
	 * Aggiunge, se possibile, un Attrzzo all'ultima stanza inserita nel labirinto
	 * Si assume che il nome degli Attrezzi sia Univoco
	 * 
	 * @param nome Oggetto istanza della classe String che rappresenta il nome dell'Attrezzo
	 * @param peso Intero che rappresenta il peso dell'Attrezzo
	 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
	 * @see Attrezzo
	 */
	public LabirintoBuilder addAttrezzo(String nome, int peso, String stanza) {
		if(nome != null) {
			Attrezzo attrezzo = new Attrezzo(nome, peso);
			Stanza curr = new Stanza(stanza);
			if(this.labirinto.getStanze().contains(curr)) {
				if (this.labirinto.addAttrezzo(attrezzo)) {
					this.labirinto.getStanze().get(this.labirinto.getStanze().indexOf(curr)).addAttrezzo(attrezzo);
				}
			}
			else
				throw new IllegalArgumentException("Stanza inesistente");
		}
		return this;
	}
	
	/**
	 * Agiunge, se possibile, una Stanza al Labirinto
	 * @param stanza Oggetto istanza della classe String che rappresenta il nome della Stanza
	 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
	 * @see Stanza
	 */
	public LabirintoBuilder addStanza(String stanza) {
		this.labirinto.addStanza(new Stanza(stanza));
		return this;
	}
	
	/**
	 * Agiunge, se possibile, una StanzaMagica al Labirinto con una SogliaMagica di default
	 * @param stanza Oggetto istanza della classe String che rappresenta il nome della Stanza
	 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
	 * @see StanzaMagica
	 */
	public LabirintoBuilder addStanzaMagica(String stanza) {
		this.labirinto.addStanza(new StanzaMagica(stanza));
		return this;
	}
	
	/**
	 * Agiunge, se possibile, una StanzaMagica al Labirinto con una SogliaMaigca passata come parametro
	 * @param stanza Oggetto istanza della classe String che rappresenta il nome della Stanza
	 * @param soglia Intero che rappresenta la SogliaMagica
	 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
	 * @see StanzaMagica
	 */
	public LabirintoBuilder addStanzaMagica(String stanza, int soglia) {
		this.labirinto.addStanza(new StanzaMagica(stanza, soglia));
		return this;
	}
	
	/**
	 * Agiunge, se possibile, una StanzaBloccata al Labirinto
	 * @param stanza Oggetto istanza della classe String che rappresenta il nome della Stanza
	 * @param direzione Oggetto istanza della classe String che rappresenta la direzione bloccata
	 * @param attrezzo Oggetto istanza della classe String che rappresenta l'Attrezzo sbloccante
	 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
	 * @see StanzaBloccata
	 */
	public LabirintoBuilder addStanzaBloccata(String stanza, String direzione, String attrezzo) {
		this.labirinto.addStanza(new StanzaBloccata(stanza, direzione, attrezzo));
		return this;
	}
	
	/**
	 * Agiunge, se possibile, una StanzaBuia al Labirinto con un AttrezzoLuminoso di default
	 * @param stanza Oggetto istanza della classe String che rappresenta il nome della Stanza
	 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
	 * @see StanzaBuia
	 */
	public LabirintoBuilder addStanzaBuia(String stanza) {
		this.labirinto.addStanza(new StanzaBuia(stanza));
		return this;
	}
	
	/**
	 * Agiunge, se possibile, una StanzaBuia al Labirinto con un AttrezzoLuminoso passato come parametro
	 * @param stanza Oggetto istanza della classe String che rappresenta il nome della Stanza
	 * @param attrezzo Oggetto istanza della classe String che rappresenta il nome dell'AttrezzoLuminoso
	 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
	 * @see StanzaBuia
	 */
	public LabirintoBuilder addStanzaBuia(String stanza, String attrezzo) {
		this.labirinto.addStanza(new StanzaBuia(stanza, attrezzo));
		return this;
	}
	
	/**
	 * Imposta, se possibile, l'adiacenza tra due stanze presenti nel Labirinto
	 * @param s1 Oggetto istanza della classe String che rappresenta il nome della prima Stanza
	 * @param s2 Oggetto istanza della classe String che rappresenta il nome della second Stanza
	 * @param direzione Oggetto istanza della classe String che rappresenta la direzione in cui le stanze sono adiacenti
	 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
	 */
	public LabirintoBuilder addAdiacenza(String s1, String s2, String direzione) {
		int index1 = this.labirinto.getStanze().indexOf(new Stanza(s1));
		int index2 = this.labirinto.getStanze().indexOf(new Stanza(s2));
				
		if(index1 != -1 && index2 != -1)
			this.labirinto.getStanze().get(index1).setStanzaAdiacente(direzione, this.labirinto.getStanze().get(index2));
		else 
			throw new IllegalArgumentException();
		return this;
	}
	
	/**
	 * Riporta un Labirinto
	 * @return Restituisce un oggetto istanza della classe Labirinto
	 * @see Labirinto
	 */
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	
}
