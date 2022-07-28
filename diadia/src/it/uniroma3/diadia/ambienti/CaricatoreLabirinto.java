package it.uniroma3.diadia.ambienti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class CaricatoreLabirinto {
	
	private static final String PERSONAGGI = "Personaggi:";

	private class FormatoFileNonValidoException extends Exception {
		private static final long serialVersionUID = -531837953470380504L;
		
		public FormatoFileNonValidoException(String e) {
			super(e);
		}
	}

	private final String  STANZE   = "Stanze:";
	private static final String STANZE_BUIE = "Stanze buie:";
	private static final String STANZE_MAGICHE = "Stanze magiche:";
	private static final String STANZE_BLOCCATE = "Stanze bloccate:";
	private final String  ATTREZZI = "Attrezzi:";
	private final String  USCITE   = "Uscite:";
	private final String  ESTREMI = "Estremi:";
	private BufferedReader reader;
	private int numeroLinea;
	
	private LabirintoBuilder builder; 
	
	public CaricatoreLabirinto(InputStream fileStream) {
		this.numeroLinea = 0;
		this.builder = Labirinto.newBuilder();
		try {
			Reader file = new InputStreamReader(fileStream);
			this.reader = new BufferedReader(file);
		} catch (Exception e) {
			System.err.println("File non trovato");
			e.printStackTrace();
		}
	}

	public Labirinto carica() {
		try {
			this.leggiStanze();
			this.leggiStanzeBuie();
			this.leggiStanzeBloccate();
			this.leggiStanzeMagiche();
			this.leggiInizialeEvincente();
			this.leggiAttrezzi();
			this.leggiAdiacenze();
			this.leggiPersonaggi();
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
		while (!nomeStanza.equals(STANZE_BUIE)) {
			this.builder.addStanza(nomeStanza);
			nomeStanza = this.leggiRiga(reader);
		}
	}

	private void leggiStanzeBuie() throws FormatoFileNonValidoException  {
		String nomeStanza = null;
		String nomeAttrezzo = null; 
		String definizioneStanza = this.leggiRiga(reader);
		
		while (!definizioneStanza.equals(STANZE_BLOCCATE)) {
			Scanner scannerDiLinea = new Scanner(definizioneStanza);
			try {
				nomeStanza = scannerDiLinea.next();
				if (nomeStanza == null)
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				
				nomeAttrezzo = scannerDiLinea.next();
				if (nomeAttrezzo == null)
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				
			}
			finally {
				if(!scannerDiLinea.hasNext())
				scannerDiLinea.close();
			}
			
			this.builder.addStanzaBuia(nomeStanza, nomeAttrezzo);
			definizioneStanza = this.leggiRiga(reader);
		}
	}
	
	private void leggiStanzeBloccate() throws FormatoFileNonValidoException  {
		String nomeStanza = null;
		String direzione = null;
		String nomeAttrezzo = null; 
		String definizioneStanza = this.leggiRiga(reader);
		
		while (!definizioneStanza.equals(STANZE_MAGICHE)) {
			Scanner scannerDiLinea = new Scanner(definizioneStanza);
			try {
				nomeStanza = scannerDiLinea.next();
				if (nomeStanza == null)
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				
				direzione = scannerDiLinea.next();
				if (direzione == null)
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				
				nomeAttrezzo = scannerDiLinea.next();
				if (nomeAttrezzo == null)
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				
			}
			finally {
				if(!scannerDiLinea.hasNext())
				scannerDiLinea.close();
			}
			
			this.builder.addStanzaBloccata(nomeStanza, direzione, nomeAttrezzo);
			definizioneStanza = this.leggiRiga(reader);
		}
	}

	private void leggiStanzeMagiche() throws FormatoFileNonValidoException  {
		String nomeStanza = null;
		int soglia = 0; 
		String definizioneStanza = this.leggiRiga(reader);
		
		while (!definizioneStanza.equals(ESTREMI)) {
			Scanner scannerDiLinea = new Scanner(definizioneStanza);
			try {
				nomeStanza = scannerDiLinea.next();
				if (nomeStanza == null)
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				try {
					soglia = Integer.parseInt(scannerDiLinea.next());
				}
				catch (NumberFormatException e) {
					throw new FormatoFileNonValidoException("Soglia magica "+soglia+" non valida [" + this.numeroLinea + "].");
				}
			}
			finally {
				if(!scannerDiLinea.hasNext())
				scannerDiLinea.close();
			}
			
			this.builder.addStanzaMagica(nomeStanza, soglia);
			definizioneStanza = this.leggiRiga(reader);
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
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				try {
					pesoAttrezzo = Integer.parseInt(scannerDiLinea.next());
				}
				catch (NumberFormatException e) {
					throw new FormatoFileNonValidoException("Peso attrezzo "+nomeAttrezzo+" non valido [" + this.numeroLinea + "].");
				}
				nomeStanza = scannerDiLinea.next();
				if (nomeStanza == null)
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				
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
		while (!datiAdiacenza.equals(PERSONAGGI)) {
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
	
	private void leggiPersonaggi() throws FormatoFileNonValidoException {
		String nome = null;
		String presentazione = null;
		String nomeAttrezzo = null;
		int pesoAttrezzo = 0;
		String nomeStanza = null; 
		String definizionePersonaggio = this.leggiRiga(reader);
		
		while (definizionePersonaggio != null) {
			nomeAttrezzo = null;
			pesoAttrezzo = 0;
			Scanner scannerDiLinea = new Scanner(definizionePersonaggio);
			scannerDiLinea.useDelimiter(", ");
			try {
				nome = scannerDiLinea.next();
				if (nome == null)
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				
				presentazione = scannerDiLinea.next();
				if (presentazione == null)
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				
				nomeStanza = scannerDiLinea.next();
				if (nomeStanza == null)
					throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");
				
				if(scannerDiLinea.hasNext()) {
					nomeAttrezzo = scannerDiLinea.next();
					if (nomeAttrezzo == null)
						throw new FormatoFileNonValidoException("Terminazione inaspettata del file [" + this.numeroLinea + "].");

					try {
						pesoAttrezzo = Integer.parseInt(scannerDiLinea.next());
					}
					catch (NumberFormatException e) {
						throw new FormatoFileNonValidoException("Peso attrezzo "+nomeAttrezzo+" non valido [" + this.numeroLinea + "].");
					}
				}
				
			}
			finally {
				if(!scannerDiLinea.hasNext())
				scannerDiLinea.close();
			}
			try {
				this.builder.addPersonaggio(nome, presentazione, nomeAttrezzo, pesoAttrezzo, nomeStanza);
			}
			catch (IllegalArgumentException e) {
				throw new FormatoFileNonValidoException("Definizione personaggio "+nome+" errata [" + this.numeroLinea + "]");
			} 
			
			definizionePersonaggio = this.leggiRiga(reader);
		}
	}
}