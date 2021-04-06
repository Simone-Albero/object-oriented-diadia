
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Labirinto:
 * Questa classe modella un labirinto.
 * Un labirinto è caratterizzato da due stanze principali: "entrata" e "uscita"; 
 * le altre stanze vengono generate e connesse tra loro a partire da quelle principali
 * 
 * @author Simone
 * @see Stanza
 * @version base
 */
public class Labirinto {
	private final static int DEF_MAX_STANZE = 5;
	private final static int DEF_MAX_ATTREZZI = 5;
	
	private Stanza entrata;
	private Stanza uscita;
	
	private Stanza stanze[];
	private int nStanze;
	private int maxStanze;
	private Attrezzo attrezzi[];
	private int nAttrezzi;
	private int maxAttrezzi;
	
	
	
	
	/**
	 * Crea un labirinto 
	 */
	public Labirinto(){
		this(DEF_MAX_STANZE, DEF_MAX_ATTREZZI);
	}
	
	/**
	 * Crea un labirinto 
	 */
	public Labirinto(int maxStanze, int maxAttrezzi){
		this.stanze = new Stanza[maxStanze];
		this.maxStanze = maxStanze;
		this.nStanze = 0;
		this.attrezzi = new Attrezzo[maxAttrezzi];
		this.maxAttrezzi = maxAttrezzi;
		this.nAttrezzi = 0;
		initLabirinto();
	}
	
	/**
	 * Inizializza il labirinto a partire da un "template"
	 * impostando le stanze principali "entrata" e "uscita",
	 * collegando tra loro le stanze secondarie
	 * e generando gli attrezzi che figurano all'interno di esse
	 * @see Attrezzo
	 */
	private void initLabirinto() {

		/* crea gli attrezzi */
		this.addAttrezzo(new Attrezzo("lanterna",3)); //0
		this.addAttrezzo(new Attrezzo("osso",1)); //1

		/* crea stanze del labirinto */
		this.addStanza(new Stanza("Atrio")); //0
		this.addStanza(new Stanza("Aula N11")); //1
		this.addStanza(new Stanza("Aula N10")); //2
		this.addStanza(new Stanza("Laboratorio Campus")); //3
		this.addStanza(new Stanza("Biblioteca")); //4

		/* collega le stanze */
		this.stanze[0].impostaStanzaAdiacente("nord", this.stanze[4]);
		this.stanze[0].impostaStanzaAdiacente("est", this.stanze[1]);
		this.stanze[0].impostaStanzaAdiacente("sud", this.stanze[2]);
		this.stanze[0].impostaStanzaAdiacente("ovest", this.stanze[3]);

		this.stanze[1].impostaStanzaAdiacente("est", this.stanze[3]);
		this.stanze[1].impostaStanzaAdiacente("ovest", this.stanze[0]);
		
		this.stanze[2].impostaStanzaAdiacente("nord", this.stanze[0]);
		this.stanze[2].impostaStanzaAdiacente("est", this.stanze[1]);
		this.stanze[2].impostaStanzaAdiacente("ovest", this.stanze[3]);
		
		this.stanze[3].impostaStanzaAdiacente("est", this.stanze[0]);
		this.stanze[3].impostaStanzaAdiacente("ovest", this.stanze[1]);

		this.stanze[4].impostaStanzaAdiacente("sud", this.stanze[0]);

		/* pone gli attrezzi nelle stanze */
		this.stanze[2].addAttrezzo(this.attrezzi[0]);
		this.stanze[0].addAttrezzo(this.attrezzi[1]);

		// il gioco comincia nell'atrio
		this.setEntrata(this.stanze[0]); 
		this.setUscita(this.stanze[4]);
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
	private void setEntrata(Stanza entrata) {
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
	private void setUscita(Stanza uscita) {
		this.uscita = uscita;
	}
	
	/**
	 * Aggiunge, se possibile, una stanza al labirinto
	 * @param stanza Oggetto istanza della classe Stanza
	 * @return Restituisce TRUE se è possibile aggiungere la stanza, altrimenti FALSE
	 * @see Stanza
	 */
	private boolean addStanza(Stanza stanza) {
		if(stanza == null)
			return false;
					
		if(this.nStanze < this.maxStanze) {
			this.stanze[this.nStanze]= stanza;
			this.nStanze++;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Aggiunge, se possibile, un attrezzo al labirinto
	 * @param attrezzo Oggetto istanza della classe Attrezzo
	 * @return Restituisce TRUE se è possibile aggiungere l'attrezzo, altrimenti FALSE
	 * @see Attrezzo
	 */
	private boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null)
			return false;
		
		if(this.nAttrezzi < this.maxAttrezzi) {
			this.attrezzi[this.nAttrezzi]= attrezzo;
			this.nAttrezzi++;
		}
		
		return false;
	}
}
