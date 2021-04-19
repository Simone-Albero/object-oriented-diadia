
package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	private static final String Buio = "Quì c'è buio pesto!!";
	private final static String attrezzoLuminosoDef = "lanterna"; 
	private String attrezzoLuminoso;
	
	public StanzaBuia(String nome) {
		this(nome, attrezzoLuminosoDef);
	}
	
	public StanzaBuia(String nome, String attrezzoLuminoso) {
		super(nome);
		this.attrezzoLuminoso = attrezzoLuminoso;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(this.attrezzoLuminoso))
			return super.getDescrizione();
		else
			return Buio;
	}
	
	public String getDescrizioneBuio() {
		return Buio;
	}
}
