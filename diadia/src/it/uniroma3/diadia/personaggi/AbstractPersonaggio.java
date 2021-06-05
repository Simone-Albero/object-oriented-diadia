package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {

	private String nome;
	private String presentazione;
	private boolean haSalutato;
	private Attrezzo present;

	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome = nome;
		this.presentazione = presentazione;
		this.haSalutato = false;
		this.present = null;
	}
	
	public AbstractPersonaggio() {
		this.nome = null;
		this.presentazione = null;
		this.haSalutato = false;
		this.present = null;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPresentazione() {
		return this.presentazione;
	}

	public void setPresentazione(String presentazione) {
		this.presentazione = presentazione;
	}
	
	public void setPresent(Attrezzo present) {
		this.present = present;
	}
	
	public Attrezzo getPresent() {
		return this.present;
	}

	public boolean haSalutato() {
		return this.haSalutato;
	}

	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome()+". ");
		
		if (!haSalutato)
			risposta.append(this.presentazione);

		else
			risposta.append("Ci siamo gia' presentati!");

		this.haSalutato = true;
		return risposta.toString();
	}
	
	abstract public String agisci(Partita partita);
	
	abstract public String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	@Override
	public String toString() {
		return this.nome;
	}
}
