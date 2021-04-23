package it.uniroma3.diadia;

public class IOSimulator implements IO {
	
	private static final int MAX_MESSAGGI = 50;
	private int maxMessaggi;
	
	private String [] comandi;
	private int comandoCorrente;
	private String[] messaggiProdotti;
	private int numeroMessaggiProdotti;
	private int numeroMessaggiMostrati;
	
	
	public IOSimulator(String[] comandi) {
		this(comandi, MAX_MESSAGGI);
	}
	
	public IOSimulator(String[] comandi, int maxMessaggi) {
		this.comandi = comandi;
		this.comandoCorrente = 0;
		this.messaggiProdotti = new String[maxMessaggi];
		this.maxMessaggi = maxMessaggi;
		this.numeroMessaggiMostrati = 0;
		this.numeroMessaggiProdotti = 0;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		if(this.numeroMessaggiProdotti < this.maxMessaggi){
			this.messaggiProdotti[this.numeroMessaggiProdotti] = messaggio;
			this.numeroMessaggiProdotti++;
		}
	}

	@Override
	public String leggiRiga() {
		String temp = this.comandi[this.comandoCorrente];
		this.comandoCorrente++;
		return temp;
	}
	
	public String nextMessaggio() {
		String next = this.messaggiProdotti[this.numeroMessaggiMostrati];
		this.numeroMessaggiMostrati++;
		return next;
	}
	
	public boolean hasNextMessaggio() {
		return this.numeroMessaggiMostrati < this.numeroMessaggiProdotti;
	}
}
