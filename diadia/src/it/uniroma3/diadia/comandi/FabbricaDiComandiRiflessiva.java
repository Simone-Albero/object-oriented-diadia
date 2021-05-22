//package it.uniroma3.diadia.comandi;
//
//import java.util.Scanner;
//
//import it.uniroma3.diadia.IO;
//
//public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
//
//	@Override
//	public AbstractComando costruisciComando(String istruzione, IO console) {
//		
//		Scanner scannerDiParole = new Scanner(istruzione);
//		String nomeComando = null;
//		String parametro = null;
//		
//		if(scannerDiParole.hasNext())
//			nomeComando = scannerDiParole.next();
//		if(scannerDiParole.hasNext())
//			parametro = scannerDiParole.next();
//		
//		StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
//		nomeClasse.append(Character.toUpperCase(nomeClasse.charAt(0)));
//		nomeClasse.append(nomeClasse.substring(1));
//		AbstractComando comando = (AbstractComando)Class.forName(nomeClasse.toString()).newInstance();
//		comando.setParametro(parametro);
//		
//		scannerDiParole.close();
//		return comando;
//	}
//
//}
