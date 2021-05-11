
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {

	private Labirinto labirinto;
	
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
	}
	
	public LabirintoBuilder(int maxStanze, int maxAttrezzi) {
		this.labirinto = new Labirinto(maxStanze, maxAttrezzi);
	}
	
	public LabirintoBuilder addEntrata(String stanza) {
		if(stanza != null) {
			Stanza that = new Stanza(stanza);
			if(!this.labirinto.getStanze().contains(that)) {
				this.labirinto.addStanza(that);
				this.labirinto.setEntrata(that);
			}

			else {
				Stanza entrata = this.labirinto.getStanze().get(this.labirinto.getStanze().indexOf(that));
				this.labirinto.setUscita(entrata);
			}
		}
		return this;
	}
	
	public LabirintoBuilder addUscita(String stanza) {
		if(stanza != null) {
			Stanza that = new Stanza(stanza);
			if(!this.labirinto.getStanze().contains(that)) {
				this.labirinto.addStanza(that);
				this.labirinto.setUscita(that);
			}
			else {
				Stanza uscita = this.labirinto.getStanze().get(this.labirinto.getStanze().indexOf(that));
				this.labirinto.setUscita(uscita);
			}
		}
		return this;	
	}
	
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		if(nome != null) {
			Attrezzo attrezzo = new Attrezzo(nome, peso);
			if (this.labirinto.addAttrezzo(attrezzo)) {
				Stanza last = this.labirinto.getStanze().get(this.labirinto.getStanze().size()-1);
				last.addAttrezzo(attrezzo);
			}
		}
		return this;
	}
	
	public LabirintoBuilder addStanza(String stanza) {
		this.labirinto.addStanza(new Stanza(stanza));
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String stanza) {
		this.labirinto.addStanza(new StanzaMagica(stanza));
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String stanza, int soglia) {
		this.labirinto.addStanza(new StanzaMagica(stanza, soglia));
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String stanza, String direzione, String attrezzo) {
		this.labirinto.addStanza(new StanzaBloccata(stanza, direzione, attrezzo));
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String stanza) {
		this.labirinto.addStanza(new StanzaBuia(stanza));
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String stanza, String attrezzo) {
		this.labirinto.addStanza(new StanzaBuia(stanza, attrezzo));
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String s1, String s2, String direzione) {
		int index1 = this.labirinto.getStanze().indexOf(new Stanza(s1));
		int index2 = this.labirinto.getStanze().indexOf(new Stanza(s2));
				
		if(index1 != -1 && index2 != -1)
			this.labirinto.getStanze().get(index1).setStanzaAdiacente(direzione, this.labirinto.getStanze().get(index2));
		return this;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	
}
