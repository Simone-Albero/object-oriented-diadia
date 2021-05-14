
package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSimulator implements IO {
	
	public static final String BENVENUTO = "benvenuto";
	private Map<String, String> messaggiProdotti;
	private List<String> comandi;
	private int comandoCorrente;
	
	public IOSimulator(String[] comandi) {
		this.comandoCorrente = 0;
		this.messaggiProdotti = new HashMap<String, String>();
		this.comandi = new ArrayList<String>(Arrays.asList(comandi));
		this.comandi.add(0,BENVENUTO);
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		if(this.comandoCorrente > this.comandi.size()-1)
			return;
		
		String prev = this.messaggiProdotti.get(this.comandi.get(comandoCorrente));
		
		if(prev == null)
			this.messaggiProdotti.put(this.comandi.get(this.comandoCorrente), messaggio);
		
		else
			this.messaggiProdotti.put(this.comandi.get(this.comandoCorrente), prev+messaggio);
	}

	@Override
	public String leggiRiga() {
		String lettura = this.comandi.get(comandoCorrente+1);
		this.comandoCorrente++;
		return lettura;
	}
	
	public String getMessaggio(String comando) {
		return this.messaggiProdotti.get(comando);
	}
	
	public boolean hasMessaggio(String comando) {
		return this.messaggiProdotti.containsKey(comando);
	}
}
