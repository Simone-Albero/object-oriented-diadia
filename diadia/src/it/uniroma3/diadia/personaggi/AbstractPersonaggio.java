package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractPersonaggio {

	private String nome;
	private String presentazione;
	private boolean haSalutato;

	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome = nome;
		this.presentazione = presentazione;
		this.haSalutato = false;
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

	public boolean haSalutato() {
		return this.haSalutato;
	}

	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome()+".");
		
		if (!haSalutato)
			risposta.append(this.presentazione);

		else
			risposta.append("Ci siamo gia' presentati!");

		this.haSalutato = true;
		return risposta.toString();
	}
	
	abstract public String agisci(Partita partita);

	@Override
	public String toString() {
		return this.nome;
	}
}