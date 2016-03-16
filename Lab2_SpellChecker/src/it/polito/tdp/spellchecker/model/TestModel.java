package it.polito.tdp.spellchecker.model;

import java.util.LinkedList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		ItalianDictionary d1 = new ItalianDictionary();
		
		
		List<String> parole = new LinkedList<String>();
		parole.add("casa");
		parole.add("macchina");
		parole.add("tempo");
		parole.add("albanese");
		parole.add("aback");
		
		d1.loadDictionary();
		long t0 = System.nanoTime();
		List<RichWord> r = new LinkedList<RichWord>(d1.spellCheckText(parole));
		long t1= System.nanoTime();
		System.out.println("lista parole trovate e non: " + r.toString() + " tempo impiegato=" + (t1-t0));
	}

}
