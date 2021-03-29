package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;

public class StanzaTest1 {

	public static void main(String[] args) {
		Stanza bar= new Stanza("bar");
		Stanza mensa= new Stanza("mensa");
		
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);
		
		System.out.println("Porta nord bar --> " + bar.getStanzaAdiacente("nord"));
		System.out.println("Porta sud mensa --> " + mensa.getStanzaAdiacente("sud"));

	}

}
