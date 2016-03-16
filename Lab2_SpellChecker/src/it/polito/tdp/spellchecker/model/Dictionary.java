package it.polito.tdp.spellchecker.model;

import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	List<String> dizionario = new LinkedList<String>();



	public List<String> getDizionario() {
		return dizionario;
	}

	public void loadDictionary() {

	}
	//Questo metodo non va implementato in questa classe. (Vedere esercizio 1.5).

	public List<RichWord> spellCheckText(List<String> inputTextList){

		List<RichWord> list = new LinkedList<RichWord>();
		/*
		boolean corretto = false;
		for(String stemp : inputTextList){
			if(dizionario.contains(stemp))
				corretto = true;
			list.add(new RichWord (stemp, corretto));
		}
		 */
		int inizio = 0;
		int fine = dizionario.size();
		
		boolean corretto = false;
		for (String stemp: inputTextList){
			
			while (inizio!=fine){
				int medio = (fine - inizio)/2;
				System.out.println(inizio + " " + medio+ " "+ fine);
				if (stemp.compareTo(dizionario.get(medio))==0){
					corretto=true;
					break;
				} else if (stemp.compareTo(dizionario.get(medio))>0){
					inizio=medio;
				} else {
					fine=medio;
				}
			}





			/*	

			if(stemp.compareTo(dizionario.get(medio)) == 0)
				corretto = true;

			else if(stemp.compareTo(dizionario.get(medio)) > 0){
				for(int i = medio + 1; i < dizionario.size(); i ++){
					if(stemp.compareTo(dizionario.get(i)) == 0){
						corretto = true;
						break;
					}		
				}
			}
			else {
				for(int i = 0; i < medio; i ++){
					if(stemp.compareTo(dizionario.get(i)) == 0){
						corretto = true;
						break;
					}		
				}
			}
			 */			
			list.add(new RichWord (stemp, corretto));
		}

		return list;

	}
	//Implementare il metodo per poter eseguire il controllo ortografico del testo in input.

}
