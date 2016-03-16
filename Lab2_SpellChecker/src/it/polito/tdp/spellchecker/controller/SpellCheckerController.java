package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.EnglishDictionary;
import it.polito.tdp.spellchecker.model.ItalianDictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SpellCheckerController {
	ItalianDictionary d1 = new ItalianDictionary();
	EnglishDictionary d2 = new EnglishDictionary();
	Dictionary d = new Dictionary();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbChoose;

    @FXML
    private ChoiceBox<String> cbChoose;

    @FXML
    private TextArea txtA1;

    @FXML
    private Button btSpell;

    @FXML
    private TextFlow txtFlow;

    @FXML
    private Label lbAvviso;

    @FXML
    private Button btClear;

    @FXML
    private Label lbTempo;

    @FXML
    void doClearText(ActionEvent event) {
    	txtA1.clear();
    	//txtA2.clear();
    	lbAvviso.setText("");
    	lbTempo.setText("");
    	txtFlow.getChildren().clear();;
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	lbAvviso.setText("");;
    	String testo = txtA1.getText();
    	String paroleErrate = "";
    	
    	  //String replace = testo.replaceAll(".","");
         // String replace1 = replace.replaceAll(",","");
          List<String> lista = new ArrayList<String>(Arrays.asList(testo.split(" ")));
          d1.loadDictionary();
          d2.loadDictionary();
    
    	if(cbChoose.getValue().compareTo("English") == 0){
    		long t0 = System.nanoTime();
    		List<RichWord> r2 = new LinkedList<RichWord>(d2.spellCheckText(lista));
    		long t1= System.nanoTime();
    		long tot = t1- t0;
    		for( RichWord s: r2){
    			if(s.isTrovata() == false)
    				paroleErrate += s.getStringa() + " ";
    		}
    		lbTempo.setText(String.format("Spell check completed in %d seconds", tot));
    	}
    	else {
    		long t0 = System.nanoTime();
    		List<RichWord> r1 = new LinkedList<RichWord>(d1.spellCheckText(lista));
    		long t1= System.nanoTime();
    		long tot = t1- t0;
    		for( RichWord s: r1){
    			if(s.isTrovata() == false)
    				paroleErrate += s.getStringa() + " ";
    		}
    		lbTempo.setText(String.format("Spell check completed in %d seconds", tot));
    	}
    	if(paroleErrate.length() > 0){
    	
    		lbAvviso.setText("your text contains errors!");
    	}
    	
    	for(int i = 0; i < lista.size(); i ++){
    		Text text = new Text(lista.get(i));
    		Text spazio = new Text(" ");
    		if(paroleErrate.contains(lista.get(i))){
    				text.setFill(Color.RED);
    				txtFlow.getChildren().addAll(text, spazio);
    				
    		}
    		else{
    			text.setFill(Color.BLACK);
				txtFlow.getChildren().addAll(text, spazio);
				
    		}
    	}
    	//txtA2.setText(paroleErrate);
    	
    }

    @FXML
    void initialize() {
        assert lbChoose != null : "fx:id=\"lbChoose\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert cbChoose != null : "fx:id=\"cbChoose\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtA1 != null : "fx:id=\"txtA1\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btSpell != null : "fx:id=\"btSpell\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtFlow != null : "fx:id=\"txtFlow\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lbAvviso != null : "fx:id=\"lbAvviso\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btClear != null : "fx:id=\"btClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lbTempo != null : "fx:id=\"lbTempo\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        
        cbChoose.getItems().addAll("English","Italian");
        
    }
}
