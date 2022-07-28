package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	@SuppressWarnings("deprecation")
	@Override
	public AbstractComando costruisciComando(String istruzione, IO console) {

		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		AbstractComando comando;

		if(scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if(scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		scannerDiParole.close();
		
		try {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
			nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
			nomeClasse.append(nomeComando.substring(1));
			comando = (AbstractComando)Class.forName(nomeClasse.toString()).newInstance();
			comando.setParametro(parametro);
		}
		catch(NoClassDefFoundError e) {
			comando = new ComandoNonValido();
		}
		catch(Exception e){
			comando = new ComandoNonValido();
		}
		
		comando.setIO(console);
		return comando;

	}

}
