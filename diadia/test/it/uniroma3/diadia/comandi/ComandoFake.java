package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFake extends AbstractComando {

	public static final String DONE = "done";

	@Override
	public void esegui(Partita partita) {
		this.console.mostraMessaggio(DONE);
	}

}
