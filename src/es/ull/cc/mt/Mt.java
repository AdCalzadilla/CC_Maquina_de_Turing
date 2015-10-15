package es.ull.cc.mt;

import java.util.LinkedList;

public class Mt {
	
	private Parser file;
	private LinkedList<State>statesList;
	private LinkedList<Character>alphabetList;
	private LinkedList<Character>tapeAlphabetList;
	private String initState;
	private String whiteCharacter;
	
	public Mt(String route){
		file = new Parser(route);
		createMachine();
	}

	private void createMachine() {
		defineStates();
		defineAlphabet();
		defineTapeAlphabet();
		initState = file.getFileLine(3).get(0);
		defineFinalStates();
		defineTransitions();
		
	}
	
	private void defineFinalStates() {
		LinkedList<String>auxFile = file.getFileLine(4);
		for(int i=0; i< auxFile.size();i++){
			for(int j=0; j < statesList.size();j++){
				if(auxFile.get(i) == statesList.get(j).getsName()){
					statesList.get(j).setsFinal(true);
					break;
				}
			}
		}
		
	}

	private void defineTapeAlphabet() {
		char aux;
		LinkedList<String>auxFile = file.getFileLine(1);
		for(int i=0; i<auxFile.size();i++){
			aux = auxFile.get(i).charAt(0);
			tapeAlphabetList.add(aux);
		}
	}

	private void defineAlphabet() {
		char aux;
		LinkedList<String>auxFile = file.getFileLine(1);
		for(int i=0; i<auxFile.size();i++){
			aux = auxFile.get(i).charAt(0);
			alphabetList.add(aux);
		}
	}

	private void defineStates(){
		State tempState;
		LinkedList<String>auxFile = file.getFileLine(0);
		for(int i=0; i<auxFile.size();i++){
			tempState = new State(auxFile.get(i));
			statesList.add(tempState);
		}
	}

	private void defineTransitions() {
		int numTapes = getNumTapes();
		
	}

	private int getNumTapes() {
		LinkedList<String>auxFile = file.getFileLine(6);
		int numTapes=0;
		
		for(int i=1; i<auxFile.size(); i++){
			for(int j=0; j<statesList.size();j++){
				if(auxFile.get(i) == statesList.get(j).getsName()){
					numTapes = i -1;
					break;
				}
			}
		}
		return numTapes;
	}
}
