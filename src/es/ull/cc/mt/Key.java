package es.ull.cc.mt;

import java.util.LinkedList;

public class Key {
	private LinkedList<Character> tapeKeys;
	
	public Key(LinkedList<Character> tapeKeys){
		this.tapeKeys = tapeKeys;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		char c1 = tapeKeys.getFirst();
		char c2 = tapeKeys.getLast();
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
		String aux = "( ";
		for(int i=0; i<tapeKeys.size(); i++){
			aux = aux + tapeKeys.get(i)+" ";
		}
		aux = aux +",";
		return super.toString();
	}	

}
