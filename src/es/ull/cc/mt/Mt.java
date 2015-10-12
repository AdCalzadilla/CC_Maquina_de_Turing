package es.ull.cc.mt;

import java.util.LinkedList;

public class Mt {
	
	private Parser file;
	private LinkedList<State>statesList;
	
	public Mt(String route){
		file = new Parser(route);
		createMachine();
	}

	private void createMachine() {
		State tempState;
		int line_one = file.getNumFinalLine().get(0)+1;
		
		for(int i=0; i<line_one;i++){
			tempState = new State(file.getFileList().get(i));
		}
		defineTransition();
		
	}

	private void defineTransition() {
		int line_Transitions = file.getNumFinalLine().get(6)+1;
		
		for(int i=line_Transitions; i<file.size();i++){
			
		}
		
	}
}
