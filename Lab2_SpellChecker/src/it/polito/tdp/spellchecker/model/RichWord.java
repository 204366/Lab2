package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String stringa;
	private boolean trovata;
	
	
	public RichWord(String stringa, boolean trovata) {
		super();
		this.stringa = stringa;
		this.trovata = trovata;
	}


	public void setTrovata(boolean trovata) {
		this.trovata = trovata;
	}


	@Override
	public String toString() {
		return " [stringa=" + stringa + ", trovata=" + trovata + "]";
	}
	
	
	
	
}
