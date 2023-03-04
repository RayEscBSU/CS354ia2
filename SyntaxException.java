//This class represents a syntax Exception
public class SyntaxException extends Exception {

	private int pos;
	private Token expected;
	private Token found;

	/**
	 Constructs a SyntaxException object with the specified position, expected token, and found token.
	 @param pos the position where the syntax error occurred
	 @param expected the expected token
	 @param found the actual token that was found
	 */
	public SyntaxException(int pos, Token expected, Token found) {
		this.pos=pos;
		this.expected=expected;
		this.found=found;
	}

	/**

	 Returns a string representation of the SyntaxException object.
	 @return a string containing information about the syntax error
	 */
	public String toString() {
		return "syntax error"
			+", pos="+pos
			+", expected="+expected
			+", found="+found;
	}

}
