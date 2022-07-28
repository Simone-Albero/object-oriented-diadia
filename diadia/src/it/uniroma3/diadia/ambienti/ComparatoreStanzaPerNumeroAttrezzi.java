package it.uniroma3.diadia.ambienti;

import java.util.Comparator;

public class ComparatoreStanzaPerNumeroAttrezzi implements Comparator<Stanza> {

	@Override
	public int compare(Stanza o1, Stanza o2) {
		Integer a = o1.getAttrezzi().size();
		Integer b = o2.getAttrezzi().size();
		
		return a.compareTo(b);
	}

	

}
