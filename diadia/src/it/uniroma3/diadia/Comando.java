
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
	 * può contenere due parole: il nome del comando ed il rispettivo parametro
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
	 * Riporta il nome del comando
	 * @return Restituisce una stringa
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Riporta il parametro associato ad un comando
	 * @return Restiuisce una stringa
	 */
	public String getParametro() {
		return this.parametro;
	}
	
	/**
	 * Verifica se il nome del comando è non valdio 
	 * @return Restituisce TRUE se il nome del comando è NULL, altrimenti FALSE
	 */
	public boolean sconosciuto() {
		return (this.nome == null);
	}
}