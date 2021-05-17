
package it.uniroma3.diadia.ambienti;

/**
 * StanzaBuia:
 * Questa classe è un estensione della classe Stanza
 * Modella una particolare Stanza buia:
 * Se nella Stanza è presente un AttrezzoLuminoso allora la descrizione di quest'ultima rimane invariata
 * Altrimenti la descrizione segnala che non è possibile avere informazioni sulla stanza corrente a causa del "buio"
 * 
 * @author Simone
 * @see Stanza
 * @version Base
 */
public class StanzaBuia extends Stanza {
	
	public static final String Buio = "Quì c'è buio pesto!!";
	private final static String attrezzoLuminosoDef = "lanterna"; 
	private String attrezzoLuminoso;
	
	/**
	 * Crea una StanzaBuia a partire da un AttrezzoLuminoso di default
	 * @param nome Oggetto istanza cella classe String che rappresenta il nome della Stanza
	 */
	public StanzaBuia(String nome) {
		this(nome, attrezzoLuminosoDef);
	}
	
	/**
	 * Crea una StanzaBuia a partire da un AttrezzoLuminoso passato come parametro
	 * @param nome Oggetto istanza della classe String che rappresenta il nome della Stanza
	 * @param attrezzoLuminoso Oggetto istanza della classe String che rappresenta il nome dell'AttrezzoLuminoso
	 */
	public StanzaBuia(String nome, String attrezzoLuminoso) {
		super(nome);
		this.attrezzoLuminoso = attrezzoLuminoso;
	}
	
	/**
	 * Riporta una descrizione della Stanza:
	 * Se nella stanza è presenta l'AttrezzoLuminoso la descrizione è quella standard della classe Stanza
	 * Altrimenti  la descrizione da come unica informazione quella che non è possibile vedere nulla a causa del "buio"
	 * 
	 * @return Restituisce un oggetto istanza della classe String
	 */
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(this.attrezzoLuminoso))
			return super.getDescrizione();
		else
			return Buio;
	}
}
