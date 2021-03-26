
package it.uniroma3.diadia;
import java.util.Scanner;

/**
 * Comando:
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {

	private String nome;
	private String parametro;
	
	/**
	 * Crea un Comando 
	 * @param istruzione Stringa che identifica il comando,
	 * pu� contenere due parole: il nome del comando ed il rispettivo parametro
	 */
	public Comando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			this.nome = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();
		
		scannerDiParole.close();
	}
	
	/**
	 * Restituisce il nome del comando
	 * @return Restituisce una stringa: comando
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Restituisce il parametro associato ad un comando
	 * @return Restiuisce una stringa: parametro
	 */
	public String getParametro() {
		return this.parametro;
	}
	
	/**
	 * Verifica se il nome del comando � non valdio 
	 * @return Restituisce TRUE se il nome del comando � NULL, altrimenti FALSE
	 */
	public boolean sconosciuto() {
		return (this.nome == null);
	}
}