package it.uniroma3.diadia;

import java.io.IOException;
import java.util.Properties;

public class CaricaotreCostanti {
	
	public static String getCostante(String key) {
		Properties prop = new Properties();
		try {
			prop.load(ClassLoader.getSystemResourceAsStream("config.properties"));
		} 
		catch (IOException e) {
			System.err.println("File non trovato");
		}
		
		return prop.getProperty(key);
	}
}
