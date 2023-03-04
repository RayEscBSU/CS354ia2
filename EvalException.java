public class EvalException extends Exception {

	private int pos; //position
	private String msg; // message

	//constructor
	public EvalException(int pos, String msg) {
		this.pos=pos;
		this.msg=msg;
	}

	//toString used to print EevalEexception
	public String toString() {
		return "eval error"
			+", pos="+pos
			+", "+msg;
	}

}
