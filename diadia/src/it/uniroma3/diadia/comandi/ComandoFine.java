package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Comando "Fine".
 */
public class ComandoFine implements Comando {
	
	private static final String NOME = "ComandoFine";
	IO console;
	
	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio("Grazie di aver giocato!");
	}

	@Override
	public void setParametro(String parametro) {
		//nessun parametro
		return;
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
		return null;
	}

}







