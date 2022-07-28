
package it.uniroma3.diadia.ambienti;

/**
 * StanzaBolccata:
 * Questa classe è un estensione della classe Stanza
 * Modella una particolare Stanza avente una direzione bloccata
 * Permette di "sbloccare" la direzione solo se nella Stanza è presente l'AttrezzoSbloccante
 * 
 * @author Simone
 * @see Stanza
 * @version base
 */
public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	/**
	 * Crea una StanzaBloccata 
	 * @param nome Oggetto istanza della classe Sting che rappresenta il nome della Stanza
	 * @param direzioneBloccata Oggetto istanza della classe Stirng che rappresenta la direzione da bloccare
	 * @param attrezzoSbloccante Oggetto istanza della classe Sting che rappresenta l'attrezzo sbloccante
	 */
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	/**
	 * Riporta la stanza nella direzione specificata
	 * Se la direzione è bloccata e la stanza corrente contiene l'AttrezzoSbloccante, viene restituita la stanza desiderata
	 * Altrimenti viene restituita la stanza corrente
	 * 
	 *  @return Restituisce un oggetto istanza della classe Stanza
	 */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.direzioneBloccata)) {
			if(this.hasAttrezzo(this.attrezzoSbloccante))
				return super.getStanzaAdiacente(direzione);
			else
				return this;
		}
		
		else
			return super.getStanzaAdiacente(direzione);
	}
	
	/**
	 * Riporta una descrizione della Stanza con la Specifica della direzione bloccata e dell'attrezzo sboccante
	 * @return Restituisce un oggetto istanza della classe String
	 */
	@Override
	public String getDescrizione() {
		return super.getDescrizione() + "\nAttenzione! la direzione: '"+this.direzioneBloccata
									  + "' è bloccata, per sbloccarla hai bisogno di: '"+this.attrezzoSbloccante+"'";
	}
}
