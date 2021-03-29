package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest2 {

	public static void main(String[] args) {
		Stanza bar= new Stanza("bar");
		Stanza mensa= new Stanza("mensa");
		Attrezzo tazzina= new Attrezzo("tazzina", 1);
		Attrezzo piatto= new Attrezzo("piatto", 2);
		
		
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);
		bar.addAttrezzo(tazzina);
		mensa.addAttrezzo(piatto);
		
		System.out.println("Attrezzo dietro porta nord del bar: " + (bar.getStanzaAdiacente("nord").getAttrezzi())[0]);
		System.out.println("Attrezzo dietro porta sud della mensa: " + (mensa.getStanzaAdiacente("sud").getAttrezzi())[0]);
		
		System.out.println("Porta nord bar --> " + bar.getStanzaAdiacente("nord"));
		System.out.println("Porta sud mensa --> " + mensa.getStanzaAdiacente("sud"));

	}

}
