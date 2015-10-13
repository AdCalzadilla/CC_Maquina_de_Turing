package es.ull.cc.mt;

public class Transition {
	
	private String wTape;
	private String eMove;
	
	public Transition(String wTape, String eMove){
		this.setwTape(wTape);
		this.seteMove(eMove);
	}

	public String getwTape() {
		return wTape;
	}

	public void setwTape(String wTape) {
		this.wTape = wTape;
	}

	public String geteMove() {
		return eMove;
	}

	public void seteMove(String eMove) {
		this.eMove = eMove;
	}

	@Override
	public String toString() {
		return "("+ wTape + ", "+ eMove+")";
	}

}
