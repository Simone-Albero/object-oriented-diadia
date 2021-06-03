package it.uniroma3.diadia.ambienti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CaricatoreLabirinto {
	private class FormatoFileNonValidoException extends Exception {
		private static final long serialVersionUID = -531837953470380504L;
		
		public FormatoFileNonValidoException(String e) {
			super(e);
		}
	}

	private final String  STANZE   = "Stanze:";
	private final String  ATTREZZI = "Attrezzi:";
	private final String  USCITE   = "Uscite:";
	private final String  ESTREMI = "Estremi:";
	private BufferedReader reader;
	private int numeroLinea;
	
	private LabirintoBuilder builder; 
	
	public CaricatoreLabirinto(String nomeFile) {
		this.numeroLinea = 0;
		this.builder = new LabirintoBuilder();
		try {
			this.reader = new BufferedReader(new FileReader(nomeFile));
		} catch (FileNotFoundException e) {
			System.err.println("File " + nomeFile + " non trovato");
			e.printStackTrace();
		}
	}

	public Labirinto carica() {
		try {
			this.leggiStanze();
			this.leggiInizialeEvincente();
			this.leggiAttrezzi();
			this.leggiAdiacenze();
		} catch (FormatoFileNonValidoException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this.builder.getLabirinto();

	}

	private String leggiRiga(BufferedReader reader) throws FormatoFileNonValidoException {
		try {
			this.numeroLinea++;
			String riga = reader.readLine();
			System.err.println("Letta riga "+ this.numeroLinea + ": "+ riga);
			return riga;
		} catch (IOException e) {
				throw new FormatoFileNonValidoException("Problemi lettura file [" + this.numeroLinea + "]");
		}
	}
	
	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = this.leggiRiga(reader);
		String nomeStanzaVincente = this.leggiRiga(reader);
		String token = this.leggiRiga(reader);
		if (!token.equals(ATTREZZI))
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.numeroLinea + "]:" +ATTREZZI +" non trovato");		
		this.builder.addEntrata(nomeStanzaIniziale);
		this.builder.addUscita(nomeStanzaVincente);
	}

	private void leggiStanze() throws FormatoFileNonValidoException  {
		String nomeStanza = null;
		nomeStanza = this.leggiRiga(reader);
		if (!nomeStanza.equals(STANZE))
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.numeroLinea + "]"+": "+STANZE +" non trovato");
		nomeStanza = this.leggiRiga(reader);
		while (!nomeStanza.equals(ESTREMI)) {
			this.builder.addStanza(nomeStanza);
			nomeStanza = this.leggiRiga(reader);
		}
	}

	private void leggiAttrezzi() throws FormatoFileNonValidoException {
		String nomeAttrezzo = null;
		int pesoAttrezzo = 0;
		String nomeStanza = null; 
		String definizioneAttrezzo = this.leggiRiga(reader);
		
		while (!definizioneAttrezzo.equals(USCITE)) {
			Scanner scannerDiLinea = new Scanner(definizioneAttrezzo);
			try {
				nomeAttrezzo = scannerDiLinea.next();
				if (nomeAttrezzo == null)
					throw new FormatoFileNonValidoException("Termine inaspettata del file [" + this.numeroLinea + "].");
				try {
					pesoAttrezzo = Integer.parseInt(scannerDiLinea.next());
				}
				catch (NumberFormatException e) {
					throw new FormatoFileNonValidoException("Peso attrezzo "+nomeAttrezzo+" non valido [" + this.numeroLinea + "].");
				}
				nomeStanza = scannerDiLinea.next();
			}
			finally {
				if(!scannerDiLinea.hasNext())
				scannerDiLinea.close();
			}
			try {
				this.builder.addAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
			}
			catch (IllegalArgumentException e) {
				throw new FormatoFileNonValidoException("Definizione attrezzo "+ nomeAttrezzo+" errata [" + this.numeroLinea + "]" +": stanza" +nomeStanza+" inesistente");
			} 
			
			definizioneAttrezzo = this.leggiRiga(reader);
		}
	}

	private void leggiAdiacenze() throws FormatoFileNonValidoException {
		String stanzaThis = null;
		String stanzaThat= null;
		String direzione = null;
		String datiAdiacenza = this.leggiRiga(reader);
		while (datiAdiacenza != null) {
			Scanner scannerDiLinea = new Scanner(datiAdiacenza);	
			try {
			while (scannerDiLinea.hasNext()) {
				stanzaThis = scannerDiLinea.next();
				stanzaThat = scannerDiLinea.next();
				direzione = scannerDiLinea.next();
				
				try {
					this.builder.addAdiacenza(stanzaThis, stanzaThat, direzione);
				}
				catch (IllegalArgumentException e) {
					throw new FormatoFileNonValidoException("Definizione errata adiacenza [" + this.numeroLinea + "]");
				}
			}
			datiAdiacenza = this.leggiRiga(reader);
			}
			finally {
				if(!scannerDiLinea.hasNext())
					scannerDiLinea.close();
			}
			
		}
	}

}