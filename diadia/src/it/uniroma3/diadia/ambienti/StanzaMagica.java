
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.CaricaotreCostanti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * StanzaMagica:
 * Questa classe è un estensione della classe Stanza
 * Modella una particolare Stanza avente un valore di soglia "sogliaMagica"
 * Superato il valore di Soglia, ogni Attrezzo lasciato nella Stanza avrà nome e peso alterati
 * 
 * @author Simone
 * @see Stanza
 * @version base
 */
public class StanzaMagica extends Stanza {

	final static private int SOGLIA_MAGICA_DEFAULT = Integer.parseInt(CaricaotreCostanti.getCostante("def_soglia_magica"));
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	/**
	 * Crea una StanzaMagica a partire da una sogliaMagica di default
	 * @param nome Oggetto istanza della classe String che rappresenta il nome della Stanza
	 */
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	/**
	 * Crea una StanzaMagica a partire da una sogliaMagica di default
	 * @param nome Oggetto istanza della classe String che rappresenta il nome della Stanza
	 * @param soglia Intero che rappresenta il valore della soglia magica
	 */
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	/**
	 * Aggiunge, se possibile, un Attrezzo alla stanza
	 * Se il numero di Attrezzi posati supera la soglia magica, 
	 * l'attrezzo prima di essere aggiunto alla stanza viene modificato
	 * 
	 * @return Restituisce TRUE se è possibile aggiungere l'Attrezzo alla Stanza, altrimenti FALSE
	 */
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica && attrezzo!=null)
			attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}
	
	/**
	 * Riporta un Attrezzo con "nome" invertito e "peso" doppio
	 * @param attrezzo Oggetto istanza della classe Attrezzo
	 * @return Restituisce un oggetto istanza della classe Attrezzo
	 * @see Stanza
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}
	
	public Attrezzo modificaAttrezzoTest(Attrezzo attrezzo) {
		return this.modificaAttrezzo(attrezzo);
	}

}




