
package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

/**
 * ComparaAttrezzoPerPeso:
 * Questa classe definisce un criterio di ordinamento per la classe Attrezzo
 * 
 * @author Simone
 * @see Attrezzo
 * @version Base
 */
public class ComparaAttrezzoPerPeso implements Comparator<Attrezzo> {
	
	/**
	 * Definisce un criterio di ordinamento crescente tra Attrezzi basato sul Peso ed in caso di uguaglianza sul Nome
	 * @param o1 Oggetto istanza della classe Attrezzo
	 * @param o2 Oggetto istanza della classe Attrezzo
	 * 
	 * @return Restituisce -1 se l'Attrezzo corrente è più piccolo di quello passato come parametro, 0 se sono uguali
	 * 		   ed 1 se l'Attrezzo corrente è più grande
	 */
	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		Integer a = o1.getPeso();
		Integer b = o2.getPeso();
		
		int flag = a.compareTo(b);
		if(flag == 0) 
			flag = o1.compareTo(o2);
		
		return flag;
	}

}
