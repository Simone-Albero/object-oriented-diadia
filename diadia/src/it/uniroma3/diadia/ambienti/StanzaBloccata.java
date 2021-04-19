
package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.hasAttrezzo(this.attrezzoSbloccante))
			return super.getStanzaAdiacente(direzione);
		else
			return this;
	}
	
	@Override
	public String getDescrizione() {
		return super.getDescrizione() + "Attenzione! la direzione: '"+this.direzioneBloccata
									  + "' è bloccata, per sbloccarla hai bisogno di: '"+this.attrezzoSbloccante+"'";
	}
}
