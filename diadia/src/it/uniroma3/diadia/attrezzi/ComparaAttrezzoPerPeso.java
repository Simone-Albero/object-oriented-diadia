
package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparaAttrezzoPerPeso implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		Integer a = o1.getPeso();
		Integer b = o2.getPeso();
		
		return b.compareTo(a);
	}

}
