package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EnglishDictionary extends Dictionary {
	
	@Override
	public void loadDictionary(){
		try {
			FileReader fr = new FileReader("rsc/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere word alla struttura dati
				dizionario.add(word);
			
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}
	
	
}
