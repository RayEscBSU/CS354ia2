//This class represents a multiplication and
// division operation
public class NodeMulop extends Node {

	private String mulop;

	/**
	 Creates a new NodeMulop object.
	 @param pos the position in the input where the operator occurs
	 @param mulop the string representation of the operator
	 */
	public NodeMulop(int pos, String mulop) {
		this.pos=pos;
		this.mulop=mulop;
	}

	/**
 	Evaluates the result of applying the multiplication or division operator to the given operands.
 	@param o1 the first operand
 	@param o2 the second operand
 	@return the result of applying the operator to the operands
 	@throws EvalException if the operator is not valid
 	**/
	public double op(double o1, double o2) throws EvalException {
		if (mulop.equals("*"))
			return o1*o2;
		if (mulop.equals("/"))
			return o1/o2;
		throw new EvalException(pos,"bogus mulop: "+mulop);
	}

	/**
	 Returns the string representation of the multiplication or division operator.
	 @return the string representation of the operator
	 */
	public String code() { return mulop; }

}
