package es.ull.cc.mt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


public class State {

	private String sName;
	private boolean sFinal;
	private HashMap<Key, Transition>matrix;
	
	public State(){
		this.setsName("vacio");
		this.setsFinal(false);
		this.matrix = new HashMap<Key, Transition>();
	}

	public State(String sName){
		this.sName = sName;
		this.sFinal = false;
		this.matrix = new HashMap<Key, Transition>();
	}
	
	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public boolean issFinal() {
		return sFinal;
	}

	public void setsFinal(boolean sFinal) {
		this.sFinal = sFinal;
	}
	
	public void putHashMap(Key iKey, Transition tran){
		matrix.put(iKey, tran);
	}
	
	public Transition getTransition(Key index1){
		return matrix.get(index1);
	}
	
	public boolean containsKey(Key question){
		if(matrix.containsKey(question)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void printMatrix(){
		Key clave;
	    Iterator<Key> keyList = matrix.keySet().iterator();
	    while(keyList.hasNext()){
	    	System.out.print("\u03B4("+getsName());
	        clave = keyList.next();
	        System.out.println(clave + ", " + matrix.get(clave)+" )");
	    }        
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(!(obj instanceof State)){
			return false;
		}
		State theQState = (State) obj;
		return theQState.getsName() == this.getsName();
	}
		
}
