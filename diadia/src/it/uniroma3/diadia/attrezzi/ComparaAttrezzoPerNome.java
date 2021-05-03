
package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparaAttrezzoPerNome implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
