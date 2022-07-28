
package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IOSimulator:
 * Questa classe modella una gestione simulata dell’Input e dell’Output.
 * Interpreta una Lista di comandi 
 * Colleziona i Messaggi ottenuti, all'intrno di una mappa con associato il comando che li ha generati  
 * @author Simone
 *
 */
public class IOSimulator implements IO {
	
	public static final String BENVENUTO = "benvenuto";
	private Map<String, String> messaggiProdotti;
	private List<String> comandi;
	private int comandoCorrente;
	
	/**
	 * Simula una console IO 
	 * Cataloga i comandi da eseguire in una Lista che tiene conto di eventuali messaggi di benvenuto ottenuti di default, 
	 * Colleziona i messagi generati da questi in una Mappa
	 * @param comandi Array di oggetti istanza della classe String che rappresenta i comandi da eseguire
	 * @see Comando
	 */
	public IOSimulator(String[] comandi) {
		this.comandoCorrente = 0;
		this.messaggiProdotti = new HashMap<String, String>();
		this.comandi = new ArrayList<String>(Arrays.asList(comandi));
		this.comandi.add(0,BENVENUTO);
	}
	
	/**
	 * Colleziona i messaggi ricevuti in Input in una Mappa
	 * I messagi iniziali di benvenuto vengono catalogati sotto il comando "BENVENUTO"
	 * Se un Comando viene ripetuto con la stessa segnatura più di una volta, 
	 * i messaggi ottenuti da quest'ultimo vengono catalogati in coda a quelli precedentemente ottenuti
	 * @see Comando
	 */
	@Override
	public void mostraMessaggio(String messaggio) {

		String prev = this.messaggiProdotti.get(this.comandi.get(comandoCorrente));
		
		if(prev == null)
			this.messaggiProdotti.put(this.comandi.get(this.comandoCorrente), messaggio);
		
		else
			this.messaggiProdotti.put(this.comandi.get(this.comandoCorrente), prev+messaggio);
	}
	
	/**
	 * Simula la lettura di un Comando restituendo una rappresentazione in Stringa del prossimo comando da Eseguire
	 * Tiene conto del "Comando 0" utile alla sola raccolta dei messaggi iniziali
	 * @return Restituisce un oggetto istanza della classe String
	 */
	@Override
	public String leggiRiga() {
		String lettura = this.comandi.get(comandoCorrente+1);
		this.comandoCorrente++;
		return lettura;
	}
	
	/**
	 * Restituisce un Messaggio ottenuto a paritre da una Comando passato come parametro
	 * @param comando Oggetto istanza della classe String che rappresenta un Comando
	 * @return Riporta un oggetto istanza della Classe String 
	 * @see Comando
	 */
	public String getMessaggio(String comando) {
		return this.messaggiProdotti.get(comando);
	}
	
	/**
	 * Verifica se nella collezione dei messaggi sono contenuti dei messaggi 
	 * ottenuti a partire da un comando passato come parametro
	 * @param comando Oggetto istanza della classe Strig che rappresenta cun Comando
	 * @return Restituisce TRUE se esiste un messaggio ottenuto a partire da un determinato Comando, altrimenti FALSE
	 * @see Comando
	 */
	public boolean hasMessaggio(String comando) {
		return this.messaggiProdotti.containsKey(comando);
	}
}
