package es.ull.cc.mt;

import java.util.LinkedList;

public class Tape {
	
	private LinkedList<Character>tape;
	private int position;
	
	public Tape(){
		tape = new LinkedList<Character>();
		setPosition(0);
	}
	
	public Tape(String cad){
		initWord(cad);
	}
	
	public void move(char direction){
		if(position == tape.size()){
			tape.addLast('.');
		}
		else if(position == '0'){
			tape.addFirst('.');
		}
		if(direction == 'R'){
			setPosition(getPosition() + 1);
		}
		else if(direction == 'L'){
			setPosition(getPosition() - 1);
		}
		
	}
	
	public void initWord(String cad){
		tape.removeAll(tape);
		for(int i=0; i<cad.length(); i++){
			tape.add(cad.charAt(i));
		}
		tape.addFirst('.');
		tape.addLast('.');
		setPosition(1);
	}
	
	public void readTape(){
		for (Character tChar : tape) {
			System.out.print(tChar+" ");
		}
	}
	
	public void write(char tChar){
		tape.set(position, tChar);
	}
	
	public char getActualChar(){
		return tape.get(position);
	}
	
	public void printTape(){
		for(Character t : tape){
			System.out.print(t+" ");
		}
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

}
