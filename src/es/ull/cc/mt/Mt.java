package es.ull.cc.mt;

import java.util.LinkedList;
import java.util.Scanner;

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
		whiteCharacter = file.getFileLine(4).get(0);
		defineFinalStates();
		dimensionTapeList();
		for(int i=6; i < file.numRowSize();i++){
			defineTransitions(i);
		}
	}
	
	private void dimensionTapeList() {
		Tape tempTape;
		for(int i=0; i < getNumTapes(); i++){
			tempTape = new Tape();
			tapesList.add(tempTape);
		}
	}

	private void defineFinalStates() {
		LinkedList<String>auxFile = file.getFileLine(5);
		for(int i=0; i< auxFile.size();i++){
			for(int j=0; j < statesList.size();j++){
				if(auxFile.get(i).equals(statesList.get(j).getsName())){
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
	
	private State changeState(String newState) {
		State qActual = new State(newState);
		for(State st: statesList){
			if(st.equals(qActual)){
				return st;
			}
		}
		return null;
	}
	
	public void printMt(){
		System.out.println("M = (Q,\u03A3,\u0393,s,b,F,\u03B4)");
		System.out.print("Q: ");
		for (State q : statesList) {
			System.out.print(q.getsName()+" ");
		}
		System.out.print("\n\u03A3: ");
		for (Character tapeChar : alphabetList) {
			System.out.print(tapeChar +" ");
		}
		System.out.print("\n\u0393: ");
		for (Character tapChar : tapeAlphabetList) {
			System.out.print(tapChar+" ");
		}
		System.out.print("\ns: "+ initState);
		System.out.print("\nb: "+ whiteCharacter);
		System.out.print("\nF: ");
		for (State finalS : statesList) {
			if( finalS.issFinal()){
				System.out.print(finalS.getsName()+" ");
			}
		}
		System.out.print("\n\u03B4:\n");
		for(State s : statesList){
			s.printMatrix();
		}
		
	}
	
	public void execute(){
		// -- Variables a utilizar
		Scanner sc = new Scanner(System.in);
		State qActual = changeState(initState);
		Key kActual;
		boolean stop = false;
		
		// -- Variables temporales
		String tempTape;
		char tempKeyChar;
		LinkedList<Character> tempKeyList = new LinkedList<Character>();
		Transition tempTransition;
		
		// -- Inicializando la ejecución
		for(int i=0; i< tapesList.size();i++){
			System.out.print(" - Introduzca la cadena que irá en la cinta "+i+": ");
			tempTape = sc.nextLine();
			tapesList.get(i).initWord(tempTape);
		}
		
		//sc.close(); -- Si lo dejo da error
		
		// -- Ejecución
		System.out.println(" \n\n | Estado \t| Caracter/es  Cinta/s Cabezal \t| Estado siguiente \t| Escritura cintas \t| Movimiento |");
		System.out.println(" | ------ \t| -------- \t --------------- \t| ---------------- \t| ---------------- \t| ---------- |");
		while(stop != true){
			System.out.print(" | "+qActual.getsName()+" \t\t|");
			for(int i=0; i<tapesList.size();i++){
				tempKeyChar = tapesList.get(i).getActualChar();
				tempKeyList.add(tempKeyChar);
				System.out.print(" ["+tempKeyChar+"] ");
				tapesList.get(i).printTape();
				System.out.print(" / "+ tapesList.get(i).getPosition()+"\t");
			}
			kActual = new Key(tempKeyList);
			if(qActual.containsKey(kActual)){
				System.out.print(" |\t "+qActual.getTransition(kActual).getNewState()+" |\t\t "+qActual.getTransition(kActual).getwTape()+" \t\t| "+qActual.getTransition(kActual).getTapeMove()+"\n");
				// Escribimos estado al que ir, escribimos cinta/s y movemos cabezal
				tempTransition = qActual.getTransition(kActual);
				for(int i=0; i<tapesList.size();i++){
					tapesList.get(i).write(qActual.getTransition(kActual).getwTape().get(i));
					tapesList.get(i).move(qActual.getTransition(kActual).getTapeMove().get(i));
				}
				qActual= changeState(tempTransition.getNewState());
				// -- Reiniciamos variable tempKeyList.
				tempKeyList.removeAll(tempKeyList);
			}
			else {
				System.out.print(" | - \t| - \t| - \n");
				stop = true;
			}
		}
		if(qActual.issFinal()){
			System.out.println("\n - Cadena aceptada.");
		}
		else{
			System.out.println("\n - Cadena rechazada.");
		}
		
	}

}
