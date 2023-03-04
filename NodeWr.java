//This class represent a node that writes
// an expression
public class NodeWr extends Node {

	private NodeExpr expr;

	public NodeWr(NodeExpr expr) {
		this.expr=expr;
	}

	/**
	 Evaluates the expression and prints the result to the standard output.
	 @param env The environment used in the evaluation process.
	 @return The evaluated result.
	 @throws EvalException if any error occurs during the evaluation process.
	 */
	public double eval(Environment env) throws EvalException {
		double d=expr.eval(env);
		double i=d;
		if (i==d)
			System.out.println((int)i);
		else
			System.out.println(d);
		return d;
	}

	/**
	 Returns the code representation of the write statement.
	 @return The code representation of the write statement.
	 */
	public String code() {
		return "printf(\"%g\\n\","
			+"(double)("
			+expr.code()
			+"));";
	}

}
