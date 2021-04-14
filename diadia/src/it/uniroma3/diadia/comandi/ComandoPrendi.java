
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Cerca, se possibile, di prendere un attrezzo, altrimenti stampa un messaggio di errore
 */
public class ComandoPrendi implements Comando {
	
	private static final String NOME = "ComandoVai"; 
	private String nomeAttrezzo;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			this.console.mostraMessaggio("Ecco gli attrezzi che puoi prendere: ");
			for(Attrezzo attrezzo : partita.getStanzaCorrente().getAttrezzi())
					if(attrezzo != null)
						this.console.mostraMessaggio("- "+attrezzo.toString());
			this.console.mostraMessaggio("Cosa vuoi prendere?");
			nomeAttrezzo = this.console.leggiRiga();
		}
		
		boolean flag= partita.getGiocatore().storeAttrezzo(nomeAttrezzo, partita.getStanzaCorrente());
		if(flag)
			this.console.mostraMessaggio("Attrezzo preso con successo!");
		else
			this.console.mostraMessaggio("Impossibile prendere l'attrezzo!");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

	@Override
	public void setIO(IO console) {
		this.console = console;
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
