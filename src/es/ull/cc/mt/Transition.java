package es.ull.cc.mt;

import java.util.LinkedList;

public class Transition {
	
	private String newState;
	private LinkedList<Character> wTape;
	private LinkedList<Character> tapeMove;
	
	public Transition(String newState, LinkedList<Character>wTape, LinkedList<Character>tapeMove){
		this.newState = newState;
		this.wTape = wTape;
		this.tapeMove = tapeMove;
	}

	public String getNewState() {
		return newState;
	}

	public void setNewState(String newState) {
		this.newState = newState;
	}

	public LinkedList<Character> getwTape() {
		return wTape;
	}

	public void setwTape(LinkedList<Character> wTape) {
		this.wTape = wTape;
	}

	public LinkedList<Character> getTapeMove() {
		return tapeMove;
	}

	public void setTapeMove(LinkedList<Character> tapeMove) {
		this.tapeMove = tapeMove;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj){
			return true;
		}
		if (!(obj instanceof Transition)){
			return false;
		}
		Transition theTransition = (Transition) obj;
		if(theTransition.newState != this.newState){
			return false;
		}
		if(wTape.size() != theTransition.getwTape().size() && tapeMove.size() != theTransition.getTapeMove().size()){
			return false;
		}
		for(int i=0; i < wTape.size(); i++){
			if(wTape.get(i) != theTransition.getwTape().get(i)){
				return false;
			}
		}
		for(int i=0; i < tapeMove.size(); i++){
			if(tapeMove.get(i) != theTransition.getTapeMove().get(i)){
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String aux = "( "+newState+" ";
		for(int i=0; i < wTape.size();i++){
			aux = aux + wTape.get(i)+ " ";
		}
		for(int i=0; i< tapeMove.size(); i++){
			aux = aux + tapeMove.get(i)+" ";
		}
		aux = aux + ")"; 
		return aux;
	}	
	
}
