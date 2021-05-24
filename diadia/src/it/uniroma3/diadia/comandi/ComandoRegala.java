package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	
	private static final String MESSAGGIO_DI_ERRORE = "Impossibile trovare l'attrezzo!";

	@Override
	public void esegui(Partita partita) {
		if(this.parametro==null) {
			
			this.console.mostraMessaggio("Ecco il tuo inventario:\n"+partita.getGiocatore().getBorsa().toString());
			if(partita.getGiocatore().getBorsa().isEmpty())
				return;
			
			this.console.mostraMessaggio("Cosa vuoi regalare?");
			this.parametro = this.console.leggiRiga();
		}
		
		if(partita.getGiocatore().getBorsa().hasAttrezzo(this.parametro)) {
			Attrezzo present = partita.getGiocatore().getBorsa().removeAttrezzo(this.parametro);
			this.console.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(present, partita));
		}
		else
			this.console.mostraMessaggio(MESSAGGIO_DI_ERRORE);
	}

}
