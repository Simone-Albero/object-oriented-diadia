
package it.uniroma3.diadia.ambienti;

import java.util.LinkedList;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected extends Stanza {
	
	static final protected int NUMERO_MASSIMO_DIREZIONI = 4;
	static final protected int NUMERO_MASSIMO_ATTREZZI = 10;

	protected String nome;
	protected LinkedList<Attrezzo> attrezzi;
	protected int numeroAttrezzi;
	protected LinkedList<Stanza> stanzeAdiacenti;
	protected int numeroStanzeAdiacenti;
	protected LinkedList<String> direzioni;
	
	public StanzaProtected(String nome) {
		super(nome);
	}

}
