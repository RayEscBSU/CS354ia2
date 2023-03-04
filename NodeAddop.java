//class represent an add or subtract opperation
public class NodeAddop extends Node {

	private String addop; // addop variable

	/**
	 Constructs a new NodeAddop object with the specified position and addop.
	 @param pos the position of the addop in the input expression
	 @param addop the addop character representing the operation
	 */
	public NodeAddop(int pos, String addop) {
		this.pos=pos;
		this.addop=addop;
	}

	/**
	 Returns the result of applying the addition or subtraction operation to the two operands.
	 @param o1 the first operand
	 @param o2 the second operand
	 @return the result of the operation
	 @throws EvalException if the addop is not '+' or '-'
	 */
	public double op(double o1, double o2) throws EvalException {
		if (addop.equals("+"))
			return o1+o2;
		if (addop.equals("-"))
			return o1-o2;
		throw new EvalException(pos,"bogus addop: "+addop);
	}

	/**

	 Returns the addop character representing the operation.
	 @return the addop character
	 */
	public String code() { return addop; }

}
