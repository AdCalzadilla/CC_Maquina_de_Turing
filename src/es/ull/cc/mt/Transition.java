package es.ull.cc.mt;

public class Transition {
	
	private String eState;
	private String eTape;
	
	public Transition(String eState, String eStack){
		this.seteState(eState);
		this.seteStack(eStack);
	}

	public String geteState() {
		return eState;
	}

	public void seteState(String eState) {
		this.eState = eState;
	}

	public String geteStack() {
		return eTape;
	}

	public void seteStack(String eTape) {
		this.eTape = eTape;
	}

	@Override
	public String toString() {
		return "("+ eState + ", "+ eTape+")";
	}

}
