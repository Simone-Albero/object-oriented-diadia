
package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.\n";

	static final private String[] elencoComandi = {"vai: permette di cambiare stanza a partire da una direzione", 
												   "aiuto: lista dei comandi diponibili", 
												   "fine: termina la partita", 
												   "prendi: permette di raccoglere un oggetto da una stanza se possibile", 
												   "posa: permette di posare un oggetto in una stanza se possibile"};

	private Partita partita;
	private IOConsole console;

	public DiaDia(IOConsole console) {
		this.partita = new Partita();
		this.console = console;
	}
	
	public void gioca() {
		String istruzione; 
		this.console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		this.console.mostraMessaggio("Attualmente ti trovi qui:\n"+partita.getStanzaCorrente().getDescrizione());
	
		do
			istruzione= this.console.leggiRiga();
			
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if(comandoDaEseguire.getNome()!=null) {
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			} 
			else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			
			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			
			else if (comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
			
			else if (comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
			
			else
				this.console.mostraMessaggio("Comando sconosciuto");
		}

		else
			this.console.mostraMessaggio("Inserire un comando");

		if (this.partita.vinta()) {
			this.console.mostraMessaggio("Hai vinto!");
			return true;
		}
		else
			return false;
	}   


	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		this.console.mostraMessaggio("Ecco i comandi che hai a disposizione:\n");
		for(int i=0; i< elencoComandi.length; i++) 
			this.console.mostraMessaggio(elencoComandi[i]+" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			this.console.mostraMessaggio("Ecco le direzioni in cui puoi andare:");
			for(String currDirezione : this.partita.getStanzaCorrente().getDirezioni())
				this.console.mostraMessaggio(currDirezione);
			
			this.console.mostraMessaggio("Dove vuoi andare?");
			direzione = this.console.leggiRiga();
		}
		
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.console.mostraMessaggio("Direzione inesistente!");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		
		this.console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	/**
	 * 
	 * @param nomeAttrezzo
	 * @param scannerDiLinee
	 */
	private void prendi(String nomeAttrezzo) {
		
		if(nomeAttrezzo==null) {
			this.console.mostraMessaggio("Nella stanza ci sono i seguenti attrezzi: ");
			for(Attrezzo attrezzo : this.partita.getStanzaCorrente().getAttrezzi())
					if(attrezzo != null)
						this.console.mostraMessaggio(attrezzo.toString());
			this.console.mostraMessaggio("Cosa vuoi prendere?");
			nomeAttrezzo = this.console.leggiRiga();
		}
		
		boolean flag= partita.getGiocatore().storeAttrezzo(nomeAttrezzo, partita.getStanzaCorrente());
		if(flag)
			this.console.mostraMessaggio("Attrezzo preso con successo!");
		else
			this.console.mostraMessaggio("Impossibile prendere l'attrezzo!");
	}
	
	/**
	 * 
	 * @param nomeAttrezzo
	 * @param scannerDiLinee
	 */
	private void posa(String nomeAttrezzo) {
		
		if(nomeAttrezzo==null) {
			this.console.mostraMessaggio("Nella borsa ci sono i seguenti attrezzi: ");
			this.console.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
			this.console.mostraMessaggio("Cosa vuoi posare?");
			nomeAttrezzo = this.console.leggiRiga();
		}
		
		boolean flag =  partita.getGiocatore().dropAttrezzo(nomeAttrezzo, partita.getStanzaCorrente());
		
		if(flag)
			this.console.mostraMessaggio("Attrezzo posato con successo!");
		else
			this.console.mostraMessaggio("Impossibile posare l'attrezzo!");
	}
	
	
	
	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		
		gioco.gioca();
	}
}