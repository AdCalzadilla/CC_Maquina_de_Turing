package es.ull.cc.mt;

import java.util.LinkedList;

public class Key {
	private String state;
	private LinkedList<Character> tapeKeys;
	
	public Key(String state, LinkedList<Character> tapeKeys){
		this.setState(state);
		this.tapeKeys = tapeKeys;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state){
		this.state = state;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		char c1 = state.charAt(0);
		char c2 = tapeKeys.get(0);
		int result = c1;
        result = 31 * result + c2;
        return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if (!(obj instanceof Key)){
			return false;
		}
		Key theKey = (Key) obj;
		if(theKey.getState() != this.getState()){
			return false;
		}
		if(tapeKeys.size() != theKey.tapeKeys.size()){
			return false;
		}
		for(int i=0; i < tapeKeys.size(); i++){
			if(tapeKeys.get(i) != theKey.tapeKeys.get(i)){
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String aux = "( "+state+ " ";
		for(int i=0; i<tapeKeys.size(); i++){
			aux = aux + tapeKeys.get(i)+" ";
		}
		aux = aux +")";
		return super.toString();
	}	

/*
	@Override
	public int hashCode() {
		char c1 = coor_x.charAt(0);
		char c2 = coor_y.charAt(0);
		int result = c1;
        result = 31 * result + c2;
        return result;
	}
*/

}
