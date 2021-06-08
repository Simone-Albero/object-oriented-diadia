
package it.uniroma3.diadia;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  Simone 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final public String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.\n";

	private Partita partita;
	private IO console;

	/**
	 * Crea una partita a partire da una cosole di input-output
	 * @param console Oggetto istanza della classe IO
	 * @see IO
	 */
	public DiaDia(IO console, Labirinto labirinto) {
		this.partita = new Partita(labirinto);
		this.console = console;
	}
	
	/**
	 * Avvia la partita e gestisce i comandi passati dall'utente
	 * @see Comando
	 */
	public void gioca() {
		String istruzione; 
		this.console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		this.console.mostraMessaggio("Attualmente ti trovi qui:\n"+partita.getStanzaCorrente().getDescrizione());
	
		do
			istruzione= this.console.leggiRiga();
			
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa un comando
	 * @return  Restituisce TRUE se il comando e' eseguito e il gioco continua, altrimenti FALSE
	 * @see Comando
	 */
	private boolean processaIstruzione(String istruzione) {
		AbstractComando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione, this.console);
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta())
			this.console.mostraMessaggio("Hai vinto!");
		
		if (!this.partita.giocatoreIsVivo())
			this.console.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}


	
	public static void main(String[] argc) {
		Scanner scannerDiLinee = new Scanner(System.in);
		IO io = new IOConsole(scannerDiLinee);
		Labirinto labirinto = new Labirinto(ClassLoader.getSystemResourceAsStream("labirinto1.txt"));
		
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		
		try {
			scannerDiLinee.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}