package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Comando:
 * Questa classe modella un comando astratto.
 * Un comando è composto da due parole:
 * Il nome del comando ed un parametro
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  Simone
 * @version base
 */
public abstract class AbstractComando {

	private static final String COMANDO = "Comando";
	protected IO console;
	protected String parametro = null;

	public void setIO(IO console) {
		this.console = console;
	}

	public String getParametro() {
		return this.parametro;
	}
	
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getNome() {
		int index = this.getClass().getName().indexOf(COMANDO);
		return this.getClass().getName().substring(index + COMANDO.length()).toLowerCase();
	}
	
	public abstract void esegui(Partita partita);
}
