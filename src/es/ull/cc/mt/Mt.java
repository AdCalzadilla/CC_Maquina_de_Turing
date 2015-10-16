package es.ull.cc.mt;

import java.util.LinkedList;

public class Mt {
	
	private Parser file;
	private LinkedList<State>statesList;
	private LinkedList<Character>alphabetList;
	private LinkedList<Character>tapeAlphabetList;
	private String initState;
	private String whiteCharacter;
	private LinkedList<Tape>tapesList;
	
	public Mt(String route){
		file = new Parser(route);
		statesList = new LinkedList<State>();
		alphabetList = new LinkedList<Character>();
		tapeAlphabetList = new LinkedList<Character>();
		tapesList = new LinkedList<Tape>();
		createMachine();
	}

	private void createMachine() {
		defineStates();
		defineAlphabet();
		defineTapeAlphabet();
		initState = file.getFileLine(3).get(0);
		defineFinalStates();
		for(int i=6; i < file.numRowSize();i++){
			defineTransitions(i);
		}
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

	private void defineTransitions(int line) {
		int numTapes = getNumTapes();
		String actualState = file.getFileLine(line).get(0);
		Key tempKey;
		LinkedList<Character>tempKeyList = new LinkedList<Character>();
		Transition tempTapeTransition;
		String tempNextState;
		LinkedList<Character>tempWriteTape = new LinkedList<Character>();
		LinkedList<Character>tempMoveTape = new LinkedList<Character>();
		
		
		for(int i=0; i< statesList.size(); i++){
			if(actualState.equals(statesList.get(i).getsName())){
				int k = 1;
				for(int j=0; j< numTapes; j++){
					tempKeyList.add(file.getFileLine(line).get(k).charAt(0));
					k++;
				}
				tempKey = new Key(tempKeyList);
				tempNextState = file.getFileLine(line).get(numTapes+1);
				k = numTapes+2;
				for(int l=0; l<numTapes; l++){
					tempWriteTape.add(file.getFileLine(line).get(k).charAt(0));
					k++;
				}
				for(int m = k; m< file.getFileLine(line).size();m++){
					tempMoveTape.add(file.getFileLine(line).get(m).charAt(0));
				}
				tempTapeTransition = new Transition(tempNextState, tempWriteTape, tempMoveTape);
				statesList.get(i).putHashMap(tempKey, tempTapeTransition);
			}
		}
		
	}

	private int getNumTapes() {
		LinkedList<String>auxFile = file.getFileLine(6);
		
		for(int i=1; i<auxFile.size(); i++){
			for(int j=0; j<statesList.size();j++){
				if(auxFile.get(i).equals(statesList.get(j).getsName())){
					return i-1;
				}
			}
		}
		return -1;
	}
}
