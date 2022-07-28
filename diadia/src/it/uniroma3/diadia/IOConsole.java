
package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * IOConsole:
 * Questa classe modella la gestione dell’Input e dell’Output.
 * Centralizza l’accesso a System.out/System.in
 *
 * @author  Simone
 * @version base
 */
public class IOConsole implements IO{
	private Scanner scannerDiLinee;
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
	}
	
	/**
	 * Stampa a schermo un messaggio a partire da una stringa 
	 * @param msg Stringa che identifica il messaggio da stampare
	 */
	public void mostraMessaggio(String msg) {
		System.out.println(msg);	
	}
	
	/**
	 * Trasforma l'imput in una stringa
	 * @return Restituisce una stringa 
	 */
	public String leggiRiga() {
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
}