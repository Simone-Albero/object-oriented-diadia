
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
	private Stanza entrata;
	private Stanza uscita;
	
	/**
	 * Crea un labirinto 
	 */
	public Labirinto(){
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
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		this.setEntrata(atrio); 
		this.setUscita(biblioteca);
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
}
