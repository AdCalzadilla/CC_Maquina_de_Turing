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
		LinkedList<String>auxFile = file.getFileList();
		LinkedList<Integer>auxNumRows = file.getNumRow();
		
		int line=0;
		int element=0;
		int i;
		
		while(line < auxNumRows.size()){
			i = 0;
			while(i < auxNumRows.get(line)){
				switch(line){
					case 0:
						tempState = new State(auxFile.get(element));
						statesList.add(tempState);
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					default:
						break;
				}
				i++;
				element++;
			}
			System.out.print("\n");
			line++;
		}
		defineTransition();
		
	}

	private void defineTransition() {
		int line_Transitions = file.getNumRow().get(6)+1;
		
		for(int i=line_Transitions; i<file.size();i++){
			
		}
		
	}
}
