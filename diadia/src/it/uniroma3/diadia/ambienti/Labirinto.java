
package it.uniroma3.diadia.ambienti;

import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.CaricaotreCostanti;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

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
	public final static int DEF_MAX_STANZE = Integer.parseInt(CaricaotreCostanti.getCostante("labirinto_max_stanze"));
	public final static int DEF_MAX_ATTREZZI = Integer.parseInt(CaricaotreCostanti.getCostante("labirinto_max_attrezzi"));

	private Stanza entrata;
	private Stanza uscita;

	public static class LabirintoBuilder {

		private Labirinto labirinto;
		private int maxStanze;
		private int maxAttrezzi;
		private Map<String, Stanza> stanze;
		private Set<Attrezzo> attrezzi;

		/**
		 * Crea un LabirintoBuilder che si occupa della costruzione di un Labirinto si dimensioni standard
		 */
		public LabirintoBuilder(int maxStanze, int maxAttrezzi) {
			this.maxStanze = maxStanze;
			this.maxAttrezzi = maxAttrezzi;
			this.labirinto = new Labirinto();
			this.stanze = new HashMap<String,Stanza>();
			this.attrezzi = new HashSet<Attrezzo>();
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
				if(!this.stanze.containsKey(stanza)) {
					if(this.stanze.size() < this.maxStanze) {
						this.stanze.put(stanza, that);
						this.labirinto.setEntrata(that);
					}	
				}

				else {
					Stanza entrata = this.stanze.get(stanza);
					this.labirinto.setEntrata(entrata);
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
				if(!this.stanze.containsKey(stanza)) {
					if(this.stanze.size() < this.maxStanze) {
						this.stanze.put(stanza, that);
						this.labirinto.setUscita(that);
					}	
				}

				else {
					Stanza entrata = this.stanze.get(stanza);
					this.labirinto.setUscita(entrata);
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

				if(this.stanze.containsKey(stanza)) {
					if (this.attrezzi.size() < this.maxAttrezzi) {
						this.attrezzi.add(attrezzo);
						this.stanze.get(stanza).addAttrezzo(attrezzo);
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
			if(stanza!=null && this.stanze.size() < this.maxStanze)
				this.stanze.put(stanza, new Stanza(stanza));
			return this;
		}

		/**
		 * Agiunge, se possibile, una StanzaMagica al Labirinto con una SogliaMagica di default
		 * @param stanza Oggetto istanza della classe String che rappresenta il nome della Stanza
		 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
		 * @see StanzaMagica
		 */
		public LabirintoBuilder addStanzaMagica(String stanza) {
			if(stanza!=null && this.stanze.size() < this.maxStanze)
				this.stanze.put(stanza, new StanzaMagica(stanza));
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
			if(stanza!=null && this.stanze.size() < this.maxStanze && soglia>=0)
				this.stanze.put(stanza, new StanzaMagica(stanza,soglia));
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
			if(stanza!=null && attrezzo!=null && this.stanze.size() < this.maxStanze)
				this.stanze.put(stanza, new StanzaBloccata(stanza, direzione, attrezzo));
			return this;
		}

		/**
		 * Agiunge, se possibile, una StanzaBuia al Labirinto con un AttrezzoLuminoso di default
		 * @param stanza Oggetto istanza della classe String che rappresenta il nome della Stanza
		 * @return Restituisce una istanza della medesima classe per permettere il method-chaining
		 * @see StanzaBuia
		 */
		public LabirintoBuilder addStanzaBuia(String stanza) {
			if(stanza!=null && this.stanze.size() < this.maxStanze)
				this.stanze.put(stanza, new StanzaBuia(stanza));
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
			if(stanza!=null && attrezzo!=null && this.stanze.size() < this.maxStanze)
				this.stanze.put(stanza, new StanzaBuia(stanza, attrezzo));
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
			if(this.stanze .containsKey(s1) && this.stanze.containsKey(s2))
				this.stanze.get(s1).setStanzaAdiacente(direzione, this.stanze.get(s2));
			else 
				throw new IllegalArgumentException();
			return this;
		}

		@SuppressWarnings("deprecation")
		public LabirintoBuilder addPersonaggio(String nome, String presentazione, String attrezzo, int peso, String stanza) {
			AbstractPersonaggio personaggio = null;

			try {
				StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.personaggi.");
				nomeClasse.append(Character.toUpperCase(nome.charAt(0)));
				nomeClasse.append(nome.substring(1));
				personaggio = (AbstractPersonaggio)Class.forName(nomeClasse.toString()).newInstance();
				personaggio.setNome(nome);
				personaggio.setPresentazione(presentazione);
				if(attrezzo!=null)
					personaggio.setPresent(new Attrezzo(attrezzo, peso));


				if(this.stanze.containsKey(stanza))
					this.stanze.get(stanza).setPersonaggio(personaggio);
				else 
					throw new IllegalArgumentException();
			}
			catch(Exception e){
				throw new IllegalArgumentException();
			}

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
		
		public Map<String,Stanza> getStanze(){
			return this.stanze;
		}
		
		public Set<Attrezzo> getAttrezzi(){
			return this.attrezzi;
		}
	}

	/**
	 * Crea un labirinto a partire da dimensioni passate come parametro
	 */
	private Labirinto(){
		this.entrata = null;
		this.uscita = null;
	}

	/**
	 * carica un Labirinto da un file
	 * @param nomeFile
	 */
	public Labirinto(InputStream fileStream) {
		CaricatoreLabirinto c =	new CaricatoreLabirinto(fileStream);
		Labirinto load = c.carica();
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

	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder(Labirinto.DEF_MAX_STANZE , Labirinto.DEF_MAX_ATTREZZI);
	}

}
